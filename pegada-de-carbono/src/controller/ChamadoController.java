package controller;

import  dao.ChamadoDao;
import  modelo.Chamado;

public  class  ChamadoController {

	public  void  registrarChamado ( Chamado  chamado ) throws  Exception {
		if (chamado.getDataChamado() ==  null ) {
			throw  new  Exception ( " Dados Inválidos! " );
		}
		if (chamado.getColaborador() ==  null ) {
			throw  new  Exception ( " Colaborador Inválido! " );
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
}
