package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.AllianceNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AllianceNoticeDao {
    @Insert("INSERT " +
            "INTO agriculturalall(a_title, a_image, a_infor, a_type, a_price, a_position, a_power, a_time, a_remark, a_author) " +
            "VALUES(#{notice.aTitle}, #{notice.aImage}, #{notice.aInfor}, #{notice.aType}, #{notice.aPrice}, #{notice.aPosition}, #{notice.aPower}, #{notice.aTime}, #{notice.aRemark}, #{notice.aAuthor})")
    int save(@Param("notice") AllianceNotice notice);

    @Update("Update agriculturalall " +
            "SET a_title=#{notice.aTitle}, " +
            "a_image=#{notice.aImage}, " +
            "a_infor=#{notice.aInfor}, " +
            "a_type=#{notice.aType}, " +
            "a_price=#{notice.aPrice}, " +
            "a_position=#{notice.aPosition}, " +
            "a_power=#{notice.aPower}, " +
            "a_time=#{notice.aTime}, " +
            "a_remark=#{notice.aRemark} " +
            "WHERE a_id=#{notice.aId}")
    int update(@Param("notice") AllianceNotice notice);

    @Delete("DELETE " +
            "FROM agriculturalall " +
            "WHERE a_id =#{id} ")
    int delete(@Param("id") Integer id);

    @Select("SELECT * " +
            "FROM agriculturalall " +
            "WHERE a_id >= (SELECT a_id from agriculturalall ORDER BY a_id LIMIT #{start}, 1) " +
            "ORDER BY a_id " +
            "LIMIT #{limit}")
    List<AllianceNotice> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * " +
            "FROM agriculturalall " +
            "WHERE a_author =#{aAuthor}")
    List<AllianceNotice> findByAuthor(@Param("aAuthor") Integer authorId);

    @Select("SELECT * FROM agriculturalall")
    List<AllianceNotice> findAll();

    @Select("SELECT * FROM agriculturalall WHERE a_id =#{noticeId}")
    AllianceNotice findById(@Param("noticeId")int noticeId);
}
