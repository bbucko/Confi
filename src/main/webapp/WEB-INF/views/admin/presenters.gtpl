<% include '/WEB-INF/includes/admin/header.gtpl' %>

<% if (!request.presenters) { %>
No presenters found
<% } else { %>
<table>
    <tr>
        <td>Name</td>
        <td>Description</td>
    </tr>
    <% request.presenters.each {presenter -> %>
    <tr>
        <td><a href="/admin/presenter/${presenter.id}">${presenter.fullName}</a></td>
        <td>${presenter.description ?: ""}</td>
    </tr>
    <% } %>
</table>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>