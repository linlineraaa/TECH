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



@TableName("examrecord")
public class ExamrecordEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ExamrecordEntity() {

	}

	public ExamrecordEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@TableId
	private Long id;


	private Long userid;



	private String username;



	private Long paperid;



	private String papername;



	private Long questionid;



	private String questionname;



	private String options;



	private Long score;



	private String answer;



	private String analysis;



	private Long myscore;



	private String myanswer;

	private Long recordid;

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

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPaperid(Long paperid) {
		this.paperid = paperid;
	}

	public Long getPaperid() {
		return paperid;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public String getPapername() {
		return papername;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getOptions() {
		return options;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getScore() {
		return score;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setMyscore(Long myscore) {
		this.myscore = myscore;
	}

	public Long getMyscore() {
		return myscore;
	}

	public void setMyanswer(String myanswer) {
		this.myanswer = myanswer;
	}

	public String getMyanswer() {
		return myanswer;
	}

	public Long getRecordid() {
		return recordid;
	}

	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}
}
