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

import com.cl.entity.GonggaoEntity;
import com.cl.entity.view.GonggaoView;

import com.cl.service.GonggaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 公告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-07 11:33:36
 */
@RestController
@RequestMapping("/gonggao")
public class GonggaoController {
    @Autowired
    private GonggaoService gonggaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggaoEntity gonggao,
		HttpServletRequest request){
        EntityWrapper<GonggaoEntity> ew = new EntityWrapper<GonggaoEntity>();

		PageUtils page = gonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GonggaoEntity gonggao, 
		HttpServletRequest request){
        EntityWrapper<GonggaoEntity> ew = new EntityWrapper<GonggaoEntity>();

		PageUtils page = gonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggaoEntity gonggao){
       	EntityWrapper<GonggaoEntity> ew = new EntityWrapper<GonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggao, "gonggao")); 
        return R.ok().put("data", gonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggaoEntity gonggao){
        EntityWrapper< GonggaoEntity> ew = new EntityWrapper< GonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggao, "gonggao")); 
		GonggaoView gonggaoView =  gonggaoService.selectView(ew);
		return R.ok("查询公告成功").put("data", gonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggaoEntity gonggao = gonggaoService.selectById(id);
		gonggao = gonggaoService.selectView(new EntityWrapper<GonggaoEntity>().eq("id", id));
        return R.ok().put("data", gonggao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggaoEntity gonggao = gonggaoService.selectById(id);
		gonggao = gonggaoService.selectView(new EntityWrapper<GonggaoEntity>().eq("id", id));
        return R.ok().put("data", gonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
    	gonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggao);
        gonggaoService.insert(gonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
    	gonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggao);
        gonggaoService.insert(gonggao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggao);
        gonggaoService.updateById(gonggao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
