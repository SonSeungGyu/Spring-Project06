package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/return")
public class SampleController1 {
	//get 방식을 사용하며 주소는 ex1 이라는것
	@GetMapping("/ex1")
	public void ex1() { //html 파일을 찾아서 반환
		//template/return/ex1.html
	}
	
	@GetMapping("/ex2")
	public String ex2() {
		return "/return/ex1.html"; //html경로를 지정 getmapping과 상관없이 return 경로로 이동
	}
	
	@ResponseBody
	@GetMapping("/ex3")
	public BookDTO ex3() {
		BookDTO bookDTO = new BookDTO("자바프로그래밍","한빛컴퍼니",20000);
		
		return bookDTO;
	}
	
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4(){
		List<BookDTO> list = new ArrayList<>();
		
		list.add(new BookDTO("자바프로그래밍","한빛컴퍼니",20000));
		list.add(new BookDTO("스프링부트","구멍가게",30000));
		list.add(new BookDTO("리눅스","길벗",40000));
		
		return list;
	}
	
	
	@GetMapping("/ex5")
	public ResponseEntity ex5() {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6(){
		
		//200 ok 응답 + message
		return new ResponseEntity<>("success..",HttpStatus.OK);
	}
	
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7(){
		BookDTO bookDTO = new BookDTO("자바프로그래밍","한빛컴퍼니",20000);
		
		//200ok 응답 + book 객체
		return new ResponseEntity<>(bookDTO,HttpStatus.OK);
	}
	
	
	
	
	
}
