package modelo;

  public class Veiculo {
	 private int id;
	 private String placa;
	 private String modelo;
	 private String ano;
	 private String veiculoDisponivel ;
	 private Double consumoKmLitro ;
	
	public   Veiculo ( int   id , String   placa , String   modelo , String   ano , String   veiculoDisponivel , Double   consumoKmLitro ) {
		this.id = id ;
		this.placa = placa ;
		this.modelo = modelo ;
		this.ano = ano ;
		this.veiculoDisponivel = veiculoDisponivel ;
		this.consumoKmLitro = consumoKmLitro ;
	}
	
	 public Veiculo (){
	}

	public Veiculo(String placa2, String modelo2, int ano2, char veiculoDisponivel2, String consumo) {
		// TODO Auto-generated constructor stub
	}

	public   int   getId () {
		 return id;
	}

	public   void   setId ( int   id ) {
		this.id = id ;
	}

	public   String   getPlaca () {
		return  placa ;
	}

	public   void   setPlaca ( String   placa ) {
		this.placa = placa ;
	}

	public   String   getModelo () {
		 return modelo;
	}

	public   void   setModelo ( String   modelo ) {
		this.modelo = modelo ;
	}

	public   String   getAno () {
		return  ano ;
	}

	public   void   setAno ( String  string) {
		this.ano = string;
	}

	public   String   getVeiculoDisponivel () {
		return  veiculoDisponivel ;
	}

	public   void   setVeiculoDisponivel ( String   veiculoDisponivel ) {
		this.veiculoDisponivel = veiculoDisponivel ;
	}

	public   Double   getConsumoKmLitro () {
		return consumoKmLitro ;
	}

	public   void   setConsumoKmLitro ( double  consumoKmLitro) {
		this.consumoKmLitro = consumoKmLitro ;
	}


		
	}

		


	

