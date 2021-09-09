package Escola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TurmaTeste {

    @Test
    void retornaTurmaNull() {
        try {
            Turma turma = new Turma(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O identificador da turma não pode ser null", e.getMessage());
        }
    }

    @Test
    void retornaNomeTurma() {
        Turma turma = new Turma("EF2");
        assertEquals("EF2", turma.getNomeTurma());
    }

    @Test
    void relacionamentoAlunoTurma(){
        Turma turma = new Turma ("EM3");
        Aluno aluno = new Aluno("Vinicius");

        turma.matricularAluno(aluno);

        assertTrue(turma.verificarAluno(aluno));
        assertTrue(aluno.verificarTurma(turma));
    }

    @Test
    void removeAlunoDaTurma(){
        Turma turma = new Turma("EM3");
        Aluno aluno = new Aluno("Maria Luisa");

        turma.matricularAluno(aluno);
        turma.desmatricularAluno(aluno);

        assertFalse(turma.verificarAluno(aluno));
        assertFalse(aluno.verificarTurma(turma));
    }

    @Test
    void alunoMatriculadoNaTurma(){
        Turma turma = new Turma("EF2");
        Aluno aluno = new Aluno("Marcos");

        turma.matricularAluno(aluno);

        assertTrue(turma.verificarAluno(aluno));
        assertTrue(aluno.verificarTurma(turma));
    }

    @Test
    void tentaApagarTurma(){
        Turma turma = new Turma("EM3");

        Unidade unidade = new Unidade("Santo Antonio 1");
        unidade.adicionarTurma(turma);

        Aluno aluno = new Aluno("Marcos");

        unidade.removerTurma(turma);
        assertFalse(unidade.verificaTurma(turma));;

    }
    @Test
    void tentaApagarTurmaNull(){
        try {
            Turma turma = new Turma("EM3");

            Unidade unidade = new Unidade("Santo Antonio 1");
            unidade.adicionarTurma(turma);
            Aluno aluno = new Aluno("Marcos");

            unidade.removerTurma(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A turma não pode ser null", e.getMessage());
        }
    }

}



