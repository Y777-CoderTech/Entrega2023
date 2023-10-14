package com.tperfect_trip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import comtperfect_trip.model.Viagem;

public class ViagemDAO {
     private static String sql;
	
	 public ViagemDAO(Connection connection) {
		this.connection = connection;
	}
	//CREAT
			public void CreateViagem(Viagem viagem) {
				sql = "INSERT INTO viagem(origemViagem, destinoViagem, dataViagem, horaPartida) VALUES (?,?,?,?)";
				try(PreparedStatement stmt = connection.prepareStatement(sql)){
				   stmt.setString(1, viagem.getOrigemViagem());
				   stmt.setString(2, viagem.getDestinoViagem());
				   stmt.setString(3, viagem.getDataViagem());
				   stmt.setString(4, viagem.getHoraViagem());
				;
				   stmt.executeUpdate();
				   System.out.println("Viagem criada com sucesso!");
				   System.out.printf("ID: %d\n Origem: %s\n Destino: %s\n Data: %s\n Hora:  %s\n",
							 viagem.getIdViagem(), viagem.getOrigemViagem(), viagem.getDestinoViagem(), viagem.getDataViagem(), viagem.getHoraViagem());
				    
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		   //READ
			public void readAllViagens(){
				sql = "SELECT * FROM viagem";
				try(PreparedStatement stmt = connection.prepareStatement(sql)){
					   ResultSet r = stmt.executeQuery();
					   while(r.next()) {
						 Viagem viagem = new Viagem();
						 viagem.setIdViagem(r.getInt("idViagem"));
						 viagem.setOrigemViagem(r.getString("origemViagem"));
						 viagem.setDestinoViagem(r.getString("destinoViagem"));
						 viagem.setDataViagem(r.getString("dataViagem"));
						 viagem.setHoraViagem(r.getString("horaPartida"));
						 System.out.printf("ID: %d\n Origem: %s\n Destino: %s\n Data: %s\n Hora:  %s\n",
								 viagem.getIdViagem(), viagem.getOrigemViagem(), viagem.getDestinoViagem(), viagem.getDataViagem(), viagem.getHoraViagem());
					   }if(!r.next()) {
						   System.out.println("Não tem mais dados!");   
					      }
				       }catch(SQLException e) {
						System.out.println("Não foi possível verificar informações .Mensagem: " + e.getMessage());
					}
			}
			
		     //UPDATE
			public void updateViagem(Viagem viagem) {
				sql = "UPDATE viagem SET  origemViagem = ?, destinoViagem = ?, dataViagem = ?, horaPartida = ? WHERE idViagem = ?";
		        try(PreparedStatement stmt = connection.prepareStatement(sql)){
		        	stmt.setString(1, viagem.getOrigemViagem());
		 		    stmt.setString(2, viagem.getDestinoViagem());
		 		    stmt.setString(3, viagem.getDataViagem());
		 		    stmt.setString(4, viagem.getHoraViagem());
		 		    stmt.setInt(5, viagem.getIdViagem());
		 		   
		 		   System.out.printf("ID: %d\n Origem: %s\n Destino: %s\n Data: %s\n Hora:  %s\n",
							 viagem.getIdViagem(), viagem.getOrigemViagem(), viagem.getDestinoViagem(), viagem.getDataViagem(), viagem.getHoraViagem());
		        stmt.executeUpdate();
	
		        	
		        }catch(SQLException e) {
		        	System.out.println("Não foi possível atualizar" + e.getMessage());
		        	
		        }
			}
			private final Connection connection;

			//DELETE
		    public void deleteViagem(int id){
		    	sql = "DELETE FROM viagem WHERE idViagem = ?";
		    	try(PreparedStatement stmt = connection.prepareStatement(sql)){ 
		    		stmt.setInt(1, id);
		    		stmt.execute();
		    		
		    		System.out.println("\n\nViagem Deletada\n\n");
		    		
		    	}catch (SQLException e) {
		    		System.out.println("Não foi possível Deletar" + e.getMessage());
		    		
		    	}
		    }
			
		}


