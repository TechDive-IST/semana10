package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class EntradaESaida1 {

  public static void main(String[] args) {

    /*try (InputStream fis = new FileInputStream("teste.txt");
         Reader isr = new InputStreamReader(fis);
         BufferedReader br = new BufferedReader(isr)) {

      String linha = br.readLine();

      while (linha != null) {
        System.out.println(linha);
        linha = br.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    try (OutputStream fos = new FileOutputStream("teste_saida.txt");
         Writer osw = new OutputStreamWriter(fos);
         BufferedWriter bw = new BufferedWriter(osw)) {
      bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ");
      bw.newLine();
      bw.newLine();
      bw.write("exemplo de texto na última linha.");
    } catch (IOException e) {
      e.printStackTrace();
    }*/

    Scanner input = new Scanner(System.in);

    try (InputStream fis = System.in; //new FileInputStream("teste.txt");
         Reader isr = new InputStreamReader(fis);
         BufferedReader br = new BufferedReader(isr);
         OutputStream fos = System.out; //new FileOutputStream("teste_saida.txt");
         Writer osw = new OutputStreamWriter(fos);
         BufferedWriter bw = new BufferedWriter(osw)) {

      String linha = br.readLine();

      while (linha != null && !linha.isEmpty() && !linha.equalsIgnoreCase("!sair!")) {
        bw.write(linha);
        bw.newLine();
        bw.flush();
        linha = br.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
