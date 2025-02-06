package modelo;

public abstract class Empleado {
	private String documento;
	private String nombre;
	private double sueldoBruto;
	
	protected Empleado(String documento, String nombre, double sueldoBruto) {
		this.documento = documento;
		this.nombre = nombre;
		this.sueldoBruto = sueldoBruto;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	protected abstract double calcularSueldoNeto();
	
}
