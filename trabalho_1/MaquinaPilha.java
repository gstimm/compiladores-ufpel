import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaquinaPilha {
  public static void main(String[] args) {
    String arquivoCodigo = args[0];

    try {
      List<String> codigo = leArquivo(arquivoCodigo);
      double resultado = processaCodigo(codigo);
      System.out.println("Resultado: " + resultado);
    } catch (Exception e) {
      System.out.println("Erro de compilação:\n" + e);
    }
  }

  public static List<String> leArquivo(String nomeArquivo) {
    List<String> codigo = new ArrayList<String>();
    System.out.println("Lendo arquivo: " + nomeArquivo);

    try {
      BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
      String linha = br.readLine();

      while (linha != null) {
        codigo.add(linha);
        linha = br.readLine();
      }
      br.close();
    } catch (Exception e) {
      System.out.println("Erro ao ler arquivo:\n" + e);
    }
    return codigo;
  } 

  public static double processaCodigo(List<String> comandos) {
    Stack<Double> pilha = new Stack<Double>();
    double resultado = 0.0;

    System.out.println("Processando código: " + comandos);

    for (String comando: comandos) {
      if(comando.startsWith("PUSH")) {
        double arg = Double.parseDouble(comando.split(" ")[1]);
        pilha.push(arg);
      } else if (comando.startsWith("SOMA")) {
        double arg1 = pilha.pop();
        double arg2 = pilha.pop();
        resultado = arg1 + arg2;
        pilha.push(resultado);
      } else if (comando.startsWith("SUB")) {
        double arg1 = pilha.pop();
        double arg2 = pilha.pop();
        resultado = arg2 - arg1;
        pilha.push(resultado);
      } else if (comando.startsWith("MULT")) {
        double arg1 = pilha.pop();
        double arg2 = pilha.pop();
        resultado = arg1 * arg2;
        pilha.push(resultado);
      } else if (comando.startsWith("DIV")) {
        double arg1 = pilha.pop();
        double arg2 = pilha.pop();
        resultado = arg2 / arg1;
        pilha.push(resultado);
      } else if (comando.startsWith("PRINT")) {
        resultado = pilha.pop();
        pilha.push(resultado);
      }
    }

    double resultadoFinal = pilha.pop();
    return resultadoFinal;
  }
}