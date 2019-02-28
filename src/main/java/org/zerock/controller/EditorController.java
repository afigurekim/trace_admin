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
@RequestMapping(value = "/editor/*")
public class EditorController {

	private static final Logger logger = LoggerFactory.getLogger(EditorController.class);

	@Inject
	BoardService service;

	// 게시글 등록하기 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		logger.info("register get............");
		return "/editor/register";
	}// end registerGet

	// 게시글 등록하기 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post............");
		logger.info(board.toString());
		service.regist(board);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end registerPost

	// 게시글 불러오기
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());
	}// end listAll

	// 자세히 보기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// end read

	// 게시글 삭제하기
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end remove

	// 게시글 수정하기
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// modifyGET

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modify post............");
		logger.info(board.toString());
		
		service.modify(board);
	
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end modifyPOST

//	@ResponseBody
//	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public ResponseEntity<?> uploadAjax(MultipartFile file) throws Exception {
//
//		logger.info("summernote post test...............");
//		System.out.println("summernote post test..............");
//		System.out.println(file.getOriginalFilename());
//
//		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
//				HttpStatus.CREATED);
//	}// end uploadAjax

	
	
	//summernote에 올린 이미ㅈㅣ/파일들의 이름을 결정하는 함수 
//	@ResponseBody
//	@RequestMapping("/displayFile")
//	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
//		/*
//		 * 파라미터로 브라우저에서 전송받기를 원하는 파일의 이름을 받는다.
//		 */
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//
//		logger.info("FILE NAME : " + fileName);
//
//		try {
//			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
//
//			MediaType mType = MediaUtils.getMediaType(formatName);
//
//			HttpHeaders headers = new HttpHeaders();
//
//			in = new FileInputStream(uploadPath + fileName);
//			if (mType != null) {
//				headers.setContentType(mType);
//			} else {
//				fileName = fileName.substring(fileName.indexOf("_") + 1);
//				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//				headers.add("Content-Disposition",
//						"attachment); filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
//			}
//
//			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//		} finally {
//			in.close();
//		}
//		return entity;
//	}

}
