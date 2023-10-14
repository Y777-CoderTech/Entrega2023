package com.tperfect_trip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comtperfect_trip.model.Cliente;


public class ClienteDAO {

	
	
private static String sql;
	
	private final Connection connection;
	
	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	//CREAT
		public void CreateCliente(Cliente cliente) {
			sql = "INSERT INTO cliente(nomeCliente, cpfCliente, rgCliente, telefoneCliente) VALUES (?,?,?,?)";
			try(PreparedStatement stmt = connection.prepareStatement(sql)){
			   stmt.setString(1, cliente.getNomeCliente());
			   stmt.setString(2, cliente.getCpfCliente());
			   stmt.setString(3, cliente.getRgCliente());
			   stmt.setString(4, cliente.getTelefoneCliente());
			;
			   stmt.executeUpdate();
			   System.out.println("Cliente criado com sucesso!");
			   System.out.printf("ID: %s\n Nome: %s\n CPF: %s\n RG: %s\n Telefone %s\n",
						 cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getRgCliente(), cliente.getTelefoneCliente());
			    
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	   //READ
		public void readAllClients(){
			sql = "SELECT * FROM cliente";
			try(PreparedStatement stmt = connection.prepareStatement(sql)){
				   ResultSet r = stmt.executeQuery();
				   while(r.next()) {
					 Cliente cliente = new Cliente();
					 cliente.setIdCliente(r.getInt("idCliente"));
					 cliente.setNomeCliente(r.getString("nomeCliente"));
					 cliente.setCpfCliente(r.getString("cpfCliente"));
					 cliente.setRgCliente(r.getString("rgCliente"));
					 cliente.setTelefoneCliente(r.getString("TelefoneCliente"));
					 
					 System.out.printf("ID: %s\n Nome: %s\n Cpf: %s\n Rg: %s\n Telefone: %s\n",
							 cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getRgCliente(), cliente.getTelefoneCliente());
				   }if(!r.next()) {
					   System.out.println("Não tem mais dados!");   
				      }
			       }catch(SQLException e) {
					System.out.println("Não foi possível verificar informações .Mensagem: " + e.getMessage());
				}
		}
		
	     //UPDATE
		public void updateCliente(Cliente cliente) {
			sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, rgCliente = ?, telefoneCliente = ? WHERE idCliente = ?";
	        try(PreparedStatement stmt = connection.prepareStatement(sql)){
	        	stmt.setString(1, cliente.getNomeCliente());
	 		    stmt.setString(2, cliente.getCpfCliente());
	 		    stmt.setString(3, cliente.getRgCliente());
	 		    stmt.setString(4, cliente.getTelefoneCliente());
	 		    stmt.setInt(5, cliente.getIdCliente());
	 		   
	 		  System.out.printf("\n\nID: %d\n Nome: %s\n Cpf: %s\n Rg: %s\n Telefone: %s\n ",
						 cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getRgCliente(), cliente.getTelefoneCliente());
	 		    stmt.executeUpdate();
	        	
	        }catch(SQLException e) {
	        	System.out.println("Não foi possível atualizar" + e.getMessage());
	        	
	        }
		}
		//DELETE
	    public void deleteCliente(int id){
	    	sql = "DELETE FROM cliente WHERE idCliente = ?";
	    	try(PreparedStatement stmt = connection.prepareStatement(sql)){ 
	    		stmt.setInt(1, id);
	    		stmt.execute();
	    		
	    		System.out.println("\n\nCliente deletado\n\n");
	    		
	    	}catch (SQLException e) {
	    		System.out.println("Não foi possível Deletar" + e.getMessage());
	    		
	    	}
	    }
		
	}


