package com.entity.view;

import com.entity.CoursetyEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;



@TableName("coursety")
public class CoursetyView extends CoursetyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CoursetyView(){
	}

 	public CoursetyView(CoursetyEntity coursetyEntity){
 	try {
			BeanUtils.copyProperties(this, coursetyEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
