package com.bjfu.inspect.dao;

import com.bjfu.inspect.bean.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UsersDao {
    @Select("SELECT u_id from user WHERE u_name = #{uName}")
    Map<String, Object> isExist(@Param("uName") String uName);

    @Insert("INSERT " +
            "INTO user(u_name, u_password, u_gender, u_age, u_true_name, u_number, telephone_num, u_type) " +
            "VALUES(#{user.uName}, #{user.uPassword}, #{user.uGender}, #{user.uAge}, #{user.uTrueName}, #{user.uNumber}, #{user.telephoneNum}, #{user.uType})")
    int save(@Param("user") Users user);

    @Select("SELECT * " +
            "FROM user " +
            "WHERE u_name = #{uName}")
    Users findByName(@Param("uName") String uName);

    @Select("SELECT * " +
            "FROM user " +
            "WHERE u_id = #{ uId }")
    Users findById(@Param("uId") int uId);

    @Delete("DELETE FROM user WHERE u_id=#{uId}")
    int deleteById(@Param("uId") int uId);

    @Update("UPDATE user " +
            "SET u_name=#{user.uName}, " +
            "u_password=#{user.uPassword} " +
            "WHERE u_id=#{user.uId}")
    int update(@Param("user") Users user);

    @Select("SELECT * " +
            "FROM users " +
            "WHERE u_id >= (SELECT u_id from users ORDER BY u_id LIMIT #{start}, 1) " +
            "ORDER BY u_id " +
            "LIMIT #{limit}")
    List<Users> findPage(@Param("start") Integer page, @Param("limit") Integer limit);

    @Select("SELECT * FROM users")
    List<Users> findAll();

    @Select("SELECT count(u_id) from users")
    int usersNum();

    @Delete("DELETE FROM users WHERE u_name=#{uName}")
    int delete(@Param("uName") String uName);

    @Select("SELECT * " +
            "FROM users " +
            "WHERE u_name like #{word}")
    List<Users> searchUser(@Param("word") String word);
}
