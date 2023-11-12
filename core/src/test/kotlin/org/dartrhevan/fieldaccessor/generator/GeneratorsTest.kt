package org.dartrhevan.fieldaccessor.generator

import org.dartrhevan.fieldaccessor.model.ClassInfo
import org.dartrhevan.fieldaccessor.model.FieldInfo
import org.dartrhevan.fieldaccessor.testimpl.TestClassReflectFieldAccessor
import org.dartrhevan.fieldaccessor.testimpl.TestClassStaticFieldAccessor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintWriter

import java.io.StringWriter
import java.util.Properties

class GeneratorsTest {
    @Test
    fun generateFieldAccessorTest() {
        val w = StringWriter()
        generateFieldAccessor(
            "TestClassFieldAccessor",
            ClassInfo(
                "temp", "TestClass", setOf(
                    FieldInfo("f1", "int"),
                    FieldInfo("f2", "String")
                )
            ), w
        )
        println(w.toString())
    }

    @Test
    fun generateFieldAccessorPropertiesTest() {
        ByteArrayOutputStream().use { os ->
            PrintWriter(os).use { w ->
                generateFieldAccessorProperties(mapOf("TestClass" to "TestClassStaticFieldAccessor"), w)
            }
            val content = os.toByteArray()
            println(String(content))
            val props = Properties()
            ByteArrayInputStream(content)
                .use { props.load(it) }
            assertEquals("TestClassStaticFieldAccessor", props["TestClass"])
        }
    }
}