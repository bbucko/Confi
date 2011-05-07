<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8/>
    <title>Confi</title>

    <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>

    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
</head>

<body>

<div data-role="page">
    <div data-role="header" data-theme="a">
        <h1><%= request.title ?: "Page Title"%></h1>
        <a href="/" data-icon="home" data-iconpos="notext" data-direction="reverse" class="ui-btn-right jqm-home">Home</a>
    </div>
    
    <div data-role="content" data-theme="b">