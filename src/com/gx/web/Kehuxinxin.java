package com.gx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.AttributePo;
import com.gx.po.KehuxinxiPo;
import com.gx.service.AttributeService;
import com.gx.service.KehuxinxiService;

@Controller
@RequestMapping("/kehuxinxi")
public class Kehuxinxin {
	
	
	@Autowired
	private AttributeService attributeService;
	
	@Autowired
	private KehuxinxiService kehuxinxiService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(HttpServletRequest request,Integer currentPage,String txtname){
		ModelAndView mv=null;
		mv=new ModelAndView("/kehuxinxi/list");
		Page<KehuxinxiPo> vo=new Page<KehuxinxiPo>();
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
		vo=this.kehuxinxiService.pageFuzzyselect(txtname, vo);
		mv.addObject("list",vo);
		mv.addObject("txtname",txtname);
		return mv;
	}
	
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		List<AttributePo> listGender=attributeService.selectGender();                      //性别
		List<AttributePo> listNation=attributeService.selectNation();                      //民族
		List<AttributePo> listPassengerLevel=attributeService.selectPassengerLevel();      //旅客级别
		List<AttributePo> listEducationDegree=attributeService.selectEducationDegree();    //文化程度
		List<AttributePo> listPapers=attributeService.selectPapers();                      //证件类型
		List<AttributePo> listThingReason=attributeService.selectThingReason();            //事由
		mv=new ModelAndView("/kehuxinxi/add");
		mv.addObject("listGender",listGender);
		mv.addObject("listNation",listNation);
		mv.addObject("listPassengerLevel",listPassengerLevel);
		mv.addObject("listEducationDegree",listEducationDegree);
		mv.addObject("listPapers",listPapers);
		mv.addObject("listThingReason",listThingReason);
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		List<AttributePo> listGender=attributeService.selectGender();                      //性别
		List<AttributePo> listNation=attributeService.selectNation();                      //民族
		List<AttributePo> listPassengerLevel=attributeService.selectPassengerLevel();      //旅客级别
		List<AttributePo> listEducationDegree=attributeService.selectEducationDegree();    //文化程度
		List<AttributePo> listPapers=attributeService.selectPapers();                      //证件类型
		List<AttributePo> listThingReason=attributeService.selectThingReason();            //事由
		KehuxinxiPo list=kehuxinxiService.selectById(id);
		mv=new ModelAndView("/kehuxinxi/update");
		mv.addObject("listGender",listGender);
		mv.addObject("listNation",listNation);
		mv.addObject("listPassengerLevel",listPassengerLevel);
		mv.addObject("listEducationDegree",listEducationDegree);
		mv.addObject("listPapers",listPapers);
		mv.addObject("listThingReason",listThingReason);
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(KehuxinxiPo kehuxinxiPo){
		ModelAndView mv=null;
		kehuxinxiService.insertAll(kehuxinxiPo);
		mv=new ModelAndView("redirect:/kehuxinxi/tolist.do");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(KehuxinxiPo passengerPo){
		ModelAndView mv=null;
		kehuxinxiService.updateById(passengerPo);
		mv=new ModelAndView("redirect:/kehuxinxi/tolist.do");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			kehuxinxiService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/kehuxinxi/tolist.do");
		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/YZ")
	public Object YZ(String papersNumber){
		int YorN=kehuxinxiService.selectYZ(papersNumber);
		Gson gson =new Gson();
		return gson.toJson(YorN);
	}
}
