package com.taeyeon.zyx.controller;

import com.taeyeon.zyx.api.TestApi;
import com.taeyeon.zyx.application.TeacherApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/student")
public class TestControl implements TestApi {
	@Autowired
	private TeacherApplication teacherApplication;

	@Override
	@RequestMapping("/testHello/{name}")
	public String testHello(@PathVariable("name")String name) {
		return "Hello world,"+name;
	}

	@RequestMapping("/user/getById")
	//@ResponseBody
	public  String getUserById(String id){
		System.out.println("++++++++++++++++From provider One: "+id);
		//return "\"helllllllllllllo\""+": "+"\""+id+"\"";
		return "hello Provider One "+id;
	}


	@RequestMapping("/user/getById/{id}")
	public String getUserById2(@PathVariable("id")String id){
		return "hello22934893849384922222 "+id;
	}

	@RequestMapping("/user/getByTuid/{tuid}")
	public String getByTuid(@PathVariable("tuid")String tuid){
		return "hello tuid: "+tuid;
	}
}
