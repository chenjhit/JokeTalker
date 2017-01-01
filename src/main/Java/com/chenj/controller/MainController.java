package com.chenj.controller;

import com.chenj.model.WebSiteEntity;
import com.chenj.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created by Administrator on 2016/10/12.
 */
@Controller
public class MainController {
    transient String tmp = "";

    @Autowired
    SiteRepository siteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin/sites", method = RequestMethod.GET)
    public String getSites(ModelMap modelMap) {
        // 查询web_site表中所有记录
        List<WebSiteEntity> siteList = siteRepository.findAll();
        // 将所有记录传递给要返回的jsp页面，放在siteList当中
        modelMap.addAttribute("siteList", siteList);
        // 返回pages目录下的admin/sites.jsp页面
        return "admin/sites";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/sites/add", method = RequestMethod.GET)
    public String addSite() {
        // 转到 admin/addUser.jsp页面
        return "admin/addSite";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/sites/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("site") WebSiteEntity webSiteEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        //userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
        List<String> strings = new ArrayList<String>() ;
        siteRepository.saveAndFlush(webSiteEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/sites";
    }
}
