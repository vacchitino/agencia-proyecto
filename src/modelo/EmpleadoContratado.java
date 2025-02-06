package modelo;

public class EmpleadoContratado extends Empleado{
	private String duracionContrato;
	private double montoPorHora;

	protected EmpleadoContratado(String documento, String nombre, double sueldoBruto, String duracionContrato, double montoPorHora) {
		super(documento, nombre, sueldoBruto);
		this.duracionContrato = duracionContrato;
		this.montoPorHora = montoPorHora;
	}

	public String getDuracionContrato() {
		return duracionContrato;
	}

	public void setDuracionContrato(String duracionContrato) {
		this.duracionContrato = duracionContrato;
	}

	public double getMontoPorHora() {
		return montoPorHora;
	}

	public void setMontoPorHora(double montoPorHora) {
		this.montoPorHora = montoPorHora;
	}

	@Override
	protected double calcularSueldoNeto() {
		return montoPorHora;
		// TODO Auto-generated method stub
		
	}
	

}
