    // Crie um programa simples que solicita dois números ao usuário e realiza a divisão do primeiro pelo segundo. Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o usuário informe 0 como divisor.

    // Crie um programa que lê uma senha do usuário. Utilize o bloco try/catch para capturar a exceção SenhaInvalidaException, uma classe de exceção personalizada que deve ser lançada caso a senha não atenda a critérios específicos (por exemplo, ter pelo menos 8 caracteres).

    // Desenvolva um programa em Java que permite aos usuários consultar informações sobre um usuário do GitHub (utilize a API pública do GitHub para obter os dados). Crie uma classe de exceção personalizada, ErroConsultaGitHubException, que estende RuntimeException. Lance essa exceção quando o nome de usuário não for encontrado. No bloco catch, trate de forma específica essa exceção, exibindo uma mensagem amigável.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.println("Digite o numerador: ");
    //     int numerador = scanner.nextInt();

    //     System.out.println("Digite o denominador: ");
    //     int denominador = scanner.nextInt();

    //     try {
    //         int resultado = numerador / denominador;
    //         System.out.println("Resultado da divisão: " + resultado);
    //     } catch (ArithmeticException e) {
    //         System.out.println("Erro: Divisão por zero não permitida");
    //     }


    //     Scanner scannerSenha = new Scanner(System.in);

    //     System.out.println("Digite sua senha: ");
    //     var senha = scannerSenha.nextLine();

    //     try {
    //         validarSenha(senha);
    //         System.out.println("Senha válida. Acesso permitido.");
    //     } catch (SenhaInvalidaException e) {
    //         System.out.println("Erro: " + e.getMessage());
    //     }
    // }

    // private static void validarSenha(String senha) {
    //     if (senha.length() < 8) {
    //         throw new SenhaInvalidaException(("A senha deve ter pelo menos 8 caracteres."));
            
    //     }
    // }


        Scanner scannerGit = new Scanner(System.in);
        System.out.println("Digite o nome de usuário do Github para consultar informações: ");
        String username = scannerGit.nextLine();

        String endereco = "https://api.github.com/users/" + username;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).header("Accept", "application/vnd.github.v3+json").build();

            HttpResponse<Script> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
            }

            String json = response.body();
            System.out.println(json);
        } catch (IOException | InterruptedException e) {

        }

    }
}
