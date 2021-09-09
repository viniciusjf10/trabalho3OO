//ALUNO : VINICIUS SOUZA ALMEIDA     MATRICULA:201865148AC

package Escola;

public class Aluno  extends Cliente implements FinanceiroAluno{
    private Turma turma;
    private float mensalidade;
    private boolean media;
    private int tamName;

    public Aluno(String nome){
        super(nome);
        this.mensalidade = 500.0f;
        this.media = false;
    }

    public Turma getTurma(){
        return turma;
    }

    public float getMensalidade(){
        return mensalidade;
    }

    public boolean getMedia(){
        return media;
    }

    public void setMedia(boolean media) {
        this.media = media;
    }

    public void adicionarTurma(Turma turma){
        if(this.turma != turma){
            if(this.turma != null){
                this.turma.desmatricularAluno(this);
            }
            this.turma = turma;
                if(this.turma != null){
                    this.tamName = getNome().length();
                }
        }
    }

    public void removerTurma(){
        this.turma.desmatricularAluno(this);
        this.turma = null;
        this.mensalidade = 0;
        this.media = false;
    }

    @Override
    public double calcularMensalidade(){
        if(media){
            return mensalidade - (0.1 * mensalidade);
        }
        else
            return mensalidade;
    }

    @Override
    public boolean renovarMatricula(){
        System.out.println("Matricula renovada com sucesso");
        return true;
    }

    public boolean verificarTurma(Turma turma){
        return this.turma == turma;
    }
}
