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
import com.gx.po.GoodsPo;
import com.gx.service.AttributeService;
import com.gx.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class Goods {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private AttributeService attributeService;
	
	        //分页和模糊查询
			@RequestMapping("/tolist")
			public ModelAndView list(HttpServletRequest request, Integer currentPage, String txtname,Integer commodityTypeID){
				ModelAndView mv=null;
				List<AttributePo> listOne=attributeService.selectCommodityType();
				mv=new ModelAndView("/goods/list");
				Page<GoodsPo> vo=new Page<GoodsPo>();
				if (commodityTypeID==null) {
					commodityTypeID=16;
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
				vo=this.goodsService.pageFuzzyselect(txtname,commodityTypeID, vo);
				mv.addObject("list",vo);
				mv.addObject("txtname",txtname);
				mv.addObject("listOne",listOne);
				mv.addObject("commodityType",commodityTypeID);
				return mv;
			}
			
			@RequestMapping("/toadd")
			public ModelAndView toadd(){
				ModelAndView mv=null;
				List<AttributePo> listOne=attributeService.selectUOM();
				List<AttributePo> listTwo=attributeService.selectCommodityType();
				mv=new ModelAndView("/goods/add");
				mv.addObject("listOne",listOne);
				mv.addObject("listTwo",listTwo);
				return mv;
			}
			
			@RequestMapping("/add")
			public ModelAndView add(GoodsPo goodsPo){
				ModelAndView mv=null;
				goodsService.insertAll(goodsPo);
				mv=new ModelAndView("redirect:/goods/tolist.do");
				return mv;
			}
			
			@RequestMapping("/toupdate")
			public ModelAndView toupdate(int id){
				ModelAndView mv=null;
				List<AttributePo> listOne=attributeService.selectUOM();
				List<AttributePo> listTwo=attributeService.selectCommodityType();
				GoodsPo commodityPo=goodsService.selectById(id);
				mv=new ModelAndView("/goods/update");
				mv.addObject("listOne",listOne);
				mv.addObject("listTwo",listTwo);
				mv.addObject("listPo",commodityPo);
				return mv;
			}
			
			@RequestMapping("/update")
			public ModelAndView update(GoodsPo goodsPo){
				ModelAndView mv=null;
				goodsService.updateById(goodsPo);
				mv=new ModelAndView("redirect:/goods/tolist.do");
				return mv;
			}
			
			@RequestMapping("/delete")
			public ModelAndView delete(String id){
				ModelAndView mv=null;
				String[] FenGe=id.split(",");
				for (int i = 0; i < FenGe.length; i++) {
					goodsService.deleteById(Integer.parseInt(FenGe[i]));
				}
				mv=new ModelAndView("redirect:/goods/tolist.do");
				return mv;
			}
			
			
			
			
			@RequestMapping("/openwindow")
			public ModelAndView openwindow(){
				ModelAndView mv=null;
				mv=new ModelAndView("/goods/commoditytype");
				return mv;
			}
			
			@RequestMapping("/newadd")
			public ModelAndView newadd(String txtname){
				ModelAndView mv=null;
				int newid=3;
				attributeService.insertAll(newid,txtname);
				mv=new ModelAndView("redirect:/goods/tolist.do");
				return mv;
			}
			
			@RequestMapping("/newdelete")
			public ModelAndView newdelete(String id){
				ModelAndView mv=null;
				String[] FenGe=id.split(",");
				for (int i = 0; i < FenGe.length; i++) {
					attributeService.deleteById(Integer.parseInt(FenGe[i]));
				}
				mv=new ModelAndView("redirect:/goods/tolist.do");
				return mv;
			}
			
			
			@ResponseBody
			@RequestMapping(value="/YZ")
			public Object YZ(String commodityName){
				int YorN=goodsService.selectYZ(commodityName);
				Gson gson =new Gson();
				return gson.toJson(YorN);
			}
}
