package com.jinw0909.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String FILE_UPLOAD_PATH = "/Users/jinwoo/jinwoo/workspace_javaSpringTest/upload/memo/images/";
	
	// 파일 업로드 (경로 리턴)
	public String saveFile(int userId, MultipartFile file) {
		// 파일 이름 겹침을 방지하기 위해서 사용자별로 디렉토리를 만들어서 저장한다.
		// 올린 시간별로 구분해서 저장
		// jinw0909_131879/test.png
		// 1970년 1월 1일 이후 지금 몇ms가 지났는지
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 파일 저장할 디렉토리 생성
		File directory = new File(filePath);
		
		if (directory.mkdir() == false) {
			logger.error("[FileManagerService saveFile] 디렉토리 생성 실패");
			return null;
		}
		
		// 파일 저장
		// byte
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e){
			logger.error("[FileManagerService saveFile] 파일 생성 실패");
			e.printStackTrace();
			return null;
		}
		
		
		// 파일이 접근 가능한 path 리턴
		
		// 파일 접근 가능한 path 리턴
		// src="/images/12_124141241/test.png"
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
	}
}
