package admin

import com.googlecode.objectify.Key
import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

request.presenters = Presenter.search()

log.info "update talk ${params.id}"
def talk = Talk.fetch(params.id)
request.talk = talk

if (request.method == "GET") {
    forward '/WEB-INF/views/admin/updateTalk.gtpl'
} else {
    talk.title = params.title
    talk.description = params.description
    talk.presenterKey = params.presenterId ? new Key<Presenter>(Presenter.class, params.presenterId as Long) : null
    talk.from = params.dateFrom ? Date.parse("yyyy-MM-dd HH:mm", "${params.day} ${params.dateFrom}") : null
    talk.to = params.dateTo ? Date.parse("yyyy-MM-dd HH:mm", "${params.day} ${params.dateTo}") : null

    request.errors = talk.validate()
    if (!request.errors) {
        dao.put talk
        assert talk.id != null

        log.info "updated Talk"
        redirect "/admin/talks"
        return
    }

    forward '/WEB-INF/views/admin/updateTalk.gtpl'
}