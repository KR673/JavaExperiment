//package com.wxb.commontest.modules.lockOwnImpl;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @Description: 作用描述
// * @Author: WangXiaoBo
// * @Date: 2019/8/26 14:27
// * @Version: 1.0
// */
//public class Counter {
//
//    private volatile int count = 0;
//    private static long offset;
//    private static Unsafe unsafe;
//
//    static {
//        try {
//            Field f = Unsafe.class.getDeclaredField("theUnsafe");
//            f.setAccessible(true);
//            unsafe = (Unsafe)f.get(null);
//            offset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("count"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void increment(){
//        int before = count;
//        while(unsafe.compareAndSwapInt(this,offset,before,before + 1)){
//            before = count;
//        }
//    }
//
//    public int getCount(){
//        return count;
//    }
//
//}
