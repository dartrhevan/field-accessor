package org.dartrhevan.fieldaccessor.generator

import org.dartrhevan.fieldaccessor.model.ClassInfo
import org.dartrhevan.fieldaccessor.writer.Writable
import java.io.OutputStream

interface Generator {
    fun generate(classInfo: ClassInfo): Writable
}