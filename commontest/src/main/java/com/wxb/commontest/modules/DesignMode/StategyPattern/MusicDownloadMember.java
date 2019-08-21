package com.wxb.commontest.modules.DesignMode.StategyPattern;

/**
 * @Description: 会员下载
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:26
 * @Version: 1.0
 */
public class MusicDownloadMember implements MusicDownload {
    @Override
    public String downMusic() {
        return "开始下载";
    }
}
