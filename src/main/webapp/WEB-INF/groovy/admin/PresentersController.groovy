package admin

import pl.iogreen.confi.model.Presenter

request.presenters = Presenter.search(sort: ["name", "surname"])

forward '/WEB-INF/views/admin/presenters.gtpl'