package my.test

import org.springframework.beans.factory.FactoryBean
import org.springframework.stereotype.Component

class CatName(private val name: String) {
    override fun toString(): String {
        return name;
    }
}

@Component
class CustomFactoryBean: FactoryBean<CatName> {

    private val names = listOf("Kitty", "Leo", "Jack", "Daisy", "Camellia", "Dahlia")

    override fun getObject(): CatName {
        return CatName(names.random())
    }

    override fun getObjectType(): Class<*> {
        return CatName::class.java
    }

}