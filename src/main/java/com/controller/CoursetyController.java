package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.CoursetyEntity;
import com.entity.view.CoursetyView;

import com.service.KechengfenleiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


@RestController
@RequestMapping("/kechengfenlei")
public class CoursetyController {
    @Autowired
    private KechengfenleiService kechengfenleiService;




    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CoursetyEntity kechengfenlei, HttpServletRequest request){
        EntityWrapper<CoursetyEntity> ew = new EntityWrapper<CoursetyEntity>();
		PageUtils page = kechengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengfenlei), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CoursetyEntity kechengfenlei, HttpServletRequest request){
        EntityWrapper<CoursetyEntity> ew = new EntityWrapper<CoursetyEntity>();
		PageUtils page = kechengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengfenlei), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( CoursetyEntity kechengfenlei){
       	EntityWrapper<CoursetyEntity> ew = new EntityWrapper<CoursetyEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengfenlei, "kechengfenlei"));
        return R.ok().put("data", kechengfenleiService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(CoursetyEntity kechengfenlei){
        EntityWrapper<CoursetyEntity> ew = new EntityWrapper<CoursetyEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengfenlei, "kechengfenlei"));
		CoursetyView kechengfenleiView =  kechengfenleiService.selectView(ew);
		return R.ok("Search course categories successfully").put("data", kechengfenleiView);
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CoursetyEntity kechengfenlei = kechengfenleiService.selectById(id);
        return R.ok().put("data", kechengfenlei);
    }


    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CoursetyEntity kechengfenlei = kechengfenleiService.selectById(id);
        return R.ok().put("data", kechengfenlei);
    }





    @RequestMapping("/save")
    public R save(@RequestBody CoursetyEntity kechengfenlei, HttpServletRequest request){
    	kechengfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengfenlei);

        kechengfenleiService.insert(kechengfenlei);
        return R.ok();
    }


    @RequestMapping("/add")
    public R add(@RequestBody CoursetyEntity kechengfenlei, HttpServletRequest request){
    	kechengfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengfenlei);

        kechengfenleiService.insert(kechengfenlei);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody CoursetyEntity kechengfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengfenlei);
        kechengfenleiService.updateById(kechengfenlei);
        return R.ok();
    }



    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);

		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}

		Wrapper<CoursetyEntity> wrapper = new EntityWrapper<CoursetyEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kechengfenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
