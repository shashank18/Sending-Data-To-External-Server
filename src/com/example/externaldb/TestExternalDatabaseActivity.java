package com.example.externaldb;

//import in.wptrafficanalyzer.achartenginedynamicchart.ChartTask;
//import in.wptrafficanalyzer.achartenginedynamicchart.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

//import com.example.activity.R;
//import com.example.activity.second;

//import com.example.bundle.third;

//import com.example.bundle.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TestExternalDatabaseActivity extends Activity {
	TextView resultview;
	StringBuffer buffer;
	private GraphicalView mChart;
   
	private XYSeries visitsSeries ;
	private XYMultipleSeriesDataset dataset;
	
	private XYSeriesRenderer visitsRenderer;
	private XYMultipleSeriesRenderer multiRenderer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
	StrictMode.enableDefaults();
		resultview=(TextView)findViewById(R.id.result);
		
		getData();
	// TextView tv=(TextView)findViewById(R.id.result);
		
	}
	public void getData()
	{
		String result="";
		InputStream isr=null;
		try{
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost("http://sysef.iisc.ernet.in/envirobat/android/graph.php");
			//HttpPost httppost=new HttpPost("http://shashankmirji.comuf.com/database1.php");
			HttpResponse response=httpclient.execute(httppost);
			HttpEntity entity=response.getEntity();
			isr=entity.getContent();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			resultview.setText("Shashank something is problem in database connection");
		}
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
			//StringBuilder sb=new StringBuilder();
			//String line=null;
			//while((line=reader.readLine())!=null)
			//{
			//	sb.append(line +"\n");
			//}
			resultview.setText(reader.readLine());
			isr.close();
		//	result=sb.toString();
		}
		catch (Exception e) 
		{
			
			// TODO: handle exception
			resultview.setText("Shashank something is problem in coversion to string");
			
		}
		
	}


}

				
			