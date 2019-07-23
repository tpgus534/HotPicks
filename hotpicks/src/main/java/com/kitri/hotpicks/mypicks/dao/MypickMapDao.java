package com.kitri.hotpicks.mypicks.dao;

import java.util.List;
import java.util.Map;

import com.kitri.hotpicks.mypicks.model.PickListDto;
import com.kitri.hotpicks.mypicks.model.ViewPickMapDto;


public interface MypickMapDao {
	List<ViewPickMapDto> getMapList(Map<String, Object> map);
	List<ViewPickMapDto> selectContentsList(Map<String, Object> map);
}
