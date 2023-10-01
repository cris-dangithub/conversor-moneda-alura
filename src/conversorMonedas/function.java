package conversorMonedas;

import javax.swing.JOptionPane;

public class function {

	ConvertirMonedas monedas = new ConvertirMonedas("COP");
	
    public void ConvertirMonedas(double Minput) {
    	String opcion = (JOptionPane.showInputDialog(null, 
    			"Elije la moneda a la que deseas convertir tu dinero ", "Monedas", 
    			JOptionPane.PLAIN_MESSAGE, null, new Object[] 
    			{"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras","De Pesos a Yen","De Pesos a Won Coreano","De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos","De Yen a Pesos","De Won Coreano a Pesos"}, 
    			"Seleccion")).toString();
        switch(opcion) {
        case "De Pesos a Dólar":
        	monedas.convertidor(Minput, "USD", false, "Dolares");
        	break;
        case "De Pesos a Euro":
        	monedas.convertidor(Minput, "EUR", false, "Euros");
        	break;
        case "De Pesos a Libras":
        	monedas.convertidor(Minput, "GBP", false, "Libras");
        	break;
        case "De Pesos a Yen":
        	monedas.convertidor(Minput, "JPY", false, "Yens");
        	break;
        case "De Pesos a Won Coreano":
        	monedas.convertidor(Minput, "KRW", false, "Wons coreanos");
        	break;    	    	                          
        case "De Dólar a Pesos":
        	monedas.convertidor(Minput, "USD", true, "Pesos");
        	break;
        case "De Euro a Pesos":
        	monedas.convertidor(Minput, "EUR", true, "Pesos");
        	break;
        case "De Libras a Pesos":
        	monedas.convertidor(Minput, "GBP", true, "Pesos");
        	break;
        case "De Yen a Pesos":
        	monedas.convertidor(Minput, "JPY", true, "Pesos");
        	break;
        case "De Won Coreano a Pesos":
        	monedas.convertidor(Minput, "KRW", true, "Pesos");
            break;
        }      
	}

}
