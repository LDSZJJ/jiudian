package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.CanzhuoyudingDao;
import com.gx.page.Page;
import com.gx.po.CanzhuoyudingPo;
import com.gx.service.CanzhuoyudingService;

@Transactional
@Service(value="CanzhuoyudingService")
public class CanzhuoyudingServiceImpl implements CanzhuoyudingService {
	
	@Autowired
	private CanzhuoyudingDao canzhuoyudingDao;

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.deleteById(id);
	}

	@Override
	public int insertAll(CanzhuoyudingPo canzhuoyudingPo) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.insertAll(canzhuoyudingPo);
	}

	@Override
	public CanzhuoyudingPo selectById(Integer id) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.selectById(id);
	}

	@Override
	public int updateById(CanzhuoyudingPo canzhuoyudingPo) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.updateById(canzhuoyudingPo);
	}

	@Override
	public int selectYZ(String TableNumber) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.selectYZ(TableNumber);
	}

	@Override
	public Page<CanzhuoyudingPo> pageFuzzyselect(String TableNumber, int TableTypeID, Page<CanzhuoyudingPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<CanzhuoyudingPo> list=canzhuoyudingDao.pageFuzzyselect(TableNumber, TableTypeID, start, vo.getPageSize());
		vo.setResult(list);
		int count=canzhuoyudingDao.countFuzzyselect(TableNumber, TableTypeID);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<CanzhuoyudingPo> fuzzySelect(String TableNumber, int TableTypeID) {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.fuzzySelect(TableNumber, TableTypeID);
	}

	@Override
	public List<CanzhuoyudingPo> selectAll() {
		// TODO Auto-generated method stub
		return canzhuoyudingDao.selectAll();
	}

}
