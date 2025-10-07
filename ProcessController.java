import java.util.ArrayList;
// Controller con los metodos para crear cada tipo de proceso. Genera una lista de procesos variados.
public class ProcessController{
    // Métodos para crear diferentes tipos de procesos con overloading
    // Mismo nombre, diferente número de parámetros
    public CPUProcess createCPUProcess(int pid, String name, int cpuBurstTime, int priority) {
        return new CPUProcess(pid, name, cpuBurstTime, priority);
    }

    public CPUProcess createCPUProcess(int pid, String name, int cpuBurstTime) {
        return new CPUProcess(pid, name, cpuBurstTime);
    }

    public IOProcess createIOProcess(int pid, String name, String ioDevice) {
        return new IOProcess(pid, name, ioDevice);
    }

    public IOProcess createIOProcess(int pid, String name, String ioDevice, int waitTime) {
        return new IOProcess(pid, name, ioDevice, waitTime);
    }

    public DaemonProcess createDaemonProcess(int pid, String name, String serviceType) {
        return new DaemonProcess(pid, name, serviceType);
    }

    public DaemonProcess createDaemonProcess(int pid, String name, String serviceType, boolean isActive) {
        return new DaemonProcess(pid, name, serviceType, isActive);
    }
    // Genera una lista de procesos variados
    public ArrayList<Process> generateProcessList(){
        ArrayList<Process> processList = new ArrayList<>();
        processList.add(createCPUProcess(1001, "VideoRenderer", 500, 9));
        processList.add(createCPUProcess(1002, "DataCompression", 300));
        processList.add(createCPUProcess(1003, "ImageProcessing", 400, 8));
        
        processList.add(createIOProcess(2001, "FileReader", "DISK"));
        processList.add(createIOProcess(2002, "NetworkTransfer", "NETWORK", 250));
        processList.add(createIOProcess(2003, "KeyboardInput", "KEYBOARD"));
        
        processList.add(createDaemonProcess(3001, "SystemLogger", "LOGGING"));
        processList.add(createDaemonProcess(3002, "HealthMonitor", "MONITORING", true));
        processList.add(createDaemonProcess(3003, "BackupService", "BACKUP"));
        
        return processList;
    }
}