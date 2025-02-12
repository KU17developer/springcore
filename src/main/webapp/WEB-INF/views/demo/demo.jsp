<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--  validator를 구현했을때 그 model값을 가지고 어떠한 내용들을 처리할 수 있는 태그들을 제공함!--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/views/common/header.jsp" />

<style>

    .errorMsg{
        color:red;
        font-size:20px;
        font-weight: bolder;
    }

</style>


<section id="content">
    <div id="demo-container">
<%--        <form id="devFrm" method="post">--%>
<%--            <div class="form-group row">--%>
<%--                <label for="devName" class="col-sm-2 col-form-label">이름</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="text" class="form-control" id="devName" name="devName">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="devAge" class="col-sm-2 col-form-label">나이</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="number" class="form-control" id="devAge" name="devAge">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="email" class="form-control" id="devEmail" name="devEmail">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label class="col-sm-2 col-form-label">성별</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">--%>
<%--                        <label class="form-check-label" for="devGender0">남</label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">--%>
<%--                        <label class="form-check-label" for="devGender1">여</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label class="col-sm-2 col-form-label">개발언어</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">--%>
<%--                        <label class="form-check-label" for="devLang0">Java</label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">--%>
<%--                        <label class="form-check-label" for="devLang1">C</label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check form-check-inline">--%>
<%--                        <input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">--%>
<%--                        <label class="form-check-label" for="devLang2">Javascript</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group row">--%>
<%--                <label for="devEmail" class="col-sm-2 col-form-label">시도</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="text" class="form-control" id="sido" name="sido">--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group row">--%>
<%--                <label for="devEmail" class="col-sm-2 col-form-label">군구</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="text" class="form-control" id="gungu" name="gungu">--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group row">--%>
<%--                <label for="devEmail" class="col-sm-2 col-form-label">동</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="text" class="form-control" id="dong" name="dong">--%>
<%--                </div>--%>
<%--            </div>--%>


<%--            <div class="form-group row">--%>
<%--                <label for="devEmail" class="col-sm-2 col-form-label">생년월일</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="date" class="form-control" id="birthday" name="birthday">--%>
<%--                </div>--%>
<%--            </div>--%>






    <%-- 스프링 form 적용하기 , prefix로 form! --%>
    <%-- 스프링 form이 제공하는 태그를 이용해서 연동할 수 있다 --%>
    <%-- 여기에 들어오는 데이터는 DemoController에서 보내준 model이랑 연동해서 값을 처리해야함! 그래서 modelAttribute="demo" 이렇게!--%>
    <%-- DemoController에서 demo라는 이름으로 보냈음! --%>

    <form:form id="devFrm" method="post" modelAttribute="demo">
        <div class="form-group row">
            <label for="devName" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">

                <%-- 여기도 input 앞에 form을 붙여줌!  --%>
                <%-- 쓰기전에 위에 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 이거 꼭 선언하기!--%>
                <%-- 그리고 추가적으로 path 속성을 반드시 써줘야함! --%>
                    <%-- path는 위에  <form:form id="devFrm" method="post" modelAttribute="demo"> 여기에서 --%>
                    <%-- modelAttribute="demo" 이 데이터에 특정한 필드를 연결한 값이다라고 표시해준거임! --%>
                    <%-- 즉 demo 이 dto 객체의 특정 필드랑 연결하는 속성을 주는거임! --%>
                    <%-- 중요!! 그리고 태그 라이브러리(jstl)를 쓴거니깐 마지막에 /를 써서 닫기 태그 꼭 해줘야됨! 이렇게 /> --%>
                <form:input path="devName" type="text" class="form-control" id="devName" name="devName"/>
                <%-- 여기 밑에다가는 에러메세지를 띄울수 있음 (설정한 어노테이션에 위반되면 에러메시지가 뜸! 에러가 없으면 안뜨고! --%>
                    <%-- cssClass는 스타일 클래스의 어떤값을 가져와서 적용하겠다! 이런뜻임!--%>
                    <%-- 이 errors 태그가 생성됐을 때 클래스(위에 style 생성한거 쓰겠다는 뜻 같음..)가 errorMsg으로 하겠다! --%>
                <form:errors path="devName" cssClass="errorMsg"/>

            </div>
        </div>
        <div class="form-group row">
            <label for="devAge" class="col-sm-2 col-form-label">나이</label>
            <div class="col-sm-10">
                <form:input path="devAge" type="number" class="form-control" id="devAge" name="devAge"/>
                <form:errors path="devAge" cssClass="errorMsg"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-10">
                <form:input path="devEmail" type="text" class="form-control" id="devEmail" name="devEmail"/>
                <form:errors path="devEmail" cssClass="errorMsg"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">성별</label>
            <div class="col-sm-10">
                <div class="form-check form-check-inline">

                    <%-- form:radiobutton 이거 해줬으니 type="radio" 지워주기 --%>
                    <form:radiobutton path="devGender" class="form-check-input" name="devGender" id="devGender0" value="M"/>
                    <label class="form-check-label" for="devGender0">남</label>
                </div>
                <div class="form-check form-check-inline">

                    <%-- form:radiobutton 이거 해줬으니 type="radio" 지워주기 --%>
                    <form:radiobutton path="devGender" class="form-check-input" name="devGender" id="devGender1" value="F"/>
                    <label class="form-check-label" for="devGender1">여</label>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">개발언어</label>
            <div class="col-sm-10">
                <div class="form-check form-check-inline">

                    <%-- form:checkbox 라는 것도 사용할 수 있음!--%>
                    <%-- type="checkbox" 이건 이제 써줄 필요 없어짐! --%>
                    <%-- checkboxes 라는것도 있는데 for문 돌아서 체크박스 개수만큼 만들어줌--%>
                    <form:checkbox path="devLang" class="form-check-input"  name="devLang" id="devLang0" value="Java"/>
                    <label class="form-check-label" for="devLang0">Java</label>
                </div>
                <div class="form-check form-check-inline">

                    <%-- form:checkbox 라는 것도 사용할 수 있음!--%>
                    <%-- type="checkbox" 이건 이제 써줄 필요 없어짐! --%>
                    <form:checkbox path="devLang" class="form-check-input"  name="devLang" id="devLang1" value="C"/>
                    <label class="form-check-label" for="devLang1">C</label>
                </div>
                <div class="form-check form-check-inline">

                    <%-- form:checkbox 라는 것도 사용할 수 있음!--%>
                    <%-- type="checkbox" 이건 이제 써줄 필요 없어짐! --%>
                    <form:checkbox path = "devLang" class="form-check-input"  name="devLang" id="devLang2" value="Javascript"/>
                    <label class="form-check-label" for="devLang2">Javascript</label>
                </div>
            </div>
        </div>

        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">시도</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sido" name="sido">
            </div>
        </div>

        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">군구</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="gungu" name="gungu">
            </div>
        </div>

        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">동</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="dong" name="dong">
            </div>
        </div>


        <div class="form-group row">
            <label for="devEmail" class="col-sm-2 col-form-label">생년월일</label>
            <div class="col-sm-10">
                <form:input path="birthday" type="date" class="form-control" id="birthday" name="birthday"/>
                <form:errors path="birthday" cssClass="errorMsg"/>
            </div>
        </div>





            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"  onclick="requestTest('demo1.do')" >
                        서블릿처럼 controller 이용하기
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo2.do')" >
                        파라미터 직접받아 처리하기(1대1매칭)
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo3.do')" >
                        @RequestParam이용하기
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo4.do')" >
                        Command 객체 이용해서 저장하기
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo5.do')" >
                        Map 객체 이용해서 저장하기
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo6.do')" >
                        추가정보 가져오기
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="requestTest('demo7.do')" >
                        ModelAndView 응답하기
                    </button>
                </div>
            </div>



            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="ajaxRequest();" >
                        ajax 요청
                    </button>
                </div>
            </div>


            <div class="form-group row">
                <div class="col-sm-12">
                    <button type="button" class = "btn btn-outline-primary col-sm-12"
                            onclick="insertDemo();" >
                        insert 실행하기
                    </button>
                </div>
            </div>



        </form:form>
    </div>
    <script>
        const insertDemo=()=>{
            const form = document.querySelector("#devFrm");
            form.action="${pageContext.request.contextPath}/demo/insertdemo.do";
            form.submit();
        }




        const ajaxRequest=()=>{
            const demo = {devName:"우감자", devAge:33, devGender:"남", devEmail:"woo@woo",devLang:["java", "javascript"]};
            fetch("${pageContext.request.contextPath}/demo/demo9.do",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(demo)
            }).then(response=>response.json())
                .then(data=>console.log(data));
        }

        const requestTest=(url)=>{
            const form = document.getElementById("devFrm");
            form.action="${pageContext.request.contextPath}/demo/"+url;
            form.submit();
        }

    </script>

</section>

<style>
    div#demo-container{
    width:50%;
    padding:15px;
    margin:0 auto;
    border:1px solid lightgray;
    border-radius:10px;
    }
</style>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />