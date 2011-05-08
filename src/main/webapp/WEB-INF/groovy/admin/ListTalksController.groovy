package admin

import pl.iogreen.confi.model.Talk

request.talks = Talk.search(sort: ["from", "title"])

forward '/WEB-INF/views/admin/talks.gtpl'