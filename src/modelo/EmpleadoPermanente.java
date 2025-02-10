package modelo;

public class EmpleadoPermanente extends Empleado{
	private double aniosAntiguedad;
	private String obraSocial;

	public EmpleadoPermanente(String documento, String nombre, double sueldoBruto, double aniosAntiguedad, String obraSocial) {
		super(documento, nombre, sueldoBruto);
		this.aniosAntiguedad = aniosAntiguedad;
		this.obraSocial = obraSocial;
	}

	public double getAniosAntiguedad() {
		return aniosAntiguedad;
	}

	public void setAniosAntiguedad(double aniosAntiguedad) {
		this.aniosAntiguedad = aniosAntiguedad;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	@Override
	public double calcularSueldoNeto() {
		double multiplicador = 1 - 0.15; //Descuentos del sueldo por Obra Social
		if(aniosAntiguedad > 5) {
			multiplicador += 0.05; //Bonificacion por años de antiguedad
		}
		return getSueldoBruto() * multiplicador;
		
	}
	
	

}
