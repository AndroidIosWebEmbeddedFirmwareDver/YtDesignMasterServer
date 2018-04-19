package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommodityOrderEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSiteCommodityOrderEntityRepository;
import com.yt.design.jpa.service.YtTbSiteCommodityOrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/

@Service
public class YtTbSiteCommodityOrderEntityServiceImpl implements YtTbSiteCommodityOrderEntityService {

    @Autowired
    YtTbSiteCommodityOrderEntityRepository ytTbSiteCommodityOrderEntityRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSiteCommodityOrderEntity create(YtTbSiteCommodityOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbSiteCommodityOrderEntityRepository.save(input);
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
    public YtTbSiteCommodityOrderEntity delete(YtTbSiteCommodityOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbSiteCommodityOrderEntityRepository.delete(input);
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
    public YtTbSiteCommodityOrderEntity update(YtTbSiteCommodityOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbSiteCommodityOrderEntityRepository.save(input);
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
    public YtTbSiteCommodityOrderEntity findOne(YtTbSiteCommodityOrderEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbSiteCommodityOrderEntityRepository.findOneById(input.getId(), 0);
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
    public List<YtTbSiteCommodityOrderEntity> find(YtTbSiteCommodityOrderEntity input) throws JpaCommonException {
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
    public DbDataCommonPageDownEntity<List<YtTbSiteCommodityOrderEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSiteCommodityOrderEntity> input) throws JpaCommonException {
        return null;
    }

}
