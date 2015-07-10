package br.com.msystem.agendacllnica;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ListacompromissoFragment extends Fragment {

	ListacompromissoListener mCallback;

	public interface ListacompromissoListener {
		public void onVoltarButton();
	}

	public void onAttach(Activity activity) {

		super.onAttach(activity);

		try {
			mCallback = (ListacompromissoListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement ListacompromissoListener");
		}
	}

	public void onResume() {

		super.onResume();

		Button botaoVoltar = (Button) getActivity().findViewById(
				R.id.voltarButton);

		if (botaoVoltar != null) {
			botaoVoltar.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					voltar(v);

				}
			});
		}

		if (getArguments() != null) {
			Long dataLong = getArguments().getLong("data");
			if (dataLong != null) {
				Date data = new Date(dataLong);
				atualizaData(data);
			}
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_listacompromisso, container,
				false);
	}

	public void atualizaData(Date data) {

		if (getActivity().findViewById(R.id.texto_fragmento) != null) {
			((TextView) getActivity().findViewById(R.id.texto_fragmento))
					.setText(data.toString());
		}
	}

	public void voltar(View view) {

		mCallback.onVoltarButton();

	}
}
