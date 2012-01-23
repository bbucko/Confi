<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8/>
    <title>Confi</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css"/>
    <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <decorator:head/>

</head>
<body>
<c:set var="homepage"><decorator:getProperty property="meta.homepage" default="false"/></c:set>
<div data-role="page" data-add-back-btn="true" data-fullscreen="true">
    <div data-role="header" data-theme="a">
        <c:if test="${!homepage}">
            <a href="/" data-icon="grid" class="ui-btn-left">Home</a>
        </c:if>
        <h1><decorator:getProperty property="meta.title" default=""/></h1>
        <a href="/about" data-icon="info" class="ui-btn-right">About</a>
    </div>

    <div data-role="content" data-theme="d">
        <decorator:body/>
    </div>
    <div data-role="footer" data-theme="a">
        <div data-role="navbar">
            <ul>
                <li><a data-icon="info" href="/talks">Talks</a></li>

                <c:if test="${!homepage}">
                    <li><a data-icon="grid" href="/">Home</a></li>
                </c:if>
                <li><a data-icon="star" href="/presenters">Presenters</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>