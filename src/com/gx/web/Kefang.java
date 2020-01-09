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
import com.gx.po.KefangPo;
import com.gx.service.AttributeService;
import com.gx.service.KefangService;



@Controller
@RequestMapping("/kefang")
public class Kefang {
	
	@Autowired
	private KefangService kefangService;
	
	
	@Autowired
	private AttributeService attributeService;
	
	//分页加模糊查询
	@RequestMapping("/tolist")
	public ModelAndView list(HttpServletRequest request,Integer currentPage,String txtname){
		ModelAndView mv=null;
		mv=new ModelAndView("/kefang/kefang");
		Page<KefangPo> vo=new Page<KefangPo>();
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
		vo=this.kefangService.pageFuzzyselect(txtname, vo);
		mv.addObject("list", vo);
		mv.addObject("txtname", txtname);
		return mv;
	}
	
	//新增客房的具体操作
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectGuestRoomLevel();//获取房间等级
		List<AttributePo> listTwo=attributeService.selectRoomState();//获取房间状态
		mv=new ModelAndView("/kefang/add");
		mv.addObject("listOne", listOne);
		mv.addObject("listTwo", listTwo);
		return mv;
	}
	
	//增加客房
	@RequestMapping("/add")
	public ModelAndView add(KefangPo kengfaPo){
		ModelAndView mv=null;
		kefangService.insertAll(kengfaPo);
		mv=new ModelAndView("redirect:/kefang/tolist.do");
		return mv;
	}
	
	//修改客房的具体操作
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		List<AttributePo> listOne=attributeService.selectGuestRoomLevel();//获取房间等级
		List<AttributePo> listTwo=attributeService.selectRoomState();//获取房间状态
		KefangPo listPo=kefangService.selectById(id);
		mv=new ModelAndView("/kefang/update");
		mv.addObject("listOne", listOne);
		mv.addObject("listTwo", listTwo);
		mv.addObject("listPo", listPo);
		return mv;
	}
	
	//修改客房
	@RequestMapping("/update")
	public ModelAndView update(KefangPo kefangPo){
		ModelAndView mv=null;
		kefangService.updateById(kefangPo);
		mv=new ModelAndView("redirect:/kefang/tolist.do");
		return mv;
	}
	
	//删除客房
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for(int i=0;i>FenGe.length;i++){
			kefangService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/kefang/tolist.do");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/YZ")
	public Object YZ(String roomNumber){
		int YorN=kefangService.selectYZ(roomNumber);
		Gson gson =new Gson();
		return gson.toJson(YorN);
	}
	
}
