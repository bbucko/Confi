import pl.iogreen.confi.model.Talk
import pl.iogreen.confi.model.Presenter

request.title = "Talks"
request.footer = "Footer"

def presenter = new Presenter(name: "Błażej", surname: "Bucko", description: "Grails/Groovy Developer", id: "1")

request.talks = [
        "today": [new Talk(id: "1", title: "Title", description: "Description", from: new Date(), presenter: presenter), new Talk(id: "2", title: "Title", description: "Description", from: new Date(), presenter: presenter)],
        "tomorrow": [new Talk(id: "3", title: "Title 2", description: "Description 2", from: new Date(), presenter: presenter)],
]

forward '/talks.gtpl'