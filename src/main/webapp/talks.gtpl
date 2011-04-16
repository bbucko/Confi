<% include '/WEB-INF/includes/header.gtpl' %>
<% if (!request.talks) { %>
    No talks found
<% } else { %>
    <ul data-role="listview" data-theme="g" data-split-icon="gear" data-split-theme="g" data-filter="true" data-inset="true">
        <% if (!request.talks.today) { %>
            No talks found today
        <% } else { %>
            <li data-role="list-divider">Today:: 10:00 - 11:00</li>
            <% request.talks.today.each {talk -> %>
                <li>
                    
                    <a href="/talk/<%=talk.id%>">
                        <img src="images/album-bb.jpg" />
                        <h3><%=talk.title%></h3>
                        <p><strong><%=talk.presenter.fullName%></strong></p>
                        <p><%=talk.description%></p>

                        <p class="ui-li-aside"><strong>Sala B</strong></p>
                    </a>
                    <a href="/speaker/1" data-rel="dialog" data-transition="slideup">Speaker</a>
                </li>
            <% } %>
        <% } %>
    </ul>
<% } %>
<% include '/WEB-INF/includes/footer.gtpl' %>

