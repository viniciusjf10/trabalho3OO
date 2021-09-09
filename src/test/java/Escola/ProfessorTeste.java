package Escola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ProfessorTeste {
    @Test
    void construtorProfessor(){
        Professor professor = new Professor("Joana");
        assertEquals("Joana",professor.getNome());
    }

    @Test
    void verificaTurmaProfessor(){
        Turma turma = new Turma ("M1");
        Professor professor = new Professor("Vanessa");
        Professor professor1 = new Professor("Bruno");

        turma.alocarProfessor(professor);
        turma.alocarProfessor(professor1);

        assertTrue(professor.verificarTurma(turma));
        assertTrue(professor1.verificarTurma(turma));
    }

    @Test
    void adicionaProfessor(){
        Turma turma = new Turma("I4");
        Professor professor = new Professor("Sidney");

        turma.alocarProfessor(professor);

        assertTrue(turma.verficarProfessor(professor));
    }

    @Test
    void removeProfessor(){
        Turma turma = new Turma("AB2");
        Professor professor = new Professor ("Marcia");

        turma.alocarProfessor(professor);

        turma.desalocarProfessor(professor);

        assertFalse(turma.verficarProfessor(professor));
    }

    @Test
    void obterTurma(){
        Turma turma = new Turma("EF4");
        Professor professor = new Professor("Matheus");

        professor.adicionarTurma(turma);
        assertEquals("EF4",professor.getTurma().getNomeTurma());
    }

    @Test
    void calculaSalarioProfessor(){
        Turma turma = new Turma("EF2");
        Professor professor = new Professor("Joao");

        turma.alocarProfessor(professor);

        assertEquals(1000,professor.calculaSalario());

    }

}
