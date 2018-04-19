package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbSitePayOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/
//商品信息表

public interface YtTbSitePayOrderEntityRepository extends JpaRepository<YtTbSitePayOrderEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbSitePayOrderEntity entity where entity.isDeleted=?1")
    public YtTbSitePayOrderEntity findALLByIsDeleted(int isDeleted);





    @Query("Select entity from YtTbSitePayOrderEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbSitePayOrderEntity findOneById(long id, int isDeleted);
}
