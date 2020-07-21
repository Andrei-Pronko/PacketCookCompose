package com.mentarey.packet.cook.ui.ext

import java.math.BigDecimal

fun Double.round(decimals: Int = 2): Double {
    val value = BigDecimal(this)
    return value.setScale(decimals, BigDecimal.ROUND_HALF_UP).toDouble()
}