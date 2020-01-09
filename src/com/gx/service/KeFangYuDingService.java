package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.KeFangYuDingPo;



public interface KeFangYuDingService {
	
	//新增预定
	public int insertAll(KeFangYuDingPo kefangyudingPo);
	
	//
	public Page<KeFangYuDingPo> pageFuzzyselect(String receiveTeamName, String passengerName,
			int predetermineStateID,Page<KeFangYuDingPo> vo);
	
	//id查询
    public KeFangYuDingPo findById(Integer id);
    
    //根据旅客id来查询
    public List<KeFangYuDingPo> findLvKeId(Integer id);
    
    //根据团队id来查询
    public List<KeFangYuDingPo> findTeamId(Integer id);
    
    //id删除
    public int deleteById(Integer id);
    
    //查询全部
    public List<KeFangYuDingPo> selectAll();
    
    //修改预定到时提示
    public int updateRemind(Integer id);
    
    //修改预定状态
    public int updatePredetermineStateID(Integer id);
}
