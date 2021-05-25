package my.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
    val app = context.getBean(App::class.java)
    app.run()
}

@Component
class App(
    private val appSetting: AppSetting,
    private val cat: Cat,
) {


    fun run() {
        cat.sayMay()
        println("App name: ${appSetting.appName}")
    }
}

@Component
class Cat(
    private val name: CatName
) {
    fun sayMay() {
        println("${name}: May-May!")
    }
}

@Component
class AppSetting {
    @Value("\${info.appName}")
    lateinit var appName: String
}
