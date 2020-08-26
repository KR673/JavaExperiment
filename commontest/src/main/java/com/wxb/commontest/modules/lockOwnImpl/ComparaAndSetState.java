//package com.wxb.commontest.modules.lockOwnImpl;
//
//import io.netty.channel.Channel;
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @Description: 作用描述
// * @Author: WangXiaoBo
// * @Date: 2019/8/26 11:01
// * @Version: 1.0
// */
//public class ComparaAndSetState {
//
//    private static long offset;
//    private static Unsafe unsafe;
//    private volatile int state;
//
//    static {
//        try {
//            Field f = Unsafe.class.getDeclaredField("theUnsafe");
//            f.setAccessible(true);
//            unsafe = (Unsafe)f.get(null);
//            offset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("state"));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private boolean comparaAndSetState(int expect, int update){
//        return unsafe.compareAndSwapInt(this, offset, expect, update);
//    }
//
//    private static class Node{
//        Thread thread;
//        Node prev;
//        Node next;
//        static long tailOffset;
//        private volatile Node head;
//        private volatile Node tail;
//
//        static {
//            try {
//                tailOffset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("tail"));
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public Node(){}
//
//        public Node(Thread thread, Node prev) {
//            this.thread = thread;
//            this.prev = prev;
//        }
//
//        private boolean compareAndSetTail(Node expect, Node update){
//            return unsafe.compareAndSwapObject(this, tailOffset,expect ,update);
//        }
//
//        public void lock(){
//
//        }
//
//        private Node enqueue(){
//            while (true){
//                Node t = tail;
//                Node node = new Node(Thread.currentThread(), t);
//
//                if(compareAndSetTail(t, node)){
//                    t.next = node;
//                    return node;
//                }
//            }
//        }
//    }
//}