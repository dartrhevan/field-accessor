package org.dartrhevan.fieldaccessor.writer

import java.io.Writer

data class ClassWriter(val fields: Set<FieldWriter>, val methods: MethodWriter) : Writable {
    override fun write(os: Writer) {
        TODO("Not yet implemented")
    }
}
