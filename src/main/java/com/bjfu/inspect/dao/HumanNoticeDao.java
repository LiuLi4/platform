package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.HumanNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HumanNoticeDao {
    @Insert("INSERT " +
            "INTO humanresoures(hr_title, hr_skill, hr_wage, hr_address, hr_request, hr_name, hr_telephone, hr_remark, hr_author, hr_time) " +
            "VALUES(#{notice.hrTitle}, #{notice.hrSkill}, #{notice.hrWage}, #{notice.hrAddress}, #{notice.hrRequest}, #{notice.hrName}, " +
            "#{notice.hrTelephone}, #{notice.hrRemark}, #{notice.hrAuthor}, #{notice.hrTime})")
    int save(@Param("notice") HumanNotice notice);

    @Update("Update humanresoures " +
            "SET hr_title=#{notice.hrTitle}, " +
            "hr_skill=#{notice.hrSkill}, " +
            "hr_wage=#{notice.hrWage}, " +
            "hr_address=#{notice.hrAddress}, " +
            "hr_request=#{notice.hrRequest}, " +
            "hr_name=#{notice.hrName}, " +
            "hr_telephone=#{notice.hrTelephone}, " +
            "hr_remark=#{notice.hrRemark}, " +
            "hr_time=#{notice.hrTime} " +
            "WHERE hr_id=#{notice.hrId}")
    int update(@Param("notice") HumanNotice notice);

    @Delete("DELETE " +
            "FROM humanresoures " +
            "WHERE hr_id =#{id} ")
    int delete(@Param("id") Integer id);

    @Select("SELECT * " +
            "FROM humanresoures " +
            "WHERE hr_id >= (SELECT hr_id from humanresoures ORDER BY hr_id LIMIT #{start}, 1) " +
            "ORDER BY hr_id " +
            "LIMIT #{limit}")
    List<HumanNotice> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * " +
            "FROM humanresoures " +
            "WHERE hr_author =#{aAuthor}")
    List<HumanNotice> findByAuthor(@Param("aAuthor") Integer authorId);

    @Select("SELECT * FROM humanresoures")
    List<HumanNotice> findAll();

    @Select("SELECT * FROM humanresoures WHERE hr_id=#{hrId}")
    HumanNotice findById(@Param("hrId")String hrId);
}
