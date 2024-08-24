package com.cl.dao;

import com.cl.entity.YuyuezixishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuezixishiView;


/**
 * 预约自习室
 * 
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
public interface YuyuezixishiDao extends BaseMapper<YuyuezixishiEntity> {
	
	List<YuyuezixishiView> selectListView(@Param("ew") Wrapper<YuyuezixishiEntity> wrapper);

	List<YuyuezixishiView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuezixishiEntity> wrapper);
	
	YuyuezixishiView selectView(@Param("ew") Wrapper<YuyuezixishiEntity> wrapper);
	

}
