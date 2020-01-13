package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.DataNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DataNoticeDao {
    @Insert("INSERT " +
            "INTO agriculturaldata(ad_name, ad_address, ad_image, ad_infor, ad_type, ad_price, ad_position, ad_power, ad_remark, ad_author, ad_time) " +
            "VALUES(#{notice.adName}, #{notice.adAddress}, #{notice.adImage}, #{notice.adInfor}, #{notice.adType}, #{notice.adPrice}, #{notice.adPosition}, " +
            "#{notice.adPower}, #{notice.adRemark}, #{notice.adAuthor}, #{notice.adTime})")
    int save(@Param("notice") DataNotice notice);

    @Update("Update agriculturaldata " +
            "SET ad_name=#{notice.adName}, " +
            "ad_address=#{notice.adAddress}, " +
            "ad_image=#{notice.adImage}, " +
            "ad_infor=#{notice.adInfor}, " +
            "ad_type=#{notice.adType}, " +
            "ad_price=#{notice.adPrice}, " +
            "ad_position=#{notice.adPosition}, " +
            "ad_power=#{notice.adPower}, " +
            "ad_remark=#{notice.adRemark}, " +
            "ad_author=#{notice.adAuthor}, " +
            "ad_time=#{notice.adTime} " +
            "WHERE ad_id=#{notice.adId}")
    int update(@Param("notice") DataNotice notice);

    @Delete("DELETE " +
            "FROM agriculturaldata " +
            "WHERE ad_id =#{id} ")
    int delete(@Param("id") Integer id);

    @Select("SELECT * " +
            "FROM agriculturaldata " +
            "WHERE ad_id >= (SELECT ad_id from agriculturaldata ORDER BY ad_id LIMIT #{start}, 1) " +
            "ORDER BY ad_id " +
            "LIMIT #{limit}")
    List<DataNotice> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * " +
            "FROM agriculturaldata " +
            "WHERE ad_author =#{aAuthor}")
    List<DataNotice> findByAuthor(@Param("aAuthor") Integer authorId);

    @Select("SELECT * " +
            "FROM agriculturaldata " +
            "WHERE ad_type like #{adType}%")
    List<DataNotice> findByType(@Param("adType") String adType);

    @Select("SELECT * FROM agriculturaldata")
    List<DataNotice> findAll();

    @Select("SELECT * FROM agriculturaldata WHERE ad_id = #{adId}")
    DataNotice findById(String adId);
}
