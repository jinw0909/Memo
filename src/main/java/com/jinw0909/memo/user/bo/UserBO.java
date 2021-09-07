package com.jinw0909.memo.user.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinw0909.memo.common.EncryptUtils;
import com.jinw0909.memo.user.dao.UserDAO;
import com.jinw0909.memo.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	public int signUp(String loginId, String password, String name, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		if (encryptPassword == "") {
			logger.error("[UserBO SignUp] !!!!!!!!!error!!!!!!!");
			return 0;
		}
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	public User signIn(String loginId, String password) {
		// 비밀번호 암호화한 후 전달
		String encryptPassword = EncryptUtils.md5(password);
		return userDAO.selectUserByIdPassword(loginId, encryptPassword);
	}
}
