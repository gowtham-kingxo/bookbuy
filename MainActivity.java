package eocom.example.storephp;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText etuser,etpass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etuser=(EditText)findViewById(R.id.usernameeditText1);
		etpass=(EditText)findViewById(R.id.passeditText2);
	}

	public void senddata(View g)
	{
		//Send the data to php
		new CreateUsers().execute();
	}
	
	public class CreateUsers extends AsyncTask<String, String, JSONObject>
	{
		JSONObject returnobj;
		MyJSON jobj;
		String url="http://10.0.2.2/BooksProject/firstpage.php";
		ProgressDialog dialog;
		List<NameValuePair> myvalues;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog=new ProgressDialog(MainActivity.this);
			dialog.setMessage("Creating...");
			dialog.show();
		}
		@Override
		protected JSONObject doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			try
			{
				jobj=new MyJSON();
			
				myvalues=new ArrayList<NameValuePair>() ;
			myvalues.add(new BasicNameValuePair("muser", etuser.getText().toString()));
			myvalues.add(new BasicNameValuePair("mpass", etpass.getText().toString()));
			
			
			returnobj=jobj.makeHttpRequest(url, "POST", myvalues);
			return returnobj;
			
			}
			catch(Exception e)
			{
				Log.d("EO Error", "Error Occured"+e.getMessage());
			}
			return returnobj;
			
			
			
		}
		
		
		protected void onPostExecute(JSONObject returno) 
		{
			super.onPostExecute(returno);
			dialog.dismiss();
			
			
			
		}
	}
		
		
	}
	

