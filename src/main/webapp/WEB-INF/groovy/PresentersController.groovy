import pl.iogreen.confi.model.Presenter

request.title = "Presenters"
request.footer = "Footer"

request.presenters = Presenter.search(sort: ["name", "surname"])

forward '/WEB-INF/views/presenters.gtpl'