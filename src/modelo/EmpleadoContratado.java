package modelo;

public class EmpleadoContratado extends Empleado{
	private double duracionHorasContrato;
	private double montoPorHora;

	public EmpleadoContratado(String documento, String nombre, double sueldoBruto, double duracionContrato, double montoPorHora) {
		super(documento, nombre, sueldoBruto);
		this.duracionHorasContrato = duracionContrato;
		this.montoPorHora = montoPorHora;
	}

	public double getDuracionContrato() {
		return duracionHorasContrato;
	}

	public void setDuracionContrato(double duracionContrato) {
		this.duracionHorasContrato = duracionContrato;
	}

	public double getMontoPorHora() {
		return montoPorHora;
	}

	public void setMontoPorHora(double montoPorHora) {
		this.montoPorHora = montoPorHora;
	}

	@Override
	public double calcularSueldoNeto() {
		return montoPorHora * duracionHorasContrato * 0.90;
	}
	

}
