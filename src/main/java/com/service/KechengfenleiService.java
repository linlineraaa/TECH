package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CoursetyEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KechengfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CoursetyView;



public interface KechengfenleiService extends IService<CoursetyEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<KechengfenleiVO> selectListVO(Wrapper<CoursetyEntity> wrapper);

   	KechengfenleiVO selectVO(@Param("ew") Wrapper<CoursetyEntity> wrapper);

   	List<CoursetyView> selectListView(Wrapper<CoursetyEntity> wrapper);

   	CoursetyView selectView(@Param("ew") Wrapper<CoursetyEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<CoursetyEntity> wrapper);

}

