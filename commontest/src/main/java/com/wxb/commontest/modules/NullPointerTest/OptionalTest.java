package com.wxb.commontest.modules.NullPointerTest;

import java.security.AllPermission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<Integer> a ;

        ArrayList<Optional<Integer>> a1 = new ArrayList<>() {{
            add(Optional.empty());
        }};


        Optional<ArrayList<Optional<Integer>>> a11 = Optional.ofNullable(a1);
        Optional<Optional<Integer>> integer = a11.map(t -> t.get(0));
        Optional<Integer> integer1 = integer.flatMap(t -> t);


    }

    public static void defaultReturn(Integer a){
        System.out.println( "aaa");
    }

    public static Optional<Integer> stringToInt(String param){
        try {
            return Optional.of(Integer.valueOf(param));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

    public static Optional<Date> stringToDate(String param, String format){
        try {
            return Optional.of(new SimpleDateFormat(format).parse(param));
        }catch (ParseException e){
            return Optional.empty();
        }
    }

}
