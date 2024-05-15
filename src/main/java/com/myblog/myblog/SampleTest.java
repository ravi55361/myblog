package com.myblog.myblog;

public class SampleTest {

    public static int testShow() {
        SampleTest sampleTest = new SampleTest();
        int otp = sampleTest.returnOtp();
        return otp;
    }

    private int returnOtp() {
        return 12345;
    }

    public static void main(String[] args) {
        int x=10;
        int y=20;

        int max=(x>y)?x:y;
        System.out.println(max);
    }
}
