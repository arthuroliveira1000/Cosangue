package tcc.cosangueapp.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class Json {

	private static String readAll(Reader reader) throws IOException {
		StringBuilder text = new StringBuilder();
		int count;
		while ((count = reader.read()) != -1) {
			text.append((char) count);
		}
		return text.toString();
	}

	private static JSONObject readJsonFromUrl(String URL) throws IOException, JSONException {
		InputStream inputStream = new URL(URL).openStream();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String text = readAll(reader);
			JSONObject jsonObject = new JSONObject(text);
			return jsonObject;
		} finally {
			inputStream.close();
		}
	}

	public static JSONObject get(String URL) {
		try {
			return readJsonFromUrl(URL);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}