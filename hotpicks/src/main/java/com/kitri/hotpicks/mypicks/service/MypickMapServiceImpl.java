package com.kitri.hotpicks.mypicks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.hotpicks.mypicks.dao.MypickMapDao;
import com.kitri.hotpicks.mypicks.model.PickListDto;
import com.kitri.hotpicks.mypicks.model.ViewPickMapDto;

@Service
public class MypickMapServiceImpl implements MypickMapService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ViewPickMapDto> getContent(Map<String, Object> map) {
		
		return sqlSession.getMapper(MypickMapDao.class).getMapList(map);
	}

	@Override
	public List<ViewPickMapDto> selectContentsList(double x,double y,List<String> selectMarkers, int distance,String userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectMarkers", selectMarkers);
		map.put("x", x);
		map.put("y", y);
		map.put("distance", distance);
		map.put("userid", userid);
		System.out.println("service" + map);
		return sqlSession.getMapper(MypickMapDao.class).selectContentsList(map);
	}

}
