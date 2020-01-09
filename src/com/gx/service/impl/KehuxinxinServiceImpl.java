package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.KehuxinxiDao;
import com.gx.page.Page;
import com.gx.po.KehuxinxiPo;
import com.gx.service.KehuxinxiService;

@Transactional
@Service(value="kehuxinxiService")
public class KehuxinxinServiceImpl implements KehuxinxiService{

	@Autowired
	private KehuxinxiDao kehuxinxiDao;
	
	@Override
	public int deleteById(Integer id) {
		return kehuxinxiDao.deleteById(id);
	}

	@Override
	public int insertAll(KehuxinxiPo kehuxinxiPo) {
		return kehuxinxiDao.insertAll(kehuxinxiPo);
	}

	@Override
	public KehuxinxiPo selectById(Integer id) {
		// TODO Auto-generated method stub
		return kehuxinxiDao.selectById(id);
	}

	@Override
	public int updateById(KehuxinxiPo kehuxinxiPo) {
		// TODO Auto-generated method stub
		return kehuxinxiDao.updateById(kehuxinxiPo);
	}

	@Override
	public Page<KehuxinxiPo> pageFuzzyselect(String name, Page<KehuxinxiPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<KehuxinxiPo> list=kehuxinxiDao.pageFuzzyselect(name, start, vo.getPageSize());
		vo.setResult(list);
		int count=kehuxinxiDao.countFuzzyselect(name);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public List<KehuxinxiPo> selectAll() {
		// TODO Auto-generated method stub
		return kehuxinxiDao.selectAll();
	}

	@Override
	public List<KehuxinxiPo> selectAjaxList(String name) {
		// TODO Auto-generated method stub
		return kehuxinxiDao.selectAjaxList(name);
	}

	@Override
	public int selectYZ(String papersNumber) {
		// TODO Auto-generated method stub
		return kehuxinxiDao.selectYZ(papersNumber);
	}

}
