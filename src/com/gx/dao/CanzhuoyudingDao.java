package com.gx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gx.po.CanzhuoyudingPo;

public interface CanzhuoyudingDao {
	
	    public int deleteById(Integer id);
		
		
		public int insertAll(CanzhuoyudingPo canzhuoyudingPo);
		
		
		public	CanzhuoyudingPo selectById(Integer id);

		public List<CanzhuoyudingPo> selectAll();
		
		public int updateById(CanzhuoyudingPo canzhuoyudingPo);
		
		//分页模糊查询
	    public List<CanzhuoyudingPo> pageFuzzyselect(@Param("TableNumber")String TableNumber,
	    		@Param("TableTypeID")int TableTypeID,@Param("start")int start,@Param("pageSize")int pageSize);
	    
	    //分页模糊查询总条数
	    public int countFuzzyselect(@Param("TableNumber")String Tablenumber, @Param("TableTypeID")int TableTypeID);
		
		
		 //ajax 验证是否存在 此商品
	    public int selectYZ(String TableNumber);
	    
	    //无分页的模糊查询  非本派所用
	    public List<CanzhuoyudingPo> fuzzySelect(@Param("TableNumber")String TableNumber,
	 		   @Param("TableTypeID")int TableTypeID);
}
