package com.korea.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.korea.domain.BoardDTO;
import com.korea.domain.SampleDTO;
import com.korea.domain.SampleDTOList;
import com.korea.domain.TodoDTO;
import com.korea.domain.TodoDTO2;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController {

	   // 클래스 레벨과 메소드 둘다 맵핑 가능
	   @RequestMapping(value= "/test", method=RequestMethod.GET)
	   public void test1() {
	      log.info("URL : /test " );
	   }
	   
	   // 메소드에만 맵핑
	   // 세분화
	   @GetMapping("/test2")
	   public void test2() {
	      log.info("URL :  /test2");
	   }
	   @GetMapping("/test3")
	   public void test3(SampleDTO dto) {
	      log.info("dto's info : " + dto);
	   }
	   @GetMapping("/test4")
	   public void test4(@RequestParam("name") String name, @RequestParam("age") Integer age ) {
	      log.info("name : " + name + " age : " + age);
	      log.info("URL : /test4");
	   }
	   @GetMapping("/test5")
	   // 주소 창 : http://localhost:8080/sample/test5?name="홍길동"
	   public void test5(@RequestParam("name") String[] list) {
	      log.info("URL : /test5");
	      for(String str : list) {
	         System.out.println(str + " ");
	      }
	   }
	   @GetMapping("/test6")
	   // localhost:8080/sample/test6?list[0].name="홍길동"&list[1].age=55
	   // [] 는 특수문자이므로 
	   // localhost:8080/sample/test6?list%5b0%.name="홍길동"&list%5b1%.age=55
	      public void test6(SampleDTOList list) {
	         log.info("URL : /test6");
	         for(SampleDTO dto : list.getList()) {
	            log.info(dto);
	         }
	      }
	   
	   
	   // 2022-01-01 떄문에 400(클라이언트 오류 발생) 오류 해결.
	   // @InitBinder를 이용해서 커스텀 데이터 타입 변환을 처리 할 수 있음
	   // new CustomDateEditor(dateFormat,true) //true : null 값 허용, false : 허용 x
	//   @InitBinder
	//   public void initBinder(WebDataBinder binder) {
//	      SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//	      binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, false));
	//   }
	//   
	   
	   // http://localhost:8080/sample/test7?title=%27%ED%85%8C%EC%8A%A4%ED%8A%B8%27&date=2022-01-01
	   @GetMapping("/test7")
	   public void test7(TodoDTO dto) {
	      log.info("URL : /test7");
	      log.info(dto);
	   }
	   
	   @GetMapping("/test8")
	   public void test8(TodoDTO2 dto) {
	      log.info("URL : /test8");
	      log.info(dto);
	   }
	   
	   @GetMapping("/test9")
	   public void test9(SampleDTO dto, Model model) {
	      log.info("URL : /TEST9" );
	      log.info("dto : " + dto);
	      
	      model.addAttribute("dto", dto);
	   }
	   
	   @GetMapping("/test10")
	   public String test10() {
	      log.info("URL : /test10");
	      
	      return "/test10";
	   }
	   
	   @GetMapping("/forward")
	   public String Forward(SampleDTO dto, Model model) {
	      log.info("URL : /forward" );
	      
	      model.addAttribute("dto", dto);
	      
	      return "forward:result";
	   }
	   
	   // 
	   @GetMapping("/redirect")
	   public String redirect(SampleDTO dto, RedirectAttributes rttr) {
	      log.info("URL : /redirect.." );
	      
//	      model.addAttribute("dto", dto);
	      rttr.addFlashAttribute("dto", dto);
	      
	      return "redirect:result";
	   }
	   
	   
	   
	   
	   
	   
	   @GetMapping("/result")
	   public void Result(Model model) {
	      log.info("URL : /result" );
//	      BoardDTO dto = new BoardDTO().builder()
//	            .no(1010)
//	            .content("내용")
//	            .writer("작성자")
//	            .build();
//	      
//	      model.addAttribute("board", dto);
//	            
	            
	   }
	   @GetMapping("/objectTest")
	   public @ResponseBody SampleDTO ObjectTest() {
	      SampleDTO dto = new SampleDTO();
	      dto.setName("홍길동");
	      dto.setAge(55);
	      
	      return dto;
	   }
	   
	   @GetMapping("/objectTest2")
	   public ResponseEntity<String> ObjectTest2() {
	      SampleDTO dto = new SampleDTO();
	      dto.setName("홍길동");
	      dto.setAge(55);
	      
	      HttpHeaders header = new HttpHeaders();
	      header.add("content-type", "application/json;charset=utf-8");
	      return new ResponseEntity<String>(dto.toString(),header,HttpStatus.OK);
	   }
	   
	   @GetMapping("/errorTest")
	   public String errortestFunc(SampleDTO dto, Model model) {
	      
	      model.addAttribute("dto",dto);
	      return "/sample/main";
	   }

}
