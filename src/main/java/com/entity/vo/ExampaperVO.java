package com.entity.vo;

import com.entity.ExampaperEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 


public class ExampaperVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
	private Integer time;
		
	
	
	private Integer status;
				
	
	
	 
	public void setTime(Integer time) {
		this.time = time;
	}
	
	
	public Integer getTime() {
		return time;
	}
				
	
	
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public Integer getStatus() {
		return status;
	}
			
}
