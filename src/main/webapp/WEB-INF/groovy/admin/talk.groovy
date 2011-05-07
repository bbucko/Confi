import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

if (params.id) {
    log.info "update talk ${params.id}"
    request.talk = Talk.fetch(params.id)

    if (request.method == "GET") {
        forward '/WEB-INF/views/admin/updateTalk.gtpl'
        return
    } else {
        println params
        redirect "/admin/talks"
        return
    }
} else {
    if (request.method == "GET") {
        log.info "create Talk"
        request.talk = new Talk()
    } else if (request.method == "POST") {
        def presenterKey = params.presenterId ? new Key<Presenter>(Presenter.class, params.presenterId as Long) : null
        def from = new Date()
        def to = new Date()

        def talk = new Talk(title: params.title, description: params.description, presenterKey: presenterKey, from: from, to: to)

        if (talk.validate()) {
            request.errors = talk.validate()
        } else {
            dao.put talk
            assert talk.id != null

            log.info "saved Talk"
            redirect "/admin/talks"
            return
        }

        request.talk = talk
    }

    request.presenters = Presenter.search()
    forward '/WEB-INF/views/admin/createTalk.gtpl'
    return
}