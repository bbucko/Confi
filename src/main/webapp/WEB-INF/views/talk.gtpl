<html>
<head>
    <meta name="title" content="Talk">
</head>

<body>
<h3>${request.talk.title}</h3>
<strong>Presenter:</strong><a href="/presenter/${request.talk.presenter.id}">${request.talk.presenter.fullName}</a><br/>
<strong>Place:</strong>${request.talk.from.format("HH:mm")} - ${request.talk.to.format("HH:mm")}<br/>
<strong>Where:</strong>${request.talk.room}<br/>

<p>${request.talk.description}</p>
</body>
</html>