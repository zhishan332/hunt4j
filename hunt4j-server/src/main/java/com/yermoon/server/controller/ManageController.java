package com.yermoon.server.controller;

import com.yermoon.server.context.ServerContext;
import com.yermoon.server.entity.Page;
import com.yermoon.server.service.PageService;
import com.yermoon.server.worker.AtticWorker;
import com.yermoon.server.worker.LinkTaskWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午4:08
 * 处理页面请求
 */
@Controller
@RequestMapping("")
public class ManageController {
    private static final Logger log = LoggerFactory.getLogger(ManageController.class);
    @Resource
    private AtticWorker atticWorker;
    @Resource
    private LinkTaskWorker linkTaskWorker;
    @Resource
    private PageService pageService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        return new ModelAndView("list");
    }
    @RequestMapping(value = "/go", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> go(int flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        try {
            switch (flag) {
                case 0:
                    startAtticWorker();
                    startLinkWorker();
                    break;
                case 1:
                    startAtticWorker();
                    break;
                case 2:
                    startLinkWorker();
                    break;
                default:
            }
        } catch (Exception e) {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> stop(int flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        try {
            switch (flag) {
                case 0:
                    atticWorker.stop();
                    linkTaskWorker.stop();
                    break;
                case 1:
                    atticWorker.stop();
                    break;
                case 2:
                    linkTaskWorker.stop();
                    break;
                default:

            }
        } catch (Exception e) {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView setting() {
        return new ModelAndView("setting");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView forSearch(String keyword, Integer page) {
        log.debug("检索关键词：" + keyword + ",page:" + page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
//        if (StringUtils.isBlank(keyword)) {
//            map.put("status", 0);
//            map.put("total", 0);
//            map.put("msg", "关键字非法！");
//        } else {
        if (null == page) page = 1;
        try {
            keyword = URLDecoder.decode(keyword == null ? "" : keyword, "utf-8");
            log.debug("检索关键词解码：" + keyword);
            if (page < 0) page = 1;
            int limit = ServerContext.getInstance().getIVal("page.shownum");
            List<Page> pages = pageService.findPage(keyword, (page - 1) * limit, limit);
            if (pages == null || pages.isEmpty()) {
                map.put("status", 0);
                map.put("msg", "Sorry,未检索到相关数据");
            }
            map.put("total", pageService.getTotal(keyword));
            map.put("data", pages);
        } catch (UnsupportedEncodingException e) {
            log.error("转换字符串错误", e);
            map.put("status", 0);
            map.put("total", 0);
            map.put("msg", "内部错误！");
        }
//        }
        ModelAndView mv = new ModelAndView();
        mv.addAllObjects(map);
        mv.setViewName("search");
        return mv;
    }

    @RequestMapping(value = "/delPage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> del(int[] ids) {
        log.info("执行删除,ids[0]:"+(ids==null||ids.length==0?null:ids[0]));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        int num = 0;
        if (ids != null && ids.length > 0) {
            num = pageService.delPage(ids);
        }
        map.put("num", num);
        return map;
    }

    private void startAtticWorker() {
        atticWorker.setDelay(ServerContext.getInstance().getIVal("website.worker.delay"));
        atticWorker.start();

    }

    private void startLinkWorker() {
        linkTaskWorker.setDelay(ServerContext.getInstance().getIVal("urltask.worker.delay"));
        linkTaskWorker.start();
    }
}
