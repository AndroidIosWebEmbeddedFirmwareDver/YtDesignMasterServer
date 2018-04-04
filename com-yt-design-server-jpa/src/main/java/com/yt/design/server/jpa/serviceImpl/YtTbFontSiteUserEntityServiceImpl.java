package com.yt.design.server.jpa.serviceImpl;

import com.yt.design.server.common.exception.JpaCommonException;
import com.yt.design.server.jpa.entity.YtTbFontSiteUserEntity;
import com.yt.design.server.jpa.repository.YtTbFontSiteUserEntityRepository;
import com.yt.design.server.jpa.service.YtTbFontSiteUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/

@Service
public class YtTbFontSiteUserEntityServiceImpl implements YtTbFontSiteUserEntityService {

    @Autowired
    YtTbFontSiteUserEntityRepository ytTbFontSiteUserEntityRepository;


    /**
     * 新增
     *
     * @param input
     * @return
     */
    @Override
    public YtTbFontSiteUserEntity create(YtTbFontSiteUserEntity input) throws JpaCommonException {
        return null;
    }

    /**
     * 删除
     *
     * @param input
     * @return
     */
    @Override
    public YtTbFontSiteUserEntity delete(YtTbFontSiteUserEntity input) throws JpaCommonException {
        return null;
    }

    /**
     * 修改
     *
     * @param input
     * @return
     */
    @Override
    public YtTbFontSiteUserEntity update(YtTbFontSiteUserEntity input) throws JpaCommonException {
        return null;
    }

    /**
     * 查询一条
     *
     * @param input
     * @return
     */
    @Override
    public YtTbFontSiteUserEntity findOne(YtTbFontSiteUserEntity input) throws JpaCommonException {
        return null;
    }

    /**
     * 查询一堆
     *
     * @param input
     * @return
     */
    @Override
    public List<YtTbFontSiteUserEntity> find(YtTbFontSiteUserEntity input) throws JpaCommonException {
        return null;
    }
}
