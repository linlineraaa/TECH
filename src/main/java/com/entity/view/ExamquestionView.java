package com.entity.view;

import com.entity.ExamquestionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 


@TableName("examquestion")
public class ExamquestionView  extends ExamquestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExamquestionView(){
	}
 
 	public ExamquestionView(ExamquestionEntity examquestionEntity){
 	try {
			BeanUtils.copyProperties(this, examquestionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
