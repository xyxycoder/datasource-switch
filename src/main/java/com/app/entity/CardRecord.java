package com.app.entity;

import java.sql.Timestamp;

public class CardRecord {
	
	private Timestamp genTime;
	private Integer seqId;
	private String type1;
	private String typeName;
	private String param1;
	private String stateName;
	private String param2;
	private String devicesName;
	private String sitName;
	private String cardNumber;
	private String acctName;
	private String userName;
	private String operatorName;
	private String devicesState;
	public Timestamp getGenTime() {
		return genTime;
	}
	public void setGenTime(Timestamp genTime) {
		this.genTime = genTime;
	}
	public Integer getSeqId() {
		return seqId;
	}
	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getDevicesName() {
		return devicesName;
	}
	public void setDevicesName(String devicesName) {
		this.devicesName = devicesName;
	}
	public String getSitName() {
		return sitName;
	}
	public void setSitName(String sitName) {
		this.sitName = sitName;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getDevicesState() {
		return devicesState;
	}
	public void setDevicesState(String devicesState) {
		this.devicesState = devicesState;
	}
	
	
	

}
