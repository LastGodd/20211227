<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../home/menu.jsp"/>
	<div align="center">
		<div>
			<h3>로 그 인</h3>
		</div>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아 이 디</th>
							<td width="250">
							<input type="text" id="id" name="id" required="required"
								placeholder="Enter E-mail..."></td>
						</tr>
						<tr>
							<th width="150">비밀번호</th>
							<td width="250">
							<input type="password" id="password" name="password" required="required"
								placeholder="Enter password..."></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;
					<input type="reset" value="취 소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>