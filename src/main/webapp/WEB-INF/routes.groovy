get "/", forward: "/index.groovy"

get "/presenters", forward: "/PresentersController.groovy"
get "/presenters/*", forward: "/PresentersController.groovy"

get "/presenter/@id", forward: "/ViewPresenterController.groovy?id=@id"

get "/talks", forward: "/TalksController.groovy"
get "/talks/*", forward: "/TalksController.groovy"

get "/talk/@id", forward: "/ViewTalkController.groovy?id=@id"

get "/admin", forward: "/admin/index.groovy"

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

get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"

all "/_ah/**", ignore: true
get "*", forward: "/NotFoundController.groovy"