package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Fetcher {
	private URL url;
	private HttpURLConnection request;
	private StringBuilder response = new StringBuilder();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public Fetcher(String url) {
		try {
			this.url = new URL(url);
			this.request = (HttpURLConnection) this.url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JsonObject GET() {
		try {
			this.request.connect();
			int responseCode = this.request.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Setear el contenido de la respuesta en forma de cadena
				this.setContentResponse();
				// obtener la respuesta entera formateada a JSON
				JsonElement jsonElement = JsonParser.parseString(this.response.toString());
				JsonObject jsonResponse = jsonElement.getAsJsonObject();
				System.out.println(this.getResponseFormattedJson(jsonResponse));
				this.request.disconnect();
				return jsonResponse;
			} else {
				throw new IOException("La solicitud no fue exitosa. Código de estado: " + responseCode);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JsonElement jsonElement = JsonParser.parseString("Ha ocurrido un error");
			JsonObject jsonErrorResponse = jsonElement.getAsJsonObject();
			return jsonErrorResponse;
		}

	}

	// logs (consola)
	public String getResponseFormattedJson(JsonObject json) {
		return this.gson.toJson(json);
	}

	public String getResponseFormattedJson(JsonObject json, String key) {
		return this.gson.toJson(json.get(key));

	}

	// Leer el contenido de la respuesta en forma de cadena
	private void setContentResponse() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.request.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			this.response.append(line);
		}
		reader.close();
	}
}
