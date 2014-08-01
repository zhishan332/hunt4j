package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.WebSiteDao;
import com.yermoon.server.entity.WebSite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class WebSiteDaoImpl extends AbstractDao implements WebSiteDao {

    @Override
    public List<WebSite> findAll() {
        long nowTime=System.currentTimeMillis();
        List<Map<String, Object>> sites = jdbcTemplate.queryForList("select * from website" +
                " where udate < "+ (nowTime-1000*60));
        List<WebSite> resList = new ArrayList<WebSite>();
        if (sites == null) return resList;
        for (Map<String, Object> map : sites) {
            WebSite ws = new WebSite();
            ws.setId(Integer.parseInt(String.valueOf(map.get("id"))));
            ws.setUrl(String.valueOf(map.get("url")));
            ws.setCharset(String.valueOf(map.get("charset")));
            ws.setRegx(String.valueOf(map.get("regx")));
            ws.setUdate(Long.parseLong(String.valueOf(map.get("udate"))));
            resList.add(ws);
        }
        return resList;
    }


    @Override
    public void update(WebSite webSite) {
        jdbcTemplate.update("update website set udate=? where id=?", webSite.getUdate(), webSite.getId());
    }
}
