<% include '/WEB-INF/includes/admin/header.gtpl' %>

<% if (!request.talks) { %>
    No talks found
<% } else { %>
    <table>
        <tr>
            <td>Title</td>
            <td>Presenter</td>
            <td>Room</td>
            <td>Schedule</td>
        </tr>
        <% request.talks.each {talk -> %>
        <tr>
            <td><a href="/admin/talk/${talk.id}">${talk.title}</a></td>
            <td>${talk.presenter.fullName}</td>
            <td>${talk.room}</td>
            <td>${talk.from.format("yyyy-MM-dd z")} :: ${talk.from.format("HH:mm")} - ${talk.to.format("HH:mm")}</td>
        </tr>
        <% } %>
    </table>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>