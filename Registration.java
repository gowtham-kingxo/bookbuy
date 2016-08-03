package eocom.example.storephp;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import eocom.example.storephp.MainActivity.CreateUsers;

public class Registration extends Activity {
	EditText username,name,pass,cpass,gender,address,email,phone;
	Button Submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		username=(EditText) findViewById(R.id.uneditText1);
		name=(EditText) findViewById(R.id.neditText2);
		pass=(EditText) findViewById(R.id.peditText3);
		//cpass=(EditText) findViewById(R.id.cpeditText4);
		gender=(EditText) findViewById(R.id.geneditText5);
		address=(EditText) findViewById(R.id.addeditText6);
		email=(EditText) findViewById(R.id.emeditText7);
		phone=(EditText) findViewById(R.id.pheditText8);
		Submit=(Button) findViewById(R.id.sbutton1);
		
	}
	public void sdata(View g)
	{
		//Send the data to php
		new CreateUsers().execute();
	}
	
	public class CreateUsers extends AsyncTask<String, String, JSONObject>
	{
		JSONObject returnobj;
		MyJSON jobj;
		String url="http://10.0.2.2/BooksProject/secondpage.php";
		ProgressDialog dialog;
		List<NameValuePair> myvalues;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog=new ProgressDialog(Registration.this);
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
			myvalues.add(new BasicNameValuePair("musername", username.getText().toString()));
			myvalues.add(new BasicNameValuePair("mname", name.getText().toString()));
			myvalues.add(new BasicNameValuePair("mpass", pass.getText().toString()));
			myvalues.add(new BasicNameValuePair("mgender", gender.getText().toString()));
			myvalues.add(new BasicNameValuePair("maddress", address.getText().toString()));
			myvalues.add(new BasicNameValuePair("memail", email.getText().toString()));
			myvalues.add(new BasicNameValuePair("mphone", phone.getText().toString()));
			
			
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
