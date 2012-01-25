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
            <li data-role="list-divider">Today:: ${hour}</li>
            <% talks.each {talk -> %>
            <li>
                <a href="/talk/${talk.id}">
                    <h3>${talk.title}</h3>

                    <p><strong>${talk.presenter.fullName}</strong></p>

                    <p>${talk.from.format("HH:mm")} - ${talk.to.format("HH:mm")} :: <strong>${talk.room}</strong></p>
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