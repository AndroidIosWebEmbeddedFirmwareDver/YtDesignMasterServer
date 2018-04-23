package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteConfigAdsEntity;
import com.yt.design.jpa.entity.YtTbSiteConfigPartnersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/
//商品信息表

public interface YtTbSiteConfigPartnersEntityRepository extends JpaRepository<YtTbSiteConfigPartnersEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSiteConfigPartnersEntity entity where entity.isDeleted=?1")
    public YtTbSiteConfigPartnersEntity findALLByIsDeleted(int isDeleted);

    @Query("Select entity from YtTbSiteConfigPartnersEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteConfigPartnersEntity findOneById(long id, int isDeleted);


    @Query("Select entity from YtTbSiteConfigPartnersEntity entity where entity.isDeleted=?1")
    public List<YtTbSiteConfigPartnersEntity> findAllByIsDeleted(int isDeleted);

    @Query(value = "select count(*) from yt_tb_site_config_partners datas where  datas.isDeleted=?1 ", nativeQuery = true)
    public int findSizeByIsDeleted(int isDeleted);
}
