package com.wxb.commontest.modules;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mchange.v2.codegen.bean.CompleteConstructorGeneratorExtension;
import org.springframework.util.CollectionUtils;

import javax.xml.crypto.Data;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/9/4 13:37
 * @Version: 1.0
 */
public class SelectJiGou {

    private static List aaa = new ArrayList();


    public static void main(String[] args) throws ParseException {
        String a = "";
        System.out.println(a.length());
    }

    public static void selectMap(Map<String, Object> param, Integer level){

        if(param.get("data") == null){
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("- ");
        }
        System.out.println(param.get("level"));

        selectMap((Map<String, Object>) param.get("data"), level + 2);
    }

}