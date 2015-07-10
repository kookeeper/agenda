package br.com.msystem.agendaclinica;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;
import br.com.msystem.agendaclinica.bean.Compromisso;

public class CompromissoXmlParser {
	// We don't use namespaces
	private static final String ns = null;

	public List<Compromisso> parse(InputStream in) throws XmlPullParserException,
			IOException, ParseException {

		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(in, null);
			parser.nextTag();
			return readFeed(parser);
		} finally {
			in.close();
		}
	}

	private List<Compromisso> readFeed(XmlPullParser parser) throws XmlPullParserException,
			IOException, ParseException {

		List<Compromisso> entries = new ArrayList<Compromisso>();

		parser.require(XmlPullParser.START_TAG, ns, "compromissoes");
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			// Starts by looking for the entry tag
			if (name.equals("compromisso")) {
				entries.add(readEntry(parser));
			} else {
				skip(parser);
			}
		}
		return entries;
	}

	private Compromisso readEntry(XmlPullParser parser)
			throws XmlPullParserException, IOException, ParseException {

		Date dataCompromisso = null;
		Integer id = null;
		DateFormat sdf = new SimpleDateFormat("yyyyMMyyhhMMss", Locale.US);
		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if (name.equals("dataCompromisso")) {
				dataCompromisso = sdf.parse(readDataCompromisso(parser));
			} else if (name.equals("id")) {
				id = Integer.parseInt(readId(parser));
			} else {
				skip(parser);
			}
		}
		Compromisso compromisso = new Compromisso();
		compromisso.setDataCompromisso(dataCompromisso);
		compromisso.setId(id);
		
		return compromisso;
	}

	private String readDataCompromisso(XmlPullParser parser) throws IOException,
			XmlPullParserException {

		parser.require(XmlPullParser.START_TAG, ns, "dataCompromisso");
		String text = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "dataCompromisso");
		return text;
	}

	private String readId(XmlPullParser parser) throws IOException,
			XmlPullParserException {

		parser.require(XmlPullParser.START_TAG, ns, "id");
		String text = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "id");
		return text;
	}

	// For the tags title and summary, extracts their text values.
	private String readText(XmlPullParser parser) throws IOException,
			XmlPullParserException {

		String result = "";
		if (parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}

	private void skip(XmlPullParser parser) throws XmlPullParserException,
			IOException {

		if (parser.getEventType() != XmlPullParser.START_TAG) {
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth != 0) {
			switch (parser.next()) {
				case XmlPullParser.END_TAG:
					depth--;
					break;
				case XmlPullParser.START_TAG:
					depth++;
					break;
			}
		}
	}
}