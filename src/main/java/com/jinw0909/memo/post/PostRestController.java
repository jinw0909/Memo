package com.jinw0909.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jinw0909.memo.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, String> create(
			@RequestParam("title") String title
			, @RequestParam("content") String content
			, @RequestParam(value = "file", required = false) MultipartFile file 
			, HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postBO.addPost(userId, title, content, file);
		
		Map<String, String> result = new HashMap<>();
		
		if (count >= 1) {
			result.put("result", "success");
		} else {
			result.put("result", "failure");
		}
		return result;
		//userId, title, content
	}
	
	@PostMapping("/update")
	public Map<String, String> update(
			@RequestParam("id") int id
			, @RequestParam("title") String title
			, @RequestParam("content") String content
			) {
		int count = postBO.updateMemo(id, title, content);
		Map<String, String> result = new HashMap<>();
		
		if (count >= 1) {
			result.put("result", "success");
		} else {
			result.put("result", "failure");
		}
		return result;
		
		
	}
	
	@GetMapping("/delete")
	public Map<String, String> delete(
			@RequestParam("id") int id) {
		int count = postBO.deleteMemo(id);
		Map<String, String> result = new HashMap<>();
		
		if (count >= 1) {
			result.put("result", "success");
		} else {
			result.put("result", "failure");
		}
		return result;
		
	}
}
