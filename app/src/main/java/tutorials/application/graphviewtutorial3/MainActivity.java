package tutorials.application.graphviewtutorial3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series, series2,series3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double y,x,f,count;
        x = -5.0;
        count = 0.0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();
        series3 = new LineGraphSeries<DataPoint>();
        series3.setDrawDataPoints(true);
        series3.setDataPointsRadius(10);
        series3.setThickness(8);
        series3.setColor(Color.RED);
        series2.setColor(Color.BLACK);
        for(int i = 0; i<500; i++){
            x = x + 0.1;
            y = Math.sin(x);
            f = Math.cos(x);
            series.appendData(new DataPoint(x, y), true, 500);
            series2.appendData(new DataPoint(x,f), true, 500);
            if(y > 0.999 && count == 0.0 && x > 0){
                count = 1.0;
                series3.appendData(new DataPoint(x,y), true, 500);
                series3.appendData(new DataPoint(x+0.0001,y+0.0001), true, 500);
            }
        }
        graph.addSeries(series);
        graph.addSeries(series2);
        graph.addSeries(series3);

        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-5.0);
        graph.getViewport().setMaxX(5.0);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-2.0);
        graph.getViewport().setMaxY(2.0);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);
    }
}

