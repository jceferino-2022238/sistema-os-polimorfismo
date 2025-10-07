/*
Proyecto: Simulador de Sistema Operativo, Polimorfismo via Herencia.
Descripción: simulador en consola donde mediante el uso de clases abstractas, herencia y métodos abstractos 
podemos implementar diferentes tipos de procesos (CPU, I/O, Daemon) y ejecutarlos en una misma ArrayList, 
manejando aspectos de polimorfismo en el programa.
Nombre: José Carlos Ceferino Fabián.
Carné: 251043
*/
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        // Inicialización de componentes del simulador
        // Controlador, Planificador y Vista
        ProcessController controller = new ProcessController();
        ProcessScheduler scheduler = new ProcessScheduler();
        OSSimulatorView view = new OSSimulatorView();
        ArrayList<Process> processList = controller.generateProcessList();
        
        scheduler.executeAllProcesses(processList, view);
        
        view.closeScanner();
    }
}