package Estudos;

public class Pessoa {
    String nome;
    String cargo;
    char sexo;
    Integer idade;


    public Pessoa(String nome, String cargo, char sexo, Integer idade){


        this.nome = nome;
        this.cargo = cargo;
        this.sexo = sexo;
        this.idade = idade;
    }

    public void apresentar(){
        System.out.println("Ola, sou o " + this.nome + ", meu cargo é " + this.cargo + ", meu sexo é "
        + this.sexo + " e minha idade é " + this.idade);
    }

    public String toCSV() {
        return this.nome + "," + this.cargo + "," + this.sexo + "," + this.idade;
    }
}
