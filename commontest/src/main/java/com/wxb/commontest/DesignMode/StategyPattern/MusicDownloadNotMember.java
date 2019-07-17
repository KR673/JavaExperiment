package com.wxb.commontest.DesignMode.StategyPattern;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/7/17 20:29
 * @Version: 1.0
 */
public class MusicDownloadNotMember implements MusicDownload {
    @Override
    public String downMusic() {
        return "您现在还不是会员, 不可以下载";
    }
}
