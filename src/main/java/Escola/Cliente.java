package Escola;

// TODOS NA INSTITUIÇÃO POSSUEM DADOS BÁSICOS CADASTRADOS COMO CLIENTES

public abstract class Cliente {
    private String nome;

    public Cliente(String nome){
        if(nome==null)
            throw new IllegalArgumentException("O nome não pode ser null");
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if(nome == null)
            throw new IllegalArgumentException("O nome não pode ser null");
        this.nome = nome;
    }
}
