package com.controller;

import java.util.Date;
import java.util.List;

import com.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.utils.R;
import com.service.RecordService;

import javax.servlet.http.HttpServletRequest;

/**
 * recordController
 */
@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public R list(Record record, int pageNum, int pageSize,  HttpServletRequest request) {
        if(!request.getSession().getAttribute("role").toString().equals("admin")) {
            record.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        List<Record> list = recordService.selectRecordList(record, pageNum, pageSize);
        Long count = recordService.countRecord(record);
        return R.ok().put("rows", list).put("total", count);
    }

    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") Long id) {
        return R.ok().put("data", recordService.selectRecordById(id));
    }
    @PostMapping
    public R add(@RequestBody Record record) {
        recordService.insertRecord(record);
        return R.ok();
    }

    @PutMapping
    public R edit(@RequestBody Record record) {
        recordService.updateRecord(record);
        return R.ok();
    }
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable Long[] ids) {
        recordService.deleteRecordByIds(ids);
        return R.ok();
    }
}
