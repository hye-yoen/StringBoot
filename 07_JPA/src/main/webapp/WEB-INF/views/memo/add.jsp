<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>/memo/add PAGE</h1>

    <P> 앞으로 26분! </P>


    <form action="/memo/add" method="post">
        <div>
            <label>TEXT : </label> <span>${text}</span><br/>
            <textarea name="text"></textarea>
        </div>
        <div>
            <label>WRITER : </label> <span>${writer}</span><br/>
            <input name="writer"></textarea>
        </div>
        <div>
            <button>메모추가</button>
        </div>

        <P> 앞으로 20분! </P>
    </form>
</body>
</html>
