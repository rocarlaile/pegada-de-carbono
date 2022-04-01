package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  java.util.ArrayList ;
import  java.util.List ;
import modelo.Colaborador;
import util.ConnectionUtil;

public  class  ColaboradorDao {
	
	private static ColaboradorDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	// Singleton
	
	public  static  ColaboradorDao  getInstance (){
		if (instance ==  null ) {
			instance =  new  ColaboradorDao ();
		}
		return instance;
	}
	
	public  void  salvar ( Colaborador  colaborador ) {
		try {
			String sql = "Insert into colaborador (id, nome, endereco, cpf, cargo, salario, telefone, cnhB (?, ?, ?, ?, ?,?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, colaborador.getId());
			pstmt.setString(2, colaborador.getNome());
			pstmt.setString(3, colaborador.getEndereco());
			pstmt.setString(4, colaborador.getCpf());
			pstmt.setString(5, colaborador.getCargo());
			pstmt.setDouble(6, colaborador.getSalario());
			pstmt.setString(7, colaborador.getTelefone());
			pstmt.setString(8, String.valueOf (colaborador.getCnhB()));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public  void  atualizar ( Colaborador  colaborador ) {
		try {
			String sql = "update colaborador set nome = ?, endereco = ?, cpf = ?, cargo = ?, salario = ?, telefone = ?, cnhB = ?, where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, colaborador.getNome());
			pstmt.setString(2, colaborador.getEndereco());
			pstmt.setString(3, colaborador.getCpf());
			pstmt.setString(4, colaborador.getCargo());
			pstmt.setDouble(5, colaborador.getSalario());
			pstmt.setString(6, colaborador.getTelefone());
			pstmt.setString(7, colaborador.getCnhB());
			pstmt.setInt(8, colaborador.getId());
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void  excluir ( int idColaborador ) { 
		try {
			String sql = "delete from colaborador where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idColaborador);
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  List< Colaborador >  listar() {
		List<Colaborador> listaColaborador = new ArrayList<>();
		try {
			String sql = "select * from colaborador";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Colaborador c = new Colaborador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCpf(rs.getString("cpf"));
				c.setCargo(rs.getString("Cargo"));
				c.setSalario(rs.getDouble("salario"));
				c.setTelefone(rs.getString("Telefone"));
				c.setCnhB(rs.getString("CnhB"));
				listaColaborador.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaborador;
	}
}
