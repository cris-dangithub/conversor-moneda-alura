package conversorMonedas;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import com.google.gson.JsonObject;
import utils.Fetcher;

public class ConvertirMonedas {
	private String route = "https://api.currencyapi.com/v3/latest?apikey=";
	private String apikey = "cur_live_bpoTkI6mOMfN8e5cPlEckc06OdymiQ4D1TVHjBBt";
	private JsonObject resAPI;

	public ConvertirMonedas() {
	}

	public ConvertirMonedas(String baseCurrency) {
		this.route += this.apikey + "&base_currency=" + baseCurrency;
		Fetcher converterApi = new Fetcher(this.route);
		this.resAPI = converterApi.GET().getAsJsonObject("data");

	}

	public void convertidor(double valor, String toCurrency, boolean isInverted, String nameCurrency) {
		DecimalFormat formato = new DecimalFormat("#.##");
		double change = this.resAPI.getAsJsonObject(toCurrency).get("value").getAsDouble();
		String monedaConvertida = formato.format(isInverted ? valor / change : valor * change);
		String msg = "Tienes $" + monedaConvertida + " " + nameCurrency;
		JOptionPane.showMessageDialog(null, msg);
	}

}
