package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Historic_siteVO;
import org.zerock.service.BoardService;

@Controller
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Inject
	BoardService service;

	// �Խñ� �ҷ�����
	@RequestMapping(value = "/category/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...........");
		List<Historic_siteVO> list = service.allHistoric();
		model.addAttribute("list",list);
	}// end listAll

	@ResponseBody
	@RequestMapping(value="/modifyCategory",method=RequestMethod.POST)
	public void modifyCategory(@RequestParam("sbno") Integer bno,@RequestParam("speriod") String speriod,@RequestParam("sthema") String sthema)throws Exception{
		;
		System.out.println(bno);
		if(speriod=="") {
			speriod=service.selectPeriod(bno);
		}
		if(sthema=="") {
			sthema=service.selectThema(bno);
		}
		System.out.println(speriod);
		System.out.println(sthema);
		service.updateCategory(speriod,sthema,bno);
		
	}
	
}
