package br.com.msystem.agendaclinica.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.com.msystem.agendaclinica.R;
import br.com.msystem.agendaclinica.bean.Compromisso;

public class ListaCompromissoFragment extends Fragment {

	public interface ListaCompromissoListener {

		public void escolherCompromisso(Compromisso compromisso);

		public void onVoltarListaCompromisso();

	}

	private ArrayList<Compromisso> listaCompromisso;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			listaCompromisso = new ArrayList<Compromisso>();
		} else {
			listaCompromisso = savedInstanceState
					.getParcelableArrayList("listaCompromisso");
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_lista_compromisso,
				container, false);

		Button botao = (Button) view
				.findViewById(R.id.botao_voltar_lista_compromisso);

		if (botao != null) {
			botao.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					((ListaCompromissoListener) getActivity())
							.onVoltarListaCompromisso();

				}
			});
		}

		return view;

	}

	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList("listaCompromisso", listaCompromisso);
	}

	public void onResume() {

		super.onResume();

		if (getArguments() != null) {
			listaCompromisso = getArguments().getParcelableArrayList(
					"listaCompromisso");
		}

		montarLista();

	}

	public void montarLista() {

		if ((listaCompromisso != null) && (listaCompromisso.size() > 0)) {
			ListView listaView = (ListView) getActivity().findViewById(
					R.id.list_lista_compromisso);

			ListAdapter adapter = new MyArrayAdapter(getActivity(),
					android.R.layout.simple_list_item_1, listaCompromisso);
			listaView.setAdapter(adapter);
		}

	}

	public void montarLista(ArrayList<Compromisso> lista) {

		this.listaCompromisso = lista;
		montarLista();

	}

	private class MyArrayAdapter extends ArrayAdapter<Compromisso> {

		public MyArrayAdapter(Context context, int resource,
				List<Compromisso> objects) {

			super(context, resource, objects);

		}

		public View getView(int position, View convertView, ViewGroup parent) {

			View view = null;
			if (convertView == null) {

				view = new TextView((Activity) getContext());
				view.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						Compromisso compromisso = (Compromisso) v.getTag();

						((ListaCompromissoListener) getActivity())
								.escolherCompromisso(compromisso);

					}
				});
				view.setTag(listaCompromisso.get(position));

			} else {
				view = convertView;
				view.setTag(listaCompromisso.get(position));
			}

			((TextView) view).setText(listaCompromisso.get(position)
					.getDataCompromisso().toString());

			return view;
		}
	}

}
