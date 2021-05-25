package my.test

import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.stereotype.Component

@Component
class CustomBeanFactoryPostProcessor : BeanFactoryPostProcessor {
    @Throws(BeansException::class)
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        println("BeanDefinitionNames: ${beanFactory.beanDefinitionNames.joinToString(", ")}")
    }
}