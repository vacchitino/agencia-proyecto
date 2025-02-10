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
	//Agrega un empleado
	public void agregarEmpleado(Empleado e) {
		listaEmpleados.add(e);
	}
	//Elimina un empleado dado el numero de documento
	public void eliminarEmpleado(String documento) {
		listaEmpleados.removeIf(empleado -> empleado.getDocumento().equals(documento));
	}
	//Busca el empleado pasando su documento por parametro
	public boolean existeEmpleado(String documento) {
		return listaEmpleados.stream().anyMatch(empleado -> empleado.getDocumento().equals(documento));	
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
