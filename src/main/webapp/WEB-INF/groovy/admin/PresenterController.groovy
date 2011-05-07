package admin

import com.google.appengine.api.datastore.Email
import com.google.appengine.api.datastore.Link
import pl.iogreen.confi.model.Presenter

if (params.id) {
    log.info "update presenter ${params.id}"
    def presenter = Presenter.fetch(params.id)
    request.presenter = presenter

    if (request.method == "GET") {
        forward '/WEB-INF/views/admin/updatePresenter.gtpl'
    } else {
        presenter.description = params.description
        presenter.surname = params.surname
        presenter.name = params.name

        request.errors = presenter.validate()
        if (!request.errors) {
            dao.put presenter
            assert presenter.id != null

            log.info "updated Talk"
            redirect "/admin/presenters"
            return
        }
        forward '/WEB-INF/views/admin/createPresenter.gtpl'
    }
} else {
    if (request.method == "GET") {
        log.info "create Presenter"
        request.presenter = new Presenter()
    } else if (request.method == "POST") {
        def presenter = new Presenter(name: params.name, surname: params.surname, description: params.description, url: params.url as Link, email: params.email as Email)
        request.errors = presenter.validate()

        if (request.errors) {
            dao.put presenter
            assert presenter.id != null

            log.info "saved Presenter"
            redirect "/admin/presenters"
            return
        }

        request.presenter = presenter
    }

    forward '/WEB-INF/views/admin/createPresenter.gtpl'
}