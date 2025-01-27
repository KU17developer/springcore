<%--
  Created by IntelliJ IDEA.
  User: ku
  Date: 2025-01-21
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>에러페이지</title>
</head>
<body>
    <h3>runtime에러가 발생</h3>
    <p>관리자에게 문의하세요!</p>
    <script>
        setTimeout(()=>{
            location.replace("${request.contextPath}")
        } )


    </script>

</body>
</html>
