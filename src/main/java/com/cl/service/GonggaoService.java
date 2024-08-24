package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GonggaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggaoView;


/**
 * 公告
 *
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
public interface GonggaoService extends IService<GonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggaoView> selectListView(Wrapper<GonggaoEntity> wrapper);
   	
   	GonggaoView selectView(@Param("ew") Wrapper<GonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggaoEntity> wrapper);
   	

}

