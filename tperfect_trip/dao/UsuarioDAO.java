package com.tperfect_trip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comtperfect_trip.model.Usuario;

public class UsuarioDAO {

	
	private static String sql;
	
	private final Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	//CREAT
	public void CreateUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario(nomeUsuario, senhaUsuario, tipoAcesso) VALUES (?,?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
		   stmt.setString(1, usuario.getNomeUsuario());
		   stmt.setString(2, usuario.getSenhaUsuario());
		   stmt.setString(3, usuario.getTipoAcesso());
		   
		   stmt.executeUpdate();
		   System.out.println("Usuário criado com sucesso!");
		   System.out.printf("ID: %s\n Nome: %s\n Senha: %s\n Tipo: %s\n",
					 usuario.getIdUsuario(), usuario.getNomeUsuario(), usuario.getSenhaUsuario(), usuario.getTipoAcesso());
		    
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
   //READ
	public void readAllUsers(){
		sql = "SELECT * FROM usuario";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			   ResultSet r = stmt.executeQuery();
			   while(r.next()) {
				 Usuario usuario = new Usuario();
				 usuario.setIdUsuario(r.getInt("idUsuario"));
				 usuario.setNomeUsuario(r.getString("nomeUsuario"));
				 usuario.setSenhaUsuario(r.getString("senhaUsuario"));
				 usuario.setTipoAcesso(r.getString("tipoAcesso"));
				 
				 System.out.printf("ID: %s\n Nome: %s\n Senha: %s\n Tipo: %s\n",
						 usuario.getIdUsuario(), usuario.getNomeUsuario(), usuario.getSenhaUsuario(), usuario.getTipoAcesso());
			   }
			   if(!r.next()) {
				   System.out.println("Não tem mais dados!");
			   }
			   
			}catch(SQLException e) {
				System.out.println("Não foi possível verificar informações .Mensagem: " + e.getMessage());
			}
        }
     //UPDATE
	public void updateUsuario(Usuario usuario) {
		sql = "UPDATE usuario SET nomeUsuario = ?, senhaUsuario = ?,tipoAcesso = ? WHERE idUsuario = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
        	stmt.setString(1, usuario.getNomeUsuario());
 		    stmt.setString(2, usuario.getSenhaUsuario());
 		    stmt.setString(3, usuario.getTipoAcesso());
 		    stmt.setInt(4, usuario.getIdUsuario());
 		      
 		   System.out.printf("\n\nID: %d\n Nome: %s\n Senha: %s\n Tipo: %s\n",
					 usuario.getIdUsuario(), usuario.getNomeUsuario(), usuario.getSenhaUsuario(), usuario.getTipoAcesso());
 		    stmt.executeUpdate();
        	
        }catch(SQLException e) {
        	System.out.println("Não foi possível atualizar" + e.getMessage());
        	
        }
	}
	//DELETE
    public void deleteUsuario(int id){
    	sql = "DELETE FROM usuario WHERE idUsuario = ?";
    	try(PreparedStatement stmt = connection.prepareStatement(sql)){ 
    		stmt.setInt(1, id);
    		stmt.execute();
    		
    		System.out.println("\n\nUsuario deletado\n\n");
    		
    	}catch (SQLException e) {
    		System.out.println("Não foi possível Deletar" + e.getMessage());
    		
    	}
    }
	
}



