package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.KeFangYuDingDao;
import com.gx.page.Page;
import com.gx.po.KeFangYuDingPo;
import com.gx.service.KeFangYuDingService;

@Transactional
@Service(value="kefangyudingService")
public class KeFangYuDingServiceImpl implements KeFangYuDingService{
	
	@Autowired
	private KeFangYuDingDao kefangyudingDao;
	
	//新增预定
	@Override
	public int insertAll(KeFangYuDingPo kefangyudingPo) {
		return kefangyudingDao.insertAll(kefangyudingPo);
	}

	@Override
	public Page<KeFangYuDingPo> pageFuzzyselect(String receiveTeamName, String passengerName, int predetermineStateID,
			Page<KeFangYuDingPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<KeFangYuDingPo> list=kefangyudingDao.pageFuzzyselect(receiveTeamName,
				passengerName, predetermineStateID, start, vo.getPageSize());
		vo.setResult(list);
		int count=kefangyudingDao.countFuzzyselect(receiveTeamName, passengerName, predetermineStateID);
		vo.setTotal(count);
		return vo;
	}

	@Override
	public KeFangYuDingPo findById(Integer id) {
		return this.kefangyudingDao.findById(id);
	}

	@Override
	public List<KeFangYuDingPo> findLvKeId(Integer id) {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.findLvKeId(id);
	}

	@Override
	public List<KeFangYuDingPo> findTeamId(Integer id) {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.findTeamId(id);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.deleteById(id);
	}

	@Override
	public List<KeFangYuDingPo> selectAll() {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.selectAll();
	}

	@Override
	public int updateRemind(Integer id) {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.updateRemind(id);
	}

	@Override
	public int updatePredetermineStateID(Integer id) {
		// TODO Auto-generated method stub
		return this.kefangyudingDao.updatePredetermineStateID(id);
	}



}
