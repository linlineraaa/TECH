package com.dao;

import com.entity.CoursetyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengfenleiVO;
import com.entity.view.CoursetyView;



public interface CoursetyDao extends BaseMapper<CoursetyEntity> {

	List<KechengfenleiVO> selectListVO(@Param("ew") Wrapper<CoursetyEntity> wrapper);

	KechengfenleiVO selectVO(@Param("ew") Wrapper<CoursetyEntity> wrapper);

	List<CoursetyView> selectListView(@Param("ew") Wrapper<CoursetyEntity> wrapper);

	List<CoursetyView> selectListView(Pagination page, @Param("ew") Wrapper<CoursetyEntity> wrapper);

	CoursetyView selectView(@Param("ew") Wrapper<CoursetyEntity> wrapper);

}
