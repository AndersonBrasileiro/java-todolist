package br.com.todolist.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.todolist.model.Tarefa;

public class TarefaRepositoryMemoria implements TarefaRepository {

    private List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listar() {
        return Collections.unmodifiableList(tarefas);
    }

    @Override
    public void remover(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }
}