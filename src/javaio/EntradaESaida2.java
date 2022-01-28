package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class EntradaESaida2 {
  public static void main(String[] args) throws IOException {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("teste_saida.txt"))) {
      bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ");
      bw.write(System.lineSeparator());
      bw.write(System.lineSeparator());
      bw.write("exemplo de texto na última linha.");
    }

    try (BufferedReader br = new BufferedReader(new FileReader("teste.txt"))) {
      String linha = br.readLine();
      while (linha != null) {
        System.out.println(linha);
        linha = br.readLine();
      }
    }

    try (BufferedReader br = new BufferedReader(new FileReader("teste.txt"));
         BufferedWriter bw = new BufferedWriter(new FileWriter("teste_saida2.txt"))) {
      String linha = br.readLine();
      while (linha != null) {
        bw.write(linha);
        bw.newLine();
        linha = br.readLine();
      }

    }

    try (PrintStream ps = new PrintStream("teste_saida3.txt")) {
      ps.println("testando printstream");
      ps.println();
      ps.print("escrevendo sem quebrar linhas");
      ps.print("escrevendo na mesma linha");
    }

    try (PrintWriter pw = new PrintWriter("teste_saida4.txt")) {
      pw.println("testando print writer");
      pw.println();
      pw.printf("Print%s é muito legal.", "Writer");
    }

    // File arquivo = new File("contas.csv");

    try(Scanner scanner = new Scanner(new File("contas.csv"));
        PrintWriter pw = new PrintWriter("saida_contas.txt")) {

      while (scanner.hasNextLine()) {
        String linha = scanner.nextLine();

        try (Scanner linhaScanner = new Scanner(linha)) {
          linhaScanner.useLocale(Locale.US);
          linhaScanner.useDelimiter(",");
          String tipoConta = linhaScanner.next();
          int numAgencia = linhaScanner.nextInt();
          int numConta = linhaScanner.nextInt();
          String titular = linhaScanner.next();
          double saldo = linhaScanner.nextDouble();

          System.out.format(new Locale("pt", "BR"),
              "%s - %04d-%08d - %s: %.2f%n",
              tipoConta, numAgencia, numConta, titular, saldo);

          pw.printf(new Locale("pt", "BR"),
              "%s - %04d-%08d - %s: %.2f%n",
              tipoConta, numAgencia, numConta, titular, saldo);
        }

        /*String[] valores = linha.split(",");
        // System.out.println(linha);
        System.out.println(Arrays.toString(valores));
        System.out.println(valores[3]);*/
      }
    }

    Path path = Paths.get("teste.txt");
    List<String> linhasArquivo = Files.readAllLines(path);
    /*for (String linha : linhasArquivo) {
      System.out.println(linha);
    }*/

    // Files.lines(path).forEach(linha -> System.out.println(linha));

    try (Stream<String> stream = Files.lines(path)){
      stream.forEach(System.out::println);
    }

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("saida_contas.txt"))) {
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }
    }

    String str = "Testando escrita com Files";
    byte[] strToBytes = str.getBytes();

    Files.write(Paths.get("teste_saida5.txt"), strToBytes);

    try (PrintStream ps = new PrintStream(new FileOutputStream("teste_saida6.txt", true))) {
      ps.println("Teste append");
    }

  }

}
