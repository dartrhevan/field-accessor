package org.dartrhevan.fieldaccessor

import org.dartrhevan.fieldaccessor.api.FieldAccessor
import org.dartrhevan.fieldaccessor.testimpl.TestClassMapFieldAccessor
import org.dartrhevan.fieldaccessor.testimpl.TestClassReflectFieldAccessor
import org.dartrhevan.fieldaccessor.testimpl.TestClassStaticFieldAccessor
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FieldAccessorBenchmark {
    private val testObj = TestClass().apply {
        f1 = 5
        f8 = "QWERTY"
    }

    @ParameterizedTest
    @MethodSource("getImplementations")
    fun testGetters(accessor: FieldAccessor<TestClass>) {
        //warm up
        executeTimed(500) {
            assertNotNull(accessor.get<Int>(testObj, "f1"))
            assertNotNull(accessor.get<Int>(testObj, "f8"))
        }
        val time = executeTimed(1500) {
            assertNotNull(accessor.get<Int>(testObj, "f1"))
            assertNotNull(accessor.get<Int>(testObj, "f8"))
        }
        println(time)
    }

    @ParameterizedTest
    @MethodSource("getImplementations")
    fun testSetters(accessor: FieldAccessor<TestClass>) {
        //warm up
        executeTimed(500) {
            accessor.set(testObj, "f1", 1)
            accessor.set(testObj, "f2", "1")
        }
        val time = executeTimed(1500) {
            accessor.set(testObj, "f1", 1)
            accessor.set(testObj, "f2", "1")
        }
        println(time)
    }

    companion object {
        @JvmStatic
        val implementations: List<Arguments> = listOf(
            Arguments.of(TestClassReflectFieldAccessor()), // test result is 505.2 for get and 598.93 for set
            Arguments.of(TestClassStaticFieldAccessor()), // test result is 168.8 for get and 193.8 for set
            Arguments.of(TestClassMapFieldAccessor()) // test result is 209.0 for get and 307.4 for set
        )
    }
}