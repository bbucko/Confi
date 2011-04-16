import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

request.title = "Welcome"
request.footer = "Footer"

if (Talk.search().isEmpty()) {
    Presenter presenter = new Presenter(name: "Błażej", surname: "Bucko", description: "Grails/Groovy Developer")
    dao.put presenter

    2.times {
        Talk talk = new Talk(title: "Title", description: "Description", from: new Date(), presenterKey: new Key<Presenter>(Presenter.class, presenter.id))
        dao.put talk
    }
}

forward '/index.gtpl'