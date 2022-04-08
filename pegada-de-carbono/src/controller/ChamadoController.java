package controller;

import  dao.ChamadoDao;
import  modelo.Chamado;

public  class  ChamadoController {



	private double Double;

	public  void  registrarChamado ( Chamado  chamado ) throws  Exception {

		
		if (chamado.getColaborador() ==  null ) {
			throw  new  Exception ( " Colaborador Inv�lido! " );
		}	
			
		if (chamado.getVeiculo() ==  null ) {
				throw  new  Exception ( " Ve�culo Inv�lido! " );	
		}
		
		if (chamado.getDistanciaPercorrida () == Double) {
			throw  new  Exception ( " Dados Inv�lidos! " );
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
}
