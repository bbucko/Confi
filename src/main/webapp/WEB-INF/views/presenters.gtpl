<% include '/WEB-INF/includes/header.gtpl' %>
<% if (!request.presenters) { %>
    No presenters found
<% } else { %>
    <ul data-role="listview" data-theme="g" data-filter="true">
        <% request.presenters.each {presenter -> %>
            <li>
                <a href="/presenter/${presenter.id}">
                    <h3>${presenter.fullName}</h3>
                </a>
            </li>
        <% } %>
    </ul>
<% } %>
<% include '/WEB-INF/includes/footer.gtpl' %>

