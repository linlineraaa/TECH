package com.entity.view;

import com.entity.DiscusszaixianxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 


@TableName("discuss")
public class DiscusszaixianxuexiView  extends DiscusszaixianxuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszaixianxuexiView(){
	}
 
 	public DiscusszaixianxuexiView(DiscusszaixianxuexiEntity discusszaixianxuexiEntity){
 	try {
			BeanUtils.copyProperties(this, discusszaixianxuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
