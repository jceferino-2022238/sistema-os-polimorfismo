import java.util.ArrayList;
import java.util.Scanner;
// Clase vista del programa, maneja la interacción con el usuario vía consola
public class OSSimulatorView{
    private Scanner scanner;

    public OSSimulatorView() {
        this.scanner = new Scanner(System.in);
    }
    // Métodos para mostrar información en consola de cada etapa del proceso
    public void displayProcessStart(Process process) {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("STARTING PROCESS: " + process.getName() + " (PID: " + process.getPid() + ")");
        System.out.println("-".repeat(60));
    }
    
    public void displayProcessExecution(Process process) {
        System.out.println("EXECUTING: " + process.toString());
    }
    
    public void displayProcessFinish(Process process) {
        System.out.println("FINISHED: " + process.getName() + " | Final State: " + process.getState());
        System.out.println("-".repeat(60));
    }
    // Solicita entrada del usuario
    public String requestUserInput(String message) {
        System.out.print("\n>>> " + message);
        return scanner.nextLine();
    }
    // Sys/out general del estado del sistema
    public void displaySystemStatus(ArrayList<Process> processList) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("OS SIMULATOR - SYSTEM STATUS");
        System.out.println("=".repeat(60));
        System.out.println("Total Processes Loaded: " + processList.size());
        System.out.println("=".repeat(60) + "\n");
    }
    
    public void closeScanner() {
        scanner.close();
    }
}