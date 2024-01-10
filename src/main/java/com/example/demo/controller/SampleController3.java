package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")
public class SampleController3 {
	
	//Request Param 방식
	@GetMapping("/ex1")
	public ResponseEntity ex1(@RequestParam(name = "i") int i) {
		System.out.println("int형 파라미터 수집: " + i);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex1?i=100 -> 호출방법
	}

	@GetMapping("/ex2")
	public ResponseEntity ex2(@RequestParam(name = "i") int i, @RequestParam(name = "c") char c) {
		System.out.println("int형 파라미터 수집: " + i + ", char형 파라미터 수집: " + c);

		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/ex3")
	// arr이라는 이름의 파라미터가 여러개 전달되더라도 배열로 수집됨
	public ResponseEntity ex3(@RequestParam(name = "arr") int[] arr) {
		// 배열 -> 문자열로 변환
		System.out.println("int형 배열 수집: " + Arrays.toString(arr));
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/ex4")
	public ResponseEntity ex4(@RequestParam(name = "list") ArrayList<Integer> list) {
		System.out.println("int형 리스트 수집: " + list);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/ex5")
	public ResponseEntity ex5(@RequestParam(name = "date")@DateTimeFormat(pattern="yyyyMMdd") LocalDate date) {
		//yyyy/MM/dd도 사용이 가능하며 출력은 yyyy-MM-dd로 동일하게 나온다.
		System.out.println("날짜 수집: " + date);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	//------------------------------------------------------------------------------------------
	//Path Variable 방식
	
	@GetMapping("/ex6/{i}")
	public ResponseEntity ex6(@PathVariable(name="i")int i) {
		System.out.println("int형 파라미터 수집: " + i);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//------------------------------------------------------------------------------------------
	//Request Body 방식
	
	@GetMapping("/ex7")
	public ResponseEntity ex7(@RequestBody BookDTO dto) {//외부에서 받은 json이 class로 변환될 수 있게 requestbody선언
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/ex8")
	public ResponseEntity ex8(@RequestBody ArrayList<BookDTO> list) {
		System.out.println("객체타입 리스트 수집: " + list);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//-------------------------quiz--------------------------------------------
	
	//q1
	@GetMapping("/q1")
	public ResponseEntity q1(@RequestParam(name="str") String str) {
		System.out.println("String타입 파라미터 수집: "+ str);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//q2
	@GetMapping("/q2")
	public ResponseEntity q2(@RequestParam(name="f")float f, @RequestParam(name="b") boolean b) {
		System.out.println("실수형 파라미터: " + f + "논리형 파라미터: " + b);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//q3
	@GetMapping("/q3")
	public ResponseEntity q3(@RequestParam(name="arr")char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr.length);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//q4
	@PostMapping("/q4")
	public ResponseEntity q4(@RequestBody StudentDTO dto) {
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//q5
	@PostMapping("/q5")
	public ResponseEntity q5(@RequestBody StudentDTO[] dto) {
		System.out.println("객체타입 배열 수집: " + dto);
		for (int i = 0; i < dto.length; i++) {
			System.out.println(dto[i]);
		}
		System.out.println(dto.length);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//q6
	@PostMapping("/q6")
	public ResponseEntity q6(@RequestBody ArrayList<CarDTO> list) {
		System.out.println("객체타입 리스트 수집: " + list);
		for (CarDTO carDTO : list) {
			System.out.println(carDTO);
		}
		System.out.println("리스트 마지막 요소: " + list.get(list.size()-1));
		return new ResponseEntity(HttpStatus.OK);
	}
}
