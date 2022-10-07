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
import com.annotation.IgnoreAuth;

import com.entity.ZaixianxuexiEntity;
import com.entity.view.ZaixianxuexiView;

import com.service.ZaixianxuexiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


@RestController
@RequestMapping("/zaixianxuexi")
public class CourseController {
    @Autowired
    private ZaixianxuexiService zaixianxuexiService;




    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianxuexiEntity zaixianxuexi, HttpServletRequest request){

        EntityWrapper<ZaixianxuexiEntity> ew = new EntityWrapper<ZaixianxuexiEntity>();
		PageUtils page = zaixianxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxuexi), params), params));
        return R.ok().put("data", page);
    }


	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianxuexiEntity zaixianxuexi, HttpServletRequest request){
        EntityWrapper<ZaixianxuexiEntity> ew = new EntityWrapper<ZaixianxuexiEntity>();
		PageUtils page = zaixianxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxuexi), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( ZaixianxuexiEntity zaixianxuexi){
       	EntityWrapper<ZaixianxuexiEntity> ew = new EntityWrapper<ZaixianxuexiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianxuexi, "zaixianxuexi"));
        return R.ok().put("data", zaixianxuexiService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(ZaixianxuexiEntity zaixianxuexi){
        EntityWrapper< ZaixianxuexiEntity> ew = new EntityWrapper< ZaixianxuexiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianxuexi, "zaixianxuexi"));
		ZaixianxuexiView zaixianxuexiView =  zaixianxuexiService.selectView(ew);
		return R.ok("SearchCourseSuccess").put("data", zaixianxuexiView);
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianxuexiEntity zaixianxuexi = zaixianxuexiService.selectById(id);
        return R.ok().put("data", zaixianxuexi);
    }


	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianxuexiEntity zaixianxuexi = zaixianxuexiService.selectById(id);
        return R.ok().put("data", zaixianxuexi);
    }




    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ZaixianxuexiEntity zaixianxuexi = zaixianxuexiService.selectById(id);
        if(type.equals("1")) {
        	zaixianxuexi.setThumbsupnum(zaixianxuexi.getThumbsupnum()+1);
        } else {
        	zaixianxuexi.setCrazilynum(zaixianxuexi.getCrazilynum()+1);
        }
        zaixianxuexiService.updateById(zaixianxuexi);
        return R.ok();
    }


    @RequestMapping("/save")
    public R save(@RequestBody ZaixianxuexiEntity zaixianxuexi, HttpServletRequest request){
    	zaixianxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxuexi);

        zaixianxuexiService.insert(zaixianxuexi);
        return R.ok();
    }


    @RequestMapping("/add")
    public R add(@RequestBody ZaixianxuexiEntity zaixianxuexi, HttpServletRequest request){
    	zaixianxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxuexi);

        zaixianxuexiService.insert(zaixianxuexi);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody ZaixianxuexiEntity zaixianxuexi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianxuexi);
        zaixianxuexiService.updateById(zaixianxuexi);
        return R.ok();
    }



    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianxuexiService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<ZaixianxuexiEntity> wrapper = new EntityWrapper<ZaixianxuexiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zaixianxuexiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
