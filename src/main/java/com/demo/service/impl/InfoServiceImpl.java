package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.InfoMapper;
import com.demo.pojo.Info;
import com.demo.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoMapper infoMapper;
	@Override
	public Info findById(int id) {
		return infoMapper.findById(id);
	}
	@Override
	public List<Info> findAll() {
		return infoMapper.findAll();
	}

}
