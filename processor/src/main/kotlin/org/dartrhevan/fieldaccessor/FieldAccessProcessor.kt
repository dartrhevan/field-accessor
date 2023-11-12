package org.dartrhevan.fieldaccessor

import com.google.auto.service.AutoService
import mu.KotlinLogging
import org.dartrhevan.fieldaccessor.generator.generateFieldAccessor
import org.dartrhevan.fieldaccessor.generator.generateFieldAccessorProperties
import org.dartrhevan.fieldaccessor.model.ClassInfo
import org.dartrhevan.fieldaccessor.model.FieldInfo
import org.dartrhevan.fieldaccessor.util.PROPERTIES_FILE
import org.dartrhevan.fieldaccessor.util.getFieldAccessorName
import java.io.Writer
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.StandardLocation

@SupportedAnnotationTypes("org.dartrhevan.fieldaccessor.api.FieldAccess")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor::class)
class FieldAccessProcessor : AbstractProcessor() {
    private val log = KotlinLogging.logger { }

    override fun process(
        annotations: Set<TypeElement>,
        roundEnvironment: RoundEnvironment
    ): Boolean {
        println("FieldAccessProcessor")
        val generatedAccessor = mutableMapOf<String, String>()
        for (annotation in annotations) {
            val annotatedElements = roundEnvironment.getElementsAnnotatedWith(annotation)
            for (element in annotatedElements) {
                val fullName = element.asType().toString()
                val simpleName = element.simpleName.toString()
                val packageName = fullName.replace(".$simpleName", "")
                log.info("Processing class {}", fullName)
                val fields = element.enclosedElements.filter { it.kind.isField }
                    .map { FieldInfo(it.simpleName.toString(), it.asType().toString()) }
                log.info("Processing fields {}", fields)
                val processingClassInfo = ClassInfo(packageName, simpleName, fields)
                val accessorName = getFieldAccessorName(simpleName)
                val accessorFullName = "$packageName.$accessorName"
                createSourceWriter(accessorFullName).use { fieldAccessorWriter ->
                    generateFieldAccessor(accessorName, processingClassInfo, fieldAccessorWriter)
                }
                generatedAccessor[fullName] = accessorFullName
            }
            createResourceWriter(PROPERTIES_FILE).use { fieldAccessorPropertiesWriter ->
                generateFieldAccessorProperties(generatedAccessor, fieldAccessorPropertiesWriter)
            }
        }
        return true
    }

    private fun createSourceWriter(name: String): Writer =
        processingEnv.filer.createSourceFile(name).openWriter()

    private fun createResourceWriter(name: String): Writer =
        processingEnv.filer.createResource(StandardLocation.CLASS_OUTPUT, "", name).openWriter()

}