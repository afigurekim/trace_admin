package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Historic_siteVO;
import org.zerock.domain.Historic_site_starVO;
import org.zerock.domain.VisitorVO;
import org.zerock.service.BoardService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("������ ����������");
		
		return "home";
	}
	@ResponseBody
	@RequestMapping(value="/allVisitor", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>>  allVisitor() {
		
		ResponseEntity<Map<String,Object>> entity= null;

		
			try {
				Map<String,Object> map = new HashMap<String,Object>();
				List<String> visit_list=new ArrayList<String>();
				SimpleDateFormat test0= new SimpleDateFormat("hh a");
				List<VisitorVO> list=service.allVisitor();
				System.out.println(list.size()+"방문자 수");
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i).getVisit_time());
					System.out.println(test0.format(list.get(i).getVisit_time()));
					visit_list.add(test0.format(list.get(i).getVisit_time()));
				}

				map.put("visit",visit_list);
				entity= new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			}
			
		
			return entity;

	}
	@ResponseBody
	@RequestMapping(value="/topHistoric", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>>  topHistoric() {
		
		ResponseEntity<Map<String,Object>> entity= null;

		
			try {
				Map<String,Object> map = new HashMap<String,Object>();
				List<Historic_siteVO> list= service.topHistoric();
				
				map.put("list", list);
				

				entity= new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			}
			
		
			return entity;

	}
	
	@ResponseBody
	@RequestMapping(value="/userStar", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>>  userStar() {
		System.out.println("사용자 별점 비율 컨트로러");
		ResponseEntity<Map<String,Object>> entity= null;

		
			try {
				Map<String,Object> map = new HashMap<String,Object>();
				List<Historic_site_starVO> list= service.userStar();
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i).getStar());
				}
				map.put("list",list);
				entity= new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			}
			
		
			return entity;

	}
	
}
