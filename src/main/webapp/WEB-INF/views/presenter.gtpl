<% include '/WEB-INF/includes/header.gtpl' %>
<h3>${request.presenter.fullName}</h3>

<% if (request.presenter.url) { %>
    <strong>Homepage: </strong><a href="${request.presenter.url}">${request.presenter.url}</a><br />
<% } %>

<% if (request.presenter.email) { %>
    <strong>E-m@il: </strong><a href="${request.presenter.email}">${request.presenter.email}</a><br />
<% } %>


<p>${request.presenter.description ?: ""}</p>

<% if (request.talks) { %>
Talks:
<ul>
    <% request.talks.each {talk -> %>
        <li>
            <a href="/talk/${talk.id}">${talk.title}</a>
        </li>
    <% } %>
</ul>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>