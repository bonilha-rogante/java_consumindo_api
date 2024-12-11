// Crie uma classe Pessoa usando o conceito de Record em Java, com atributos como nome, idade e cidade. Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON representando uma pessoa em um objeto do tipo Pessoa.

// Modifique o programa do Exercício anterior para permitir a conversão de um JSON mesmo se alguns campos estiverem ausentes ou se houver campos adicionais não representados no objeto Pessoa. Consulte a documentação da biblioteca Gson para flexibilizar a conversão.

// Crie uma classe Livro que contenha atributos como título, autor e um objeto representando a editora. Em seguida, implemente um programa que utiliza a biblioteca Gson para converter um JSON aninhado representando um livro em um objeto do tipo Livro.

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.exercicios02.Livro;
import br.com.alura.exercicios02.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {

        String json = "{\"nome\":\"Rodrigo\",\"idade\":30,\"cidade\":\"Brasilia\"}";

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        System.out.println(pessoa);

        String json2 = "{\"nome\":\"Rodrigo\",\"idade\":30}";

        Gson gson2 = new GsonBuilder().setLenient().create();
        Pessoa pessoa2 = gson2.fromJson(json2, Pessoa.class);
        System.out.println(pessoa2);

        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";

        Gson gson3 = new Gson();

        Livro livro = gson3.fromJson(jsonLivro, Livro.class);
        System.out.println(livro);

    }
}
