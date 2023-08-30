package com.example.demo.item.util;


import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileTests {
	
	//디렉토리 밑에 있는 파일을 모두 읽는 방법
		//파일이 존재하는지 검사하는 방법
		//파일과 디렉토리를 생성하는 방법
	
	@Test
	public void 폴더생성() {	
		try {
			File dir = new File("C:\\newsadfasdf");
			dir.mkdir(); // 폴더 생성
		} catch (Exception e) {
			System.out.println("파일 및 폴더 생성에 실패했습니다.");
		}
	}
		
		 
	
	@Test
	public void 파일찾기() {
		
		File file = new File("C:\\Users\\user\\Desktop\\a\\b\\c\\asdf.txt");
		
		System.out.println(file.exists());
	}
	
}
