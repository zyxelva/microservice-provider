package com.taeyeon.zyx.controller;

import com.taeyeon.zyx.application.report.TbClientReportApplication;
import com.taeyeon.zyx.dto.TbClientReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class ClientReportControl {

    @Autowired
    private TbClientReportApplication tbClientReportApplication;

    @GetMapping("/testHello/{name}")
    public String testHello(@PathVariable("name") String name) {
        return "Hello world," + name;
    }

    @GetMapping("/getReportById/{id}")
    public TbClientReportDto getReportById(@PathVariable("id") Long id) {
        System.out.println("================this is one-----=====================get client report start. id:{}: " + id);
        return tbClientReportApplication.get(id);
    }

    @GetMapping("/getReportById2/{id}")
    public ResponseEntity<TbClientReportDto> getReportById2(@PathVariable("id") String id) {
        System.out.println("================this is two----==========================get client report start. id:{}: " + id);
        return ResponseEntity.ok(tbClientReportApplication.get(Long.valueOf(id)));
    }

}
