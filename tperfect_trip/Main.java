package com.tperfect_trip;

import java.util.Scanner;

import com.tperfect_trip.dao.ClienteDAO;
import com.tperfect_trip.dao.UsuarioDAO;
import com.tperfect_trip.dao.ViagemDAO;
import com.tperfect_trip.database.DatabaseConnection;
import comtperfect_trip.model.Cliente;
import comtperfect_trip.model.Viagem;
import comtperfect_trip.model.Usuario;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			var connection = DatabaseConnection.createConnection();
			UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
			ClienteDAO clienteDAO = new ClienteDAO(connection);
            ViagemDAO  viagemDAO  = new ViagemDAO(connection);
			
			
			
			int option = 0;
			
			
			do {
				System.out.println("Finalizando");
						
						
				System.out.println("1Escolha uma opção  de 1 - 13\n"
						+ "1 - Create\n"
			             + "2 - Read\n"
			             + "3 - Update\n"
			             + "4 - Delete\n"
			             + "Escolha uma opção  de 5 - 9\n"
			             + "5 - Create\n"
						 + "6 - Read\n"
				         + "7 - Update\n"
				         + "8 - Delete\n"
				         + "Escolha uma opção de 9 - 13\n"
				         + "9  - Create\n"
						 + "10 - Read\n"
				         + "11 - Update\n"
				         + "12 - Delete\n"
				         + "13 - Sair\n");
						option = scanner.nextInt();
						
						switch (option) {
						case 1:
							scanner.nextLine();
							Usuario usuario = new Usuario();
							System.out.println("Nome Completo: ");
							usuario.setNomeUsuario(scanner.nextLine());	
							System.out.println("Senha: ");		
							usuario.setSenhaUsuario(scanner.nextLine());
							System.out.println("Tipo de Acesso: ");
							usuario.setTipoAcesso(scanner.nextLine());
							
					      usuarioDAO.CreateUsuario(usuario);
							
							
							break;
						case 2:
							usuarioDAO.readAllUsers();
							break;
						case 3:
							Usuario usuarioAtualizado = new Usuario();
							System.out.println("Digite o ID do Usuario a ser atualizado: ");
							usuarioAtualizado.setIdUsuario(scanner.nextInt());
							scanner.nextLine();
							System.out.println("Nome Completo: ");
							usuarioAtualizado.setNomeUsuario(scanner.nextLine());
							System.out.println("Senha: ");
							usuarioAtualizado.setSenhaUsuario(scanner.nextLine());
							System.out.println("Tipo de Acesso: ");
							usuarioAtualizado.setTipoAcesso(scanner.nextLine());
							
							usuarioDAO.updateUsuario(usuarioAtualizado);
						   break;
						
						case 4:
							 
							System.out.println("Digite o Id DO usuario a ser Deletado!");
							int idUsuario = scanner.nextInt();
							usuarioDAO.deleteUsuario(idUsuario);
							break;
							
							
						case 5:
							scanner.nextLine();
							Cliente cliente = new Cliente();
							System.out.println("Nome Completo: ");
							cliente.setNomeCliente(scanner.nextLine());	 
							System.out.println("Rg: ");		
							cliente.setRgCliente(scanner.nextLine());
							System.out.println("Cpf: ");
							cliente.setCpfCliente(scanner.nextLine());
							System.out.println("Telefone: ");
							cliente.setTelefoneCliente(scanner.next());
							
					      clienteDAO.CreateCliente(cliente);
							
							
							break;
						case 6:  
							clienteDAO.readAllClients();
							break;
						case 7:
							Cliente clienteAtualizado = new Cliente();
							System.out.println("Digite o ID do Cliente a ser atualizado: ");
							clienteAtualizado.setIdCliente(scanner.nextInt());
							scanner.nextLine();
							System.out.println("Nome Completo: ");
							clienteAtualizado.setNomeCliente(scanner.nextLine());
							System.out.println("Rg: ");
							clienteAtualizado.setRgCliente(scanner.nextLine());
							System.out.println("Cpf: ");
							clienteAtualizado.setCpfCliente(scanner.nextLine());
							System.out.println("Telefone: ");
							clienteAtualizado.setTelefoneCliente(scanner.nextLine());
							
							clienteDAO.updateCliente(clienteAtualizado);
						   break;
						
						case 8:
							 
							System.out.println("Digite o Id do cliente a ser Deletado!");
							int idCliente = scanner.nextInt();
							clienteDAO.deleteCliente(idCliente);
						 
						case 9:
							scanner.nextLine();
							Viagem viagem = new Viagem();
							System.out.println("Nome de Origem: ");
							viagem.setOrigemViagem(scanner.nextLine());	 
							System.out.println("Nome do Destino: ");		
							viagem.setDestinoViagem(scanner.nextLine());
							System.out.println("Data: ");
							viagem.setDataViagem(scanner.nextLine());
							System.out.println("Hora: ");
							viagem.setHoraViagem(scanner.nextLine());
							
					      viagemDAO.CreateViagem(viagem);
							
							
							break;
						case 10:  
							viagemDAO.readAllViagens();
							break;
						case 11:
							Viagem viagemAtualizado = new Viagem();
							System.out.println("Digite o ID da Viagem a ser atualizado: ");
							viagemAtualizado.setIdViagem(scanner.nextInt());
							scanner.nextLine();
							System.out.println("Origem da Viagem: ");
							viagemAtualizado.setOrigemViagem(scanner.nextLine());
							System.out.println("Destino da Viagem: ");
							viagemAtualizado.setDestinoViagem(scanner.nextLine());
							System.out.println("Data: ");
							viagemAtualizado.setDataViagem(scanner.nextLine());
							System.out.println("Hora: ");
							viagemAtualizado.setHoraViagem(scanner.nextLine());
							
							viagemDAO.updateViagem(viagemAtualizado);
						   break;
						
						case 12:
							 
							System.out.println("Digite o Id da Viagem a ser Deletado!");
							int idViagem = scanner.nextInt();
							viagemDAO.deleteViagem(idViagem);
						}
						
			

			
			     } while (option !=13);
			
			
			} 
			
		
		
	}
	
	}
	
	

