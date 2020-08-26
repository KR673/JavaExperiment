package com.wxb.commontest.modules;

import com.wxb.commontest.dao.mysql.MonthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/filter")
public class filterTest {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    MonthMapper month;

    @RequestMapping("/say")
    public void say(HttpServletRequest request){
        httpServletRequest.getCookies();
        System.out.println("hello");

        month.selectAll();
    }

}
