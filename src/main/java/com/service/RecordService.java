package com.service;

import com.entity.Record;

import java.util.List;

public interface RecordService
{
    public Record selectRecordById(Long id);

    public List<Record> selectRecordList(Record record, int pageNum, int pageSize);

    public Long countRecord(Record record);

    public int insertRecord(Record record);

    public int updateRecord(Record record);

    public int deleteRecordByIds(Long[] ids);

    public int deleteRecordById(Long id);
}
