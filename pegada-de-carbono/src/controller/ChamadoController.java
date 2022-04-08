package controller;

import  dao.ChamadoDao;
import  modelo.Chamado;

public  class  ChamadoController {



	private double Double;

	public  void  registrarChamado ( Chamado  chamado ) throws  Exception {

		
		if (chamado.getColaborador() ==  null ) {
			throw  new  Exception ( " Colaborador Inválido! " );
		}	
			
		if (chamado.getVeiculo() ==  null ) {
				throw  new  Exception ( " Veículo Inválido! " );	
		}
		
		if (chamado.getDistanciaPercorrida () == Double) {
			throw  new  Exception ( " Dados Inválidos! " );
		}
		ChamadoDao.getInstance().registrarChamado(chamado);
	}
}
