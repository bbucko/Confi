import pl.iogreen.confi.model.Talk

def talk = Talk.fetch(params.id as Long)

request.title = "${talk.title}"
request.footer = "Footer"

request.talk = talk

forward '/WEB-INF/views//talk.gtpl'