import  java.time.LocalDate;

import  controller.ColaboradorController ;
import  controller.VeiculoController;
import  controller.ChamadoController;
import  modelo.Colaborador;
import  modelo.Veiculo;
import  modelo.Chamado;

public class Principal {

	public  static  void  main ( String [] args ) {

		testeColaborador();
		testeVeiculo();
		testeChamado();

	}

	public  static  void  testeColaborador () {
		Colaborador c1 =  new  Colaborador ( 1, " Ada Lovelace ", " Rua dos Programadores - n�mero 1010 ", " 045888555-74 ", " Gerente ", 15000.00, " 48 95555-8888 ", 'S');


		Colaborador c2 =  new  Colaborador ( 2 , " Carolina Shaw " , " Rua dos Sonhos - n�mero 21 " , " 035218555-43 " , " Coordenadora " , 12000.00 , " 48 93575-8258 " , 'S');
		
		ColaboradorController controller =  new  ColaboradorController ();
		try {
			controller.salvar(c1);
			controller.salvar(c2);
		} catch ( Exception e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------");
		}

		for (Colaborador c: controller.listar()) {
			System.out.println(c.toString());
			System.out.println("-----------------------------------");
		}
	}

	public  static  void  testeVeiculo () {
		Veiculo v1 =  new  Veiculo ( 1 , " LSN4582 " , " Toyota Corolla " , 2020 , 'S' , " 13,9 km/l " );
		
		Veiculo v2 =  new  Veiculo ( 2 , " OXM2754 " , " Chevrolet Onix " , 2021 , 'S' , " 15,7 km/l " );

		VeiculoController controller =  new  VeiculoController();

		try {
			controller.salvar(v1);
			controller.salvar(v2);
		} catch ( Exception e) {
			System.out.println(e.getMessage());
		}
		for (Veiculo v: controller.listar()) {
			System.out.println(v.toString());
			System.out.println("---------------------------");
		}
	}

	public  static  void  testeChamado () {

		Veiculo v1 =  new  Veiculo ( 1 , " LSN4582 " , " Toyota Corolla " , 2020 , 'S' , " 13,9 km/l " );
		
		Colaborador c1 =  new  Colaborador ( 1 , " Ada Lovelace " , " Rua dos Programadores - n�mero 1010 " , " 045888555-74 " , " Gerente " , 15000.00 , " 48 95555-8888 " , 'S' );

		Chamado ch1 =  new  Chamado ( 1 , LocalDate . now(), " Rua das Ac�cias - n�mero 35 " , 20.00 , c1, v1 );
		
		ChamadoController controller =  new  ChamadoController();
		
		try {
			controller.registrarChamado(ch1);
		} catch ( Exception e) {
			System.out.println(e.getMessage());
			System.out.println("---------------------------");
		}
	}
}