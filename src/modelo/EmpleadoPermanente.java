package modelo;

public class EmpleadoPermanente extends Empleado{
	private double aniosAntiguedad;
	private String obraSocial;

	protected EmpleadoPermanente(String documento, String nombre, double sueldoBruto, double aniosAntiguedad, String obraSocial) {
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
	protected double calcularSueldoNeto() {
		double sueldoNeto = getSueldoBruto();
		if(aniosAntiguedad > 5) {
			sueldoNeto = getSueldoBruto() * 0.05;
		}
		return sueldoNeto;
		
	}
	
	

}
