package com.wxb.commontest.modules;


import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/6/18 16:27
 * @Version: 1.0
 */
@Data
public class Param {
    public static void main(String[] args) {
        List<paramP> objects = new ArrayList<>();

        System.out.println(objects.stream().map(t -> new HashMap(2) {{
            put(t.getUserGroupId(), t.getUserGroupId());
            put(t.getUserGroupId() + 1,t.getUserGroupId());
        }}).collect(Collectors.toList()));
    }
}

@Data
class paramP{

    Integer a;
    Integer userGroupId;
    public paramP(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

}
