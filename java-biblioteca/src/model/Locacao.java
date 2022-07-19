package model;

/**
 * Classe para armazenar os atributos e m�todos do objeto loca��o
 * @author Victor Baptista
 * @since 18/02/2021
 */
public class Locacao {

	//M�todo construtor
	public Locacao() {
	}
	
	//Declarando os atributos
	private int codigo;
	private Data dataLocacao;
	private Data dataDevolucao;
	private Livro livros[];
	private Usuario usuario;
	
	//M�todos getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Data getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Data dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Data getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Livro[] getLivros() {
		return livros;
	}
	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
