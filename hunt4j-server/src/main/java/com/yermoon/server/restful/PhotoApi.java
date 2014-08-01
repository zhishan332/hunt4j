package com.yermoon.server.restful;

import com.yermoon.server.entity.Page;
import com.yermoon.server.restful.dto.PhotoPageDto;
import com.yermoon.server.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片API
 *
 * @author wangqing
 * @since 1.0.0
 */
@Controller
@RequestMapping("")
public class PhotoApi {
    private static final Logger log = LoggerFactory.getLogger(PhotoApi.class);
    @Value("#{settings['static.img.host']}")
    private String imgHost;
    @Resource
    private PageService pageService;

    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    @ResponseBody
    public List<PhotoPageDto> find(int start, int limit) {
        log.info("api-最新图片内容查找执行，start：" + start + ",limit:" + limit);
        List<Page> pages = pageService.findPage(null, (start - 1) * limit, limit);
        List<PhotoPageDto> list = new ArrayList<PhotoPageDto>();
        if (pages != null) {
            for (Page page : pages) {
//                String imgUrls = page.getImgUrl();
//                if (StringUtils.isBlank(imgUrls)) continue;
//                String[] imgArry = imgUrls.split(";");
//                Set<String> imgSet = new HashSet<String>();
//                for (String str : imgArry) {
//                    imgSet.add(imgHost + str);
//                }
//                PhotoPageDto dto = new PhotoPageDto();
//                dto.setTitle(page.getTitle());
//                dto.setUdate(page.getUdate());
//                dto.setCdate(page.getCdate());
//                dto.setImgNum(page.getImgNum());
//                dto.setImgUrls(imgSet);
//                list.add(dto);
            }
        }
        return list;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "你好中国";
    }
}
