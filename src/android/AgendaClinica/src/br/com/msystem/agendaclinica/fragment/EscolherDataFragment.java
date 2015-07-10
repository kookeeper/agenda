package br.com.msystem.agendaclinica.fragment;

import java.util.Calendar;
import java.util.Date;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import br.com.msystem.agendaclinica.R;

public class EscolherDataFragment extends Fragment {

	public interface EscolherDataListener {

		public void escolherData(Date data);

	}

	private SharedPreferences pref;
	private OnDateChangeListener calendarViewChangeListener;

	public void onAttach(Activity activity) {

		super.onAttach(activity);

		if (!(activity instanceof EscolherDataListener)) {
			throw new ClassCastException("A Activity " + activity
					+ " não implementa a interface EscolherDataListener.");
		}

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_escolher_data, container,
				false);

	}

	private Date buscarData() {

		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			return buscarDataDatePicker();
		} else {
			return buscarDataCalendarView();
		}

	}

	private Date buscarDataDatePicker() {

		DatePicker picker = (DatePicker) getActivity().findViewById(
				R.id.escolher_data_picker);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, picker.getDayOfMonth());
		cal.set(Calendar.MONTH, picker.getMonth());
		cal.set(Calendar.YEAR, picker.getYear());

		return cal.getTime();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private Date buscarDataCalendarView() {

		CalendarView calendarView = (CalendarView) getActivity().findViewById(
				R.id.escolher_calendar_view);

		return new Date(calendarView.getDate());

	}

	private void configurarBotaoPesquisar() {

		Button botaoPesquisar = (Button) getActivity().findViewById(
				R.id.botao_pesquisar_data);

		if (botaoPesquisar != null) {
			botaoPesquisar.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					Date data = buscarData();

					((EscolherDataListener) getActivity()).escolherData(data);

				}
			});
		}

		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
			configurarCalendarView();
		}

	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void configurarCalendarView() {

		final CalendarView calendarView = (CalendarView) getActivity()
				.findViewById(R.id.escolher_calendar_view);

		if (calendarView != null) {

			calendarViewChangeListener = new OnDateChangeListener() {

				@Override
				public void onSelectedDayChange(CalendarView view, int year,
						int month, int dayOfMonth) {

					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
					cal.set(Calendar.MONTH, month);
					cal.set(Calendar.YEAR, year);

					atualizaDataSelecionada(cal.getTimeInMillis());

					((EscolherDataListener) getActivity()).escolherData(cal
							.getTime());

				}
			};

			calendarView.setOnDateChangeListener(calendarViewChangeListener);
		}

	}

	private void configurarDatePicker() {

		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(pref.getLong("dataSelecionada", 0));

		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {

			DatePicker dataView = (DatePicker) getActivity().findViewById(
					R.id.escolher_data_picker);

			int year = cal.get(Calendar.YEAR);
			int monthOfYear = cal.get(Calendar.MONTH);
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			OnDateChangedListener onDateChangedListener = new OnDateChangedListener() {

				@Override
				public void onDateChanged(DatePicker view, int year,
						int monthOfYear, int dayOfMonth) {

					cal.set(Calendar.YEAR, year);
					cal.set(Calendar.MONTH, monthOfYear);
					cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

					atualizaDataSelecionada(cal.getTimeInMillis());

				}
			};
			((DatePicker) dataView).init(year, monthOfYear, dayOfMonth,
					onDateChangedListener);
		} else {
/*
			CalendarView dataView = (CalendarView) getActivity().findViewById(
					R.id.escolher_calendar_view);

			onResumeNewer(dataView, cal.getTimeInMillis());
*/
		}

	}

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		pref = getActivity().getPreferences(Context.MODE_PRIVATE);

	}

	public void onResume() {

		super.onResume();

		configurarBotaoPesquisar();
		configurarDatePicker();

	}
/*
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void onResumeNewer(View dataView, long data) {

		((CalendarView) dataView).setOnDateChangeListener(null);
		((CalendarView) dataView).setDate(data, true, true);
		((CalendarView) dataView).setOnDateChangeListener(calendarViewChangeListener);

	}
*/
	protected void atualizaDataSelecionada(Long data) {

		Editor editor = pref.edit();

		editor.putLong("dataSelecionada", data);

		editor.commit();

	}
}
