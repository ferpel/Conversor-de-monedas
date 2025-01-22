import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedaAPI {
    String keyApi="9f341169b71e64e3305ea117";
    Moneda buscarMoneda(String codigoMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+keyApi+"/latest/"+codigoMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        //try {
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Moneda.class);
        // } catch (Exception e) {
        //    throw new RuntimeException("No se encontró esa moneda.");
        // }

    }
}
