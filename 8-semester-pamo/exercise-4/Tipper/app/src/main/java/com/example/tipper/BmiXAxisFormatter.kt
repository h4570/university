package com.example.tipper

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class BmiXAxisFormatter(dateStrings: Array<String?>) : ValueFormatter() {
    private val inputDateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val sdf = SimpleDateFormat("dd.MM")
    private val dates: MutableList<Date>

    init {
        dates = ArrayList()
        for (dateString in dateStrings) {
            try {
                val date = inputDateFormat.parse(dateString)
                dates.add(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
    }

    override fun getAxisLabel(value: Float, axis: AxisBase): String {
        val index = Math.round(value)
        return if (index < 0 || index >= dates.size) {
            ""
        } else sdf.format(dates[index])
    }
}