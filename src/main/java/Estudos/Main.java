package Estudos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        try{
            InputStream is = new FileInputStream("src/main/java/Estudos/cadastro.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {

                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",");

                String nome = partes[0];
                String cargo = partes[1];
                char sexo = partes[2].charAt(0);
                Integer idade = Integer.parseInt(partes[3]);

                Pessoa pessoa = new Pessoa(
                        partes[0],
                        partes[1],
                        partes[2].charAt(0),
                        Integer.parseInt(partes[3])
                );

                pessoas.add(pessoa);

                //System.out.println(linha);
            }

            br.close();
            isr.close();
            is.close();

        } catch (Exception e){
            System.out.println("Erro no arquivo!");
            System.out.println(e.getMessage());
        }

        try{
            OutputStream os = new FileOutputStream("src/main/java/Estudos/cadastro2.csv");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("nome,cargo,sexo,idade");
            bw.newLine();

            for (Pessoa p : pessoas) {
                System.out.println(p.toCSV());
                bw.write(p.toCSV());
                bw.newLine();
            }

            bw.close();
            osw.close();
            os.close();



        }catch(Exception e){
            System.out.println("Erro na escrita do arquivo.");
        }


        System.out.println("\n--- PESSOAS CADASTRADAS ---");
        for (Pessoa p : pessoas) {
            p.apresentar();
        }

    }
}