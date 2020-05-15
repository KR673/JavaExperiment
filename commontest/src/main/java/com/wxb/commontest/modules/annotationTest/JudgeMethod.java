package com.wxb.commontest.modules.annotationTest;

import com.wxb.commontest.pojo.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

public class JudgeMethod {

    public static void main(String[] args) throws Exception {
        Person person = new Person();

        person.setName("abc");

        System.out.println(fieldIncludeNull(person, TypeOne.class));
    }

    public static boolean fieldIncludeNull(Object trueParam, Class<? extends Annotation> anno) throws Exception {

        Field[] declaredFields = trueParam.getClass().getDeclaredFields();

        for (Field fields : declaredFields) {
            fields.setAccessible(true);

            if(fields.getAnnotation(anno) != null) {

                if(Objects.equals(fields.get(trueParam), null)) {
                    return true;
                }
            }
        }

        return false;
    }
}
