package Estudos;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try{
            InputStream is = new FileInputStream("src/main/java/Estudos/cadastro.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

            br.close();
            isr.close();
            is.close();

        } catch (Exception e){
            System.out.println("Erro no arquivo!");
            System.out.println(e.getMessage());
        }

    }
}