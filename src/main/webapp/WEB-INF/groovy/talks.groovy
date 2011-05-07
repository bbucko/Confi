import pl.iogreen.confi.model.Talk

request.title = "Talks"
request.footer = "Footer"

def todayStart = new Date() - 100
def todayEnd = new Date() + 1

request.talks = [
        "today": Talk.search(
                filter: [
                        "dateFrom >= ": todayStart.format("%F 00:00:00"),
                        "dateFrom < ": todayEnd.format("%F 00:00:00")
                ]
        )
]

forward '/WEB-INF/views/talks.gtpl'