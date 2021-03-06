<html>
<head>
    <meta name="title" content="Conference Schedule">
    <meta name="pageType" content="home">
</head>

<body>
<ul data-role="listview" data-theme="g">
    <% if (request.nowTalking) { %>
    <li data-role="list-divider">Current talks</li>
    <% request.nowTalking.each {talk -> %>
    <li>
        <a href="/talk/${talk.id}">
            <h3>${talk.title}</h3>

            <p><strong>${talk.presenter.fullName}</strong></p>

            <p>${talk.from.format("HH:mm")} - ${talk.to.format("HH:mm")} :: <strong>${talk.room}</strong></p>
        </a>
    </li>
    <% }
    }

    if (request.nextTalks) { %>
    <li data-role="list-divider">Next talks</li>
    <% request.nextTalks.each {talk -> %>
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
</body>
</html>