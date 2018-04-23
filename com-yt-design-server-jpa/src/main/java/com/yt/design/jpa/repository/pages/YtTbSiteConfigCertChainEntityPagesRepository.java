package com.yt.design.jpa.repository.pages;

import com.yt.design.jpa.entity.YtTbSiteConfigCertChainEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description 商品（作品）、服务、需求统一类型表
 * @Author
 * @Create 2018-04-02 下午4:22
 **/

public interface YtTbSiteConfigCertChainEntityPagesRepository extends CrudRepository<YtTbSiteConfigCertChainEntity, Long> {

    @Query("select datas  from YtTbSiteConfigCertChainEntity datas where  datas.isDeleted=?1")
    public Page<YtTbSiteConfigCertChainEntity> findAllByPagesAndIsDeleted(int isDeleted, Pageable pageable);

}
