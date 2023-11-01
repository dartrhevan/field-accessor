package org.dartrhevan.fieldaccessor

import java.math.BigDecimal
import java.math.RoundingMode

fun executeTimed(iterationsCount: Int, func: () -> Unit): Double {
    val startTime = System.nanoTime()
    for (i in 0..iterationsCount)
        func()
    return BigDecimal((System.nanoTime() - startTime).toDouble() / iterationsCount)
        .setScale(2, RoundingMode.HALF_EVEN).toDouble()
}