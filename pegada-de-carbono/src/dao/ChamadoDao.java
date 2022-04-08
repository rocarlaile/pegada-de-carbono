package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Chamado;
import util.ConnectionUtil;

public  class  ChamadoDao {

	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	

	public  static  ChamadoDao  getInstance () {
		if (instance ==  null ) {
			instance =  new  ChamadoDao ();
		}
		return instance;
	}
	

	public void registrarChamado ( Chamado  chamado ) {
		
		try {
			
			String sql = "insert into chamado (id, dataChamado, endereco, distanciaPercorrida, motorista, carro) values (?, ?, ?, ?, ?, ?)"; 
		
			PreparedStatement pstmt = con.prepareStatement(null);
		
			pstmt.setInt(1, chamado.getId());
			pstmt.setDate(2, java.sql.Date.valueOf(chamado.getDataChamado()));
			pstmt.setString(3, chamado.getEnderecoAtendimento());
			pstmt.setDouble(4, chamado.getDistanciaPercorrida());
			pstmt.setString(5, chamado.getColaborador().getNome());
			pstmt.setString(6, chamado.getVeiculo().getPlaca());
		
		
			pstmt.executeUpdate();
			
					 
			} catch (SQLException e) {
	e.printStackTrace();

			}

			}
		}


