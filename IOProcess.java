// Clase hija de Process que representa un proceso de I/O
public class IOProcess extends Process{
    private String ioDevice;
    private int waitTime;
    private int dataTransferred;

    // Constructores con overloading
    public IOProcess(int pid, String name, String ioDevice) {
        super(pid, name);
        this.ioDevice = ioDevice;
        this.waitTime = 0;
        this.dataTransferred = 0;
    }
    
    public IOProcess(int pid, String name, String ioDevice, int waitTime) {
        super(pid, name);
        this.ioDevice = ioDevice;
        this.waitTime = waitTime;
        this.dataTransferred = 0;
    }
    
    // Getters y Setters
    public String getIoDevice() {
        return ioDevice;
    }
    
    public void setIoDevice(String ioDevice) {
        this.ioDevice = ioDevice;
    }
    
    public int getWaitTime() {
        return waitTime;
    }
    
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    
    public int getDataTransferred() {
        return dataTransferred;
    }
    
    public void setDataTransferred(int dataTransferred) {
        this.dataTransferred = dataTransferred;
    }

    @Override
    public void execute() {
        this.state = "WAITING";
        // Simula espera por dispositivo I/O
        this.waitTime += 200;
        this.executionTime += waitTime;
        // Al igual que en CPUProcess, usamos Thread.sleep para simular el tiempo de espera
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.state = "RUNNING";
        this.dataTransferred += 512; // Simula transferencia de datos en KB
        this.state = "FINISHED";
    }

    @Override
    public String toString() {
        return "[I/O PROCESS] " + super.toString() + " | Device: " + ioDevice + " | Data: " + dataTransferred + "KB";
    }

}