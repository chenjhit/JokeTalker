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
        // ��ѯweb_site�������м�¼
        List<WebSiteEntity> siteList = siteRepository.findAll();
        // �����м�¼���ݸ�Ҫ���ص�jspҳ�棬����siteList����
        modelMap.addAttribute("siteList", siteList);
        // ����pagesĿ¼�µ�admin/sites.jspҳ��
        return "admin/sites";
    }

    // get���󣬷�������û� ҳ��
    @RequestMapping(value = "/admin/sites/add", method = RequestMethod.GET)
    public String addSite() {
        // ת�� admin/addUser.jspҳ��
        return "admin/addSite";
    }

    // post���󣬴�������û����󣬲��ض����û�����ҳ��
    @RequestMapping(value = "/admin/sites/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("site") WebSiteEntity webSiteEntity) {
        // ע��˴���post���󴫵ݹ�������һ��UserEntity������������˸��û�����Ϣ
        // ͨ��@ModelAttribute()ע����Ի�ȡ���ݹ�����'user'���������������

        // ���ݿ������һ���û����ò���ʱ����ˢ�»���
        //userRepository.save(userEntity);

        // ���ݿ������һ���û���������ˢ�»���
        List<String> strings = new ArrayList<String>() ;
        siteRepository.saveAndFlush(webSiteEntity);

        // �ض����û�����ҳ�棬����Ϊ redirect:url
        return "redirect:/admin/sites";
    }
}
