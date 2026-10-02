package br.com.todolist.service;

import java.util.ArrayList;
import java.util.List;

import br.com.todolist.model.StatusTarefa;
import br.com.todolist.model.Tarefa;

public class ListaDeTarefas {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public Tarefa buscarPorDescricao(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (descricao.equals(tarefa.getDescricao())) {
                return tarefa;
            }
        }

        return null;
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    public List<Tarefa> listarPorStatus(StatusTarefa status) {
        List<Tarefa> resultado = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                resultado.add(tarefa);
            }
        }

        return resultado;
    }

    public int contarConcluidas() {
        int quantidade = 0;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == StatusTarefa.CONCLUIDA) {
                quantidade++;
            }
        }

        return quantidade;
    }
}