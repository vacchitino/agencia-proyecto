package ejecucion;

import modelo.Empresa;
import vista.VistaPrincipal;
import controlador.ControladorEmpresa;

public class Usuario {
    public static void main(String[] args) {
        // Obtener la única instancia de Empresa (Singleton)
        Empresa empresa = Empresa.getInstancia();

        // Crear la vista (interfaz gráfica)
        VistaPrincipal vista = new VistaPrincipal();

        // Crear el controlador y enlazarlo con la vista y el modelo
        ControladorEmpresa controlador = new ControladorEmpresa(vista, empresa);

        // Hacer visible la interfaz gráfica
        vista.setVisible(true);
    }
}
