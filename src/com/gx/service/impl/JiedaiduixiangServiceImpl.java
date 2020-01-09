package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.JiedaiduixiangDao;
import com.gx.page.Page;
import com.gx.po.JiedaiduixiangPo;
import com.gx.service.JiedaiduixiangService;

@Transactional
@Service(value="jiedaiduixiangService")
public class JiedaiduixiangServiceImpl implements JiedaiduixiangService{
	
	@Autowired
	private JiedaiduixiangDao jiedaiduixiangDao;
	
	
	@Override
	public int deleteById(Integer id) {
		return jiedaiduixiangDao.deleteById(id);
	}

	@Override
	public int insertAll(JiedaiduixiangPo jiedaiduixiangPo) {
		return jiedaiduixiangDao.insertAll(jiedaiduixiangPo);
	}

	@Override
	public JiedaiduixiangPo selectById(Integer id) {
		return jiedaiduixiangDao.selectById(id);
	}

	@Override
	public int updateById(JiedaiduixiangPo jiedaiduixiangPo) {
		return jiedaiduixiangDao.updateById(jiedaiduixiangPo);
	}

	@Override
	public Page<JiedaiduixiangPo> pageFuzzyselect(String teamName, Page<JiedaiduixiangPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<JiedaiduixiangPo> list=jiedaiduixiangDao.pageFuzzyselect(teamName, start, vo.getPageSize());
		vo.setResult(list);
		int count=jiedaiduixiangDao.countFuzzyselect(teamName);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public int selectYZ(String teamCode) {
		return jiedaiduixiangDao.selectYZ(teamCode);
	}

	@Override
	public List<JiedaiduixiangPo> ajaxSelect(String teamName) {
		return jiedaiduixiangDao.ajaxSelect(teamName);
	}

}
