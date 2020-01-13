package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.ProjectNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectNoticeDao {
    @Insert("INSERT " +
            "INTO project(p_title, p_image, p_address, p_type, p_hnum, p_wage, p_time, p_creat_time, p_remark, p_author) " +
            "VALUES(#{notice.pTitle}, #{notice.pImage}, #{notice.pAddress}, #{notice.pType}, #{notice.pHnum}, #{notice.pWage}, #{notice.pTime}, #{notice.pCreatTime}, #{notice.pRemark}, #{notice.pAuthor})")
    int save(@Param("notice") ProjectNotice notice);

    @Update("Update project " +
            "SET p_title=#{notice.pTitle}, " +
            "p_image=#{notice.pImage}, " +
            "p_address=#{notice.pAddress}, " +
            "p_type=#{notice.pType}, " +
            "p_hnum=#{notice.pHnum}, " +
            "p_wage=#{notice.pWage}, " +
            "p_time=#{notice.pTime}, " +
            "p_creat_time=#{notice.pCreatTime}, " +
            "p_remark=#{notice.pRemark} " +
            "WHERE p_id=#{notice.pId}")
    int update(@Param("notice") ProjectNotice notice);

    @Delete("DELETE " +
            "FROM project " +
            "WHERE p_id =#{id} ")
    int delete(@Param("id") Integer id);

    @Select("SELECT * " +
            "FROM project " +
            "WHERE p_id >= (SELECT p_id from project ORDER BY p_id LIMIT #{start}, 1) " +
            "ORDER BY p_id " +
            "LIMIT #{limit}")
    List<ProjectNotice> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * " +
            "FROM project " +
            "WHERE p_author =#{aAuthor}")
    List<ProjectNotice> findByAuthor(@Param("aAuthor") Integer authorId);

    @Select("SELECT * FROM project")
    List<ProjectNotice> findAll();

    @Select("SELECT * FROM project WHERE p_id =#{pId}")
    ProjectNotice findById(@Param("pId")String pId);
}
