// Sandro Sobczyński (s20600)

package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class BMIChart extends AppCompatActivity {
    private LineChart bmiChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_chart);

        bmiChart = findViewById(R.id.bmi_chart);
        setupBmiChart();

        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIChart.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    private void setupBmiChart() {
        List<Entry> entries = new ArrayList<>();
        String[] dates = new String[] {
                "2023-01-01", "2023-01-08", "2023-01-15", "2023-01-22",
                "2023-01-29", "2023-02-05", "2023-02-12", "2023-02-19",
                "2023-02-26", "2023-03-05"
        };
        float[] bmiValues = new float[] {
                24.5f, 24.2f, 24.0f, 23.8f, 23.6f, 23.4f, 23.2f, 23.0f, 22.8f, 22.6f
        };

        for (int i = 0; i < dates.length; i++) {
            entries.add(new Entry(i, bmiValues[i]));
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "BMI");
        LineData lineData = new LineData(lineDataSet);
        bmiChart.setData(lineData);

        XAxis xAxis = bmiChart.getXAxis();
        xAxis.setTextSize(10f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new BmiXAxisFormatter(dates));
        xAxis.setLabelCount(dates.length);
        xAxis.setGranularity(1f);

        bmiChart.getAxisRight().setEnabled(false);
        bmiChart.getDescription().setEnabled(false);

        bmiChart.invalidate();
    }
}