package org.dartrhevan.fieldaccessor

import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("org.dartrhevan.fieldaccessor.api.FieldAccess")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor::class)
class FieldAccessProcessor : AbstractProcessor() {
    override fun process(annotations: Set<TypeElement>,
                         roundEnvironment: RoundEnvironment): Boolean {
        for (annotation in annotations) {
            val annotatedElements = roundEnvironment.getElementsAnnotatedWith(annotation)
            for (element in annotatedElements) {
                val type = element.asType()

            }
            // …
        }
        return true
    }
}