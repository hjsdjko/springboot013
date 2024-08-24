package com.cl.entity.view;

import com.cl.entity.YuyuezixishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 预约自习室
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
@TableName("yuyuezixishi")
public class YuyuezixishiView  extends YuyuezixishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuezixishiView(){
	}
 
 	public YuyuezixishiView(YuyuezixishiEntity yuyuezixishiEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuezixishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
