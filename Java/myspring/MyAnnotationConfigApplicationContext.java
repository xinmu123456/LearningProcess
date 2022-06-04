package com.xinmu.myspring;

import com.xinmu.myspring.anno.Autowired;
import com.xinmu.myspring.anno.Component;
import com.xinmu.myspring.anno.Qualifier;
import com.xinmu.myspring.anno.Value;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * author: xinmu
 * date: 2022/5/30
 * time: 19:34
 */


public class MyAnnotationConfigApplicationContext {

    private Map<String, Object> ioc = new HashMap<>();

    public MyAnnotationConfigApplicationContext(String pack) {
        //遍历包,找到目标类
        Set<BeanDefinition> beanDefinitions = findBeanDefinitions(pack);
        //根据原材料创建bean
        createObject(beanDefinitions);
        //自动装载
        autowireObject(beanDefinitions);
    }

    public void autowireObject(Set<BeanDefinition> beanDefinitions) {
        Iterator<BeanDefinition> iterator = beanDefinitions.iterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = iterator.next();
            Class clazz = beanDefinition.getBeanClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Autowired annotation = declaredField.getAnnotation(Autowired.class);
                if (annotation != null) {
                    Qualifier qualifier = declaredField.getAnnotation(Qualifier.class);
                    if (qualifier != null) {
                        //byName
                        String beanName = qualifier.value();
                        Object bean = getBean(beanName);
                        String fieldName = declaredField.getName();
                        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Method method = null;
                        try {
                            method = clazz.getMethod(methodName, declaredField.getType());
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                        Object object = getBean(beanDefinition.getBeanName());
                        try {
                            //object是主体对象,bean是属性对象
                            method.invoke(object, bean);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //byType
                        //遍历ioc容器查看是否有该类型的bean
                        List<Object> collect = ioc.entrySet().stream()
                                .map(Map.Entry::getValue)
                                .collect(Collectors.toList());

                        //System.out.println(declaredField);
                        //System.out.println(ioc.containsValue(declaredField));

                        for (Object bean : collect) {
                            Object object = getBean(beanDefinition.getBeanName());
                            //容器中有字段的class类型
                            if (bean.getClass() == declaredField.getType()) {
                                String fieldName = declaredField.getName();
                                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                                Method method = null;
                                try {
                                    method = object.getClass().getMethod(methodName, declaredField.getType());
                                } catch (NoSuchMethodException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    method.invoke(object, bean);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        return ioc.get(beanName);
    }

    public void createObject(Set<BeanDefinition> beanDefinitions) {
        Iterator<BeanDefinition> iterator = beanDefinitions.iterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = iterator.next();
            Class clazz = beanDefinition.getBeanClass();
            String beanName = beanDefinition.getBeanName();
            try {
                //创建的对象
                Object o = clazz.getConstructor().newInstance();
                ioc.put(beanName, o);
                //完成属性的赋值
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    Value valueAnnotation = declaredField.getAnnotation(Value.class);
                    if (valueAnnotation != null) {
                        String value = valueAnnotation.value();
                        String fieldName = declaredField.getName();
                        //利用set方法注入
                        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Method method = clazz.getMethod(methodName, declaredField.getType());

                        //完成数据类型的转换
                        Object val = null;
                        switch (declaredField.getType().getName()) {
                            case "java.lang.Integer":
                                val = Integer.parseInt(value);
                                break;
                            case "java.lang.String":
                                val = value;
                                break;
                            case "java.lang.Float":
                                val = Float.parseFloat(value);
                                break;
                        }
                        method.invoke(o, val);
                    }
                }

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Set<BeanDefinition> findBeanDefinitions(String pack) {
        //1.获取包下的所有类
        Set<Class<?>> classes = MyTools.getClasses(pack);
        Iterator<Class<?>> iterator = classes.iterator();
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        while (iterator.hasNext()) {
            //2.遍历这些类,找到加了注解的类
            Class<?> clazz = iterator.next();
            Component componentAnnotation = clazz.getAnnotation(Component.class);
            if (componentAnnotation != null) {
                //3.将这些类封装成BeanDefinition,装载到集合中
                //获取Component注解的值
                String beanName = componentAnnotation.value();
                if ("".equals(beanName)) {
                    //获取类名的首字母的小写
                    String className = clazz.getName().replaceAll(clazz.getPackage().getName() + ".", "");
                    beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                }
                beanDefinitions.add(new BeanDefinition(beanName, clazz));
            }
        }

        return beanDefinitions;
    }
}
