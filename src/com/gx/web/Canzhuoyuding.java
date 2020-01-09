package com.gx.web;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gx.page.Page;
import com.gx.po.AttributePo;
import com.gx.po.CanzhuoyudingPo;
import com.gx.po.GoodsPo;
import com.gx.service.AttributeService;
import com.gx.service.CanzhuoyudingService;

@Controller
@RequestMapping("/canzhuoyuding")
public class Canzhuoyuding {
	
	@Autowired
	private CanzhuoyudingService canzhuoyudingService;
	
	@Autowired
	private AttributeService attributeService;
	
	//分页和模糊查询
	@RequestMapping("/tolist")
	public ModelAndView list(HttpServletRequest request, Integer currentPage, String txtname,Integer TableTypeID){
		ModelAndView mv=null;
		
		List<AttributePo> listOne=attributeService.selectCanzhuoType();
		mv=new ModelAndView("/canzhuoyuding/list");
		Page<CanzhuoyudingPo> vo=new Page<CanzhuoyudingPo>();
		if(TableTypeID==null){
			TableTypeID=72;
		}
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		if(txtname==null)
		{
			txtname="";
		}
		vo.setCurrentPage(currentPage);
		vo=this.canzhuoyudingService.pageFuzzyselect(txtname,TableTypeID, vo);
		mv.addObject("list",vo);
		mv.addObject("txtname",txtname);
		mv.addObject("listOne",listOne);
		mv.addObject("tableType",TableTypeID);
		System.out.println(mv);
		return mv;
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectCanzhuoType();
		List<AttributePo> listTwo=attributeService.selectUOME();
		mv=new ModelAndView("/canzhuoyuding/add");
		mv.addObject("listOne",listOne);
		mv.addObject("listTwo",listTwo);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(CanzhuoyudingPo canzhuoyudingPo){
		ModelAndView mv=null;
		canzhuoyudingService.insertAll(canzhuoyudingPo);
		mv=new ModelAndView("redirect:/canzhuoyuding/tolist.do");
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectCanzhuoType();
		List<AttributePo> listTwo=attributeService.selectUOME();
		CanzhuoyudingPo canzhuoyudingPo=canzhuoyudingService.selectById(id);
		mv=new ModelAndView("/canzhuoyuding/update");
		mv.addObject("listOne",listOne);
		mv.addObject("listTwo",listTwo);
		mv.addObject("listPo",canzhuoyudingPo);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(CanzhuoyudingPo canzhuoyudingPo){
		ModelAndView mv=null;
		canzhuoyudingService.updateById(canzhuoyudingPo);
		mv=new ModelAndView("redirect:/canzhuoyuding/tolist.do");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			canzhuoyudingService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/canzhuoyuding/tolist.do");
		return mv;
	}
	
	
	
	
	
	
	
}
