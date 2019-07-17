package com.wxb.commontest.DesignMode.StategyPattern;

/**
 * @Description: 环境角色, 用于获取策略的类型与执行对应的策略
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:30
 * @Version: 1.0
 */
public class Context {

    private MusicDownload musicDownload;

    public String StategyInvoke(MemberEnum memberEnum){

        musicDownload = StrategyFactory.factory().creator(memberEnum);

        return musicDownload.downMusic();
    }

}
