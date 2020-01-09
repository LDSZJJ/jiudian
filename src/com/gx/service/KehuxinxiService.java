package com.gx.service;

import java.util.List;

import com.gx.page.Page;
import com.gx.po.KehuxinxiPo;


public interface KehuxinxiService {
public int deleteById(Integer id);
	
	
	public int insertAll(KehuxinxiPo kehuxinxiPo);
	
	
	public	KehuxinxiPo selectById(Integer id);

	
	public int updateById(KehuxinxiPo kehuxinxiPo);
	
	
	//分页需要
	public Page<KehuxinxiPo> pageFuzzyselect(String name,Page<KehuxinxiPo> vo);
	
    //查询所有数据  非本派所用
    public List<KehuxinxiPo> selectAll();
    
    //模糊查询 运用 Ajax 非分页
    public List<KehuxinxiPo> selectAjaxList(String name);
    
  //ajax 验证是否存在 此身份证号码
   public int selectYZ(String papersNumber);
}
