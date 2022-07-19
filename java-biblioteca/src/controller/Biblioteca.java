package controller;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe para efetuar o processamento..
 * 
 * @author Victor Baptista
 * @since 18/02/2021
 */
public class Biblioteca {

	// declarando os atributos
	private Livro livros[];
	private Usuario usuarios[];
	private Locacao locacoes[];

	// vari�veis auxiliares para defini��o pelo usu�rio os tamanhos dos vetores
	private int tamanhoLivros;
	private int tamanhoUsuarios;
	private int tamanhoLocacoes;

	// M�todo construtor da classe
	public Biblioteca() {
		processar();
	}

	// M�todo principal para executar a classe
	public void processar() {

		// capturando o tamanho do vetor Livros
		tamanhoLivros = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros a biblioteca comporta"));

		// capturando o tamanho do vetor Usuarios
		tamanhoUsuarios = Integer
				.parseInt(JOptionPane.showInputDialog("Informe quantos usu�rios a biblioteca comporta"));

		// capturando o tamanho do vetor Loca��es
		tamanhoLocacoes = tamanhoLivros;

		// definindo o tamanho dos vetores
		livros = new Livro[tamanhoLivros];
		usuarios = new Usuario[tamanhoUsuarios];
		locacoes = new Locacao[tamanhoLocacoes];

		// processamento de looping do programa
		while (true) {
			escolhaUsuario();
		}
	}

	// M�todo para capturar a escolha do usu�rio
	public void escolhaUsuario() {

		// menu do usu�rio
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(
				"Informe a op��o desejada:\n\n" + "OP��O 1 : Cadastrar Livro\n" + "OP��O 2 : Cadastrar Usu�rio\n"
						+ "OP��O 3 : Loca��o de Livro\n" + "OP��O 4 : Devolu��o de livro\n"
						+ "OP��O 5 : Listar Livros Cadastrados\n" + "OP��O 6 : Listar Usu�rios Cadastrados\n"
						+ "OP��O 7 : Pesquisar Livros por Editora\n" + "OP��O 8 : Pesquisar Livros por Autor\n"
						+ "OP��O 9 : Pesquisar Livros por Data da Loca��o\n" + "OP��O 10 : Sair do Programa\n"));

		// envia para o m�todo escolhaProcessamento a op��o desejada pelo usu�rio
		escolhaProcessamento(escolha);
	}

	// M�todo para sele��o das op��es do programa
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarLivro();
			break;

		case 2:
			cadastrarUsuario();
			break;

		case 3:
			efetuarLocacaoLivro();
			break;

		case 4:
			efetuarDevolucaoLivro();
			break;

		case 5:
			listarLivrosCadastrados();
			break;

		case 6:
			listarUsuariosCadastrados();
			break;

		case 7:
			pesquisarLivrosPorEditora();
			break;

		case 8:
			pesquisarLivrosPorAutor();
			break;

		case 9:
			pesquisarLocacaoPorDataLocacao();
			break;

		case 10:
			sairSistema();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida!", "Menu Biblioteca", 0);
			break;
		}
	}

	// M�todos para o cadastro de livros
	public void cadastrarLivro() {

		// vari�vel auxiliar para verificar se o livro foi cadastrado
		boolean cadastrado = false;

		// verifica o espa�o do vetor livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				livros[i] = criarLivro();
				cadastrado = true;
				break;
			}
		}

		// informa ao usu�rio se o cadastro foi realizado com sucesso ou n�o
		if (cadastrado) {
			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro de Livros", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"___________ERROR_________" + "\n\nA biblioteca n�o comporta mais livros.", "Cadastro de Livros",
					2);
		}
	}

	// M�todo para criar e retornar um livro para efetuar o cadastro
	public Livro criarLivro() {
		Autor autor = new Autor();
		Editora editora = new Editora();
		Livro livro = new Livro();

		// Recebe do usu�rio dados relacionados ao Autor
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo do Autor:")));
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do Autor:"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do Autor:"));

		// Recebe do usu�rio dados relacionados a Editora
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da Editora:")));
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da Editora:"));
		editora.setPais(JOptionPane.showInputDialog("Informe o pa�s em que a Editora est� localizada:"));

		// Recebe do usu�rio dados relacionados ao livro
		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo do Livro:")));
		livro.setTitulo(JOptionPane.showInputDialog("Informe o t�tulo do Livro:"));
		livro.setEditora(editora);
		livro.setAutor(autor);
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publica��o do Livro:")));
		livro.setDisponivel(true);

		return livro;
	}

	// M�todo para o cadastro de usu�rios
	public void cadastrarUsuario() {

		// vari�vel auxiliar para verificar se o usu�rio foi cadastrado
		boolean cadastrado = false;

		// verifica o espa�o do vetor usu�rios
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				cadastrado = true;
				break;
			}
		}

		// informa ao usu�rio se o cadastro foi realizado com sucesso ou n�o
		if (cadastrado) {
			// JOptionPane.showConfirmDialog(null, "Usu�rio cadastrado com sucesso!",
			// "Cadastro de Usu�rios", 1);
			JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso!", "Cadastro de Usu�rios", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"___________ERROR_________" + "\n\nA biblioteca n�o comporta mais usu�rios.",
					"Cadastro de Usu�rios", 2);
		}
	}

	// M�todo para criar e retornar um usu�rio para efetuar o cadastro
	public Usuario criarUsuario() {
		Data data = new Data();
		Usuario usuario = new Usuario();

		// Recebe do usu�rio dados relacionados ao usu�rio
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo de registro do Usu�rio:")));
		usuario.setNome(JOptionPane.showInputDialog("Informe o nome completo do Usu�rio:"));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o n�mero de telefone do Usu�rio:"));
		usuario.setEmail(JOptionPane.showInputDialog("Informe o email do Usu�rio:"));

		// Recebe do usu�rio dados relacionados a data
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe a data de nascimento do usu�rio!\nDia:")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("M�s:")));
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		usuario.setDataNacimento(data);

		return usuario;
	}

	// M�todo para processar a loca��o de livros
	public void efetuarLocacaoLivro() {

		// vari�vel auxiliar para utilizar para testar usu�rios e livros dispon�veis
		boolean teste = false;

		// vari�vel auxiliar para verificar se o livro no cadastro est� locado
		boolean locado = false;

		// For para verificar se h� usu�rios cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				teste = true;
			}
		}

		if (teste) {// se encontrou algum usu�rio
			// zera a vari�vel de teste para reutiliza��o
			teste = false;
			// varre o vetor de livros para verificar se h� livros dispon�veis
			for (int i = 0; i < livros.length; i++) {
				if ((livros[i] != null) && (livros[i].isDisponivel())) {
					teste = true;
				}
			}

			// Caso exista livro cadastrado e dispon�vel
			if (teste) {
				// varre o vetor de loca��o e efetua a loca��o
				for (int i = 0; i < locacoes.length; i++) {
					if (locacoes[i] == null) {
						locacoes[i] = criarLocacao();
						locado = true;
						break;
					}
				}

				// exibe o resultado da loca��o ao usu�rio
				if (locado) {
					JOptionPane.showMessageDialog(null, "Livro locado com sucesso.", "Loca��o de Livros", 1);
				} else {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a loca��o.", "Loca��o de Livros", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "N�o h� livros dispon�veis.", "Loca��o de Livros", 2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "N�o h� usu�rios cadastrados.", "Loca��o de Livros", 2);
		}

	}

	// M�todo para criar uma loca��o para efetuar o cadastro
	public Locacao criarLocacao() {

		// declara��o do objeto que ser� retornado
		Locacao locacao = new Locacao();

		// vetor de livros que o usu�rio deseja locar
		Livro emprestimos[];

		// vari�vel para realizar todos os testes da classe loca��o
		boolean teste = false;

		// quantidade de livros que o usu�rio deseja
		int tamanho = 0;

		// compara��o com a quantidade de livros
		int contador = 0;

		// vari�vel para receber c�digo
		int codigo;

		// recebe do usu�rio o c�digo de loca��o
		do {
			// reseta a vari�vel teste
			teste = false;

			// recebe do usu�rio o c�digo de loca��o
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo de loca��o:"));

			// varre o vetor de loca��es em busca do c�digo informado
			for (int i = 0; i < locacoes.length; i++) {
				if ((locacoes[i] != null) && (locacoes[i].getCodigo() == codigo)) {
					teste = true;
				}
			}

			// exibe ao usu�rio o caso o c�digo de loca��o informado j� existe
			if (teste) {
				JOptionPane.showMessageDialog(null, "C�digo inv�lido!", "Loca��o de livros", 2);
			}

		} while (teste);

		// atribui o codigo de loca��o
		locacao.setCodigo(codigo);

		// loop para receber as inform��es do usu�rio
		do {
			// Recebe o c�digo do usu�rio que deseja realizar a loca��o
			codigo = Integer.parseInt(
					JOptionPane.showInputDialog("Informe o c�digo do usu�rio que deseja realizar a loca��o:"));

			// for para verificar se existe o c�digo do usu�rio digitado
			for (int i = 0; i < usuarios.length; i++) {
				if ((usuarios[i] != null) && (usuarios[i].getCodigo() == codigo)) {
					locacao.setUsuario(usuarios[i]);
					teste = true;
				}
			}

			// informa ao usu�rio que o c�digo n�o � v�lido
			if (!teste) {
				JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!", "Loca��o de Livros", 0);
			}
		} while (!teste);

		// reseta a vari�vel teste
		teste = false;

		// loop para receber as informa��es dos livros que o usu�rio deseja locar
		do {
			// recebe a quantidade de livros que o usu�rio deseja
			tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros o usu�rio deseja locar:"));

			// verifica se a quantidade de livros desejada � v�lida
			if (tamanho > 0) {
				// varre o vetor de livros verificando a quantidade de livros dispon�veis
				for (int i = 0; i < livros.length; i++) {
					if ((livros[i] != null) && (livros[i].isDisponivel())) {
						contador++;
					}
				}

				// verifica se exite uma quantidade de livros dispon�veis maior ou igual a
				// quantidade desejada pelo usu�rio
				if (contador >= tamanho) {
					teste = true;
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade inv�lida!", "Loca��o de Livros", 0);
					contador = 0;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Quantidade inv�lida!", "Loca��o de Livros", 0);
			}

		} while (!teste);

		// atribui o tamanho ao vetor de emprestimo
		emprestimos = new Livro[tamanho];

		// reseta o contador
		contador = 0;

		// solicita os livros para empr�stimo
		do {
			// reseta a vari�vel teste
			teste = false;

			// recebe do usu�rio o c�digo do livro
			codigo = Integer
					.parseInt(JOptionPane.showInputDialog("Informe o c�digo do livro que o usu�rio deseja locar:"));

			// valida o c�digo digitado pelo usu�rio
			for (int i = 0; i < livros.length; i++) {
				if ((livros[i] != null) && (livros[i].getCodigo() == codigo)) {
					teste = true;
					if (livros[i].isDisponivel()) {
						for (int j = 0; j < emprestimos.length; j++) {
							if (emprestimos[j] == null) {
								emprestimos[j] = livros[i];
								livros[i].setDisponivel(false);
								contador++;
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Livro indispon�vel!", "Loca��o de Livros", 0);
					}
				}
			}

			// informa ao usu�rio caso o c�digo informado seja inv�lido
			if (!teste) {
				JOptionPane.showMessageDialog(null, "C�digo inv�lido!", "Loca��o de Livros", 0);
			}

		} while (contador != tamanho);

		// efetua a loca��o
		locacao.setLivros(emprestimos);

		// recebendo a data atual do sistema
		LocalDateTime relogio = LocalDateTime.now();

		// declara os objetos de data
		Data dataLocacao = new Data();
		Data dataDevolucao = new Data();

		// atribuindo a data atual na data de loca��o
		dataLocacao.setDia(relogio.getDayOfMonth());
		dataLocacao.setMes(relogio.getMonthValue());
		dataLocacao.setAno(relogio.getYear());

		// atribuindo a data de loca��o na loca��o
		locacao.setDataLocacao(dataLocacao);

		// recebe do usu�rio a data de devolu��o dos livros
		dataDevolucao.setDia(Integer.parseInt(
				JOptionPane.showInputDialog("Informe a data que o usu�rio ir� devolver os livros locados.\nDia:")));
		dataDevolucao.setMes(Integer.parseInt(JOptionPane.showInputDialog("M�s:")));
		dataDevolucao.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		// atribuindo a data de devolu��o na devolu��o
		locacao.setDataDevolucao(dataDevolucao);

		// retorna o objeto de loca��o
		return locacao;
	}

	// M�todo para processar a devolu��o de livros
	public void efetuarDevolucaoLivro() {

		// recebe o c�digo de loca��o
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da loca��o:"));

		// vari�vel auxiliar para gravar a posi��o do vetor loca��o
		int posicao = 0;

		// vari�vel auxiliar para testes
		boolean teste = false;

		// verifica se existe uma loca��o com o c�digo informado
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getCodigo() == codigo)) {
				teste = true;
				posicao = i;
			}
		}

		// efetua a devolu��o
		if (teste) {
			// declara e instancia o vetor devolu��o com o tamanho igual a quantidade de
			// livros que foram locados pelo usu�rio
			Livro devolucao[] = new Livro[locacoes[posicao].getLivros().length];

			// atribui os livros a serem devolvido ao vetor devolu��o
			devolucao = locacoes[posicao].getLivros();

			// varre o vetor de devolu��o e vetor de livros e reseta os livros para
			// dispon�vel
			for (int i = 0; i < devolucao.length; i++) {
				for (int j = 0; j < livros.length; j++) {
					if (livros[j].getCodigo() == devolucao[i].getCodigo()) {
						livros[j].setDisponivel(true);
					}
				}
			}

			// reseta o vetor de loca��o na posi��o correta
			locacoes[posicao] = null;

			// exibe o resultado da devolu��o
			JOptionPane.showMessageDialog(null, "Devolu��o conclu�da!", "Devolu��o de Livros", 1);

		} else {
			JOptionPane.showMessageDialog(null, "C�digo de loca��o inv�lido!", "Devolu��o de Livros", 0);
		}
	}

	// M�todo para listar os livros cadastrados
	public void listarLivrosCadastrados() {

		// vari�vel auxiliar para exibir os livros cadastrados
		String mensagem = "";

		// vari�vel auxiliar
		boolean existe = false;

		// varrendo o vetor de livros para verificar se h� livros cadastrados
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += (i + 1) + " - T�tulo: " + livros[i].getTitulo() + " - C�digo: " + livros[i].getCodigo()
						+ " - Dispon�vel: " + livros[i].disponibilidade(livros[i].isDisponivel()) + "\n";
				existe = true;
			}
		}

		// exibindo os livros cadastrados ao usu�rio
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Livros Cadastrados", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o h� livros cadastrados!", "Livros Cadastrados", 2);
		}
	}

	// M�todo para listar os usuarios cadastrados
	public void listarUsuariosCadastrados() {

		// vari�vel auxiliar para exibir os usu�rios cadastrados
		String mensagem = "";

		// vari�vel auxiliar
		boolean existe = false;

		// varrendo o vetor de usuarios para verificar se h� usu�rios cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - Usu�rio: " + usuarios[i].getNome() + " - C�digo: " + usuarios[i].getCodigo()
						+ "\n";
				existe = true;
			}
		}

		// exibindo os usu�rios cadastrados ao usu�rio
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Usu�rios Cadastrados", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o h� usu�rios cadastrados!", "Usu�rios Cadastrados", 2);
		}
	}

	// M�todo para pesquisar livros por editora
	public void pesquisarLivrosPorEditora() {

		// recebe do usu�rio a editora do livro para pesquisa
		String editora = JOptionPane.showInputDialog("Informe a Editora do(s) livro(s) para pesquisa:");

		// vari�vel auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por Editora:\n\n";

		// vari�vel auxiliar para verificar se a editora existe no cadastro
		boolean existe = false;

		// varre o vetor livros em busca da editora desejada pelo usu�rio
		for (int i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].getEditora().getNome().equals(editora))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa ao usu�rio
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa de livros por Editora:", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Esta editora n�o est� cadastrada em nossos sistemas.",
					"Pesquisa de livros por Editora:", 2);
		}
	}

	// M�todo para pesquisar livros por autor
	public void pesquisarLivrosPorAutor() {

		// recebe do usu�rio o autor do livro para pesquisa
		String autor = JOptionPane.showInputDialog("Informe o Autor do(s) livro(s) para pesquisa:");

		// vari�vel auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por Autor:\n\n";

		// vari�vel auxiliar para verificar se o autor existe no cadastro
		boolean existe = false;

		// varre o vetor livros em busca do autor desejado pelo usu�rio
		for (int i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].getAutor().getNome().equals(autor))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa ao usu�rio
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa de livros por Autor:", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Este autor n�o est� cadastrado em nossos sistemas.",
					"Pesquisa de livros por Autor:", 2);
		}
	}

	// M�todo para pesquisar o livro pela data de loca��o
	public void pesquisarLocacaoPorDataLocacao() {

		// declara um objeto do tipo Data
		Data dataPesquisa = new Data();

		// vari�vel auxiliar
		boolean teste = false;

		// vari�vel auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por data de loca��o:\n\n";

		// recebe a data de loca��o
		dataPesquisa.setDia(Integer.parseInt(
				JOptionPane.showInputDialog("Informe a data de loca��o dos livros que deseja pesquisar.\nDia:")));
		dataPesquisa.setMes(Integer.parseInt(JOptionPane.showInputDialog("M�s:")));
		dataPesquisa.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		// varre o vetor loca��o e atribui as loca��es a variavel mensagem
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getDataLocacao().toString().equals(dataPesquisa.toString()))) {
				mensagem += "C�digo da loca��o: " + locacoes[i].getCodigo() + " - Usu�rio: "
						+ locacoes[i].getUsuario().getNome() + "\n";
				teste = true;
			}
		}

		// exibe ao usu�rio o resultado da pesquisa
		if (teste) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por data de loca��o.", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o h� loca��es na data informada!", "Pesquisa por data de loca��o.",
					2);
		}
	}

	// M�todo para montar a mensagem do resultado das pesquisas ao usu�rio
	public String mensagem(Livro livro) {

		// vari�vel auxiliar para retornar a mensagem formada
		String msg = "\n";

		// montando a mensagem de retorno ao usu�rio
		msg += "C�digo: " + livro.getCodigo() + "\n";
		msg += "T�tulo: " + livro.getTitulo() + "\n";
		msg += "Editora: " + livro.getEditora().getNome() + "\n";
		msg += "Autor: " + livro.getAutor().getNome() + "\n";
		msg += "Ano de Publica��o: " + livro.getAnoPublicacao() + "\n";
		msg += "Dispon�vel: " + livro.disponibilidade(livro.isDisponivel()) + "\n";

		return msg;
	}

	// M�todo para sair do sistema
	public void sairSistema() {
		System.exit(0);
	}
}