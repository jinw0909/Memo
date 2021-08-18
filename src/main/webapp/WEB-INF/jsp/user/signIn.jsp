<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<head>
<meta charset="UTF-8">
<title>메모 - 로그인</title>
</head>
<body>
	<div id="wrap" class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp"></c:import>
		<section class="content d-flex justify-content-center">
			<div class="login-box h-100 d-flex align-items-center justify-content-center">
				<div class="w-100">
					<h1 class="text-center">로그인</h1>
					<input type="text" class="form-control mt-3" placeholder="아이디">
					<input type="text" class="form-control mt-3" placeholder="비밀번호">
					<buttton type="submit" class="btn btn-success btn-block mt-3 w-100">제출</buttton>
					<div class="mt-3 text-right"><a href="/user/signup_view">회원가입</a></div>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>
</body>
</html>