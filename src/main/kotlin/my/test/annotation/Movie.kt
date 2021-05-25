package my.test.annotation

class Movie {
    @field:MyAnnotation("The Book Thief")
    private val name = ""


    @MyAnnotation("7")
    private val rating = ""

    override fun toString(): String {
        return "Movie(name='$name', rating='$rating')"
    }
}
