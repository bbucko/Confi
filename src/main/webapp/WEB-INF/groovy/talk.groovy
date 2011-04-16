import pl.iogreen.confi.model.Talk

def talk = Talk.fetch(params.id as Long)

request.title = "Talk :: ${talk.title} by ${talk.presenter.fullName}"
request.footer = "Footer"

request.talk = talk

forward '/talk.gtpl'