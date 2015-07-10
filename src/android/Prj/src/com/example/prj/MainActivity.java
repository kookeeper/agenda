package com.example.prj;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.ClientProtocolException;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {

			case R.id.action_settings:
				return true;
			case R.id.action_search:
				openSearch();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}

	}

	private void openSearch() {

		// TODO Auto-generated method stub
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public void sendMessage(View view) throws ClientProtocolException,
			IOException {

		EditText edit = (EditText) findViewById(R.id.edit_message);

		String message = edit.getText().toString();

		String[] req = new String[1];
		req[0] = message;

		String mensagemRetorno = "Nao deu certo";
		try {
			mensagemRetorno = new Connector().execute(req).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		Intent intent = new Intent(this, DisplayMessageActivity.class);

		intent.putExtra(EXTRA_MESSAGE, mensagemRetorno);

		startActivity(intent);
	}

}
