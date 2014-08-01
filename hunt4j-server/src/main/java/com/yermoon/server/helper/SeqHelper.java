package com.yermoon.server.helper;

import com.yermoon.server.dao.SeqDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 生成sequence
 *
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class SeqHelper {
    @Resource
    private SeqDao seqDao;

    public long getSeq(String seqName) {
        if (StringUtils.isBlank(seqName)) return -1;
        return seqDao.getSeq(seqName);
    }
}
