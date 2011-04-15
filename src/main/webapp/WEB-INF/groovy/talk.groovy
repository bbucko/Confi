import pl.iogreen.confi.model.Talk
import pl.iogreen.confi.model.Presenter

request.title = "Talk"
request.footer = "Footer"

def presenter = new Presenter(name: "Błażej", surname: "Bucko", description: "Grails/Groovy Developer", id: "1")

request.talk = new Talk(id: "1", title: "Title", description: "Description", from: new Date(), presenter: presenter)


forward '/talk.gtpl'