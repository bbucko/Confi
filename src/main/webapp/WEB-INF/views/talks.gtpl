<% include '/WEB-INF/includes/header.gtpl' %>
<% if (!request.talks) { %>
    No talks found
<% } else { %>
    <% if (!request.talks.today) { %>
        No talks found today
    <% } else { %>
        <ul data-role="listview" data-theme="g" data-filter="true">
            <% request.talks.today.each {hour, talks -> %>
                <li data-role="list-divider">Today:: ${hour}</li>
                <% talks.each {talk -> %>
                    <li>
                        <a href="/talk/${talk.id}">
                            <h3>${talk.title}</h3>
                            <p><strong>${talk.presenter.fullName}</strong></p>
                            <p>${talk.from.format("HH:mm")} - ${talk.to.format("HH:mm")} :: <strong>${talk.room}</strong></p>
                            <p>${talk.description}</p>
                        </a>
                    </li>
                <% } %>
            <% } %>
        </ul>
    <% } %>
<% } %>
<% include '/WEB-INF/includes/footer.gtpl' %>