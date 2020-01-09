package com.gx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gx.dao.KefangDao;
import com.gx.page.Page;
import com.gx.po.KefangPo;

import com.gx.service.KefangService;
@Transactional
@Service(value="KefangService")
public class KefangServiceImpl implements KefangService{
	
	@Autowired
	private KefangDao kefangDao;
	
	//删除客房
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return kefangDao.deleteById(id);
	}
	
	//增加客房
	@Override
	public int insertAll(KefangPo kefangPo) {
		// TODO Auto-generated method stub
		return kefangDao.insertAll(kefangPo);
	}
	
	//搜索客房
	@Override
	public KefangPo selectById(Integer id) {
		// TODO Auto-generated method stub
		return kefangDao.selectById(id);
	}
	
	//分页加模糊查询
	@Override
	public Page<KefangPo> pageFuzzyselect(String roomNumber, Page<KefangPo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<KefangPo> list=this.kefangDao.pageFuzzyselect(roomNumber, start, vo.getPageSize());
		vo.setResult(list);
		
		int count=this.kefangDao.countFuzzyselect(roomNumber);
		vo.setTotal(count);
		return vo;
	}
	
	//更新客房
	@Override
	public int updateById(KefangPo kefangPo) {
		// TODO Auto-generated method stub
		return kefangDao.updateById(kefangPo);
	}
	
	//ajax 验证是否存在 此房间号
	@Override
	public int selectYZ(String roomNumber) {
		return kefangDao.selectYZ(roomNumber);
	}

	@Override
	public int updateByIdToRoomState(KefangPo kefangPo) {
		return kefangDao.updateByIdToRoomState(kefangPo);
	}

	@Override
	public List<KefangPo> selectInformation(String roomNumber) {
		return kefangDao.selectInformation(roomNumber);
	}
	
	//查询全部
	@Override
	public List<KefangPo> selectAll() {
		return kefangDao.selectAll();
	}

	@Override
	public List<KefangPo> levelSelectInformation(Integer guestRoomLevelID) {
		return kefangDao.levelSelectInformation(guestRoomLevelID);
	}

}
