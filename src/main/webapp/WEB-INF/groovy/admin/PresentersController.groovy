package admin

import pl.iogreen.confi.model.Presenter

request.presenters = Presenter.search()

forward '/WEB-INF/views/admin/presenters.gtpl'