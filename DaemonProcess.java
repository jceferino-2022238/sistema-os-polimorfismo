// Clase hija de Process que representa un proceso daemon
public class DaemonProcess extends Process {
    private String serviceType;
    private boolean isActive;
    private int cycleCount;

    // Constructores con overloading
    public DaemonProcess(int pid, String name, String serviceType) {
        super(pid, name);
        this.serviceType = serviceType;
        this.isActive = true;
        this.cycleCount = 0;
    }
    
    public DaemonProcess(int pid, String name, String serviceType, boolean isActive) {
        super(pid, name);
        this.serviceType = serviceType;
        this.isActive = isActive;
        this.cycleCount = 0;
    }
    
    // Getters y Setters
    public String getServiceType() {
        return serviceType;
    }
    
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public int getCycleCount() {
        return cycleCount;
    }
    
    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
    }
    @Override
    public void execute() {
        if (isActive) {
            this.state = "RUNNING";
            // Simula servicio en segundo plano
            this.cycleCount++;
            this.executionTime += 100;
            // Simula tiempo de ejecución del proceso daemon
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            this.state = "BACKGROUND";
        }
    }
    
    @Override
    public String toString() {
        return "[DAEMON] " + super.toString() + " | Service: " + serviceType + " | Active: " + isActive + " | Cycles: " + cycleCount;
    }
}