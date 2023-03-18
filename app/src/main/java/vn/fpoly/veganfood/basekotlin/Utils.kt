package vn.fpoly.veganfood.basekotlin

import android.annotation.SuppressLint
import android.text.Editable
import kotlinx.coroutines.*
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class Utils {
    companion object {

        @SuppressLint("SimpleDateFormat")
        fun formatDay(startAt: String): String {
            var result = ""
            try {
                val df1: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                val timezone = TimeZone.getTimeZone("GMT")
                df1.timeZone = timezone
                val date: Date = df1.parse(startAt)
                val writeDate = SimpleDateFormat("dd/MM/yyyy")
                writeDate.timeZone = TimeZone.getTimeZone("GMT+07:00")
                result = writeDate.format(date)
            } catch (ex: ParseException) {
                return startAt
            }
            return result
        }
    }
}