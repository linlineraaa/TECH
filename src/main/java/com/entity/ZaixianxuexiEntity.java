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



@TableName("course")
public class ZaixianxuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZaixianxuexiEntity() {

	}

	public ZaixianxuexiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@TableId
	private Long id;


	@TableField("course_id")
	private String kechengbianhao;


	@TableField("course_name")
	private String kechengmingcheng;


	@TableField("course_type")
	private String kechengleixing;


	@TableField("picture")
	private String tupian;


	@TableField("video")
	private String shipin;


	@TableField("information")
	private String xuexiziliao;


	@TableField("course_content")
	private String kechengneirong;


	@TableField("course_highlight")
	private String kechengliangdian;


	@TableField("course_introduction")
	private String kechengjieshao;


	private Integer thumbsupnum;


	private Integer crazilynum;


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

	public void setKechengbianhao(String kechengbianhao) {
		this.kechengbianhao = kechengbianhao;
	}

	public String getKechengbianhao() {
		return kechengbianhao;
	}

	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}

	public String getKechengmingcheng() {
		return kechengmingcheng;
	}

	public void setKechengleixing(String kechengleixing) {
		this.kechengleixing = kechengleixing;
	}

	public String getKechengleixing() {
		return kechengleixing;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}

	public String getTupian() {
		return tupian;
	}

	public void setShipin(String shipin) {
		this.shipin = shipin;
	}

	public String getShipin() {
		return shipin;
	}

	public void setXuexiziliao(String xuexiziliao) {
		this.xuexiziliao = xuexiziliao;
	}

	public String getXuexiziliao() {
		return xuexiziliao;
	}

	public void setKechengneirong(String kechengneirong) {
		this.kechengneirong = kechengneirong;
	}

	public String getKechengneirong() {
		return kechengneirong;
	}

	public void setKechengliangdian(String kechengliangdian) {
		this.kechengliangdian = kechengliangdian;
	}

	public String getKechengliangdian() {
		return kechengliangdian;
	}

	public void setKechengjieshao(String kechengjieshao) {
		this.kechengjieshao = kechengjieshao;
	}

	public String getKechengjieshao() {
		return kechengjieshao;
	}

	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}

	public Integer getThumbsupnum() {
		return thumbsupnum;
	}

	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}

	public Integer getCrazilynum() {
		return crazilynum;
	}

}
