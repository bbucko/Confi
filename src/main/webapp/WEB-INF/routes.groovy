import groovy.time.TimeCategory

Integer.metaClass.mixin TimeCategory
Date.metaClass.mixin TimeCategory

get "/", forward: "/WelcomeController.groovy", cache: 5.minutes
get "/about", forward: "/AboutController.groovy"
//, cache: (24 * 10).hours

get "/presenters", forward: "/PresentersController.groovy", cache: 24.hours
get "/presenters/*", forward: "/PresentersController.groovy", cache: 24.hours

get "/presenter/@id", forward: "/ViewPresenterController.groovy?id=@id", cache: 24.hours

get "/talks", forward: "/TalksController.groovy", cache: 24.hours
get "/talks/*", forward: "/TalksController.groovy", cache: 24.hours

get "/talk/@id", forward: "/ViewTalkController.groovy?id=@id", cache: 24.hours

get "/admin", forward: "/admin/index.groovy", cache: (365 * 24).hours

get "/admin/talks", forward: "/admin/ListTalksController.groovy"
get "/admin/import/talks", forward: "/admin/ImportTalksController.groovy"

get "/admin/talk", forward: "/admin/CreateTalkController.groovy"
post "/admin/talk", forward: "/admin/CreateTalkController.groovy"

get "/admin/talk/@id", forward: "/admin/UpdateTalkController.groovy?id=@id"
post "/admin/talk/@id", forward: "/admin/UpdateTalkController.groovy?id=@id"

get "/admin/presenters", forward: "/admin/ListPresentersController.groovy"
get "/admin/import/presenters", forward: "/admin/ImportPresentersController.groovy"

get "/admin/presenter", forward: "/admin/CreatePresenterController.groovy"
post "/admin/presenter", forward: "/admin/CreatePresenterController.groovy"

get "/admin/presenter/@id", forward: "/admin/UpdatePresenterController.groovy?id=@id"
post "/admin/presenter/@id", forward: "/admin/UpdatePresenterController.groovy?id=@id"

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png", cache: (365 * 24).hours

all "/_ah/**", ignore: true
get "*", forward: "/NotFoundController.groovy"