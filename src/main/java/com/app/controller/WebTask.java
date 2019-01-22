package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.app.entity.CardRecord;
import com.app.mapper.InfoMapper;
import com.app.mapper.UserMapper;
import com.app.servcie.UserService;
import com.app.util.CustomerContextHolder;

@Component
public class WebTask {
	
	@Autowired
	private InfoMapper infoMapper;
	@Autowired
	private UserMapper userMapper;
	public static boolean isFlg=false;
   
	@Scheduled(cron = "0/45 * * * * ?")
	public void taskJob(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = new GregorianCalendar();
		Date date = new Date();
		c.setTime(date);//设置参数时间
		c.add(Calendar.SECOND,-120);//把日期往后增加SECOND 秒.整数往后推,负数往前移动
		date=c.getTime();
		String str = df.format(date);
		
		
		List<CardRecord> list;
		List<CardRecord> sysList;
		List<CardRecord> smList;
		//查询上次最后插入数据时间cardrecord表   p=30,79
		String cardRecord = userMapper.selectLastTime();
		//切换数据源，获取数据
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MSSQL);	
		
		//sys_alarm表
			sysList = infoMapper.selectSysAllInfo(str);
			System.out.println("查询时间是"+str+"     !!!!!!!!!!!!!!!!!!!!!!!               )))))))))))))))))))))");
			System.out.println(sysList);
			System.out.println("查询时间是"+str+"     !!!!!!!!!!!!!!!!!!!!!!!               )))))))))))))))))))))");
		//Sm_collection_point表
			smList = infoMapper.selectSmAllInfo(str);
		//cardrecord表
		if(StringUtils.isEmpty(cardRecord)){
			//第一次插入
			list = infoMapper.selectAllInfo();
		}else{
			//更具时间查询最新数据插入
			list = infoMapper.selectInfoByTime(cardRecord);
		}
		//切换数据源，插入数据
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);	
		//sys_alarm表
		if(!sysList.isEmpty()){
			userMapper.insertSysInfo(sysList);
			System.out.println("sys_alarm插入了了"+sysList.size()+"条数据");
			//ASSERT_ID
			userMapper.updateSmInfo(sysList);
		}
		//cardrecord表
		if(!list.isEmpty()){
		userMapper.insertNewInfo(list);
		System.out.println("cardrecord插入了了"+list.size()+"条数据");
		}
		//Sm_collection_point表
		if(!smList.isEmpty()){
		userMapper.insertSmInfo(smList);
		}
	}
	
	
//	@Scheduled(cron = "0/30 * * * * ?")
//	public void taskJob(){
//		List<CardRecord> list;
//		List<CardRecord> sysList;
//		List<CardRecord> smList;
//		//查询上次最后插入数据时间cardrecord表   p=30,79
//		String cardRecord = userMapper.selectLastTime();
//		//查询上次最后插入数据时间sys_alarm表   p=20 且报警类型为报警和强制开门
//		String startDate = userMapper.selectSysLastTime();
//		//查询上次最后插入数据时间Sm_collection_point表   p=20 非报警
//		String pointDate = userMapper.selectSmLastTime();
//		//切换数据源，获取数据
//		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MSSQL);	
//		
//		//sys_alarm表
//		if(StringUtils.isEmpty(startDate)){
//			sysList = infoMapper.selectSysAllInfo();
//		}else {
//			sysList = infoMapper.selectSysInfoByTime(startDate);
//		}
//		//Sm_collection_point表
//		if (StringUtils.isEmpty(pointDate)) {
//			smList = infoMapper.selectSmAllInfo();
//		} else {
//			smList = infoMapper.selectSmInfoByTime(pointDate);
//		}
//		//cardrecord表
//		if(StringUtils.isEmpty(cardRecord)){
//			//第一次插入
//			list = infoMapper.selectAllInfo();
//		}else{
//			//更具时间查询最新数据插入
//			list = infoMapper.selectInfoByTime(cardRecord);
//		}
//		//切换数据源，插入数据
//		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_MYSQL);	
//		//cardrecord表
//		if(!list.isEmpty()){
//		userMapper.insertNewInfo(list);
//		System.out.println("cardrecord插入了了"+list.size()+"条数据");
//		}
//		//sys_alarm表
//		if(!sysList.isEmpty()){
//		userMapper.insertSysInfo(sysList);
//		System.out.println("sys_alarm插入了了"+sysList.size()+"条数据");
//		}
//		//Sm_collection_point表
//		if(!smList.isEmpty()){
//		userMapper.insertSmInfo(smList);
//		}
//	}
	
//	@Scheduled(cron = "0/30 * * * * ?")
//	public void sendOrderToDSPT() throws Exception {
//		if (isFlg) {
//			return;
//		}
//		isFlg = true;
//		try{
//			this.taskJob();
//			isFlg = false;
//		}catch(Exception e){
//			System.out.println(e.getMessage().toString());
//			System.out.println("执行错误");
//		}finally{
//		isFlg = false;
//		}
//	}
}
