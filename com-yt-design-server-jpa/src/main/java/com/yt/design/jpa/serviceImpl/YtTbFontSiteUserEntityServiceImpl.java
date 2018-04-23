package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbFontSiteUserEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbFontSiteUserEntityRepository;
import com.yt.design.jpa.service.YtTbFontSiteUserEntityService;
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
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbFontSiteUserEntity create(YtTbFontSiteUserEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbFontSiteUserEntityRepository.save(input);
        }
        return null;
    }

    /**
     * 删除
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbFontSiteUserEntity delete(YtTbFontSiteUserEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbFontSiteUserEntityRepository.delete(input);
            return input;
        }
        return null;
    }

    /**
     * 修改
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbFontSiteUserEntity update(YtTbFontSiteUserEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbFontSiteUserEntityRepository.save(input);
        }
        return null;
    }

    /**
     * 查询一条
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbFontSiteUserEntity findOne(YtTbFontSiteUserEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbFontSiteUserEntityRepository.findOneById(input.getId(), 0);
        }
        return null;
    }

    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public List<YtTbFontSiteUserEntity> find(YtTbFontSiteUserEntity input) throws JpaCommonException {

        return null;
    }

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public DbDataCommonPageDownEntity<List<YtTbFontSiteUserEntity>> findPages(DbDataCommonPageQueryEntity<YtTbFontSiteUserEntity> input) throws JpaCommonException {
        return null;
    }


    /**
     * 主站注册用户
     *
     * @param input
     * @return
     * @throws JpaCommonException
     */
    @Override
    public YtTbFontSiteUserEntity fontSiteCreate(YtTbFontSiteUserEntity input) throws Exception {
        if (input != null && input.dataCheckForFontSiteCreate()) {
            ytTbFontSiteUserEntityRepository.save(input);
        }
        return null;
    }

    /**
     * 主站登录用户
     *
     * @param input
     * @return
     * @throws JpaCommonException
     */
    @Override
    public YtTbFontSiteUserEntity fontSiteLogin(YtTbFontSiteUserEntity input) throws Exception {
        if (input != null && input.dataCheckForFontSiteLogin()) {
            YtTbFontSiteUserEntity a = ytTbFontSiteUserEntityRepository.findOneByEmailAndPassword(input.getEmail(), input.getPassword(), 0);
            a.setEmail(null);
            a.setPassword(null);
            a.setInvitationCode(null);
            a.setInputInvitationCode(null);
            a.setCreatedDateTime(null);
            a.setModifiedDateTime(null);
            a.setEmail(null);
            a.setIsDeleted(0);
            return a;
        }
        return null;
    }
}
