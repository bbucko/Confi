package admin

import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

request.presenters = Presenter.search()

if (request.method == "GET") {
    log.info "create Talk"
    request.talk = new Talk()
} else if (request.method == "POST") {
    def presenterKey = params.presenterId ? new Key<Presenter>(Presenter.class, params.presenterId as Long) : null

    def from = params.dateFrom ? Date.parse("yyyy-MM-dd HH:mm", "${params.day} ${params.dateFrom}") : null
    def to = params.dateTo ? Date.parse("yyyy-MM-dd HH:mm", "${params.day} ${params.dateTo}") : null

    def talk = new Talk(title: params.title, description: params.description, presenterKey: presenterKey, room: params.room, from: from, to: to)
    request.errors = talk.validate()

    if (!request.errors) {
        dao.put talk
        assert talk.id != null

        log.info "saved Talk"
        redirect "/admin/talks"
        return
    }

    request.talk = talk
}

forward '/WEB-INF/views/admin/createTalk.gtpl'
