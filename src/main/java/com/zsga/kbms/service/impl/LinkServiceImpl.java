package com.zsga.kbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsga.kbms.dao.LinkDao;
import com.zsga.kbms.entity.Link;
import com.zsga.kbms.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService {
	
	@Autowired
	private LinkDao linkDao;

	@Override
	public Integer addLink(Link link) {
		return linkDao.insertLink(link);
	}

	@Override
	public PageInfo<Link> findLink(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<Link> linkList = linkDao.queryLink();
		PageInfo<Link> pageInfo = new PageInfo<Link>(linkList);
		return pageInfo;
	}

	@Override
	public List<Link> findTop5Link() {
		return linkDao.queryTop5Link();
	}

	@Override
	public Integer editLink(Link link) {
		return linkDao.updateLink(link);
	}

	@Override
	public Integer removeLink(Integer id) {
		return linkDao.deleteLink(id);
	}

}
