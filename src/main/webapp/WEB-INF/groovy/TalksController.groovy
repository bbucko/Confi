import pl.iogreen.confi.model.Talk

request.title = "Talks"
request.footer = "Footer"

def today = new Date()
today.clearTime()

def foundTodayTalks = Talk.search(filter: ["from >= ": today, "from < ": today + 1], sort: ["from", "title"])
//def foundTomorrowTalks = Talk.search(filter: ["from >= ": today + 1, "from < ": today + 2])

request.talks = [
        "today": foundTodayTalks.groupBy {Talk talk -> talk.from.format("HH:00")}
]

forward '/WEB-INF/views/talks.gtpl'