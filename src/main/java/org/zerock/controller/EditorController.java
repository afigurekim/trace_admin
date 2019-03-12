package org.zerock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;
import org.zerock.util.MediaUtils;

@Controller
@RequestMapping(value = "/editor/*")
public class EditorController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(EditorController.class);

	@Inject
	BoardService service;

	// 占쌉시깍옙 占쏙옙占쏙옙歐占?get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		logger.info("register get............");
		return "/editor/register";
	}// end registerGet

	// 占쌉시깍옙 占쏙옙占쏙옙歐占?post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post............");
		logger.info(board.toString());
		service.regist(board);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end registerPost

	// 占쌉시깍옙 占쌀뤄옙占쏙옙占쏙옙
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());
	}// end listAll

	// 占쌘쇽옙占쏙옙 占쏙옙占쏙옙
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// end read

	// 占쌉시깍옙 占쏙옙占쏙옙占싹깍옙
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end remove

	// 占쌉시깍옙 占쏙옙占쏙옙占싹깍옙
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}// modifyGET

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modify post............");
		logger.info(board.toString());
		System.out.println(board.toString());
		service.modify(board);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/editor/listAll";

	}// end modifyPOST

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String upload(MultipartFile file) throws Exception {
		System.out.println("original name :" + file.getOriginalFilename());

		System.out.println(file.getSize());
		String name = file.getOriginalFilename();

		String filepath = "C:\\zzz\\";
		File f = new File(filepath + name);

		file.transferTo(f);
		System.out.println(filepath + name);
		return name;

		// return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath,
		// file.getOriginalFilename(), file.getBytes()),
		// HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping(value = "/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename) throws Exception {
		System.out.println("?붿뒪?뚮젅???뚯씪");
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		System.out.println("filename :" + filename);
		try {
			String formatName = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + filename);

			if (mType != null) {
				headers.setContentType(mType);
			} else {
				filename = filename.substring(filename.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename\"" + new String(filename.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

}
