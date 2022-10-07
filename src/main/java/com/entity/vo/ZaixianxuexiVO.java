package com.entity.vo;

import com.entity.ZaixianxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 


public class ZaixianxuexiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
	private String kechengmingcheng;
		
	
	
	private String kechengleixing;
		
	
	
	private String tupian;
		
	
	
	private String shipin;
		
	
	
	private String xuexiziliao;
		
	
	
	private String kechengneirong;
		
	
	
	private String kechengliangdian;
		
	
	
	private String kechengjieshao;
		
	
	
	private Integer thumbsupnum;
		
	
	
	private Integer crazilynum;
				
	
	
	 
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
