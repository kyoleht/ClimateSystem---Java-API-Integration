import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClimateSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da cidade: ");
        String cidade = scanner.nextLine();

        try {
            String respostaJson = getDadosClimaticos(cidade);
            imprimirDadosClimaticos(respostaJson);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static String getDadosClimaticos(String cidade) throws Exception {
        String apiKEY = "ded6aef53a314222a1a25432262601";
        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        String urlAPI = new String("https://api.weatherapi.com/v1/current.json?key=" + apiKEY + "&q=" + formataNomeCidade);
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(urlAPI)).build(); //construção http e URI da req definida

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return res.body();
    }

   public static void imprimirDadosClimaticos(String dados) {
        JSONObject dadosJson = JsonParser.parseString(dados).getAsJsonObject();

        JSONObject location = dadosJson.getAsJsonObject("location");
        JSONObject current = dadosJson.getAsJsonObject("current");

        String cidade = location.get("name").getAsString();
        String pais = location.get("country").getAsString();

        String condicaoTempo = current.getAsJsonObject("condition").get("text").getAsString();

        int umidade = current.get("humidity").getAsInt();
        float velocidadeVento = current.get("wind_kph").getAsFloat();
        float pressaoAtmosferica = current.get("pressure_mb").getAsFloat();
        float sensacaoTermica = current.get("feelslike_c").getAsFloat();
        float temperaturaAtual = current.get("temp_c").getAsFloat();
        String dataHoraString = current.get("last_updated").getAsString();

        System.out.println("\n--- Informações Meteorológicas ---");
        System.out.println("Cidade: " + cidade + ", " + pais);
        System.out.println("Data e Hora: " + dataHoraString);
        System.out.println("Temperatura: " + temperaturaAtual + "°C (Sente-se como " + sensacaoTermica + "°C)");
        System.out.println("Condição: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Vento: " + velocidadeVento + " km/h");
        System.out.println("Pressão: " + pressaoAtmosferica + " mb");
    }
}