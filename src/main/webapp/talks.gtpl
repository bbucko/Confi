<% include '/WEB-INF/includes/header.gtpl' %>
<% if (!request.talks) { %>
No talks found
<% } else { %>
<ul data-role="listview" data-theme="g">
    <% if (!request.talks.today) { %>
        No talks found today
    <% } else { %>
        <li data-role="list-divider">Friday, October 8, 2010 :: 10:00</li>
        <% request.talks.today.each {talk -> %>
            <li>
                <a href="/talk/<%= talk.id %>">
                    <h3><%= talk.title %></h3>

                    <p><strong><%= talk.presenter.name %></strong></p>

                    <p><%= talk.description %></p>

                    <p class="ui-li-aside"><strong>Sala B</strong></p>
                </a>
            </li>
        <% } %>
    <% } %>
</ul>
<% } %>
<% include '/WEB-INF/includes/footer.gtpl' %>

