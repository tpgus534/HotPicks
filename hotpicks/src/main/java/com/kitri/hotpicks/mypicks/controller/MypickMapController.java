package com.kitri.hotpicks.mypicks.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.hotpicks.mypicks.model.PickListDto;
import com.kitri.hotpicks.mypicks.model.ViewPickMapDto;
import com.kitri.hotpicks.mypicks.service.MypickMapService;

@Controller
@RequestMapping("/mypickmap")
public class MypickMapController {
	
	@Autowired
	private MypickMapService mypickMapService;
	
	@RequestMapping("/mvmypickmap")
	public String mvMap() {
		return "mypicks/mypickmap";
	}
	
	@RequestMapping("/getmaplist")
	@ResponseBody
	public String mypicksMap(@RequestParam Map<String, Object> map) {
		List<ViewPickMapDto> list = mypickMapService.getContent(map);
		JSONArray array = new JSONArray(list);
		return array.toString();
		
	}
	@RequestMapping("/getcontentslist")
	public String selectContentsList(@RequestParam(value = "selectMarkers") List<String> selectMarkers,
									 @RequestParam("x") double x, 
									 @RequestParam("y") double y,
									 @RequestParam("selectDistance") int distance,
									 @RequestParam("userid") String userid, Model model) {
		
		if (selectMarkers.size() != 0) {
			List<ViewPickMapDto> list = mypickMapService.selectContentsList(x, y, selectMarkers, distance, userid);
			model.addAttribute("list",list);
			
		}		
		String path = "mypicks/selectcontents";
		return path;
	}
	
}
