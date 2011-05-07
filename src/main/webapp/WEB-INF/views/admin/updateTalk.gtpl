<% include '/WEB-INF/includes/admin/header.gtpl' %>

<form action="/admin/talk/<%=request.talk.id%>" method="post">

    <input type="submit" value="Update talk" name="update"/>
</form>


<% include '/WEB-INF/includes/footer.gtpl' %>