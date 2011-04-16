import com.googlecode.objectify.*
import groovyx.gaelyk.obgaektify.*

def classRegistry = ObgaektifyRegistryHandler.loadClassRegistry()


System.out.println("Registering ObgaektifyPlugin...")

// add new variables in the binding
binding {
	obgaektify = new ObgaektifyDAO()
	dao = obgaektify
}

//add new routes with the usual routing system format
routes {
}

//install new categories
categories ObgaektifyCategory

//Register the Domain classes the programmer adds to /WEB-INF/obgaektify.groovy
classRegistry.each{c->
	System.out.println("...registering Obgaektifiable domain $c")
	ObjectifyService.register(c)
}