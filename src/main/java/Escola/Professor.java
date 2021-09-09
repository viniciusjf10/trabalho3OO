package Escola;

public class Professor extends Cliente implements FinanceiroFuncionario{
    private Turma turma;
    private float salario;
    private int tamName;

    public Professor(String nome){
        super(nome);
        this.salario = 500.0f;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void adicionarTurma(Turma turma){
        if(this.turma != turma){
            if(this.turma != null){
                this.turma.desalocarProfessor(this);
            }
            this.turma = turma;
            if(this.turma != null){
                this.tamName = getNome().length();
            }
        }
    }

    public void removerTurma(){
        this.turma.desalocarProfessor(this);
        this.turma = null;
    }

    public boolean verificarTurma(Turma turma){
        return this.turma == turma;
    }

    public double calculaSalario(){
        return salario*2;
    }
    public void reajusteAnual(){
        System.out.println("O salario foi reajustado com sucesso");
    }
}
