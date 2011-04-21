import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

if (params.id) {
    log.info "update talk ${params.id}"

    forward '/admin/updateTalk.gtpl'
    return
} else {
    if (request.method == "GET") {
        log.info "create Talk"
        request.talk = new Talk()

    } else if (request.method == "POST") {
        def talk = new Talk(title: params.title, description: params.description, presenterKey: new Key<Presenter>(Presenter.class, params.presenterId as Long), from: new Date(), to: new Date())
        request.talk = talk

        if (talk.validate()) {
            request.errors = talk.validate()
        } else {
            dao.put talk
            assert talk.id != null

            log.info "saved Talk"
            redirect "/talks"
            return
        }
    }

    request.presenters = Presenter.search()
    forward '/admin/createTalk.gtpl'
    return
}