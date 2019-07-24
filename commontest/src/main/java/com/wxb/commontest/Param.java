package com.wxb.commontest;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/6/18 16:27
 * @Version: 1.0
 */
@Data
public class Param {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("2339879879")
                .map(t -> t.replaceAll("([0-9]{3})([0-9]{4})([0-9]*)", "$1****$3"))
                .orElse(""));
    }
}
