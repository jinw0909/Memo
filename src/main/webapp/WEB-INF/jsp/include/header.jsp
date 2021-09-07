<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="bg-secondary d-flex align-items-center justify-content-between pt-2">
	<h2 class="memo ml-3">MEMO</h2>
	<c:if test="${not empty userName }">
		<div class="mr-4">${userName }님 <a href="/user/sign_out">로그아웃</a> </div>
	</c:if>
</header>