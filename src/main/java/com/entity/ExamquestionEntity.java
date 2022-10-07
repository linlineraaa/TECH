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



@TableName("examquestion")
public class ExamquestionEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ExamquestionEntity() {

	}

	public ExamquestionEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@TableId
	private Long id;


	private Long paperid;



	private String papername;



	private String questionname;



	private String options;



	private Long score;



	private String answer;



	private String analysis;



	private Long type;



	private Long sequence;


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

	public void setType(Long type) {
		this.type = type;
	}

	public Long getType() {
		return type;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getSequence() {
		return sequence;
	}

}
