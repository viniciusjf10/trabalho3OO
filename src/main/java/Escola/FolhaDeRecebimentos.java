package Escola;

public class FolhaDeRecebimentos {
    private float rendaMensal;

    public void FolhaDePagamento() {
        this.rendaMensal = 0.0f;
    }

    public float calculaRendaMensal(Turma turma) {
        this.calculaMensalidadeAluno(turma);
        return this.rendaMensal;
    }

    public void calculaMensalidadeAluno(Turma turma) {
        if (turma.getAlunos() != null) {
            for (Aluno aluno : turma.getAlunos()) {
                this.rendaMensal += aluno.getMensalidade();
            }
        }
    }
}
