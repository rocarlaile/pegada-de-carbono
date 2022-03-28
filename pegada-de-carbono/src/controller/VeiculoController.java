package controller;

import  java.util.List ;
import  dao.VeiculoDao ;
import  modelo.Veiculo ;

public  class  VeiculoController {

	public  void  salvar ( Veiculo  veiculo ) throws  Exception {
		if (veiculo . getPlaca() ==  null  || veiculo.getPlaca ().length() !=  7 ) {
			throw  new  Exception ( " Descrição da placa do veículo inválida. Por favor, digite uma placa válida! " );
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}

	public  void  atualizado ( Veiculo  veiculo ) throws  Exception {
		if (veiculo . getPlaca() ==  null  || veiculo.getPlaca ().length() !=  7 ) {
			throw  new  Exception ( " Descrição da placa do veículo inválida. Por favor, digite uma placa válida! " );
		}
		VeiculoDao.getInstance().atualizado(veiculo);
	}

	public  void  excluir ( int idVeiculo ) throws Exception {  
		if (idVeiculo ==  0 ) {
			throw  new  Exception ( " Nenhum veículo foi selecionado. " );
		}
		VeiculoDao.getInstance() . excluir(idVeiculo);
	}

	public  List< Veiculo >  listar (){
		return  VeiculoDao.getInstance().listar();
	}

}
