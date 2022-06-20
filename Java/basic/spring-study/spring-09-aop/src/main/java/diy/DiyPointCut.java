package diy;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 16:56
 */


public class DiyPointCut {
    public void before(){
        System.out.println("========方法执行前====");
    }

    public void after(){
        System.out.println("====方法执行后========");
    }
}
