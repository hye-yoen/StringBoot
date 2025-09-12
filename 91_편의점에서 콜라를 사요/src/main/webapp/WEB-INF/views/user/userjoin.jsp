<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MEMO ADD(/memo/add)</h1>

	<form action="/user/join" method="post">
		<div>
			<label>text : </label>  <span>${username}</span><br>
			<textarea name="username" /></textarea>
		</div>
		<div>
			<label>writer : </label>  <span>${password}</span><br>
			<input name="password" />
		</div>
		<div>
			<input type="submit" value="임시회원가입" />
		</div>
	</form>

</body>
</html>
