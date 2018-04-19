package com.yt.design.jpa.repository.normal;

import com.yt.design.jpa.entity.YtTbFontSiteUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午4:22
 **/

public interface YtTbFontSiteUserEntityRepository extends JpaRepository<YtTbFontSiteUserEntity, String> {

    //    @Query("Select entity from LeMobileUserSmsEntity entity where entity.smsTag= ?1 and entity.phone= ?2 and  entity.isDeleted=0")
    @Query("Select entity from YtTbFontSiteUserEntity entity where entity.isDeleted=?1")
    public YtTbFontSiteUserEntity findALLByIsDeleted(int isDeleted);


    @Query("Select entity from YtTbFontSiteUserEntity entity where entity.id=?1 and entity.isDeleted=?2")
    public YtTbFontSiteUserEntity findOneById(long id, int isDeleted);


    @Query("Select entity from YtTbFontSiteUserEntity entity where entity.email=?1 and entity.isDeleted=?2")
    public YtTbFontSiteUserEntity findOneByEmail(String email, int isDeleted);


}
