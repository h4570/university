// Sandro Sobczyński (s20600)
package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class BMIChart : AppCompatActivity() {
    private var bmiChart: LineChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_chart)
        bmiChart = findViewById(R.id.bmi_chart)
        setupBmiChart()
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this@BMIChart, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun setupBmiChart() {
        val entries: ArrayList<Entry> = ArrayList()
        val dates: Array<String?> = arrayOf(
            "2023-01-01", "2023-01-08", "2023-01-15", "2023-01-22",
            "2023-01-29", "2023-02-05", "2023-02-12", "2023-02-19",
            "2023-02-26", "2023-03-05"
        )
        val bmiValues = floatArrayOf(
            24.5f, 24.2f, 24.0f, 23.8f, 23.6f, 23.4f, 23.2f, 23.0f, 22.8f, 22.6f
        )
        for (i in dates.indices) {
            entries.add(Entry(i.toFloat(), bmiValues[i]))
        }
        val lineDataSet = LineDataSet(entries, "BMI")
        val lineData = LineData(lineDataSet)
        bmiChart!!.data = lineData
        val xAxis = bmiChart!!.xAxis
        xAxis.textSize = 10f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.valueFormatter = BmiXAxisFormatter(dates)
        xAxis.labelCount = dates.size
        xAxis.granularity = 1f
        bmiChart!!.axisRight.isEnabled = false
        bmiChart!!.description.isEnabled = false
        bmiChart!!.invalidate()
    }
}