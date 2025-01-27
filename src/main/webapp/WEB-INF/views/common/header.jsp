<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HelloSpring</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${path}/resources/css/style.css"/>
    <script src="${path}/resources/js/jquery-3.7.0.min.js"></script>
</head>
<body>
<div id="container">
    <header>
        <div id="header-container">
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img alt="로고" src="${path}/resources/images/logo-spring.png"
                     width="50px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul	class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="">HOME</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="${path}/demo/demo.do">DEMO(controller-test)</a>
                    </li>
                </ul>
                <button class="btn btn-outline-success my-2 my-sm-0"
                        data-toggle="modal" data-target="#loginModal">로그인</button>
                &nbsp;
                <button class="btn btn-outline-primary my-2 my-sm-0"
                        onclick="">
                    회원가입
                </button>
            </div>
        </nav>
    </header>
