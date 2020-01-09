package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.GoodsDao;
import com.gx.page.Page;
import com.gx.po.GoodsPo;
import com.gx.service.GoodsService;


@Transactional
@Service(value="GoodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return goodsDao.deleteById(id);
	}

	@Override
	public int insertAll(GoodsPo goodsPo) {
		// TODO Auto-generated method stub
		return goodsDao.insertAll(goodsPo);
	}

	@Override
	public GoodsPo selectById(Integer id) {
		// TODO Auto-generated method stub
		return goodsDao.selectById(id);
	}

	@Override
	public int updateById(GoodsPo goodsPo) {
		// TODO Auto-generated method stub
		return goodsDao.updateById(goodsPo);
	}

	@Override
	public Page<GoodsPo> pageFuzzyselect(String commodityName, int commodityTypeID, Page<GoodsPo> vo) {
			int start=0;
			if (vo.getCurrentPage()>1) {
				start=(vo.getCurrentPage()-1)*vo.getPageSize();
			}
			List<GoodsPo> list=goodsDao.pageFuzzyselect(commodityName, commodityTypeID, start, vo.getPageSize());
			vo.setResult(list);
			int count=goodsDao.countFuzzyselect(commodityName, commodityTypeID);
			vo.setTotal(count);
			return vo;
		}

	@Override
	public List<GoodsPo> fuzzySelect(String commodityName, int commodityTypeID) {
		// TODO Auto-generated method stub
		return goodsDao.fuzzySelect(commodityName, commodityTypeID);
	}

	@Override
	public int selectYZ(String commodityName) {
		// TODO Auto-generated method stub
		return goodsDao.selectYZ(commodityName);
	}
	
	

}
