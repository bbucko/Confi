<% include '/WEB-INF/includes/admin/header.gtpl' %>

<% if (!request.talks) { %>
    No talks found
<% } else { %>
    <table>
        <tr>
            <td>Title</td>
            <td>Description</td>
            <td>Presenter</td>
        </tr>
        <% request.talks.each {talk -> %>
        <tr>
            <td><a href="/admin/talk/${talk.id}">${talk.title}</a></td>
            <td>${talk.description}</td>
            <td>${talk.presenter.fullName}</td>
        </tr>
        <% } %>
    </table>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>