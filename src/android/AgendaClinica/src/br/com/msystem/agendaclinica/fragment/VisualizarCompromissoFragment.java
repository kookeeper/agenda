package br.com.msystem.agendaclinica.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import br.com.msystem.agendaclinica.R;
import br.com.msystem.agendaclinica.bean.Compromisso;

public class VisualizarCompromissoFragment extends Fragment {

	public interface VisualizarCompromissoListener {

		public void onVoltarVisualizarCompromisso();

	}

	public void onAttach(Activity activity) {

		super.onAttach(activity);

		if (!(activity instanceof VisualizarCompromissoListener)) {
			throw new ClassCastException(
					"A Activity "
							+ activity
							+ " não implementa a interface VisualizarCompromissoListener.");
		}
	}

	public void onResume() {

		super.onResume();

		if (getArguments() != null) {
			Compromisso bean = getArguments().getParcelable("compromisso");
			mostrarCompromisso(bean);
		}

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_visualizar_compromisso,
				container, false);

		Button botao = (Button) view
				.findViewById(R.id.botao_voltar_visualizar_compromisso);

		if (botao != null) {
			botao.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					((VisualizarCompromissoListener) getActivity())
							.onVoltarVisualizarCompromisso();

				}
			});
		}
		return view;
	}

	public void mostrarCompromisso(Compromisso bean) {

		TextView text = (TextView) getActivity().findViewById(
				R.id.data_compromisso_text_view);

		text.setText(bean.getDataCompromisso().toString());

		TextView id = (TextView) getActivity().findViewById(
				R.id.id_compromisso_text_view);
		id.setText(bean.getId().toString());

	}
}
