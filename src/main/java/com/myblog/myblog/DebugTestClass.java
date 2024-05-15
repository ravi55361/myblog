package com.myblog.myblog;

public class DebugTestClass {

    public static void main(String[] args) {
        DebugTestClass debugTestClass = new DebugTestClass();
        int val = debugTestClass.test();
        System.out.println(val);
    }

    public int test(){
        int otp = SampleTest.testShow();
        return otp;
    }
}
