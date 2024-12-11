// Crie um programa em Java que utilize as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta à API do Google Books. Solicite ao usuário que insira o título de um livro, e exiba as informações disponíveis sobre o livro retornado pela API.

// Crie um programa Java que utiliza as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta à

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // HttpClient client = HttpClient.newHttpClient();
        // HttpRequest request = HttpRequest.newBuilder()
        //         .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=quilting"))
        //         .build();
        // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // System.out.println("Livro ok:" + response.body());

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome da receita: ");
        var nomeDaReceita = leitura.nextLine();

        String receita = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nomeDaReceita;
                            
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(receita))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
        System.out.println(response.body());
    }
}
