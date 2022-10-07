package com.dao;

import com.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper
{
    public Record selectRecordById(Long id);

    public List<Record> selectRecordList(@Param("Record") Record record, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Long countRecord(Record record);

    public int insertRecord(Record record);

    public int updateRecord(Record record);

    public int deleteRecordById(Long id);

    public int deleteRecordByIds(Long[] ids);
}
