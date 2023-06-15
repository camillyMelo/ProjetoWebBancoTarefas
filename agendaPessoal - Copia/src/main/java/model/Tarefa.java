package model;

import java.util.Date;

public class Tarefa {
	private int id;
	private String titulo;
	private String descricao;
    private String status;
    private Date data_cricao;
    private Date data_conclusao;
    private Usuario usuario;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData_cricao() {
		return data_cricao;
	}
	public void setData_cricao(Date data_cricao) {
		this.data_cricao = data_cricao;
	}
	public Date getData_conclusao() {
		return data_conclusao;
	}
	public void setData_conclusao(Date data_conclusao) {
		this.data_conclusao = data_conclusao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
