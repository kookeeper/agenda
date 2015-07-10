package br.com.msystem.agendacllnica;

import java.util.Date;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import br.com.msystem.agendacllnica.CalendarioFragment.CalendarioListener;
import br.com.msystem.agendacllnica.ListacompromissoFragment.ListacompromissoListener;

public class AgendaActivity extends ActionBarActivity implements
		CalendarioListener, ListacompromissoListener {

	private String login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);

		View container = findViewById(R.id.fragment_container);

		if (container != null) {

			CalendarioFragment fragment = new CalendarioFragment();

			fragment.setArguments(getIntent().getExtras());

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(container.getId(), fragment);

			transaction.commit();

		}

		container = findViewById(R.id.fragment_calendario_container);

		if (container != null) {

			CalendarioFragment fragment = new CalendarioFragment();

			fragment.setArguments(getIntent().getExtras());

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(container.getId(), fragment);

			transaction.commit();

		}

		container = findViewById(R.id.fragment_listacompromisso_container);

		if (container != null) {

			ListacompromissoFragment fragment = new ListacompromissoFragment();

			fragment.setArguments(getIntent().getExtras());

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(container.getId(), fragment);

			transaction.commit();

		}

		TextView loginView = (TextView) findViewById(R.id.login);

		if (loginView != null) {

			SharedPreferences prefs = getSharedPreferences(getString(R.string.app_name),
					Context.MODE_PRIVATE);

			login = prefs.getString("login", "");

			loginView.setText(login);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agenda, menu);
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

	@Override
	public void onDataSelected(Date data) {

		ListacompromissoFragment fragment;
		if (findViewById(R.id.fragment_container) != null) {

			fragment = new ListacompromissoFragment();

			Bundle bundle = new Bundle();
			bundle.putLong("data", data.getTime());
			fragment.setArguments(bundle );
			
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(R.id.fragment_container, fragment);
			transaction.addToBackStack(null);

			transaction.commit();
		} else {

			fragment = (ListacompromissoFragment) getSupportFragmentManager()
					.findFragmentById(R.id.fragment_listacompromisso_container);

			fragment.atualizaData(data);
			
		}
	}

	@Override
	public void onVoltarButton() {

		if (findViewById(R.id.fragment_container) != null) {

			CalendarioFragment fragment = new CalendarioFragment();

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(R.id.fragment_container, fragment);
			transaction.addToBackStack(null);

			transaction.commit();
		}

	}

}
