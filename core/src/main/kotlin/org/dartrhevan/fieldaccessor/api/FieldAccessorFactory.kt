package org.dartrhevan.fieldaccessor.api

interface FieldAccessorFactory {
    fun<T> getFieldAccessorFor(type: Class<T>): FieldAccessor<T>
}