package com.entity.model;

import com.entity.DiscusszaixianxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 


public class DiscusszaixianxuexiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
	private Long userid;
		
	
	
	private String content;
		
	
	
	private String reply;
				
	
	
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
	public Long getUserid() {
		return userid;
	}
				
	
	
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getContent() {
		return content;
	}
				
	
	
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	public String getReply() {
		return reply;
	}
			
}
