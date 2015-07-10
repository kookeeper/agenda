package com.example.prj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class Connector extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {

		String retorno = "";
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpUriRequest req = new HttpGet(
					"http://serpa.no-ip.org:8080/RestProject/helloworld/" + params[0]);
			HttpResponse res = client.execute(req);
			InputStream in = res.getEntity().getContent();
			
			Scanner scanner = new Scanner(in);
			scanner.useDelimiter("\\A");
			if (scanner.hasNext()) {
				retorno = scanner.next();
			}
			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}

}
