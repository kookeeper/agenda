package br.com.msystem.agendaclinica;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import br.com.msystem.agendaclinica.activity.LoginActivity;
import br.com.msystem.agendaclinica.bean.Compromisso;

public class CompromissoTask extends
		AsyncTask<Date, Void, ArrayList<Compromisso>> {

	@Override
	protected ArrayList<Compromisso> doInBackground(Date... params) {

		ArrayList<Compromisso> lista = new ArrayList<Compromisso>();
		try {

			String dataString = new SimpleDateFormat("yyyyMMddhhmmss", Locale.US)
					.format(params[0]);

			String url = LoginActivity.url + "RestProject/compromisso/"
					+ dataString;

			lista.addAll(loadXmlFromNetwork(url));
			
			return lista;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return lista;

	}

	// Uploads XML from stackoverflow.com, parses it, and combines it with
	// HTML markup. Returns HTML string.
	private List<Compromisso> loadXmlFromNetwork(String urlString)
			throws XmlPullParserException, IOException, ParseException {

		InputStream stream = null;
		// Instantiate the parser
		CompromissoXmlParser stackOverflowXmlParser = new CompromissoXmlParser();
		List<Compromisso> entries = null;

		try {
			stream = downloadUrl(urlString);
			entries = stackOverflowXmlParser.parse(stream);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}

		return entries;
	}

	// Given a string representation of a URL, sets up a connection and gets
	// an input stream.
	private InputStream downloadUrl(String urlString) throws IOException {

		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000 /* milliseconds */);
		conn.setConnectTimeout(15000 /* milliseconds */);
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		// Starts the query
		conn.connect();
		return conn.getInputStream();
	}

}