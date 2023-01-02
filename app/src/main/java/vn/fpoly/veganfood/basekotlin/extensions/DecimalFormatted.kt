package vn.fpoly.veganfood.basekotlin.extensions

import java.text.DecimalFormat

fun Int.decimalFormatted(): String = DecimalFormat("#,###").format(this)
