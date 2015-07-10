package br.com.msystem.agendaclinica;

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
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

public class EscolherDataFragment extends Fragment {

	public interface EscolherDataListener {

		public void escolherData(Date data);

	}

	private SharedPreferences pref;

	public void onAttach(Activity activity) {

		super.onAttach(activity);

		if (!(activity instanceof EscolherDataListener)) {
			throw new ClassCastException("A Activity " + activity
					+ " não implementa a interface EscolherDataListener.");
		}

	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		pref = getActivity().getPreferences(Context.MODE_PRIVATE);

		if (savedInstanceState != null) {
			return;
		}
		
	}
	
	public void onResume() {
		super.onResume();
		
		View dataView = getActivity().findViewById(R.id.escolher_data);
		
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(pref.getLong("dataSelecionada", 0));
		
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			int year = cal.get(Calendar.YEAR);
			int monthOfYear = cal.get(Calendar.MONTH);
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			OnDateChangedListener onDateChangedListener = new OnDateChangedListener() {
				
				@Override
				public void onDateChanged(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
				
					cal.set(Calendar.YEAR, year);
					cal.set(Calendar.MONTH, monthOfYear);
					cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

					atualizaDataSelecionada(cal.getTimeInMillis());
					
				}
			};
			((DatePicker)dataView).init(year, monthOfYear, dayOfMonth, onDateChangedListener);
		} else {
			onResumeNewer(dataView, cal.getTimeInMillis());
		}
		
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void onResumeNewer(View dataView, long data) {

		((CalendarView)dataView).setDate(data, true, true);

	}

	protected void atualizaDataSelecionada(Long data) {

		Editor editor = pref.edit();

		editor.putLong("dataSelecionada", data);
		
		editor.commit();
		
	}
}
