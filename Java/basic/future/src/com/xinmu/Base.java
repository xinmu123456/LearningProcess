package com.xinmu;

public class Base {
    public String baseName = "base";

    public void callName() {
        System.out.println(baseName);
    }

    public void callBaseName() {
        System.out.println(baseName);
    }


    public static void main(String[] args) {
        Base b = new Son();
        b.callName();
        b.callBaseName();
        System.out.println(b.baseName);
        System.out.println(((Sub)b).baseName);

    }
}

class Sub extends Base {
    public String baseName = "sub";

    public void callName() {
        System.out.println(baseName);
    }
}

class Son extends Sub {
    public String baseName = "son";

    public void callName() {
        System.out.println(baseName);
    }
}