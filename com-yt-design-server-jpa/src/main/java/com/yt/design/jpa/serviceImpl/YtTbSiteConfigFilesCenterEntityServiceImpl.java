package com.yt.design.jpa.serviceImpl;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import com.yt.design.jpa.entity.YtTbSiteConfigFilesCenterEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.repository.normal.YtTbSiteConfigFilesCenterEntityRepository;
import com.yt.design.jpa.repository.pages.YtTbSiteConfigFilesCenterEntityPagesRepository;
import com.yt.design.jpa.service.YtTbSiteConfigFilesCenterEntityService;
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

@Service
public class YtTbSiteConfigFilesCenterEntityServiceImpl implements YtTbSiteConfigFilesCenterEntityService {

    @Autowired
    YtTbSiteConfigFilesCenterEntityRepository commonRepository;

    @Autowired
    YtTbSiteConfigFilesCenterEntityPagesRepository pagesRepository;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */

    @Override
    public YtTbSiteConfigFilesCenterEntity create(YtTbSiteConfigFilesCenterEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForCreate()) {
            return commonRepository.save(input);
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
    public YtTbSiteConfigFilesCenterEntity delete(YtTbSiteConfigFilesCenterEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForDelete()) {
            commonRepository.delete(input);
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
    public YtTbSiteConfigFilesCenterEntity update(YtTbSiteConfigFilesCenterEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForUpdate()) {
            return commonRepository.save(input);
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
    public YtTbSiteConfigFilesCenterEntity findOne(YtTbSiteConfigFilesCenterEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindOne()) {
            return commonRepository.findOneById(input.getId(), 0);
        }
        return null;
    }
    /**
     * 查询一条
     *
     * @param fileUid 输入参数
     * @return 输出参数
     */
    @Override
    public YtTbSiteConfigFilesCenterEntity findOneByFileUid(String fileUid) throws JpaCommonException {
        if (fileUid != null && fileUid.length() > 0) {
            return commonRepository.findOneByFileUid(fileUid, 0);
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
    public List<YtTbSiteConfigFilesCenterEntity> find(YtTbSiteConfigFilesCenterEntity input) throws JpaCommonException {
        if (input != null && input.dataCheckForFind()) {
            return null;
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
    public DbDataCommonPageDownEntity<List<YtTbSiteConfigFilesCenterEntity>> findPages(DbDataCommonPageQueryEntity<YtTbSiteConfigFilesCenterEntity> input) throws JpaCommonException {
        if (input != null && input.dataCheckForFindPages(input)) {
            //1.   取数据
            Pageable pageable = new PageRequest(input.getPage(), input.getSize(), input.getSortDirecion() == 0 ? Sort.Direction.DESC : Sort.Direction.ASC, input.getSortType() != null ? input
                    .getSortType()
                    : "id");
            Page<YtTbSiteConfigFilesCenterEntity> pageAbleDatas = null;
            if (input.getData() != null) {

            } else {
                pageAbleDatas = pagesRepository.findAllByPagesAndIsDeleted(0, pageable);
                DbDataCommonPageDownEntity<List<YtTbSiteConfigFilesCenterEntity>> result = new DbDataCommonPageDownEntity<List<YtTbSiteConfigFilesCenterEntity>>();
                result.setData(pageAbleDatas != null ? pageAbleDatas.getContent() : null);
                result.setTotalSize(commonRepository.findSizeByIsDeleted(0));
                result.setNowPage(input.getPage());
                return result;
            }
        }

        return null;
    }

}
