package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteServiceOrderEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSiteServiceOrderEntityRepository;
import com.yt.design.jpa.service.YtTbSiteServiceOrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/

@Service
public class YtTbSiteServiceOrderEntityServiceImpl implements YtTbSiteServiceOrderEntityService {

    @Autowired
    YtTbSiteServiceOrderEntityRepository ytTbSiteServiceOrderEntityRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSiteServiceOrderEntity create(YtTbSiteServiceOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbSiteServiceOrderEntityRepository.save(input);
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
    public YtTbSiteServiceOrderEntity delete(YtTbSiteServiceOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbSiteServiceOrderEntityRepository.delete(input);
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
    public YtTbSiteServiceOrderEntity update(YtTbSiteServiceOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbSiteServiceOrderEntityRepository.save(input);
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
    public YtTbSiteServiceOrderEntity findOne(YtTbSiteServiceOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbSiteServiceOrderEntityRepository.findOneById(input.getId(), 0);
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
    public List<YtTbSiteServiceOrderEntity> find(YtTbSiteServiceOrderEntity input) throws JpaCommonException {

        return null;
    }

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public DbDataCommonPageDownEntity<List<YtTbSiteServiceOrderEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSiteServiceOrderEntity> input) throws JpaCommonException {
        return null;
    }


}
