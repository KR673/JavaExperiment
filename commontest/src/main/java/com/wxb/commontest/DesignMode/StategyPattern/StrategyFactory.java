package com.wxb.commontest.DesignMode.StategyPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 策略工厂 负责Strategy实例的创建 根据传入的type实现创建不同的策略
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:31
 * @Version: 1.0
 */
public class StrategyFactory {

    private static Map<MemberEnum, MusicDownload> map = new HashMap<>();
    private static StrategyFactory factory = new StrategyFactory();

    {
        map.put(MemberEnum.MEMBER, new MusicDownloadMember());
        map.put(MemberEnum.NOT_MEMBER, new MusicDownloadNotMember());
    }

    public static StrategyFactory factory(){
        return factory;
    }

    public MusicDownload creator(MemberEnum memberEnum){
        return map.get(memberEnum);
    }

}
