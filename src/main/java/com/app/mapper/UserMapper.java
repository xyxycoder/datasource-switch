package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.app.entity.CardRecord;
import com.app.entity.User;

public interface UserMapper {


	

	String selectLastTime();
	
	String selectSysLastTime();
	
	String selectSmLastTime();
	
	
	
	int insertNewInfo(List<CardRecord> list);
	
	int insertSysInfo(List<CardRecord> list);
	
	int updateSmInfo(List<CardRecord> list);
	
	int insertSmInfo(List<CardRecord> list);
	
}
