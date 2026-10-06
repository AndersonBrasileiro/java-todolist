package br.com.todolist.service;

import java.util.ArrayList;
import java.util.List;

import br.com.todolist.model.StatusTarefa;
import br.com.todolist.model.Tarefa;
import br.com.todolist.repository.TarefaRepository;

public class ListaDeTarefas {

    private TarefaRepository repository;

    public ListaDeTarefas(TarefaRepository repository) {
        this.repository = repository;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        repository.adicionar(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    public Tarefa buscarPorDescricao(String descricao) {
        for (Tarefa tarefa : repository.listar()) {
            if (descricao.equals(tarefa.getDescricao())) {
                return tarefa;
            }
        }

        return null;
    }

    public void removerTarefa(Tarefa tarefa) {
        repository.remover(tarefa);
    }

    public List<Tarefa> listarPorStatus(StatusTarefa status) {
        List<Tarefa> resultado = new ArrayList<>();

        for (Tarefa tarefa : repository.listar()) {
            if (tarefa.getStatus() == status) {
                resultado.add(tarefa);
            }
        }

        return resultado;
    }

    public int contarConcluidas() {
        int quantidade = 0;

        for (Tarefa tarefa : repository.listar()) {
            if (tarefa.getStatus() == StatusTarefa.CONCLUIDA) {
                quantidade++;
            }
        }

        return quantidade;
    }
}