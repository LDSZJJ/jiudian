package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.CanzhuoyudingPo;


public interface CanzhuoyudingService {
	
    public int deleteById(Integer id);
    
    public List<CanzhuoyudingPo> selectAll();
	
	
	public int insertAll(CanzhuoyudingPo canzhuoyudingPo);
	
	
	public	CanzhuoyudingPo selectById(Integer id);

	
	public int updateById(CanzhuoyudingPo canzhuoyudingPo);
	
	
	//分页需要
	public Page<CanzhuoyudingPo> pageFuzzyselect(String TableNumber,int TableTypeID,Page<CanzhuoyudingPo> vo);
	
	//无分页的模糊查询  非本派所用
	public List<CanzhuoyudingPo> fuzzySelect(String TableNumber,int TableTypeID);

	//ajax 验证是否存在 此商品
    public int selectYZ(String TableNumber);
}
