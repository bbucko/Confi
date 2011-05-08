<% include '/WEB-INF/includes/admin/header.gtpl' %>
<% if (request.errors) {
    out.print "<div class='error'>"
    request.errors.each {
        out.print "${it.message} <br />"
    }
    out.print "</div>"
} %>

<form action="/admin/talk" method="post">
    <table>
        <tr>
            <td><label for="title">Title of the talk</label></td>
            <td><input type="text" name="title" id="title" required value="${request.talk?.title ?: ""}"/></td>
        </tr>
        <tr>
            <td><label for="description">Description</label></td>
            <td><textarea rows="20" cols="50" name="description" id="description">${request.talk?.description ?: ""}</textarea></td>
        </tr>
        <tr>
            <td><label for="presenterId">Presenter</label></td>
            <td>
                <select name="presenterId" id="presenterId">
                    <% request.presenters.each { presenter -> %>
                    <option value="${presenter.id}" <% if (request.talk.presenterKey?.id && request.talk.presenterKey.id == presenter.id) { out.print "selected" } %>>${presenter.fullName}</option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="day">Day</label></td>
            <td><input type="date" name="day" id="day" value="${request.talk?.from?.format("yyyy-MM-dd") ?: ""}"></td>
        </tr>
        <tr>
            <td><label for="dateFrom">Hour from</label></td>
            <td><input type="time" name="dateFrom" id="dateFrom" value="${request.talk?.from?.format("HH:mm") ?: ""}"></td>
        </tr>
        <tr>
            <td><label for="dateTo">Hour to</label></td>
            <td><input type="time" name="dateTo" id="dateTo" value="${request.talk?.to?.format("HH:mm") ?: ""}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add new talk" name="add"/></td>
        </tr>
    </table>

</form>

<% include '/WEB-INF/includes/footer.gtpl' %>