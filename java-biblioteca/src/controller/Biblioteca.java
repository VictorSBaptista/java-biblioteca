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

	// variáveis auxiliares para definição pelo usuário os tamanhos dos vetores
	private int tamanhoLivros;
	private int tamanhoUsuarios;
	private int tamanhoLocacoes;

	// Método construtor da classe
	public Biblioteca() {
		processar();
	}

	// Método principal para executar a classe
	public void processar() {

		// capturando o tamanho do vetor Livros
		tamanhoLivros = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros a biblioteca comporta"));

		// capturando o tamanho do vetor Usuarios
		tamanhoUsuarios = Integer
				.parseInt(JOptionPane.showInputDialog("Informe quantos usuários a biblioteca comporta"));

		// capturando o tamanho do vetor Locações
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

	// Método para capturar a escolha do usuário
	public void escolhaUsuario() {

		// menu do usuário
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(
				"Informe a opção desejada:\n\n" + "OPÇÃO 1 : Cadastrar Livro\n" + "OPÇÃO 2 : Cadastrar Usuário\n"
						+ "OPÇÃO 3 : Locação de Livro\n" + "OPÇÃO 4 : Devolução de livro\n"
						+ "OPÇÃO 5 : Listar Livros Cadastrados\n" + "OPÇÃO 6 : Listar Usuários Cadastrados\n"
						+ "OPÇÃO 7 : Pesquisar Livros por Editora\n" + "OPÇÃO 8 : Pesquisar Livros por Autor\n"
						+ "OPÇÃO 9 : Pesquisar Livros por Data da Locação\n" + "OPÇÃO 10 : Sair do Programa\n"));

		// envia para o método escolhaProcessamento a opção desejada pelo usuário
		escolhaProcessamento(escolha);
	}

	// Método para seleção das opções do programa
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
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Menu Biblioteca", 0);
			break;
		}
	}

	// Métodos para o cadastro de livros
	public void cadastrarLivro() {

		// variável auxiliar para verificar se o livro foi cadastrado
		boolean cadastrado = false;

		// verifica o espaço do vetor livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				livros[i] = criarLivro();
				cadastrado = true;
				break;
			}
		}

		// informa ao usuário se o cadastro foi realizado com sucesso ou não
		if (cadastrado) {
			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro de Livros", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"___________ERROR_________" + "\n\nA biblioteca não comporta mais livros.", "Cadastro de Livros",
					2);
		}
	}

	// Método para criar e retornar um livro para efetuar o cadastro
	public Livro criarLivro() {
		Autor autor = new Autor();
		Editora editora = new Editora();
		Livro livro = new Livro();

		// Recebe do usuário dados relacionados ao Autor
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do Autor:")));
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do Autor:"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do Autor:"));

		// Recebe do usuário dados relacionados a Editora
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código da Editora:")));
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da Editora:"));
		editora.setPais(JOptionPane.showInputDialog("Informe o país em que a Editora está localizada:"));

		// Recebe do usuário dados relacionados ao livro
		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do Livro:")));
		livro.setTitulo(JOptionPane.showInputDialog("Informe o título do Livro:"));
		livro.setEditora(editora);
		livro.setAutor(autor);
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publicação do Livro:")));
		livro.setDisponivel(true);

		return livro;
	}

	// Método para o cadastro de usuários
	public void cadastrarUsuario() {

		// variável auxiliar para verificar se o usuário foi cadastrado
		boolean cadastrado = false;

		// verifica o espaço do vetor usuários
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				cadastrado = true;
				break;
			}
		}

		// informa ao usuário se o cadastro foi realizado com sucesso ou não
		if (cadastrado) {
			// JOptionPane.showConfirmDialog(null, "Usuário cadastrado com sucesso!",
			// "Cadastro de Usuários", 1);
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro de Usuários", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"___________ERROR_________" + "\n\nA biblioteca não comporta mais usuários.",
					"Cadastro de Usuários", 2);
		}
	}

	// Método para criar e retornar um usuário para efetuar o cadastro
	public Usuario criarUsuario() {
		Data data = new Data();
		Usuario usuario = new Usuario();

		// Recebe do usuário dados relacionados ao usuário
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código de registro do Usuário:")));
		usuario.setNome(JOptionPane.showInputDialog("Informe o nome completo do Usuário:"));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o número de telefone do Usuário:"));
		usuario.setEmail(JOptionPane.showInputDialog("Informe o email do Usuário:"));

		// Recebe do usuário dados relacionados a data
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe a data de nascimento do usuário!\nDia:")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Mês:")));
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		usuario.setDataNacimento(data);

		return usuario;
	}

	// Método para processar a locação de livros
	public void efetuarLocacaoLivro() {

		// variável auxiliar para utilizar para testar usuários e livros disponíveis
		boolean teste = false;

		// variável auxiliar para verificar se o livro no cadastro está locado
		boolean locado = false;

		// For para verificar se há usuários cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				teste = true;
			}
		}

		if (teste) {// se encontrou algum usuário
			// zera a variável de teste para reutilização
			teste = false;
			// varre o vetor de livros para verificar se há livros disponíveis
			for (int i = 0; i < livros.length; i++) {
				if ((livros[i] != null) && (livros[i].isDisponivel())) {
					teste = true;
				}
			}

			// Caso exista livro cadastrado e disponível
			if (teste) {
				// varre o vetor de locação e efetua a locação
				for (int i = 0; i < locacoes.length; i++) {
					if (locacoes[i] == null) {
						locacoes[i] = criarLocacao();
						locado = true;
						break;
					}
				}

				// exibe o resultado da locação ao usuário
				if (locado) {
					JOptionPane.showMessageDialog(null, "Livro locado com sucesso.", "Locação de Livros", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação.", "Locação de Livros", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Não há livros disponíveis.", "Locação de Livros", 2);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Não há usuários cadastrados.", "Locação de Livros", 2);
		}

	}

	// Método para criar uma locação para efetuar o cadastro
	public Locacao criarLocacao() {

		// declaração do objeto que será retornado
		Locacao locacao = new Locacao();

		// vetor de livros que o usuário deseja locar
		Livro emprestimos[];

		// variável para realizar todos os testes da classe locação
		boolean teste = false;

		// quantidade de livros que o usuário deseja
		int tamanho = 0;

		// comparação com a quantidade de livros
		int contador = 0;

		// variável para receber código
		int codigo;

		// recebe do usuário o código de locação
		do {
			// reseta a variável teste
			teste = false;

			// recebe do usuário o código de locação
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código de locação:"));

			// varre o vetor de locações em busca do código informado
			for (int i = 0; i < locacoes.length; i++) {
				if ((locacoes[i] != null) && (locacoes[i].getCodigo() == codigo)) {
					teste = true;
				}
			}

			// exibe ao usuário o caso o código de locação informado já existe
			if (teste) {
				JOptionPane.showMessageDialog(null, "Código inválido!", "Locação de livros", 2);
			}

		} while (teste);

		// atribui o codigo de locação
		locacao.setCodigo(codigo);

		// loop para receber as informções do usuário
		do {
			// Recebe o código do usuário que deseja realizar a locação
			codigo = Integer.parseInt(
					JOptionPane.showInputDialog("Informe o código do usuário que deseja realizar a locação:"));

			// for para verificar se existe o código do usuário digitado
			for (int i = 0; i < usuarios.length; i++) {
				if ((usuarios[i] != null) && (usuarios[i].getCodigo() == codigo)) {
					locacao.setUsuario(usuarios[i]);
					teste = true;
				}
			}

			// informa ao usuário que o código não é válido
			if (!teste) {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Locação de Livros", 0);
			}
		} while (!teste);

		// reseta a variável teste
		teste = false;

		// loop para receber as informações dos livros que o usuário deseja locar
		do {
			// recebe a quantidade de livros que o usuário deseja
			tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros o usuário deseja locar:"));

			// verifica se a quantidade de livros desejada é válida
			if (tamanho > 0) {
				// varre o vetor de livros verificando a quantidade de livros disponíveis
				for (int i = 0; i < livros.length; i++) {
					if ((livros[i] != null) && (livros[i].isDisponivel())) {
						contador++;
					}
				}

				// verifica se exite uma quantidade de livros disponíveis maior ou igual a
				// quantidade desejada pelo usuário
				if (contador >= tamanho) {
					teste = true;
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade inválida!", "Locação de Livros", 0);
					contador = 0;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Quantidade inválida!", "Locação de Livros", 0);
			}

		} while (!teste);

		// atribui o tamanho ao vetor de emprestimo
		emprestimos = new Livro[tamanho];

		// reseta o contador
		contador = 0;

		// solicita os livros para empréstimo
		do {
			// reseta a variável teste
			teste = false;

			// recebe do usuário o código do livro
			codigo = Integer
					.parseInt(JOptionPane.showInputDialog("Informe o código do livro que o usuário deseja locar:"));

			// valida o código digitado pelo usuário
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
						JOptionPane.showMessageDialog(null, "Livro indisponível!", "Locação de Livros", 0);
					}
				}
			}

			// informa ao usuário caso o código informado seja inválido
			if (!teste) {
				JOptionPane.showMessageDialog(null, "Código inválido!", "Locação de Livros", 0);
			}

		} while (contador != tamanho);

		// efetua a locação
		locacao.setLivros(emprestimos);

		// recebendo a data atual do sistema
		LocalDateTime relogio = LocalDateTime.now();

		// declara os objetos de data
		Data dataLocacao = new Data();
		Data dataDevolucao = new Data();

		// atribuindo a data atual na data de locação
		dataLocacao.setDia(relogio.getDayOfMonth());
		dataLocacao.setMes(relogio.getMonthValue());
		dataLocacao.setAno(relogio.getYear());

		// atribuindo a data de locação na locação
		locacao.setDataLocacao(dataLocacao);

		// recebe do usuário a data de devolução dos livros
		dataDevolucao.setDia(Integer.parseInt(
				JOptionPane.showInputDialog("Informe a data que o usuário irá devolver os livros locados.\nDia:")));
		dataDevolucao.setMes(Integer.parseInt(JOptionPane.showInputDialog("Mês:")));
		dataDevolucao.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		// atribuindo a data de devolução na devolução
		locacao.setDataDevolucao(dataDevolucao);

		// retorna o objeto de locação
		return locacao;
	}

	// Método para processar a devolução de livros
	public void efetuarDevolucaoLivro() {

		// recebe o código de locação
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da locação:"));

		// variável auxiliar para gravar a posição do vetor locação
		int posicao = 0;

		// variável auxiliar para testes
		boolean teste = false;

		// verifica se existe uma locação com o código informado
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getCodigo() == codigo)) {
				teste = true;
				posicao = i;
			}
		}

		// efetua a devolução
		if (teste) {
			// declara e instancia o vetor devolução com o tamanho igual a quantidade de
			// livros que foram locados pelo usuário
			Livro devolucao[] = new Livro[locacoes[posicao].getLivros().length];

			// atribui os livros a serem devolvido ao vetor devolução
			devolucao = locacoes[posicao].getLivros();

			// varre o vetor de devolução e vetor de livros e reseta os livros para
			// disponível
			for (int i = 0; i < devolucao.length; i++) {
				for (int j = 0; j < livros.length; j++) {
					if (livros[j].getCodigo() == devolucao[i].getCodigo()) {
						livros[j].setDisponivel(true);
					}
				}
			}

			// reseta o vetor de locação na posição correta
			locacoes[posicao] = null;

			// exibe o resultado da devolução
			JOptionPane.showMessageDialog(null, "Devolução concluída!", "Devolução de Livros", 1);

		} else {
			JOptionPane.showMessageDialog(null, "Código de locação inválido!", "Devolução de Livros", 0);
		}
	}

	// Método para listar os livros cadastrados
	public void listarLivrosCadastrados() {

		// variável auxiliar para exibir os livros cadastrados
		String mensagem = "";

		// variável auxiliar
		boolean existe = false;

		// varrendo o vetor de livros para verificar se há livros cadastrados
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += (i + 1) + " - Título: " + livros[i].getTitulo() + " - Código: " + livros[i].getCodigo()
						+ " - Disponível: " + livros[i].disponibilidade(livros[i].isDisponivel()) + "\n";
				existe = true;
			}
		}

		// exibindo os livros cadastrados ao usuário
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Livros Cadastrados", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não há livros cadastrados!", "Livros Cadastrados", 2);
		}
	}

	// Método para listar os usuarios cadastrados
	public void listarUsuariosCadastrados() {

		// variável auxiliar para exibir os usuários cadastrados
		String mensagem = "";

		// variável auxiliar
		boolean existe = false;

		// varrendo o vetor de usuarios para verificar se há usuários cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - Usuário: " + usuarios[i].getNome() + " - Código: " + usuarios[i].getCodigo()
						+ "\n";
				existe = true;
			}
		}

		// exibindo os usuários cadastrados ao usuário
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Usuários Cadastrados", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não há usuários cadastrados!", "Usuários Cadastrados", 2);
		}
	}

	// Método para pesquisar livros por editora
	public void pesquisarLivrosPorEditora() {

		// recebe do usuário a editora do livro para pesquisa
		String editora = JOptionPane.showInputDialog("Informe a Editora do(s) livro(s) para pesquisa:");

		// variável auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por Editora:\n\n";

		// variável auxiliar para verificar se a editora existe no cadastro
		boolean existe = false;

		// varre o vetor livros em busca da editora desejada pelo usuário
		for (int i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].getEditora().getNome().equals(editora))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa ao usuário
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa de livros por Editora:", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Esta editora não está cadastrada em nossos sistemas.",
					"Pesquisa de livros por Editora:", 2);
		}
	}

	// Método para pesquisar livros por autor
	public void pesquisarLivrosPorAutor() {

		// recebe do usuário o autor do livro para pesquisa
		String autor = JOptionPane.showInputDialog("Informe o Autor do(s) livro(s) para pesquisa:");

		// variável auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por Autor:\n\n";

		// variável auxiliar para verificar se o autor existe no cadastro
		boolean existe = false;

		// varre o vetor livros em busca do autor desejado pelo usuário
		for (int i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].getAutor().getNome().equals(autor))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa ao usuário
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa de livros por Autor:", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Este autor não está cadastrado em nossos sistemas.",
					"Pesquisa de livros por Autor:", 2);
		}
	}

	// Método para pesquisar o livro pela data de locação
	public void pesquisarLocacaoPorDataLocacao() {

		// declara um objeto do tipo Data
		Data dataPesquisa = new Data();

		// variável auxiliar
		boolean teste = false;

		// variável auxiliar para exibir resultado da pesquisa
		String mensagem = "Pesquisa por data de locação:\n\n";

		// recebe a data de locação
		dataPesquisa.setDia(Integer.parseInt(
				JOptionPane.showInputDialog("Informe a data de locação dos livros que deseja pesquisar.\nDia:")));
		dataPesquisa.setMes(Integer.parseInt(JOptionPane.showInputDialog("Mês:")));
		dataPesquisa.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano:")));

		// varre o vetor locação e atribui as locações a variavel mensagem
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getDataLocacao().toString().equals(dataPesquisa.toString()))) {
				mensagem += "Código da locação: " + locacoes[i].getCodigo() + " - Usuário: "
						+ locacoes[i].getUsuario().getNome() + "\n";
				teste = true;
			}
		}

		// exibe ao usuário o resultado da pesquisa
		if (teste) {
			JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por data de locação.", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não há locações na data informada!", "Pesquisa por data de locação.",
					2);
		}
	}

	// Método para montar a mensagem do resultado das pesquisas ao usuário
	public String mensagem(Livro livro) {

		// variável auxiliar para retornar a mensagem formada
		String msg = "\n";

		// montando a mensagem de retorno ao usuário
		msg += "Código: " + livro.getCodigo() + "\n";
		msg += "Título: " + livro.getTitulo() + "\n";
		msg += "Editora: " + livro.getEditora().getNome() + "\n";
		msg += "Autor: " + livro.getAutor().getNome() + "\n";
		msg += "Ano de Publicação: " + livro.getAnoPublicacao() + "\n";
		msg += "Disponível: " + livro.disponibilidade(livro.isDisponivel()) + "\n";

		return msg;
	}

	// Método para sair do sistema
	public void sairSistema() {
		System.exit(0);
	}
}