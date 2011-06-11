<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset=utf-8/>
    <title>Confi</title>

    <script src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>


    <link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
</head>

<body>

<div data-role="page">
    <div data-role="header" data-theme="a">
        <h1><%= request.title ?: "Page Title"%></h1>
        <a href="/" data-icon="home" data-iconpos="notext" data-direction="reverse" class="ui-btn-right jqm-home">Home</a>
    </div>
    
    <div data-role="content" data-theme="b">