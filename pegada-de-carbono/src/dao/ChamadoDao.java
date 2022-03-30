package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

	public  List<Chamado>  registrarChamado ( Chamado  chamado ) {
		List<Chamado> listaChamados = new ArrayList<>();
		try {
			String sql = "select * from chamado";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Chamado ch = new Chamado();
				ch.setId(rs.getInt("id"));
				ch.setEnderecoAtendimento(rs.getString("enderecoAtendimento"));
				ch.setDistanciaPercorrida(rs.getDouble("distanciaPercorrida"));
				ch.setVeiculo(null);
				ch.setColaborador(null);
				listaChamados.add(ch); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}
}
