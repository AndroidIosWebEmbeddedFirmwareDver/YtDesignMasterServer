package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSiteCommonTypeEntityRepository;
import com.yt.design.jpa.repository.pages.YtTbSiteCommonTypeEntityPagesRepository;
import com.yt.design.jpa.service.YtTbSiteCommonTypeEntityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:54
 **/


//商品（作品）、服务、需求统一类型表
@Service
public class YtTbSiteCommonTypeEntityServiceImpl implements YtTbSiteCommonTypeEntityService {

    @Autowired
    YtTbSiteCommonTypeEntityRepository ytTbSiteCommonTypeEntityRepository;

    @Autowired
    YtTbSiteCommonTypeEntityPagesRepository ytTbSiteCommonTypeEntityPagesRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSiteCommonTypeEntity create(YtTbSiteCommonTypeEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return ytTbSiteCommonTypeEntityRepository.save(input);
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
    public YtTbSiteCommonTypeEntity delete(YtTbSiteCommonTypeEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            ytTbSiteCommonTypeEntityRepository.delete(input);
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
    public YtTbSiteCommonTypeEntity update(YtTbSiteCommonTypeEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return ytTbSiteCommonTypeEntityRepository.save(input);
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
    public YtTbSiteCommonTypeEntity findOne(YtTbSiteCommonTypeEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return ytTbSiteCommonTypeEntityRepository.findOneById(input.getId(), 0);
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
    public List<YtTbSiteCommonTypeEntity> find(YtTbSiteCommonTypeEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFind()) {
            if (input.getLevel() > 0 && (input.getLevel() == 1 || input.getLevel() == 2)) {
                return ytTbSiteCommonTypeEntityRepository.findAllByLevel(input.getLevel(), 0);
            }
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
    public DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSiteCommonTypeEntity> input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindPages(input)) {
            //1.   取数据
            Pageable pageable = new PageRequest(input.getPage(), input.getSize(), input.getSortDirecion() == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, input.getSortType() != null ? input
                    .getSortType()
                    : "id");
            Page<YtTbSiteCommonTypeEntity> pageAbleDatas;

            if (input.getData() != null) {
                pageAbleDatas = ytTbSiteCommonTypeEntityPagesRepository.findAllByPagesAndIsDeletedAndLevel(0, input.getData().getLevel(), pageable);
            } else {

                pageAbleDatas = ytTbSiteCommonTypeEntityPagesRepository.findAllByPagesAndIsDeleted(0, pageable);
            }
            //2. 筛数据
            DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>> result = new DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>>();
            result.setData(pageAbleDatas != null ? pageAbleDatas.getContent() : null);
            result.setTotalSize(ytTbSiteCommonTypeEntityRepository.findSizeByPagesAndIsDeletedAndLevel(0, input.getData().getLevel()));
            result.setNowPage(input.getPage());
            return result;
        }
        return null;
    }
}