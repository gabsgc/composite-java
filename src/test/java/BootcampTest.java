import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootcampTest {
    @Test
    void deveRetornarEmentaDoBootcamp() {
        Curso curso1 = new Curso("Pensamento Computacional");
        Curso curso2 = new Curso("Introdução a POO");
        Curso curso3 = new Curso("SQL");

        Projeto projeto1 = new Projeto("Criando consultas no MySQl", 20);
        Projeto projeto2 = new Projeto("Abstraindo uma biblioteca usando POO", 80);

        curso2.addConteudo(projeto2);
        curso3.addConteudo(projeto1);

        Curso ementa = new Curso("Introdução ao Desenvolvimento de Software");
        ementa.addConteudo(curso1);
        ementa.addConteudo(curso2);
        ementa.addConteudo(curso3);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setEmenta(ementa);

        assertEquals(
                "Curso Introdução ao Desenvolvimento de Software\n" +
                "Curso Pensamento Computacional\n" +
                "Curso Introdução a POO\n" +
                "Projeto Abstraindo uma biblioteca usando POO - pontuação: 80\n" +
                "Curso SQL\n" +
                "Projeto Criando consultas no MySQl - pontuação: 20\n", bootcamp.getEmenta());
    }

    @Test
    void deveLancarExcecaoQuandoBootcampNaoTiverEmenta() {
        try {
            Bootcamp bootcamp = new Bootcamp();
            bootcamp.getEmenta();
            fail();
        } catch (NullPointerException ex) {
            assertEquals("Bootcamp sem ementa disponível.", ex.getMessage());
        }
    }
}