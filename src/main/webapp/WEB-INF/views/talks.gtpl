<html>
<head>
    <meta name="title" content="Talks">
    <meta name="pageType" content="talks">
</head>

<body>
<%
    if (!request.talks) {
        println "No talks found."
    } else {
        if (!request.talks.today) {
            println "No talks found today."
        } else { %>
        <ul data-role="listview" data-theme="g" data-filter="true">
            <% request.talks.today.each {hour, talks -> %>
            <li data-role="list-divider">${new Date().format("DD-MM")} :: ${hour}</li>
            <% talks.each {talk -> %>
            <li>
                <a href="/talk/${talk.id}">
                    <h3>${talk.title}</h3>
                    <p>
                        ${talk.from.format("HH:mm")} - ${talk.to.format("HH:mm")} in <strong>${talk.room}</strong>
                        <span class="ui-li-aside"><strong>${talk.presenter.fullName}</strong></span>
                    </p>
                </a>
            </li>
            <% }
            } %>
        </ul>
    <%
        }
    }
    %>
</body>
</html>