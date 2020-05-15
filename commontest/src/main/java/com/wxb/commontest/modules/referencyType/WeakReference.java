package com.wxb.commontest.modules.referencyType;

public class WeakReference {

    public static void main(String[] args) throws InterruptedException {

        java.lang.ref.WeakReference r = new java.lang.ref.WeakReference(new String("I'm here"));
        java.lang.ref.WeakReference sr = new java.lang.ref.WeakReference("I'm here");
        System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
        System.gc();
        Thread.sleep(100);

        // only r.get() becomes null
        System.err.println("after gc: r=" + r.get() + ", static=" + sr.get());
    }
}
