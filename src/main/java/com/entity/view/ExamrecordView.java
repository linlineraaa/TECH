package com.entity.view;

import com.entity.ExamrecordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 


@TableName("examrecord")
public class ExamrecordView  extends ExamrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExamrecordView(){
	}
 
 	public ExamrecordView(ExamrecordEntity examrecordEntity){
 	try {
			BeanUtils.copyProperties(this, examrecordEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
