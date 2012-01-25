<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8/>
    <title>Confi</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>

    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <decorator:head/>
</head>
<body>
<div data-role="page">
    <div data-role="header" data-theme="a">
        <h1><decorator:getProperty property="meta.title" default=""/></h1>
        <a href="/about" data-icon="info" class="ui-btn-right">About</a>
    </div>

    <div data-role="content" data-theme="d">
        <decorator:body/>
    </div>
    <div data-role="footer" data-theme="a" data-position="fixed">
        <div data-role="navbar">
            <ul>
                <c:set var="pageType"><decorator:getProperty property="meta.pageType"/></c:set>
                <li><a <c:if test="${pageType eq 'talks'}">class="ui-btn-active"</c:if> data-icon="info" href="/talks">Talks</a></li>
                <li><a <c:if test="${pageType eq 'home'}">class="ui-btn-active"</c:if> data-icon="grid" href="/">Home</a></li>
                <li><a <c:if test="${pageType eq 'presenters'}">class="ui-btn-active"</c:if> data-icon="star" href="/presenters">Presenters</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>