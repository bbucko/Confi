import pl.iogreen.confi.model.Presenter
import com.google.appengine.api.datastore.Link
import com.google.appengine.api.datastore.Email

if (params.id) {
    log.info "update presenter ${params.id}"
    request.presenter = Presenter.fetch(params.id)

    if (request.method == "GET") {
        forward '/WEB-INF/views/admin/updatePresenter.gtpl'
        return
    } else {
        println params
        redirect "/admin/presenters"
        return
    }
} else {
    if (request.method == "GET") {
        log.info "create Presenter"
        request.presenter = new Presenter()
    } else if (request.method == "POST") {
        def presenter = new Presenter(name: params.name, surname: params.surname, description: params.description, url: params.url as Link, email: params.email as Email)

        if (presenter.validate()) {
            request.errors = presenter.validate()
        } else {
            dao.put presenter
            assert presenter.id != null

            log.info "saved Presenter"
            redirect "/admin/presenters"
            return
        }

        request.presenter = presenter
    }

    forward '/WEB-INF/views/admin/createPresenter.gtpl'
    return
}