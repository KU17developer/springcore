<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<section id="content">

    <table class="table">
        <tr>
            <th scope="col">번호</th>
            <th scope="col">이름</th>
            <th scope="col">나이</th>
            <th scope="col">이메일</th>
            <th scope="col">성별</th>
            <th scope="col">개발가능언어</th>
            <th scope="col">수정</th>
        </tr>
        <tbody>
            <c:forEach var = "demo" items = "${demos}" varStatus = "vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${demo.devName}</td>
                    <td>${demo.devAge}</td>
                    <td>${demo.devEmail}</td>
                    <td>${demo.devGender}</td>
                    <td>
                        <ul>
                        <c:forEach var="l" items="${demo.devLang}">
                            <li>${l}</li>
                        </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>