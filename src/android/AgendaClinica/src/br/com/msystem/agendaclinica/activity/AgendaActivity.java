package br.com.msystem.agendaclinica.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import br.com.msystem.agendaclinica.CompromissoTask;
import br.com.msystem.agendaclinica.R;
import br.com.msystem.agendaclinica.bean.Compromisso;
import br.com.msystem.agendaclinica.fragment.EscolherDataFragment;
import br.com.msystem.agendaclinica.fragment.EscolherDataFragment.EscolherDataListener;
import br.com.msystem.agendaclinica.fragment.ListaCompromissoFragment;
import br.com.msystem.agendaclinica.fragment.ListaCompromissoFragment.ListaCompromissoListener;
import br.com.msystem.agendaclinica.fragment.VisualizarCompromissoFragment;
import br.com.msystem.agendaclinica.fragment.VisualizarCompromissoFragment.VisualizarCompromissoListener;

public class AgendaActivity extends ActionBarActivity implements
		EscolherDataListener, ListaCompromissoListener,
		VisualizarCompromissoListener {

	private ArrayList<Compromisso> listaCompromisso;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);

		View container = findViewById(R.id.container_frame);

		if (container == null) {
			container = findViewById(R.id.escolher_data_frame);
		}

		if (container != null) {

			EscolherDataFragment fragment = new EscolherDataFragment();
			fragment.setArguments(getIntent().getExtras());

			getSupportFragmentManager().beginTransaction()
					.replace(container.getId(), fragment).commit();

		}

		container = findViewById(R.id.lista_compromisso_frame);

		if (container != null) {

			ListaCompromissoFragment fragment = new ListaCompromissoFragment();
			fragment.setArguments(getIntent().getExtras());

			getSupportFragmentManager().beginTransaction()
					.replace(container.getId(), fragment).commit();

		}

		container = findViewById(R.id.visualizar_compromisso_frame);

		if (container != null) {

			VisualizarCompromissoFragment fragment = new VisualizarCompromissoFragment();
			fragment.setArguments(getIntent().getExtras());

			getSupportFragmentManager().beginTransaction()
					.replace(container.getId(), fragment).commit();

		}

		if (savedInstanceState == null) {

			listaCompromisso = new ArrayList<Compromisso>();

		} else {
			listaCompromisso = savedInstanceState
					.getParcelableArrayList("listaCompromisso");
		}
	}

	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList("listaCompromisso", listaCompromisso);
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
	public void escolherData(Date data) {

		listaCompromisso = new ArrayList<Compromisso>();

		AsyncTask<Date, Void, ArrayList<Compromisso>> task = new CompromissoTask()
				.execute(data);
		try {
			listaCompromisso.addAll(task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		Fragment fragment = null;
		if (findViewById(R.id.lista_compromisso_fragment) == null) {
			fragment = new ListaCompromissoFragment();

			Bundle bundle = new Bundle();
			bundle.putParcelableArrayList("listaCompromisso", listaCompromisso);
			fragment.setArguments(bundle);
			getSupportFragmentManager()
					.beginTransaction()
					.replace(findViewById(R.id.container_frame).getId(),
							fragment).commit();

		} else {

			for (Fragment f : getSupportFragmentManager().getFragments()) {
				if (f.getClass() == ListaCompromissoFragment.class) {
					fragment = f;
					break;
				}
			}

			((ListaCompromissoFragment) fragment).montarLista(listaCompromisso);
		}

	}

	@Override
	public void escolherCompromisso(Compromisso compromisso) {

		Fragment fragment = null;
		if (findViewById(R.id.visualizar_compromisso_fragment) == null) {
			fragment = new VisualizarCompromissoFragment();

			Bundle bundle = new Bundle();
			bundle.putParcelable("compromisso", compromisso);
			fragment.setArguments(bundle);
			getSupportFragmentManager()
					.beginTransaction()
					.replace(findViewById(R.id.container_frame).getId(),
							fragment).commit();
		} else {

			for (Fragment f : getSupportFragmentManager().getFragments()) {
				if (f.getClass() == VisualizarCompromissoFragment.class) {
					fragment = f;
					break;
				}
			}

			((VisualizarCompromissoFragment) fragment)
					.mostrarCompromisso(compromisso);
		}

	}

	public void onVoltarVisualizarCompromisso() {

		if (findViewById(R.id.container_frame) != null) {

			ListaCompromissoFragment fragment = new ListaCompromissoFragment();

			Bundle bundle = new Bundle();
			bundle.putParcelableArrayList("listaCompromisso", listaCompromisso);
			fragment.setArguments(bundle);

			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			transaction.replace(R.id.container_frame, fragment);
			transaction.addToBackStack(null);

			transaction.commit();
		}

	}

	@Override
	public void onVoltarListaCompromisso() {

		if (findViewById(R.id.container_frame) != null) {

			EscolherDataFragment fragment = new EscolherDataFragment();

			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container_frame, fragment)
					.addToBackStack(null).commit();
		}

	}
}
