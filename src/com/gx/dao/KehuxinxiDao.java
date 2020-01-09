package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.KehuxinxiPo;

public interface KehuxinxiDao {
	public int deleteById(Integer id);
	
	
	public int insertAll(KehuxinxiPo kehuxinxiPo);
	
	
	public	KehuxinxiPo selectById(Integer id);

	
	public int updateById(KehuxinxiPo kehuxinxiPo);
	
	//分页模糊查询
    public List<KehuxinxiPo> pageFuzzyselect(@Param("name")String name,
    		@Param("start")int start,@Param("pageSize")int pageSize);
    
    //分页模糊查询总条数
    public int countFuzzyselect(@Param("name")String name);
    
    
   //ajax 验证是否存在 此身份证号码
   public int selectYZ(String papersNumber);
    
    
    
    
    //查询所有数据  非本派所用
    public List<KehuxinxiPo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<KehuxinxiPo> selectAjaxList(String name);
}
