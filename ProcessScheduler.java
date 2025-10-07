import java.util.ArrayList;
// Clase controladora que maneja la ejecución de los procesos, individual y general
public class ProcessScheduler{
    // Ejecuta un proceso individual y en caso de procesos I/O, solicita entrada del usuario usando el metodo
    // requestUserInput de OSSimulatorView
    public void executeProcess(Process process, OSSimulatorView view){
        view.displayProcessStart(process);
        process.execute();
        view.displayProcessExecution(process);
        // Verifica si el proceso requiere entrada del usuario
        if (checkProcessRequiresInput(process)){
            String input = view.requestUserInput("Process" + process.getName() + " requires input. Please provide:");
            if (process instanceof IOProcess){
                ((IOProcess) process).setDataTransferred(((IOProcess)process).getDataTransferred() + input.length());
            }
        }

        view.displayProcessFinish(process);
    }

    // Ejecuta todos los procesos en la lista

    public void executeAllProcesses(ArrayList<Process> processList, OSSimulatorView view){
        view.displaySystemStatus(processList);
        for (Process process : processList) {
            executeProcess(process, view);
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL PROCESSES COMPLETED");
        System.out.println("=".repeat(60));
    }
    // Verifica si el proceso es de tipo I/O y si requiere entrada del usuario (por ejemplo, dispositivo "KEYBOARD")
    public boolean checkProcessRequiresInput(Process process) {
        if (process instanceof IOProcess) {
            IOProcess ioProcess = (IOProcess) process;
            return ioProcess.getIoDevice().equals("KEYBOARD");
        }
        return false;
    }
    // Actualiza el estado del proceso
    public void updateProcessState(Process process, String newState){
        process.setState(newState);
    }
}