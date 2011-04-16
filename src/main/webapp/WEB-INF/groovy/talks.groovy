import pl.iogreen.confi.model.Talk

request.title = "Talks"
request.footer = "Footer"

request.talks = [
        "today": Talk.search()
]

forward '/talks.gtpl'