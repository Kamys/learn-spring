package my.test.annotation;

import java.lang.reflect.Field

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class MyAnnotation (val data: String)

class MyAnnotationProcessor {
    fun injectValues(target: Any) {
        val fields = target::class.java.declaredFields

        fields.forEach { field ->
            field.findAnnotation<MyAnnotation>()?.let {
                field.isAccessible = true
                field.set(target, it.data)
            }
        }
    }
}

inline fun <reified T : Annotation> Field.findAnnotation(): T? =
    @Suppress("UNCHECKED_CAST")
    annotations.firstOrNull { it is T } as T?

fun main() {
    val target = Movie()
    MyAnnotationProcessor().injectValues(target)
    println(target)
}

