package br.com.todolist.repository;

import java.util.List;

import br.com.todolist.model.Tarefa;

public interface TarefaRepository {

    void adicionar(Tarefa tarefa);

    List<Tarefa> listar();

    void remover(Tarefa tarefa);
}