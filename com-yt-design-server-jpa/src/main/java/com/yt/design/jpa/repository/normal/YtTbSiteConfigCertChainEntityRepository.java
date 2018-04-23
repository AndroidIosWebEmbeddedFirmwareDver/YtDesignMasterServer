package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSiteConfigCertChainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/
//商品信息表

public interface YtTbSiteConfigCertChainEntityRepository extends JpaRepository<YtTbSiteConfigCertChainEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSiteConfigCertChainEntity entity where entity.isDeleted=?1")
    public YtTbSiteConfigCertChainEntity findALLByIsDeleted(int isDeleted);

    @Query("Select entity from YtTbSiteConfigCertChainEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSiteConfigCertChainEntity findOneById(long id, int isDeleted);


    @Query("Select entity from YtTbSiteConfigCertChainEntity entity where entity.isDeleted=?1")
    public List<YtTbSiteConfigCertChainEntity> findAllByIsDeleted(int isDeleted);

    @Query(value = "select count(*) from yt_tb_site_config_cert_chain datas where  datas.isDeleted=?1 ", nativeQuery = true)
    public int findSizeByIsDeleted(int isDeleted);
}
