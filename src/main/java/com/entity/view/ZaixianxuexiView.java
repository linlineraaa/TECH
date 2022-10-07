package com.entity.view;

import com.entity.ZaixianxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 


@TableName("course")
public class ZaixianxuexiView  extends ZaixianxuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianxuexiView(){
	}
 
 	public ZaixianxuexiView(ZaixianxuexiEntity zaixianxuexiEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianxuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
