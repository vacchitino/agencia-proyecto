package modelo;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import modelo.Empleado;

public class Empresa {
	private String nombre;
	private String domicilio;
	private ArrayList<Empleado> listaEmpleados;
	private static Empresa instancia; //SINGLETON 1ER PASO
	
	private Empresa(String nombre, String domicilio) { //SINGLETON 2DO PASO --> CONSTRUCTOR PRIVADO
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.listaEmpleados = new ArrayList<Empleado>();
	}
	
	public static Empresa getInstancia() { // SINGLETON 3ER PASO --> METODO QUE INSTANCIA A LA CLASE POR UNICA VEZ
		if(instancia == null) {
			instancia = new Empresa("Autos Lujosos","Villa Luro");
		}
		return instancia;
	}
	public void agregarEmpleado(Empleado e) {
		listaEmpleados.add(e);
	}
	public void eliminarEmpleado(String documento) {
		listaEmpleados.removeIf(empleado -> empleado.getDocumento().equals(documento));
	}
	public boolean existeEmpleado(String documento) {
		boolean bandera = false;
		for(int i = 0; i < listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).getDocumento().equals(documento)) {
				bandera = true;
				
			}
		}return bandera;
	}
	public Empleado empleadoMayorSueldo() {
		if(listaEmpleados.isEmpty()) {
			throw new NoSuchElementException("No hay empleados cargados en la empresa.");
		}
		Empleado empMayorSueldo = listaEmpleados.get(0);//tomar como referencia el primer empleado
		for(int i = 0; i < listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).calcularSueldoNeto() > empMayorSueldo.calcularSueldoNeto()) {
				empMayorSueldo = listaEmpleados.get(i);
			}
		}
		return empMayorSueldo;
	}
	
	
}
