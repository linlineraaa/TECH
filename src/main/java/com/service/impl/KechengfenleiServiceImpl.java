package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CoursetyDao;
import com.entity.CoursetyEntity;
import com.service.KechengfenleiService;
import com.entity.vo.KechengfenleiVO;
import com.entity.view.CoursetyView;

@Service("kechengfenleiService")
public class KechengfenleiServiceImpl extends ServiceImpl<CoursetyDao, CoursetyEntity> implements KechengfenleiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CoursetyEntity> page = this.selectPage(
                new Query<CoursetyEntity>(params).getPage(),
                new EntityWrapper<CoursetyEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CoursetyEntity> wrapper) {
		  Page<CoursetyView> page =new Query<CoursetyView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<KechengfenleiVO> selectListVO(Wrapper<CoursetyEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public KechengfenleiVO selectVO(Wrapper<CoursetyEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<CoursetyView> selectListView(Wrapper<CoursetyEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CoursetyView selectView(Wrapper<CoursetyEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
