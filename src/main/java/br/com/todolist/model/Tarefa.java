package br.com.todolist.model;

public class Tarefa {

    private String descricao;
    private StatusTarefa status;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void concluir() {
        this.status = StatusTarefa.CONCLUIDA;
    }
    

}