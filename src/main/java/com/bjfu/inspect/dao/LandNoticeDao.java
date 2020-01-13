package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.LandNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LandNoticeDao {
    @Insert("INSERT " +
            "INTO landtrans(lt_image, lt_title, lt_type, lt_price, lt_region, lt_position, lt_area, lt_year, lt_name, lt_telephone, lt_address, lt_remark, lt_author, lt_time) " +
            "VALUES(#{notice.ltImage}, #{notice.ltTitle}, #{notice.ltType}, #{notice.ltPrice}, #{notice.ltRegion}, #{notice.ltPosition}, #{notice.ltArea}, #{notice.ltYear}, " +
            "#{notice.ltName},#{notice.ltTelephone},#{notice.ltAddress},#{notice.ltRemark}, #{notice.ltAuthor}, #{notice.ltTime})")
    int save(@Param("notice") LandNotice notice);

    @Update("Update landtrans " +
            "SET lt_image=#{notice.ltImage}, " +
            "lt_title=#{notice.ltTitle}, " +
            "lt_type=#{notice.ltType}, " +
            "lt_price=#{notice.ltPrice}, " +
            "lt_region=#{notice.ltRegion}, " +
            "lt_position=#{notice.ltPosition}, " +
            "lt_area=#{notice.ltArea}, " +
            "lt_year=#{notice.ltYear}, " +
            "lt_name=#{notice.ltName}, " +
            "lt_telephone=#{notice.ltTelephone}, " +
            "lt_address=#{notice.ltAddress}, " +
            "lt_remark=#{notice.ltRemark}, " +
            "lt_time=#{notice.ltTime} " +
            "WHERE lt_id=#{notice.ltId}")
    int update(@Param("notice") LandNotice notice);

    @Delete("DELETE " +
            "FROM landtrans " +
            "WHERE lt_id =#{id} ")
    int delete(@Param("id") Integer id);

    @Select("SELECT * " +
            "FROM landtrans " +
            "WHERE lt_id >= (SELECT lt_id from landtrans ORDER BY lt_id LIMIT #{start}, 1) " +
            "ORDER BY lt_id " +
            "LIMIT #{limit}")
    List<LandNotice> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * " +
            "FROM landtrans " +
            "WHERE lt_author =#{aAuthor}")
    List<LandNotice> findByAuthor(@Param("aAuthor") Integer authorId);

    @Select("SELECT * FROM landtrans")
    List<LandNotice> findAll();

    @Select("SELECT * FROM landtrans WHERE lt_id = #{ltId}")
    LandNotice findById(@Param("ltId")String ltId);
}
