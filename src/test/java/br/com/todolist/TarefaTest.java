package br.com.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.todolist.model.StatusTarefa;
import br.com.todolist.model.Tarefa;

public class TarefaTest {

    @Test
    void tarefaNovaDeveComecarNaoConcluida() {

        Tarefa tarefa = new Tarefa("Estudar Java");
        assertEquals(StatusTarefa.PENDENTE, tarefa.getStatus());
    }

    @Test
    void concluirDeveMarcarTarefaComoConcluida() {

        Tarefa tarefa = new Tarefa("Estudar Java");

        tarefa.concluir();

        assertEquals(StatusTarefa.CONCLUIDA, tarefa.getStatus());
    }


}