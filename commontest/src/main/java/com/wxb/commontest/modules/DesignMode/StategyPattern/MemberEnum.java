package com.wxb.commontest.modules.DesignMode.StategyPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:32
 * @Version: 1.0
 */
public enum MemberEnum {

    MEMBER(1, "会员"),
    NOT_MEMBER(2, "非会员");

    private Integer key;
    private String value;

    MemberEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static MemberEnum getByValue(Integer key) {
        for (MemberEnum memberEnum : values()) {
            if ((memberEnum.getKey()) == key) {
                return memberEnum;
            }
        }
        return null;
    }
}
