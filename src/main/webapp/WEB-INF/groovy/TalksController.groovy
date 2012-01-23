import pl.iogreen.confi.model.Talk

request.title = "Talks"
request.footer = "Footer"

def today = new Date()
final tomorrow = (new Date() + 1.day).clearTime()
today.clearTime()
final String cacheKey = "todayTalks${today.time}"
if (!cacheKey in memcache) {
    log.info "Cache miss for ${cacheKey}"
    memcache[cacheKey] = Talk.search(filter: ["from >=": today, "from <": tomorrow], sort: ["from", "title"])
}

request.talks = [
        "today": memcache[cacheKey].groupBy {Talk talk -> talk.from.format("HH:00")}
]

forward '/WEB-INF/views/talks.gtpl'