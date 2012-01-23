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
</head>

<body>

<div data-role="page" data-add-back-btn="true" data-fullscreen="true">
    <div data-role="header" data-theme="a">
        <h1><%=request.title ?: "Page Title"%></h1>
        <a href="/about" data-icon="info" class="ui-btn-right">About</a>
        <a href="/" data-icon="grid" class="ui-btn-left">Home</a>
    </div>

    <div data-role="content" data-theme="d">
    <% TimeZone.'default'= TimeZone.getTimeZone('CET') //set the default time zone %>