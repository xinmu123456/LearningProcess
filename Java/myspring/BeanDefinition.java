package com.xinmu.myspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: xinmu
 * date: 2022/5/30
 * time: 19:35
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanDefinition {
    private String beanName;
    private Class beanClass;
}
