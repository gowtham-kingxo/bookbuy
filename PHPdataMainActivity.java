package eocom.example.storephp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class PHPdataMainActivity extends Activity {

	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phpdata_main);
		
		lv=(ListView)findViewById(R.id.listView1);
		
		
		
	}
	
	class GetUserDetails extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			
			return null;
		}
	}
}
