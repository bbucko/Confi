<% include '/WEB-INF/includes/admin/header.gtpl' %>

<% if (request.errors) {
    out.print "<div class='error'>"
    request.errors.each {
        out.print "${it.message} <br />"
    }
    out.print "</div>"
} %>

<form action="/admin/presenter" method="post">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name" required value="${request.presenter?.name ?: ""}"/></td>
        </tr>
        <tr>
            <td><label for="surname">Surname</label></td>
            <td><input type="text" name="surname" id="surname" required value="${request.presenter?.surname ?: ""}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description</label></td>
            <td><textarea name="description" id="description" rows="20" cols="50">${request.presenter.description ?: ""}</textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add new presenter" name="add"/></td>
        </tr>
    </table>
</form>

<% include '/WEB-INF/includes/footer.gtpl' %>