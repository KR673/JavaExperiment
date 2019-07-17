package com.wxb.commontest.LambdaTeat;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/5/17 13:53
 * @Version: 1.0
 */
public class StreamTestTwo {
    public static void main(String[] args) {



        String s = "http://hangzhou-zhuanma.oss-cn-hangzhou.aliyuncs.com/abc/display.jpg";

        if(s.matches("^http://hangzhou-zhuanma\\.oss-cn-hangzhou\\.aliyuncs\\.com/.*")){
            System.out.println("符合");
        }

/*        List<String> aa = Arrays.stream(s.replaceAll("^http://hangzhou-zhuanma\\.oss-cn-hangzhou\\.aliyuncs\\.com/(.*)", "$1")
                .split("/"))
                .map(t -> "/" + t)
                .collect(Collectors.toList());

            aa.stream().forEach(System.out::println);*/
    }
}
