<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width = "500" cellpadding="0" cellspacing = "0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items = "${list}" var="dto">
		 <!-- request.setAttribute("list", dtos)에서 dtos를 list에 넣었고, 그걸 여기서 사용했다. -->
		<!-- list안에 들어있던걸 dto로 옮겼음. 그걸 지금부터 forEach를 써서 아래 설정된값들을 쭉 불러올거임-->
		<tr>
			<td>${dto.bId }</td><!-- dto.getbId인것. dto에서 bId값을 받아온다는것 -->
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}"-</c:forEach><!-- 대댓글 처리부분. 중간에 - 를 표시했음. -->
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
				<!-- 하이퍼링크씀. dto.bTitle 즉 게시물제목을 누르면 content_view.do로 이동하는데 이때 bId를 가져감. -->
				<!-- bId에는 dto.bId에서 글 아이디를 가져가는것. -->
			<td>${dto.bDate}</td><!-- 날짜. -->
			<td>${dto.bHit}</td><!-- 조회수 -->
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>