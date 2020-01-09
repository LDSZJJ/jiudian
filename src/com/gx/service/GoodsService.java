package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.GoodsPo;

public interface GoodsService {
	
	public int deleteById(Integer id);
	
	
	public int insertAll(GoodsPo goodsPo);
	
	
	public	GoodsPo selectById(Integer id);

	
	public int updateById(GoodsPo goodsPo);
	
	
	//分页需要
	public Page<GoodsPo> pageFuzzyselect(String commodityName,int commodityTypeID,Page<GoodsPo> vo);
	
	//无分页的模糊查询  非本派所用
	public List<GoodsPo> fuzzySelect(String commodityName,int commodityTypeID);

	//ajax 验证是否存在 此商品
    public int selectYZ(String commodityName);
}
