package com.entity.vo;

import com.entity.ExamquestionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 


public class ExamquestionVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	
	
	private String papername;
		
	
	
	private String questionname;
		
	
	
	private String options;
		
	
	
	private Long score;
		
	
	
	private String answer;
		
	
	
	private String analysis;
		
	
	
	private Long type;
		
	
	
	private Long sequence;
				
	
	
	 
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
