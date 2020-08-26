package com.wxb.commontest.modules.socketTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8000);
//        for (;;){
//            Socket client = serverSocket.accept();
//            System.out.println(client.getInputStream());
//            client.close();
//        }
//        System.out.println(0.0/0.0);
        ArrayList<Object> ls = new ArrayList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");
        ls.add("6");
        Iterator<Object> iterator = ls.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }

}
