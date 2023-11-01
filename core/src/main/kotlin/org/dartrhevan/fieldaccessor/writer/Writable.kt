package org.dartrhevan.fieldaccessor.writer

import java.io.Writer

interface Writable {
    fun write(os: Writer)
}