package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YuyuezixishiDao;
import com.cl.entity.YuyuezixishiEntity;
import com.cl.service.YuyuezixishiService;
import com.cl.entity.view.YuyuezixishiView;

@Service("yuyuezixishiService")
public class YuyuezixishiServiceImpl extends ServiceImpl<YuyuezixishiDao, YuyuezixishiEntity> implements YuyuezixishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuezixishiEntity> page = this.selectPage(
                new Query<YuyuezixishiEntity>(params).getPage(),
                new EntityWrapper<YuyuezixishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuezixishiEntity> wrapper) {
		  Page<YuyuezixishiView> page =new Query<YuyuezixishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyuezixishiView> selectListView(Wrapper<YuyuezixishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuezixishiView selectView(Wrapper<YuyuezixishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
