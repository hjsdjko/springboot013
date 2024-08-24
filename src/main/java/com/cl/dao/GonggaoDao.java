package com.cl.dao;

import com.cl.entity.GonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggaoView;


/**
 * 公告
 * 
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
public interface GonggaoDao extends BaseMapper<GonggaoEntity> {
	
	List<GonggaoView> selectListView(@Param("ew") Wrapper<GonggaoEntity> wrapper);

	List<GonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<GonggaoEntity> wrapper);
	
	GonggaoView selectView(@Param("ew") Wrapper<GonggaoEntity> wrapper);
	

}
