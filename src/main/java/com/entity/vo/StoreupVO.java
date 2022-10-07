package com.entity.vo;

import com.entity.StoreupEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 


public class StoreupVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
	private Long refid;
		
	
	
	private String tablename;
		
	
	
	private String name;
		
	
	
	private String picture;
				
	
	
	 
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	
	
	public Long getRefid() {
		return refid;
	}
				
	
	
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	
	public String getTablename() {
		return tablename;
	}
				
	
	
	 
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
				
	
	
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	public String getPicture() {
		return picture;
	}
			
}
