package br.com.msystem.agendacllnica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity {

	private EditText username;
//	private EditText password;
	private TextView attempts;
//	private Button login;
	private int counter = 3;

	protected void onDestroy() {
		super.onDestroy();
		System.out.println("Destruindo Login");
	}

	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("login", ((EditText) findViewById(R.id.loginEdit)).getText().toString());
		
		super.onSaveInstanceState(savedInstanceState);
	}

	public void onRestoreInstanceState(Bundle savedInstanteState) {
		super.onRestoreInstanceState(savedInstanteState);
		((EditText) findViewById(R.id.loginEdit)).setText(savedInstanteState.getString("login"));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			System.out.println("Versao Jelly Bean");
		}
		setContentView(R.layout.activity_login);
		username = (EditText) findViewById(R.id.loginEdit);
//		password = (EditText) findViewById(R.id.senhaEdit);
		attempts = (TextView) findViewById(R.id.textView5);
		attempts.setText(Integer.toString(counter));
//		login = (Button) findViewById(R.id.loginButton);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void login(View view) {
/*
		if (username.getText().toString().equals("admin")
				&& password.getText().toString().equals("admin")) {
			Toast.makeText(getApplicationContext(), "Redirecting...",
					Toast.LENGTH_SHORT).show();
	*/		
			Intent intent = new Intent(this, AgendaActivity.class);

			SharedPreferences prefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
			
			Editor editor = prefs.edit();
			editor.putString("login", username.getText().toString());
			editor.commit();
			
			startActivity(intent);
		/*	
		} else {
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
			attempts.setBackgroundColor(Color.RED);
			counter--;
			attempts.setText(Integer.toString(counter));
			if (counter == 0) {
				login.setEnabled(false);
			}

		}
		*/
	}

}
