package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;



@TableName("discuss")
public class DiscusszaixianxuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscusszaixianxuexiEntity() {
		
	}
	
	public DiscusszaixianxuexiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@TableId
	private Long id;
	
					
	private Long refid;
	
	
					
	private Long userid;
	
	
					
	private String content;
	
	
					
	private String reply;
	
	
	@JsonFormat(locale="en", timezone="GMT+1", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	
	public Long getRefid() {
		return refid;
	}
	
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
