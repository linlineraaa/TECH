package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ExamquestionEntity;
import com.entity.view.ExamquestionView;

import com.service.ExamquestionService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;



@RestController
@RequestMapping("/examquestion")
public class ExamquestionController {
    @Autowired
    private ExamquestionService examquestionService;




    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExamquestionEntity examquestion, HttpServletRequest request){

        EntityWrapper<ExamquestionEntity> ew = new EntityWrapper<ExamquestionEntity>();
		PageUtils page = examquestionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examquestion), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExamquestionEntity examquestion, HttpServletRequest request){
        EntityWrapper<ExamquestionEntity> ew = new EntityWrapper<ExamquestionEntity>();
		PageUtils page = examquestionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examquestion), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/lists")
    public R list( ExamquestionEntity examquestion){
       	EntityWrapper<ExamquestionEntity> ew = new EntityWrapper<ExamquestionEntity>();
      	ew.allEq(MPUtil.allEQMapPre( examquestion, "examquestion"));
        return R.ok().put("data", examquestionService.selectListView(ew));
    }


    @RequestMapping("/query")
    public R query(ExamquestionEntity examquestion){
        EntityWrapper< ExamquestionEntity> ew = new EntityWrapper< ExamquestionEntity>();
 		ew.allEq(MPUtil.allEQMapPre( examquestion, "examquestion"));
		ExamquestionView examquestionView =  examquestionService.selectView(ew);
		return R.ok("SearchSuccess").put("data", examquestionView);
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExamquestionEntity examquestion = examquestionService.selectById(id);
        return R.ok().put("data", examquestion);
    }


    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExamquestionEntity examquestion = examquestionService.selectById(id);
        return R.ok().put("data", examquestion);
    }





    @RequestMapping("/save")
    public R save(@RequestBody ExamquestionEntity examquestion, HttpServletRequest request){
    	examquestion.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examquestion);

        examquestionService.insert(examquestion);
        return R.ok();
    }


    @RequestMapping("/add")
    public R add(@RequestBody ExamquestionEntity examquestion, HttpServletRequest request){
    	examquestion.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(examquestion);

        examquestionService.insert(examquestion);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody ExamquestionEntity examquestion, HttpServletRequest request){
        //ValidatorUtils.validateEntity(examquestion);
        examquestionService.updateById(examquestion);
        return R.ok();
    }



    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        examquestionService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<ExamquestionEntity> wrapper = new EntityWrapper<ExamquestionEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = examquestionService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
