package com.service.impl;

import java.util.List;

import com.dao.RecordMapper;
import com.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService
{
    @Autowired
    private RecordMapper recordMapper;
    public Record selectRecordById(Long id)
    {
        return recordMapper.selectRecordById(id);
    }

    @Override
    public List<Record> selectRecordList(Record record, int pageNum, int pageSize)
    {
        return recordMapper.selectRecordList(record, (pageNum - 1) * pageSize,pageSize);
    }

    @Override
    public Long countRecord(Record record)
    {
        return recordMapper.countRecord(record);
    }

    @Override
    public int insertRecord(Record record)
    {
        return recordMapper.insertRecord(record);
    }

    @Override
    public int updateRecord(Record record)
    {
        return recordMapper.updateRecord(record);
    }

    @Override
    public int deleteRecordByIds(Long[] ids)
    {
        return recordMapper.deleteRecordByIds(ids);
    }

    @Override
    public int deleteRecordById(Long id)
    {
        return recordMapper.deleteRecordById(id);
    }
}
