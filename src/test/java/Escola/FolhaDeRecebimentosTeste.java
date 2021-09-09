package Escola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FolhaDeRecebimentosTeste {

    @Test
    void  retornaRendaDeTresAluno(){
        Aluno aluno1 = new Aluno ("Maicon");
        Aluno aluno2 = new Aluno ("Jeferson");
        Aluno aluno3 = new Aluno ("Jose");

        Turma turma = new Turma ("EF3");

        List<Aluno>  alunos = Arrays.asList(aluno1,aluno2,aluno3);

        turma.matricularAlunoS(alunos);

        FolhaDeRecebimentos folhaDeRecebimentos = new FolhaDeRecebimentos();

        assertNotEquals(0,folhaDeRecebimentos.calculaRendaMensal(turma));
    }

    @Test
    void retornaARendaDeUmAluno(){
        Aluno aluno1 = new Aluno ("Jose");

        Turma turma = new Turma ("EF3");

        turma.matricularAluno(aluno1);

        FolhaDeRecebimentos folhaDeRecebimentos = new FolhaDeRecebimentos();

        if(aluno1.getMedia())
        assertEquals(450,folhaDeRecebimentos.calculaRendaMensal(turma));
        else
            assertEquals(500,folhaDeRecebimentos.calculaRendaMensal(turma));
    }

    @Test
    void semAlunoNaTurma(){
        Turma turma = new Turma ("EF3");
        FolhaDeRecebimentos folhaDeRecebimentos = new FolhaDeRecebimentos();
        assertEquals(0,folhaDeRecebimentos.calculaRendaMensal(turma));
    }

}
