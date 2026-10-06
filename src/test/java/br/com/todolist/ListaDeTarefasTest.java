package br.com.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.todolist.model.StatusTarefa;
import br.com.todolist.model.Tarefa;
import br.com.todolist.repository.TarefaRepositoryMemoria;
import br.com.todolist.service.ListaDeTarefas;

public class ListaDeTarefasTest {

    @Test
    void deveAdicionarTarefasNaLista() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Praticar JUnit");
        Tarefa tarefa3 = new Tarefa("Praticar Volei");

        lista.adicionarTarefa(tarefa1);
        lista.adicionarTarefa(tarefa2);
        lista.adicionarTarefa(tarefa3);

        assertEquals(3, lista.listarTarefas().size());
    }

    @Test
    void deveEncontrarTarefaPelaDescricao() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        Tarefa tarefa = new Tarefa("Estudar Java");
        lista.adicionarTarefa(tarefa);

        Tarefa resultado = lista.buscarPorDescricao("Estudar Java");

        assertEquals(tarefa, resultado);
    }

    @Test

    void deveRetornarNullQuandoTarefaNaoForEncontrada() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        lista.adicionarTarefa(new Tarefa("Estudar Java"));

        Tarefa resultado = lista.buscarPorDescricao("Fazer exercícios");

        assertEquals(null, resultado);
    }

    @Test
    void deveRemoverTarefaDaLista() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        Tarefa tarefa = new Tarefa("Estudar Java");
        lista.adicionarTarefa(tarefa);

        lista.removerTarefa(tarefa);

        assertEquals(0, lista.listarTarefas().size());
    }

    @Test
    void deveListarTarefasPorStatus() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Praticar JUnit");
        Tarefa tarefa3 = new Tarefa("Estudar Spring");

        lista.adicionarTarefa(tarefa1);
        lista.adicionarTarefa(tarefa2);
        lista.adicionarTarefa(tarefa3);

        tarefa1.concluir();

        List<Tarefa> concluidas = lista.listarPorStatus(StatusTarefa.CONCLUIDA);
        List<Tarefa> pendentes = lista.listarPorStatus(StatusTarefa.PENDENTE);

        assertEquals(1, concluidas.size());
        assertEquals(2, pendentes.size());
    }

    @Test
    void deveContarTarefasConcluidas() {

        ListaDeTarefas lista = new ListaDeTarefas(new TarefaRepositoryMemoria());

        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Praticar JUnit");
        Tarefa tarefa3 = new Tarefa("Estudar Spring");

        lista.adicionarTarefa(tarefa1);
        lista.adicionarTarefa(tarefa2);
        lista.adicionarTarefa(tarefa3);

        tarefa1.concluir();
        tarefa2.concluir();

        assertEquals(2, lista.contarConcluidas());
    }
}