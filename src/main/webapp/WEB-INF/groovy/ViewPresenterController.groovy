import pl.iogreen.confi.model.Presenter
import pl.iogreen.confi.model.Talk

def presenter = Presenter.fetch(params.id)

request.title = presenter.fullName
request.footer = "Footer"
request.presenter = presenter
request.talks = Talk.search(filter: ["presenterKey = ": presenter], sort: ["title"])


forward '/WEB-INF/views/presenter.gtpl'