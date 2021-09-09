package Escola;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnidadeTeste {

    @Test
    void construtorUnidade(){
        Unidade unidade = new Unidade ("Espaço Mágico");

        assertNotEquals("Null",unidade.getNomeUnidade());
    }


    @Test
    void retornaUnidadeNull() {
        try {
            Unidade unidade = new Unidade(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O nome para unidade é obrigatória", e.getMessage());
        }
    }

    @Test
    void SetNomeNulo() {
        try {
            Unidade unidade = new Unidade("Santo Antonio I");
            unidade.setNome(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da unidade é obrigatório", e.getMessage());
        }
    }

    @Test
    void deveAdicionarTurma() {
        Unidade unidade = new Unidade("Santo Antonio II");
        Turma turma = new Turma("EM3");

        unidade.adicionarTurma(turma);

        assertTrue(turma.verificarUnidade(unidade));
        assertTrue(unidade.verificaTurma(turma));
    }

    @Test
    void deveAdicionarTurmaS(){
        Unidade unidade  = new Unidade ("Benfica");
        Turma turma = new Turma("EF2");
        Turma turma2 = new Turma("EF1");

        unidade.adicionarTurma(turma);
        unidade.adicionarTurma(turma2);

        assertTrue(unidade.verificaTurma(turma));
        assertTrue(unidade.verificaTurma(turma2));
    }

    @Test
    void deveRemoverTurma() {
        Unidade unidade = new Unidade("Santo Antonio II");
        Turma turma = new Turma("EM3");

        unidade.adicionarTurma(turma);
        unidade.removerTurma(turma);

        assertFalse(turma.verificarUnidade(unidade));
        assertFalse(unidade.verificaTurma(turma));
    }

}





