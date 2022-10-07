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

import com.entity.DiscusszaixianxuexiEntity;
import com.entity.view.DiscusszaixianxuexiView;

import com.service.DiscusszaixianxuexiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


@RestController
@RequestMapping("/discusszaixianxuexi")
public class DiscussController {
    @Autowired
    private DiscusszaixianxuexiService discusszaixianxuexiService;




    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszaixianxuexiEntity discusszaixianxuexi, HttpServletRequest request){

        EntityWrapper<DiscusszaixianxuexiEntity> ew = new EntityWrapper<DiscusszaixianxuexiEntity>();
		PageUtils page = discusszaixianxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszaixianxuexi), params), params));
        return R.ok().put("data", page);
    }


	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszaixianxuexiEntity discusszaixianxuexi, HttpServletRequest request){
        EntityWrapper<DiscusszaixianxuexiEntity> ew = new EntityWrapper<DiscusszaixianxuexiEntity>();
		PageUtils page = discusszaixianxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszaixianxuexi), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( DiscusszaixianxuexiEntity discusszaixianxuexi){
       	EntityWrapper<DiscusszaixianxuexiEntity> ew = new EntityWrapper<DiscusszaixianxuexiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszaixianxuexi, "discusszaixianxuexi"));
        return R.ok().put("data", discusszaixianxuexiService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(DiscusszaixianxuexiEntity discusszaixianxuexi){
        EntityWrapper< DiscusszaixianxuexiEntity> ew = new EntityWrapper< DiscusszaixianxuexiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszaixianxuexi, "discusszaixianxuexi"));
		DiscusszaixianxuexiView discusszaixianxuexiView =  discusszaixianxuexiService.selectView(ew);
		return R.ok("SearchCourseSuccess").put("data", discusszaixianxuexiView);
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszaixianxuexiEntity discusszaixianxuexi = discusszaixianxuexiService.selectById(id);
        return R.ok().put("data", discusszaixianxuexi);
    }


    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszaixianxuexiEntity discusszaixianxuexi = discusszaixianxuexiService.selectById(id);
        return R.ok().put("data", discusszaixianxuexi);
    }





    @RequestMapping("/save")
    public R save(@RequestBody DiscusszaixianxuexiEntity discusszaixianxuexi, HttpServletRequest request){
    	discusszaixianxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszaixianxuexi);

        discusszaixianxuexiService.insert(discusszaixianxuexi);
        return R.ok();
    }


    @RequestMapping("/add")
    public R add(@RequestBody DiscusszaixianxuexiEntity discusszaixianxuexi, HttpServletRequest request){
    	discusszaixianxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszaixianxuexi);

        discusszaixianxuexiService.insert(discusszaixianxuexi);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody DiscusszaixianxuexiEntity discusszaixianxuexi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszaixianxuexi);
        discusszaixianxuexiService.updateById(discusszaixianxuexi);
        return R.ok();
    }



    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszaixianxuexiService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<DiscusszaixianxuexiEntity> wrapper = new EntityWrapper<DiscusszaixianxuexiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszaixianxuexiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
