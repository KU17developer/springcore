<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<section id="content">
    ${demos}
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

    </table>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>