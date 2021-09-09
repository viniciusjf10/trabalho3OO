package Escola;
import java.util.ArrayList;
import java.util.List;

public class Unidade {
    private String nomeUnidade;
    private List<Turma> turmas;

    //CRIA UMA UNIDADE DE ESCOLA SENDO OBRIGATÓRIO UM NOME E CRIA UMA LISTA DE TURMAS
    public Unidade(String unidade) {
        if (unidade == null)
            throw new IllegalArgumentException("O nome para unidade é obrigatória");
        this.turmas = new ArrayList<Turma>();
        this.nomeUnidade = unidade;
    }

    public void setNome(String nomeUnidade) {
        if(nomeUnidade == null)
            throw new IllegalArgumentException("Nome da unidade é obrigatório");
        this.nomeUnidade = nomeUnidade;
    }

    public String getNomeUnidade() {
        return this.nomeUnidade;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    //Verifica se a turma já está criada dentro de uma unidade. Será usado para evitar recriar turmas
    public boolean verificaTurma(Turma turma){
        return this.turmas.contains(turma);
    }

    //Adiciona uma turma a unidade
    public void adicionarTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("A turma não pode ser null");
        }
        if (!(verificaTurma(turma))) {
            this.turmas.add(turma);
        }
        if(!turma.verificarUnidade(this)){
            turma.criarUnidade(this);
        }
    }

    //Remove uma turma da unidade
    public void removerTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("A turma não pode ser null");
        }
        if ((verificaTurma(turma))) {
            this.turmas.remove(turma);
        }
        if(turma.verificarUnidade(this)){
            turma.apagarUnidade(this);
        }
    }
}