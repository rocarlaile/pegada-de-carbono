package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  java.util.ArrayList;
import  java.util.List;

import  modelo.Veiculo;
import util.ConnectionUtil;

public  class  VeiculoDao {

	private static VeiculoDao instance;
	private Connection con = ConnectionUtil.getConnection();

	public  static  VeiculoDao  getInstance () {
		if (instance ==  null ) {
			instance =  new  VeiculoDao ();
		}
		return instance;
	}

	public  void  salvar ( Veiculo  veiculo ) {
		try {
			String sql = "Insert into veiculo (id, placa, modelo, ano, veiculoDisponivel, consumoKmLitro (?, ?, ?, ?, ?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, veiculo.getId());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setInt(3, veiculo.getAno());
			pstmt.setString(4, String.valueOf (veiculo.getVeiculoDisponivel()));
			pstmt.setString(5, veiculo.getConsumoKmLitro());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

	public  void  atualizado ( Veiculo  veiculo ) {
		try {
			String sql = "update veiculo set placa = ?, modelo = ?, ano = ?, consumoKmLitro = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setString(2, veiculo.getModelo());
			pstmt.setInt(3, veiculo.getAno());
			pstmt.setString(4, veiculo.getConsumoKmLitro());
			pstmt.setInt(5, veiculo.getId());
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void  excluir ( int idVeiculo ) { 
		try {
			String sql = "delete from veiculo where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(idVeiculo, idVeiculo);
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  List< Veiculo >  listar (){
		List<Veiculo> listaVeiculos = new ArrayList<>();
		try {
			String sql = "select * from veiculo";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("id"));
				v.setPlaca(rs.getString("placa"));
				v.setModelo(rs.getString("modelo"));
				v.setAno(rs.getInt("ano"));
				v.setConsumoKmLitro(rs.getString("Consumo"));
				listaVeiculos.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}
}
