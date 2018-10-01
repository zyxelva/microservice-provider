package com.taeyeon.zyx.controller;

import com.taeyeon.zyx.application.report.TbClientReportApplication;
import com.taeyeon.zyx.common.Page;
import com.taeyeon.zyx.dto.ReportParamDto;
import com.taeyeon.zyx.dto.TbClientReportDto;
import com.taeyeon.zyx.utils.CommUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class ClientReportController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

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

    @PostMapping("/listByIds")
    public List<TbClientReportDto> listByIds(@RequestBody Collection<Long> ids) {
        System.out.println("================listByIds===============");
        return tbClientReportApplication.list(ids);
    }

    @PostMapping("/listByObject")
    public TbClientReportDto listByObject(@RequestBody TbClientReportDto reportDto) {
        System.out.println("================listByObject===============");
        if (!CommUtil.isValid(reportDto.getId())) {
            logger.error("listByObject, but id is null.");
            return null;
        }
        return tbClientReportApplication.get(reportDto.getId());
    }


    @PostMapping("/page")
    public Page<TbClientReportDto> page(ReportParamDto reportParam) {
        if (reportParam == null) {
            logger.error("page,but reportParam should not be null!");
            return Page.emptyPage();
        }
        System.out.println("================page===============");
        return tbClientReportApplication.page(reportParam);
    }

    @PostMapping("/add")
    public Long add(@RequestBody TbClientReportDto reportDto){
        if(null==reportDto){
            logger.error("add, but reportDto is null");
            return null;
        }
        System.out.println("================add===============");
        return tbClientReportApplication.add(reportDto);
    }

    @PutMapping("/delete")
    public int delete(@RequestBody TbClientReportDto reportDto){
        if(null==reportDto){
            logger.error("delete, but reportDto is null");
            return 0;
        }
        System.out.println("================delete===============");
        return tbClientReportApplication.delete(reportDto);
    }
}
