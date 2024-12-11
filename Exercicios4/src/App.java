// Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado "arquivo.txt": "Conteúdo a ser gravado no arquivo." Utilize as classes do pacote java.io.

// Defina uma classe chamada Titulo com os atributos necessários. Em seguida, crie um programa que instancia um objeto Titulo, serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.

// Modifique o programa anterior para que o JSON gerado seja formatado de maneira mais elegante. Utilize o método setPrettyPrinting para alcançar esse resultado.

// Defina uma classe chamada Veiculo com os atributos necessários. Em seguida, crie um programa que instancia um objeto Veiculo, serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        String data = "Conteúdo a ser grava no arquivo";

        try (FileWriter writer = new FileWriter("arquivo.txt")) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
