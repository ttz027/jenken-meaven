package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.pojo.Info;

public interface InfoService {
	Info findById(int id);
	List<Info> findAll();
}
