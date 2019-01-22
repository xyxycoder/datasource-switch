package com.app.mapper;

import java.util.List;

import com.app.entity.CardRecord;

public interface InfoMapper {
    
	
	
    List<CardRecord> selectAllInfo();
	
	List<CardRecord> selectInfoByTime(String time);
	
	List<CardRecord> selectSysAllInfo(String time);
		
	List<CardRecord> selectSysInfoByTime(String time);
	
	List<CardRecord> selectSmAllInfo(String time);
	
    List<CardRecord> selectSmInfoByTime(String time);
}
