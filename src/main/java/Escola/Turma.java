package Escola;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nomeTurma;
    private  List<Aluno> alunos;
    private List<Unidade> unidades;
    private List<Professor> professores;

    //CRIA UMA TURMA E INSTANCIA LISTA DE ALUNOS
    public Turma(String nomeTurma){
        if(nomeTurma == null)
            throw new IllegalArgumentException("O identificador da turma não pode ser null");

        this.nomeTurma = nomeTurma;
        this.alunos = new ArrayList<Aluno>();
        this.unidades = new ArrayList<Unidade>();
        this.professores = new ArrayList<Professor>();
    }

    //GETS PARA ALUNOS

    public List<Aluno> getAlunos(){
        return alunos;
    }

    public List<Unidade> getUnidades(){return unidades;}

    public String getNomeTurma() {
        return nomeTurma;
    }

    //ADICIONA ALUNO A UMA TURMA
    public void matricularAluno(Aluno aluno){
        if(!this.alunos.contains(aluno)){
            this.alunos.add(aluno);
        }
        aluno.adicionarTurma(this);
    }

    public void matricularAlunoS(List<Aluno> alunos){
        for(Aluno aluno : alunos){
            if(!this.alunos.contains(aluno)){
                this.alunos.add(aluno);
            }
            aluno.adicionarTurma(this);
        }
    }

    public void alocarProfessor(Professor professor){
        if(!this.professores.contains(professor)){
            this.professores.add(professor);
        }
        professor.adicionarTurma(this);
    }


    //REMOVE O ALUNO DE UMA TURMA
    public void desmatricularAluno(Aluno aluno){
        if(this.alunos.contains(aluno)){
            this.alunos.remove(aluno);
            aluno.removerTurma();
        }
    }

    public void desalocarProfessor(Professor professor){
        if(this.professores.contains(professor)){
            this.professores.remove(professor);
            professor.removerTurma();
        }
    }

    public void criarUnidade(Unidade unidade) {
        if (unidade == null) {
            throw new NullPointerException("Unidade não pode ser null");
        }
        if (!this.unidades.contains(unidade)) {
            this.unidades.add(unidade);
        }
        if (!unidade.verificaTurma(this)) {
            unidade.adicionarTurma(this);
        }
    }

    public void apagarUnidade(Unidade unidade) {
        if (unidade == null) {
            throw new NullPointerException("Unidade não pode ser null");
        }
        if (this.unidades.contains(unidade)) {
            this.unidades.remove(unidade);
        }
        if (unidade.verificaTurma(this)) {
            unidade.removerTurma(this);
        }
    }

    public boolean verificarUnidade(Unidade unidade){
        return this.unidades.contains(unidade);
    }

    public boolean verificarAluno(Aluno aluno){
        return this.alunos.contains(aluno);
    }

    public boolean verficarProfessor(Professor professor) {return this.professores.contains(professor);}

    public List<Aluno> alunos() {
        return alunos;
    }
}
