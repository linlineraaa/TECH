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



@TableName("user")
public class YonghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YonghuEntity() {

	}

	public YonghuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@TableId
	private Long id;


	@TableField("account")
	private String yonghuming;


	@TableField("password")
	private String mima;


	@TableField("username")
	private String xingming;


	@TableField("age")
	private String nianling;


	@TableField("sex")
	private String xingbie;


	@TableField("phone")
	private String shouji;


	@TableField("mail")
	private String youxiang;

	@TableField("student_number")
	private String shenfenzheng;


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

	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}

	public String getYonghuming() {
		return yonghuming;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getMima() {
		return mima;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingming() {
		return xingming;
	}

	public void setNianling(String nianling) {
		this.nianling = nianling;
	}

	public String getNianling() {
		return nianling;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getShouji() {
		return shouji;
	}

	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}

	public String getYouxiang() {
		return youxiang;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}

	public String getShenfenzheng() {
		return shenfenzheng;
	}

	@Override
	public String toString() {
		return "YonghuEntity{" +
				"id=" + id +
				", yonghuming='" + yonghuming + '\'' +
				", mima='" + mima + '\'' +
				", xingming='" + xingming + '\'' +
				", nianling='" + nianling + '\'' +
				", xingbie='" + xingbie + '\'' +
				", shouji='" + shouji + '\'' +
				", youxiang='" + youxiang + '\'' +
				", shenfenzheng='" + shenfenzheng + '\'' +
				", addtime=" + addtime +
				'}';
	}
}
