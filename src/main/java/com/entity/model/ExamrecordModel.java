package com.entity.model;

import com.entity.ExamrecordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 


public class ExamrecordModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
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
			
}
