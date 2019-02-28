package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping(value = "/category/*")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Inject
	BoardService service;

	// �Խñ� ����ϱ� get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		logger.info("register get............");
		return "/category/register";
	}// end registerGet

	// �Խñ� ����ϱ� post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post............");
		logger.info(board.toString());
		System.out.println(board.getTheme());
		service.regist(board);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/category/listAll";

	}// end registerPost

	// �Խñ� �ҷ�����
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());
	}// end listAll

	// �ڼ��� ����
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// end read

	// �Խñ� �����ϱ�
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/category/listAll";

	}// end remove

	// �Խñ� �����ϱ�
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// modifyGET

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modify post............");
		logger.info(board.toString());
		System.out.println(board.getTheme());
		
		service.modify(board);
	
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/category/listAll";

	}// end modifyPOST

}
