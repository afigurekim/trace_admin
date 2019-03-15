package org.zerock.controller;

import java.util.List;

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
import org.zerock.domain.Historic_site_detailVO;
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
		/*for(int i=0;i<list.size();i++) {
		list.get(i).setThema(list.get(i).getThema().replace("고육", "교육"));
		service.updateThema(list.get(i));
		}*/
		model.addAttribute("list",list);
	}// end listAll
	
	@RequestMapping(value="/category/auto_classify",method=RequestMethod.GET)
	public String auto_classify() throws Exception{
		List<Historic_site_detailVO> detail = service.allDetail();
		if(detail.size()>=1) {
		for(int i=0;i<detail.size();i++) {
			System.out.println(detail.get(i).getDetail());
			
			if(detail.get(i).getDetail().indexOf("구석기")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"선사");
			}if(detail.get(i).getDetail().indexOf("신석기")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"선사");

			}if(detail.get(i).getDetail().indexOf("청동기")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"선사");

			}
			if(detail.get(i).getDetail().indexOf("철기")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"선사");

			}
			 if(detail.get(i).getDetail().indexOf("백제")!=-1) {
					service.updatePeriod(detail.get(i).getBno(),"삼국");

			} if(detail.get(i).getDetail().indexOf("고구려")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"삼국");

			}if(detail.get(i).getDetail().indexOf("신라")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"삼국");

			}if(detail.get(i).getDetail().indexOf("삼국")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"삼국");

			}
			if(detail.get(i).getDetail().indexOf("고려")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"고려");

			}
			
			if(detail.get(i).getDetail().indexOf("조선")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"조선");

			} if(detail.get(i).getDetail().indexOf("대한")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"근현대");

			} if(detail.get(i).getDetail().indexOf("일제")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"근현대");

			}  if(detail.get(i).getDetail().indexOf("의열단")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"근현대");

			} if(detail.get(i).getDetail().indexOf("독립")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"근현대");

			} if(detail.get(i).getDetail().indexOf("한국")!=-1) {
				service.updatePeriod(detail.get(i).getBno(),"근현대");

			}
		
			
		}
		}
		return "home";
	}
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
