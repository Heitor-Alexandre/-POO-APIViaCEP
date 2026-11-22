package ProjetoAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirCEP {

	public static void main(String[] args) {
		System.out.println("Aluno: Heitor Alexandre | RA: 0025566");
		
		String cep = "72542410";
		String url = "https://viacep.com.br/ws/" + cep + "/json/";

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();

			HttpResponse<String> response = client.send(
					request,
					HttpResponse.BodyHandlers.ofString()
			);

			System.out.println("Status da resposta: " + response.statusCode());
			System.out.println("Dados do CEP:");
			System.out.println(response.body());

		} catch (Exception e) {
			System.out.println("Erro ao consultar o CEP: " + e.getMessage());
		}
	}
}