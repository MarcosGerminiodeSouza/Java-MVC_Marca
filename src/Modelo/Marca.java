package Modelo;

public class Marca {
    //1. atributos
    private int id_marca;
    private String nome;
    //2. método construtor
    public Marca(int id_marca, String nome) {
        this.id_marca = id_marca;
        this.nome = nome;
    }
    // getters e setters
    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
