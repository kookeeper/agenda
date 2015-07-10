package br.com.msystem.agendaclinica;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import br.com.msystem.agendaclinica.activity.LoginActivity;

/**
 * Represents an asynchronous login/registration task used to authenticate the
 * user.
 */
public class UserLoginTask extends AsyncTask<String, Void, Boolean> {
	/**
	 * 
	 */
	private final LoginActivity loginTask;

	/**
	 * @param loginActivity
	 */
	public UserLoginTask(LoginActivity loginActivity) {

		loginTask = loginActivity;
	}

	@Override
	protected Boolean doInBackground(String... params) {

		Scanner scanner = null;
		try {

			DefaultHttpClient client = new DefaultHttpClient();
			HttpUriRequest req = new HttpGet(LoginActivity.url + "RestProject/"
					+ params[0] + "/" + params[1]);
			HttpResponse res = client.execute(req);
			InputStream in = res.getEntity().getContent();

			scanner = new Scanner(in);
			scanner.useDelimiter("\\A");
			if (scanner.hasNext()) {
				String resposta = scanner.next();
				return resposta.equals("true");
			}

			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			scanner.close();
		}

	}

	@Override
	protected void onPostExecute(final Boolean success) {

		loginTask.mAuthTask = null;
		loginTask.showProgress(false);

		if (success) {
			loginTask.finish();
		} else {
			loginTask.mPasswordView.setError(loginTask
					.getString(R.string.error_incorrect_password));
			loginTask.mPasswordView.requestFocus();
		}
	}

	@Override
	protected void onCancelled() {

		loginTask.mAuthTask = null;
		loginTask.showProgress(false);
	}
}