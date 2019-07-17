package com.wxb.commontest;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/11 9:26
 * @Version: 1.0
 */
public class floatTest {
    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumIntegerDigits(2);
        System.out.println(decimalFormat.format(111));

    }
}
