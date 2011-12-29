import pl.iogreen.confi.model.Talk

request.title = "Welcome to 33 Degree"
request.footer = "Footer"

def today = new Date()
today.clearTime()

def nowTalking = Talk.search(filter: ["from >= ": today, "from < ": today + 1], sort: ["from", "title"])
def nextTalks = Talk.search(filter: ["from >= ": today + 1, "from < ": today + 2])


forward '/WEB-INF/views/index.gtpl'