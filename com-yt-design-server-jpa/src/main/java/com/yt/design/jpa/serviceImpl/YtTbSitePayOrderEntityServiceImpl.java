package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSitePayOrderEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSitePayOrderEntityRepository;
import com.yt.design.jpa.service.YtTbSitePayOrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/

@Service
public class YtTbSitePayOrderEntityServiceImpl implements YtTbSitePayOrderEntityService {

    @Autowired
    YtTbSitePayOrderEntityRepository ytTbSitePayOrderEntityRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSitePayOrderEntity create(YtTbSitePayOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbSitePayOrderEntityRepository.save(input);
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
    public YtTbSitePayOrderEntity delete(YtTbSitePayOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbSitePayOrderEntityRepository.delete(input);
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
    public YtTbSitePayOrderEntity update(YtTbSitePayOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbSitePayOrderEntityRepository.save(input);
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
    public YtTbSitePayOrderEntity findOne(YtTbSitePayOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbSitePayOrderEntityRepository.findOneById(input.getId(), 0);
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
    public List<YtTbSitePayOrderEntity> find(YtTbSitePayOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFind()) {

        }
        return null;
    }

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public DbDataCommonPageDownEntity<List<YtTbSitePayOrderEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSitePayOrderEntity> input) throws JpaCommonException {
        return null;
    }


}

