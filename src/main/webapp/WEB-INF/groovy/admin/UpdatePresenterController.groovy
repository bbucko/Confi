package admin

import com.google.appengine.api.datastore.Email
import com.google.appengine.api.datastore.Link
import pl.iogreen.confi.model.Presenter

log.info "update presenter ${params.id}"
def presenter = Presenter.fetch(params.id)
request.presenter = presenter

if (request.method == "GET") {
    forward '/WEB-INF/views/admin/updatePresenter.gtpl'
} else {
    presenter.description = params.description
    presenter.surname = params.surname
    presenter.name = params.name
    presenter.url = params.url ? params.url as Link : null
    presenter.email = params.email ? params.email as Email : null

    request.errors = presenter.validate()
    if (!request.errors) {
        dao.put presenter
        assert presenter.id != null

        redirect "/admin/presenters"
        memcache.clearAll()
        return
    }
    forward '/WEB-INF/views/admin/createPresenter.gtpl'
}