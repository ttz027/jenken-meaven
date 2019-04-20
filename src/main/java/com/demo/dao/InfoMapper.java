package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.demo.pojo.Info;

@Mapper
public interface InfoMapper {
	
//	@Select("select * from info where id = #{id}")
	Info findById(@Param("id") int id);
	@Select("select * from info")
	List<Info> findAll();
	
}
