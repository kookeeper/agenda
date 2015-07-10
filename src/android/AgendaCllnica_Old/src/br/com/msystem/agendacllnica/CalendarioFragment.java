package br.com.msystem.agendacllnica;

import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
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

public class CalendarioFragment extends Fragment {

	CalendarioListener mCallback;

	public interface CalendarioListener {
		public void onDataSelected(Date data);
	}

	public void onAttach(Activity activity) {

		super.onAttach(activity);

		try {
			mCallback = (CalendarioListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement CalendarioListener");
		}
	}

	public void onPause() {
		super.onPause();
		
		SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
		
		Editor editor = pref.edit();
		editor.putLong("dataSelecionada", buscarDataSelecionada().getTime());
		editor.commit();
	}

	public void onResume() {

		super.onResume();

		SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
		
		int year;
		int month;
		int dayOfMonth;

		Calendar cal = Calendar.getInstance();

		if (pref.contains("dataSelecionada")) {
			Date data = new Date(pref.getLong("dataSelecionada", 0));

			cal.setTime(data);

		}

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			onResumeGinger(year, month, dayOfMonth);
		} else {
			onResumeNewer(cal.getTimeInMillis());
		}

	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void onResumeNewer(long date) {

		CalendarView calendarView = (CalendarView) getActivity().findViewById(
				R.id.calendarView1);

		if (calendarView != null) {
			calendarView.setDate(date);
			calendarView.setOnDateChangeListener(new OnDateChangeListener() {

				@Override
				public void onSelectedDayChange(CalendarView view, int year,
						int month, int dayOfMonth) {

					dataSelecionada(year, month, dayOfMonth);

				}
			});
		}
	}

	private void onResumeGinger(int year, int month, int dayOfMonth) {

		DatePicker datepicker = (DatePicker) getActivity().findViewById(
				R.id.datePicker);

		datepicker.init(year, month, dayOfMonth, null);

		Button b = (Button) getActivity().findViewById(R.id.botao_consultar);

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				escolherData(v);

			}
		});

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_calendario, container, false);

	}

	public void escolherData(View view) {

		DatePicker datepicker = (DatePicker) getActivity().findViewById(
				R.id.datePicker);

		if (datepicker != null) {

			int year = datepicker.getYear();
			int month = datepicker.getMonth();
			int dayOfMonth = datepicker.getDayOfMonth();

			dataSelecionada(year, month, dayOfMonth);

		}

	}

	public void dataSelecionada(int year, int month, int dayOfMonth) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

		Date data = cal.getTime();

		mCallback.onDataSelected(data);

	}

	@SuppressLint("NewApi")
	public Date buscarDataSelecionada() {

		DatePicker datepicker = (DatePicker) getActivity().findViewById(
				R.id.datePicker);

		if (datepicker != null) {

			int year = datepicker.getYear();
			int month = datepicker.getMonth();
			int dayOfMonth = datepicker.getDayOfMonth();

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			
			return cal.getTime();

		} else {
			
			CalendarView calendar = (CalendarView) getActivity().findViewById(R.id.calendarView1);

			return new Date(calendar.getDate());
		}

	}
}
