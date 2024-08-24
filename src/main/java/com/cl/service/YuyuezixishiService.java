package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyuezixishiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuezixishiView;


/**
 * 预约自习室
 *
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
public interface YuyuezixishiService extends IService<YuyuezixishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuezixishiView> selectListView(Wrapper<YuyuezixishiEntity> wrapper);
   	
   	YuyuezixishiView selectView(@Param("ew") Wrapper<YuyuezixishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuezixishiEntity> wrapper);
   	

}
