package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.KefangPo;




public interface KefangService {
	
	//删除客房
	public int deleteById(Integer id);
	
	//增加客房
	public int insertAll(KefangPo kefangPo);
	
	//搜索客房
	public KefangPo selectById(Integer id);
	
	//查询全部
    public List<KefangPo> selectAll();
	
	//分页加模糊查询
	public Page<KefangPo> pageFuzzyselect(String roomNumber,Page<KefangPo> vo);
	
	//更新客房
	public int updateById(KefangPo kefangPo);
	
	//ajax 验证是否存在 此房间号
	public int selectYZ(String roomNumber);
	
	// 非本派所用  安排房间时 需要改变当前房间的房态
    public int updateByIdToRoomState(KefangPo kefangPo);
    
  //非本派所用  查询房间信息
    public  List<KefangPo> selectInformation(String roomNumber);
    
    //非本派所用  客服等级来查询房间信息
    public  List<KefangPo> levelSelectInformation(Integer guestRoomLevelID);
    
    
}
