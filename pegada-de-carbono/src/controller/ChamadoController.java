package controller;

import  dao.ChamadoDao;
import  modelo.Chamado;

public  class  ChamadoController {

	public  void  registrarChamado ( Chamado  chamado ) throws  Exception {
		if (chamado.getDataChamado() ==  null ) {
			throw  new  Exception ( " Dados Inv�lidos! " );
		}
		if (chamado.getColaborador() ==  null ) {
			throw  new  Exception ( " Colaborador Inv�lido! " );
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
}
