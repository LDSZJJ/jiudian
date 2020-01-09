package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.JiedaiduixiangPo;

public interface JiedaiduixiangService {
	public int deleteById(Integer id);
	
	
	public int insertAll(JiedaiduixiangPo jiedaiduixiangPo);
	
	
	public	JiedaiduixiangPo selectById(Integer id);

	
	public int updateById(JiedaiduixiangPo jiedaiduixiangPo);
	
	
	//分页需要
	public Page<JiedaiduixiangPo> pageFuzzyselect(String teamName,Page<JiedaiduixiangPo> vo);
	
	
	//ajax 验证是否存在 此团队编号
    public int selectYZ(String teamCode);
	
	
	//ajax查询 预订所用
    public List<JiedaiduixiangPo> ajaxSelect(String teamName);
}
