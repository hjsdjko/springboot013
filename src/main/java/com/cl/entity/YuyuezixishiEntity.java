package com.cl.entity;

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


/**
 * 预约自习室
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
@TableName("yuyuezixishi")
public class YuyuezixishiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuyuezixishiEntity() {
		
	}
	
	public YuyuezixishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 自习室名称
	 */
					
	private String zixishimingcheng;
	
	/**
	 * 自习室号
	 */
					
	private String zixishihao;
	
	/**
	 * 自习室类型
	 */
					
	private String zixishileixing;
	
	/**
	 * 自习室图片
	 */
					
	private String zixishitupian;
	
	/**
	 * 自习室座位
	 */
					
	private Integer zixishizuowei;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
	/**
	 * 设置：自习室名称
	 */
	public void setZixishimingcheng(String zixishimingcheng) {
		this.zixishimingcheng = zixishimingcheng;
	}
	/**
	 * 获取：自习室名称
	 */
	public String getZixishimingcheng() {
		return zixishimingcheng;
	}
	/**
	 * 设置：自习室号
	 */
	public void setZixishihao(String zixishihao) {
		this.zixishihao = zixishihao;
	}
	/**
	 * 获取：自习室号
	 */
	public String getZixishihao() {
		return zixishihao;
	}
	/**
	 * 设置：自习室类型
	 */
	public void setZixishileixing(String zixishileixing) {
		this.zixishileixing = zixishileixing;
	}
	/**
	 * 获取：自习室类型
	 */
	public String getZixishileixing() {
		return zixishileixing;
	}
	/**
	 * 设置：自习室图片
	 */
	public void setZixishitupian(String zixishitupian) {
		this.zixishitupian = zixishitupian;
	}
	/**
	 * 获取：自习室图片
	 */
	public String getZixishitupian() {
		return zixishitupian;
	}
	/**
	 * 设置：自习室座位
	 */
	public void setZixishizuowei(Integer zixishizuowei) {
		this.zixishizuowei = zixishizuowei;
	}
	/**
	 * 获取：自习室座位
	 */
	public Integer getZixishizuowei() {
		return zixishizuowei;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：时间
	 */
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}
	/**
	 * 获取：时间
	 */
	public Date getShijian() {
		return shijian;
	}

}
