package org.example;
    /*
        !IMPORTANTE!
              Os comentários serão feito para observações de linhas que possui algo especial
    */

import java.sql.*;
/*I mportante! Observar que ao importar recursos do SQL, ele importa TODOS os recursos do pacote atráves do caracter */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    /*
        COMENTARIO 001:
            "private" restringe o acesso da variável apenas à própria classe.
            "static" permite utilizar o Scanner sem criar um objeto da classe.
            Cria um único Scanner para receber dados digitados pelo usuário via teclado.
     */

    //  private static final String bd_URL = "";
    //	private static final String bd_URL = "jdbc:mysql://localhost:3306/usuario";

    private static final String bd_URL = "jdbc:mariadb://localhost:3306/bolos_fischboys";
    private static final String bd_Usuario = "root";
    private static final String bd_senha = "";
        /*
            COMENTARIO 002:
                Constantes utilizadas para armazenar as informações de conexão
                com o banco de dados.
         */

    public static void main(String[] args) {

        //Declarar e Iniciar variáveis do menu aqui
        boolean sairMenu = false;
        boolean operadorMenu = false;
        int opcaoMenu = 0;
        String digitarMenu = "";

        //Mensagem de Vindo ao Sistema
        System.out.println("============================");
        System.out.println("-- BEM VINDO AO SISTEMA --");
        System.out.println("============================");

        while(sairMenu == false){
        /*
            COMENTARIO 003:
        	 	Este Loop controla os Menus Gerenciais do sistema, ele funciona da seguinte maneira:
        	 		1 - digitarMenu = scan.nextLine()
        	 				Após o <Enter> , é atribuido um valor digitado para uma variavel tipo String,
        	 				que vai ser testado o valor.
        	 		2 -	operadorMenu = testarMenu(digitarMenu)
        	 				O teste do valor é dado através de uma funcao que retorna um booleano, onde: se o valor digitado
        	 		 		recebeu somente numero, ele atribui valor verdadeiro para a variavel.
        */
            System.out.println("=============MENU===========");
            System.out.println("1 - Gerenciar Cliente(s)");
            System.out.println("2 - Gerenciar Bolo(s)");
            System.out.println("3 - Gerenciar Venda(s)");
            System.out.println("4 - Sair");
            System.out.println("Selecione uma opção do Menu e pressione <Enter>:");
            digitarMenu = scan.nextLine();
            operadorMenu = testarMenu(digitarMenu);

            if(operadorMenu == true) {
                /*
                    COMENTARIO 004:
        		 	    Se a opção do menu foi digitado correta, é atribuido um valor inteiro para a variavel opcaoMenu.
        		 	    Sendo convertido o valor tipo String em Char (Unico caractere, pegando a primeira posicao 0) numerico,
        		 	    que será a opção do Menu.
        		 */
                opcaoMenu = Character.getNumericValue(digitarMenu.charAt(0));
                switch(opcaoMenu) {
                    case 1:
                        gerenciarCliente();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\n");
                        System.out.println("Deseja realmente sair do sistema? 1) Sim 2) Não");
                        System.out.println("Selecione uma opção do Menu e pressione <Enter>:");
                        digitarMenu = scan.nextLine();
                        operadorMenu = testarMenu(digitarMenu);
        				    /*
   					 		    COMENTARIO 005:
   					 			    Se a opção do Menu foi digitada correta, é questionado para o usuário se ele deseja sair.
   					 			    Se sim, vai entrar na próxima estrutura de condição, atribui o valor digitado para
   					 			    variável opcaoMenu, e se a opção for igual a 1, sai do sistema
        				    */
                        if(operadorMenu == true) {
                            opcaoMenu = Character.getNumericValue(digitarMenu.charAt(0));
                            if(opcaoMenu == 1) {
                                sairMenu = true;
                            }
                        }else{
                            System.out.println("\n");
                            System.out.println("Favor digitar somente numeros: " + " 1,2,3.." + "para a opção do Menu.");
                            System.out.println("Pressione <Enter> para continuar...");
                            scan.nextLine();
                        }

                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Opção invalida! favor tentar novamente.");
                        System.out.println("Pressione <Enter> para continuar...");
                        scan.nextLine();
                        break;
                }
            }else{
                System.out.println("\n");
                System.out.println("Favor digitar somente numeros: " + " 1,2,3.." + "para a opção do Menu.");
                System.out.println("Pressione <Enter> para continuar...");
                scan.nextLine();
            }
        }
        scan.close();
    }
    public static boolean testarMenu(String opcaoMenu) {
		/*
		  COMENTARIO 006:
				Testa o valor que o usuario digitou da seguinte maneira:
		  		Se o valor digitado for diferente de vazio E o valor digitado
		  		é somente numeros, atribui um valor de retorno VERDADEIRO
		 */
        boolean testarMenu = false;
        if(!opcaoMenu.isEmpty() && opcaoMenu.matches("\\d+")) {
            testarMenu = true;
        }
        return testarMenu;
    }
    public static void gerenciarCliente(){
        //Declaracao da Variaveis da Area gerenciar Cliente
        boolean sairMenuCliente = false;
        boolean operadorMenu = false;
        int opcaoMenu = 0;
        String digitarMenu = "";

        while(sairMenuCliente == false){
            /*
                COMENTARIO 007:
                    Este Loop controla os Menus Gerenciais do sistema, ele funciona da seguinte maneira:
                        1 - digitarMenu = scan.nextLine() Após o <Enter> , é atribuido um valor digitado
                            para uma variavel tipo String, que vai ser testado o valor.
                        2 -	operadorMenu = testarMenu(digitarMenu), o teste do valor é dado através de uma
                            funcao que retorna um booleano, onde: se o valor digitado recebeu somente numero,
                            ele atribui valor verdadeiro para a variavel.
             */


            System.out.println("=============GERENCIAR CLIENTE===========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Todos Clientes");
            System.out.println("3 - Buscar por (Nome) do Cliente");
            System.out.println("4 - Alterar dados do Cliente");
            System.out.println("5 - Deletar/Desativar Cliente");
            System.out.println("6 - <-- Voltar");
            System.out.println("Selecione uma opção do Menu e pressione <Enter>:");
            digitarMenu = scan.nextLine();
            operadorMenu = testarMenu(digitarMenu);

            if(operadorMenu == true) {
                 /*
                    COMENTARIO 008:
        		 	    Se a opção do Menu foi digitada correta, é atribuido um valor inteiro para a variavel opcaoMenu.
        		 	    Sendo convertido o valor tipo String em Char (Unico caractere, pegando a primeira posicao 0) numerico,
        		 	    que será a opção do Menu.
        		 */
                opcaoMenu = Character.getNumericValue(digitarMenu.charAt(0));
                switch(opcaoMenu) {
                    case 1:
                        cadastrarCliente();
                    break;
                    case 2:
                        listarCliente();
                    break;
                    case 3:
                        buscarCliente();
                    break;
                    case 6:
                        sairMenuCliente = true;
                        System.out.println(" <--- Voltando para o Menu Principal");
                        System.out.println("Selecione uma opção do Menu e pressione <Enter>:");
                        scan.nextLine();
                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Opção invalida! favor tentar novamente.");
                        System.out.println("Pressione <Enter> para continuar...");
                        scan.nextLine();
                        break;
                }
            }else{
                System.out.println("\n");
                System.out.println("Favor digitar somente numeros: " + " 1,2,3.." + "para a opção do Menu.");
                System.out.println("Pressione <Enter> para continuar...");
                scan.nextLine();
            }
        }


    }
    public static void buscarCliente(){
        String lista = "";
        String buscar = "";
        boolean conferirValor = false;

        System.out.println("\n");
        System.out.println("<<BUSCAR CLIENTE>>");
        System.out.println("Digite um nome para buscar as informações do cliente:");
        System.out.println("Pressione <Enter> para continuar...");
        buscar = scan.nextLine();

        conferirValor = testarValores(buscar,1);
        //Testa se o valor é correto, se sim, é atribuido a variavel nome o nome do usuário
        if(conferirValor == true) {
            String sql ="SELECT * FROM cliente where nome LIKE '" + buscar + "%'";

            try(Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){

                while(rs.next()){
                    boolean clienteAtivo = false;
                    String respoAtivo = "";

                    clienteAtivo = rs.getBoolean("ativo");

                    if(clienteAtivo == true) {
                        respoAtivo = "Ativo";
                    }else {
                        respoAtivo = "Desativado";
                    }
                    lista += " Nome: " + rs.getString("nome") + " | " + " Telefone: " + rs.getString("telefone") + " | " +
                            " Ativo: " + respoAtivo + "\n";
                }
            }catch (Exception e){
                System.out.println("FALHA ao BUSCAR a lista de cliente(s)! Favor entrar em contato com a equipe técnica. Pressione <Enter> para continuar:");
                scan.nextLine();
            }
            if(!lista.isEmpty()){
                System.out.println("<<LISTAR CLIENTES>>");
                System.out.println("\n");
                System.out.println(lista);
                System.out.println("Pressione <Enter> para continuar...");
                scan.nextLine();
            }else {
                System.out.println("Nenhum cliente encontrado! Pressione <Enter> para continuar");
                scan.nextLine();
            }
        }else {
            System.out.println("O nome deve conter apenas letras. Favor tentar novamente (Pressione <Enter> para continuar):");
            scan.nextLine();
        }
    }
    public static void listarCliente(){
        String lista = "";

        System.out.println("\n");
        System.out.println("Pressione <Enter> para Gerar a Lista de Clientes:");
        scan.nextLine();

        lista = listCliente(2);

        if(!lista.isEmpty()){
            System.out.println("<<LISTAR CLIENTES>>");
            System.out.println("\n");
            System.out.println(lista);
            System.out.println("Pressione <Enter> para continuar...");
            scan.nextLine();
        }else {
            System.out.println("Nenhum cliente encontrado! Pressione <Enter> para continuar");
            scan.nextLine();
        }

    }
    public static String listCliente(int tipoLista){
        /*
            COMENTARIO 009:
 				O método lisCliente serve para listar os clientes conforme o tipo de passagem de parâmetros, onde:
 				      1 - Lista Resumida somente com Numero de Cadastro e Nome
 				      2 - Lista Completa com todos os dados do cliente
        */

        String resultado = "";
        String sql ="SELECT * FROM cliente";

        try(Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                boolean clienteAtivo = false;
                String respoAtivo = "";

                clienteAtivo = rs.getBoolean("ativo");

                if(clienteAtivo == true) {
                    respoAtivo = "Ativo";
                }else {
                    respoAtivo = "Desativado";
                }
                switch (tipoLista){
                    case 1:
                        resultado += " Nome: " + rs.getString("nome") + " | " +
                                " Ativo: " + respoAtivo + "\n";
                    break;
                    case 2:
                        resultado += " Nome: " + rs.getString("nome") + " | " + " Telefone: " + rs.getString("telefone") + " | " +
                                " Ativo: " + respoAtivo + "\n";
                    break;
                    default:
                        System.out.println("Opção invalida! Favor verificar a passagem de parâmetros em listCliente().");
                    break;
                }


            }

        }catch (Exception e){
            System.out.println("FALHA ao fazer a lista de cliente(s)! Favor entrar em contato com a equipe técnica. Pressione <Enter> para continuar:");
            scan.nextLine();
        }


        return resultado;
    }
    public static void cadastrarCliente(){
        /*
 			COMENTARIO 009:
 				O método cadastrarCliente serve para cadastrar as informações do cliente, que são:
 				nome e telefone, conforme condições exigidas para o usário

		 */

        //Variáveis que irão auxiliar e testar valores inseridos
        String testarValor = "";
        boolean conferirValor = false;

        //Variáveis que irão atribuir valores inseridos após verificação
        String nome = ""; //Não pode conter mais do que 100 caracteres e tem que ser somente letras
        String telefone = ""; // Não pode conter mais do que 20 caracteres e deve ser somente numeros

        //PRIMEIRO TESTE -> Nome do Usuário
        while(conferirValor == false) {
            // Só sairá do loop quando o valor de nome do usuário for correto
            System.out.println("\n");
            System.out.println("<<CADASTRAR CLIENTE>>");
            System.out.println("Digite o nome do usuário (Pressione <Enter> para continuar):");
            testarValor = scan.nextLine();

            conferirValor = testarValores(testarValor,1);
            //Testa se o valor é correto, se sim, é atribuido a variavel nome o nome do usuário
            if(conferirValor == true) {
                nome = testarValor;
            }else {
                System.out.println("Valor infomado é inválido. Favor tentar novamente (Pressione <Enter> para continuar):");
                scan.nextLine();
            }
        }
        testarValor = "";
        conferirValor = false;
        while(conferirValor == false) {
            // Só sairá do loop quando o valor de telefone do usuário for correto
            System.out.println("\n");
            System.out.println("<<CADASTRAR CLIENTE>>");
            System.out.println("Digite o Telefone do cliente (SOMENTE NUMEROS) (Pressione <Enter> para continuar):");
            testarValor = scan.nextLine();

            conferirValor = testarValores(testarValor, 2);
            //Testa se o valor é correto, se sim, é atribuido a variavel email o e-mail do usuário

            if(conferirValor == true) {
                telefone = testarValor;
            }else {
                System.out.println("Valor infomado é inválido. Favor tentar novamente (Pressione <Enter> para continuar):");
                scan.nextLine();
            }
        }
        /*
			COMENTARIO 010:
				Após confirmar que todas as informações digitadas estão corretas, é possível a inserir no banco de dados
				os valores do usuário que se deseja cadastrar
		*/
        // IMPORTANTE! É INCIADO E ATRIBUIDO na a varável sql o comando de SQL para inserção dos dados
        String sql ="INSERT INTO cliente(nome,telefone,ativo) VALUES(?,?,?)";
        try(Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            /*
             	COMENTARIO 011:
             		Bloco responsável por executar a operação de inserção do usuário no banco de dados.
             		O try-with-resources cria automaticamente os objetos Connection e PreparedStatement,
             		garantindo que ambos sejam fechados ao final da execução, mesmo em caso de erro.

 					Os métodos setString() associam os valores informados aos parâmetros da instrução SQL,
 					substituindo os caracteres '?' presentes na consulta.

 					Em seguida, executeUpdate() executa o comando SQL e retorna a quantidade de registros
 					afetados pela operação. Caso ao menos uma linha seja inserida, uma mensagem de sucesso
 					é exibida ao usuário.

 					 Se ocorrer qualquer exceção durante o processo, a falha é informada e a exceção é encapsulada
 					 em uma RuntimeException para tratamento posterior.

 					 !IMPORTANTE!
 					 PreparedStatement stmt = conn.prepareStatement(sql) faz duas coisas, compila e prepara o SQL
 					 antes da execução e protege contra o SQL Injection,
             */
            stmt.setString(1,nome);
            stmt.setString(2,telefone);
            stmt.setBoolean(3,true);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas>0){
                System.out.println("Cliente salvo com SUCESSO! Pressione <Enter> para continuar:");
                scan.nextLine();
            }
        } catch (Exception e) {
            System.out.println("FALHA ao salvar cliente! Favor entrar em contato com a equipe técnica. Pressione <Enter> para continuar:");
            scan.nextLine();
            throw new RuntimeException(e);
        }
    }
    public static boolean testarValores(String testarValor, int tipoTesteValor) {
        /*
			COMENTARIO 012:
				Método responsável por validar os dados informados pelo usuário antes de serem gravados ou consultados no banco de dados.
				O parâmetro "testarValor" contém o valor digitado pelo usuário.
				O parâmetro "tipoTesteValor" define qual regra de validação será aplicada.
				Tipos de validação:
					1 - Nome: Aceita apenas letras e espaços e até 100 caracteres.
					5 - Telefone: Aceita apenas números com até 20 caracteres.
					Retorno: Retona se o valor é verdadeiro ou não

		 */
        boolean retornarValor = false;

        switch (tipoTesteValor) {
            case 1:
                //Testa uma variável tipo String: se ela é diferente de vazia, se ela é menor e igual a 100 caracteres e se tem somente letras e espaço
                if (!testarValor.isEmpty() && testarValor.length() <= 100 && testarValor.matches("[\\p{L} ]+")) {
                    retornarValor = true;
                }
                break;
            case 2:
                //Testa uma variável tipo String: se ela é diferente de vazia, se ela é menor e igual a 20 caracteres e se tem somente numeros
                if(!testarValor.isEmpty() && testarValor.length() <= 20 && testarValor.matches("\\d+")) {
                    retornarValor = true;
                }
                break;
            default:
                System.out.println("Opção invalida! Favor verificar a passagem de parâmetros em testarValores().");
                break;
        }
        return retornarValor;
    }
    private static Connection conectar() throws SQLException {
		 /*
			COMENTARIO 013:
			 Realiza a conexão com o banco de dados utilizando as credenciais
			 configuradas e retorna um objeto Connection para execução das
			 operações de acesso aos dados.
		*/
        return DriverManager.getConnection(bd_URL,bd_Usuario,bd_senha);
    }
}