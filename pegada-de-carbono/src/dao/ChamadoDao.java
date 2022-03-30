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
			String sql = "insert into chamado (dataChamado, colaborador, veiculo, distanciaPercrrida, id) values (?, ?, ?, ?, ?)"; 
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setDate(1, java.sql.Date.valueOf(chamado.getDataChamado()));
			pstmt.setInt(2, chamado.getColaborador().getId());
			pstmt.setInt(3, chamado.getVeiculo().getId());
			pstmt.setDouble(2, chamado.getDistanciaPercorrida());
			
			int key = pstmt.executeUpdate();
			if (key > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
