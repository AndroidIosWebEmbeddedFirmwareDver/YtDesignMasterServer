package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteDemandOrderEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSiteDemandOrderEntityRepository;
import com.yt.design.jpa.service.YtTbSiteDemandOrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/

@Service
public class YtTbSiteDemandOrderEntityServiceImpl implements YtTbSiteDemandOrderEntityService {

    @Autowired
    YtTbSiteDemandOrderEntityRepository ytTbSiteDemandOrderEntityRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSiteDemandOrderEntity create(YtTbSiteDemandOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbSiteDemandOrderEntityRepository.save(input);
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
    public YtTbSiteDemandOrderEntity delete(YtTbSiteDemandOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbSiteDemandOrderEntityRepository.delete(input);
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
    public YtTbSiteDemandOrderEntity update(YtTbSiteDemandOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbSiteDemandOrderEntityRepository.save(input);
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
    public YtTbSiteDemandOrderEntity findOne(YtTbSiteDemandOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbSiteDemandOrderEntityRepository.findOneById(input.getId(), 0);
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
    public List<YtTbSiteDemandOrderEntity> find(YtTbSiteDemandOrderEntity input) throws JpaCommonException {
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
    public DbDataCommonPageDownEntity<List<YtTbSiteDemandOrderEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSiteDemandOrderEntity> input) throws JpaCommonException {
        return null;
    }

}

