package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.NoticeCriteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.service.NoticeService;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Inject
	private NoticeService service;

	/*
	 * @RequestMapping(value="/listAll",method=RequestMethod.GET) public void
	 * listPage(Model model,NoticeCriteria cri)throws Exception{
	 * 
	 * model.addAttribute("list1", service.listCriteria(cri)); //10개씩 자르는거 PageMaker
	 * pageMaker=new PageMaker(); pageMaker.setCri(cri); //
	 * pageMaker.setTotalCount(131); pageMaker.setTotalCount(service.listCount());
	 * model.addAttribute("pageMaker", pageMaker); }
	 */
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void listAll(@ModelAttribute("cri") SearchCriteria cri,Model model)throws Exception {
		
	//	model.addAttribute("list1", service.listCriteria(cri)); //10개씩 자르는거
		model.addAttribute("list1", service.listSearchCriteria(cri)); //10개씩 자르는거
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		
		//pageMaker.setTotalCount(service.listCount());
		pageMaker.setTotalCount(service.listSearchCount());
		
		model.addAttribute("pageMaker", pageMaker);		

	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void  read(Model model,@RequestParam("bno") int bno,@ModelAttribute("cri") NoticeCriteria cri) throws Exception {
		model.addAttribute("read", service.read(bno));
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register() {
		
		return "/notice/register";
	}
	
	@RequestMapping(value="/register2",method=RequestMethod.GET)
	public void register2() {
		
	}
	
	@RequestMapping(value="/register3",method=RequestMethod.GET)
	public void register3() {
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		service.create(vo);
		rttr.addFlashAttribute("result","success");
		return "redirect: /notice/list";
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("bno") int bno,Model model) throws Exception {
		model.addAttribute("board",service.read(bno));
		return "notice/modify";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(RedirectAttributes rttr,NoticeVO vo) throws Exception {
	
		service.update(vo);
		rttr.addFlashAttribute("result","success");
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(RedirectAttributes rttr,@RequestParam("bno") int bno) throws Exception {
		
		service.delete(bno);
		rttr.addFlashAttribute("result","success");
		
		
		return "redirect:/notice/list";
		
	}
	

	

}
