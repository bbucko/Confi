<% include '/WEB-INF/includes/admin/header.gtpl' %>

<% if (!request.talks) { %>
    No talks found
<% } else { %>
    <table>
        <% request.talks.all.each {talk -> %>
        <tr>
            <td><a href="/admin/talk/<%=talk.id%>"><%=talk.title%></a></td>
            <td><%=talk.description%></td>
        </tr>
        <% } %>
    </table>
<% } %>

<% include '/WEB-INF/includes/footer.gtpl' %>