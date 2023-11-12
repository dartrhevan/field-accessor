package org.dartrhevan.fieldaccessor.api

import org.dartrhevan.fieldaccessor.util.PROPERTIES_FILE
import java.util.*
import java.util.concurrent.ConcurrentHashMap

object FieldAccessorFactory {
    private val accessorsClasses = Properties()
    private val accessorsInstances = ConcurrentHashMap<String, FieldAccessor<*>>()

    init {
        accessorsClasses.load(
            FieldAccessorFactory.javaClass.getResourceAsStream("/$PROPERTIES_FILE"))
    }

    fun <T> getFieldAccessorFor(type: Class<T>): FieldAccessor<T> {
        val typeName = type.name
        val accessorsClassName = accessorsClasses[typeName]!!.toString()
        accessorsInstances.computeIfAbsent(typeName) {
            val accessorsClass = Class.forName(accessorsClassName)
            accessorsClass.getDeclaredConstructor().newInstance() as FieldAccessor<*>
        }
        @Suppress("UNCHECKED_CAST")
        return accessorsInstances[typeName] as FieldAccessor<T>
    }
}