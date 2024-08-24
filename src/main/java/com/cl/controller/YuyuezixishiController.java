package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuyuezixishiEntity;
import com.cl.entity.view.YuyuezixishiView;

import com.cl.service.YuyuezixishiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约自习室
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
@RestController
@RequestMapping("/yuyuezixishi")
public class YuyuezixishiController {
    @Autowired
    private YuyuezixishiService yuyuezixishiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuezixishiEntity yuyuezixishi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yuyuezixishi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuezixishiEntity> ew = new EntityWrapper<YuyuezixishiEntity>();

		PageUtils page = yuyuezixishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuezixishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuezixishiEntity yuyuezixishi, 
		HttpServletRequest request){
        EntityWrapper<YuyuezixishiEntity> ew = new EntityWrapper<YuyuezixishiEntity>();

		PageUtils page = yuyuezixishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuezixishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuezixishiEntity yuyuezixishi){
       	EntityWrapper<YuyuezixishiEntity> ew = new EntityWrapper<YuyuezixishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuezixishi, "yuyuezixishi")); 
        return R.ok().put("data", yuyuezixishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuezixishiEntity yuyuezixishi){
        EntityWrapper< YuyuezixishiEntity> ew = new EntityWrapper< YuyuezixishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuezixishi, "yuyuezixishi")); 
		YuyuezixishiView yuyuezixishiView =  yuyuezixishiService.selectView(ew);
		return R.ok("查询预约自习室成功").put("data", yuyuezixishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuezixishiEntity yuyuezixishi = yuyuezixishiService.selectById(id);
		yuyuezixishi = yuyuezixishiService.selectView(new EntityWrapper<YuyuezixishiEntity>().eq("id", id));
        return R.ok().put("data", yuyuezixishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuezixishiEntity yuyuezixishi = yuyuezixishiService.selectById(id);
		yuyuezixishi = yuyuezixishiService.selectView(new EntityWrapper<YuyuezixishiEntity>().eq("id", id));
        return R.ok().put("data", yuyuezixishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuezixishiEntity yuyuezixishi, HttpServletRequest request){
    	yuyuezixishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuezixishi);
        yuyuezixishiService.insert(yuyuezixishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuezixishiEntity yuyuezixishi, HttpServletRequest request){
    	yuyuezixishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuezixishi);
        yuyuezixishiService.insert(yuyuezixishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuezixishiEntity yuyuezixishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuezixishi);
        yuyuezixishiService.updateById(yuyuezixishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuezixishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
