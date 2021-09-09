package Escola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class AlunoTeste {

    @Test
    void verificaTurma(){
        Turma turma = new Turma ("M1");
        Aluno aluno = new Aluno("Vanessa");
        Aluno aluno1 = new Aluno("Bruno");

        turma.matricularAluno(aluno);
        turma.matricularAluno(aluno1);

        assertTrue(aluno.verificarTurma(turma));
        assertTrue(aluno1.verificarTurma(turma));
    }

    @Test
    void renovaMatriculaDoAluno(){
        Turma turma = new Turma("EI1");
        Aluno aluno = new Aluno("Monique");

        turma.matricularAluno(aluno);

        assertTrue(aluno.renovarMatricula());
    }

    @Test
    void adicionaAluno(){
        Turma turma = new Turma("I4");
        Aluno aluno = new Aluno("Sidney");

        turma.matricularAluno(aluno);

        assertTrue(turma.verificarAluno(aluno));
    }

    @Test
    void removerAluno(){
        Turma turma = new Turma("AB2");
        Aluno aluno = new Aluno ("Marcia");

        turma.matricularAluno(aluno);

        turma.desmatricularAluno(aluno);

        assertFalse(turma.verificarAluno(aluno));
    }

    @Test
    void obterTurma(){
        Turma turma = new Turma("EF4");
        Aluno aluno = new Aluno("Matheus");

        aluno.adicionarTurma(turma);
        assertEquals("EF4",aluno.getTurma().getNomeTurma());
    }

    @Test
    void calculaMensalidadeDoAluno(){
        Turma turma = new Turma("EF2");
        Aluno aluno = new Aluno("Joao");

        turma.matricularAluno(aluno);

        if(aluno.getMedia())
            assertEquals(450,aluno.calcularMensalidade());
        else
            assertEquals(500,aluno.calcularMensalidade());
    }

    @Test
    void retornaListaDeAluno(){
        Turma turma = new Turma ("EM2");
        Aluno aluno1 = new Aluno ("Maicon");
        Aluno aluno2 = new Aluno ("Amanda");
        Aluno aluno3 = new Aluno ("Bianca");

        List<Aluno> alunos = Arrays.asList(aluno1,aluno2,aluno3);

        turma.matricularAlunoS(alunos);

        assertEquals(alunos, turma.alunos());
    }

}
