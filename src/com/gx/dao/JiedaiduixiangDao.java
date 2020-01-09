package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.JiedaiduixiangPo;
public interface JiedaiduixiangDao {
	public int deleteById(Integer id);
	
	
	public int insertAll(JiedaiduixiangPo jiedaiduixiangPo);
	
	
	public	JiedaiduixiangPo selectById(Integer id);

	
	public int updateById(JiedaiduixiangPo jiedaiduixiangPo);
	
	//分页模糊查询
    public List<JiedaiduixiangPo> pageFuzzyselect(@Param("teamName")String teamName,
    		@Param("start")int start,@Param("pageSize")int pageSize);
    
    //分页模糊查询总条数
    public int countFuzzyselect(@Param("teamName")String teamName);
    
    
    
    //ajax 验证是否存在 此团队编号
    public int selectYZ(String teamCode);
    
    
    
    //ajax查询 预订所用
    public List<JiedaiduixiangPo> ajaxSelect(String teamName);
}
