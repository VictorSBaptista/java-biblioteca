package model;

/**
 * Classe para armazenar os atributos e métodos do objeto usuario
 * @author Victor Baptista
 * @since 18/02/2021
 */
public class Usuario {

	//Método construtor da classe
	public Usuario() {
	}
	
	//Declarando os atributos
	private int codigo;
	private String nome;
	private Data dataNacimento;
	private String telefone;
	private String email;
	
	//Métodos getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Data getDataNacimento() {
		return dataNacimento;
	}
	public void setDataNacimento(Data dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
