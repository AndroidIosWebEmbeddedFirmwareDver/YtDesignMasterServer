package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteConfigAdsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/

public interface YtTbSiteConfigAdsEntityRepository extends JpaRepository<YtTbSiteConfigAdsEntity, String> {

    @Query("Select entity from YtTbSiteConfigAdsEntity entity where entity.isDeleted=?1")
    public YtTbSiteConfigAdsEntity findALLByIsDeleted(int isDeleted);


    @Query("Select entity from YtTbSiteConfigAdsEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteConfigAdsEntity findOneById(long id, int isDeleted);


    @Query("Select entity from YtTbSiteConfigAdsEntity entity where entity.isDeleted=?1")
    public List<YtTbSiteConfigAdsEntity> findAllByIsDeleted(int isDeleted);


    @Query(value = "select count(*) from yt_tb_site_config_ads datas where  datas.isDeleted=?1 ", nativeQuery = true)
    public int findSizeByIsDeleted(int isDeleted);
}
