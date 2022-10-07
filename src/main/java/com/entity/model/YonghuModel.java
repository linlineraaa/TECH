package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;



public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;




	private String mima;



	private String xingming;



	private String nianling;



	private String xingbie;



	private String shouji;



	private String youxiang;



	private String shenfenzheng;




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

}
