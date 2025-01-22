import java.util.Map;

public class ConversorMoneda {

    public String convertirMoneda(Map<String,Double> rates,
                                  String monedaOrigen,String codigoMonedaAConvertir,
                                  Double cantidadMoneda){
        String codigoMoneda=String.valueOf(rates.get(codigoMonedaAConvertir));
        // String  mensajeConversor="";
        Double rate=rates.get(codigoMonedaAConvertir);
        Double totalConversion=rate*cantidadMoneda;
        return (cantidadMoneda + " ["+monedaOrigen+"]" + " a "+ "["+ codigoMonedaAConvertir+"]" + " es = " + totalConversion);

    }
}
