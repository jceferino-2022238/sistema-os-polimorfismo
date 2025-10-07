// Clase hija de Process que representa un proceso de CPU
public class CPUProcess extends Process{
    private int cpuBurstTime;
    private int priority;
    private int progress;
    // Constructores con overloading
    public CPUProcess(int pid, String name, int cpuBurstTime, int priority) {
        super(pid, name);
        this.cpuBurstTime = cpuBurstTime;
        this.priority = priority;
        this.progress = 0;
    }
    
    public CPUProcess(int pid, String name, int cpuBurstTime) {
        super(pid, name);
        this.cpuBurstTime = cpuBurstTime;
        this.priority = 5; 
        this.progress = 0;
    }
    
    // Getters y Setters
    public int getCpuBurstTime() {
        return cpuBurstTime;
    }
    
    public void setCpuBurstTime(int cpuBurstTime) {
        this.cpuBurstTime = cpuBurstTime;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getProgress() {
        return progress;
    }
    
    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    @Override
    // Se cambia el estado del proceso, se avanza su progreso y acumula tiempo de ejecución
    public void execute() {
        this.state = "RUNNING";
        this.progress += 25;
        this.executionTime += cpuBurstTime;
        
        try {
            // Thread.sleep simula el tiempo de CPU consumido
            Thread.sleep(cpuBurstTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (progress >= 100) {
            this.state = "FINISHED";
        }
    }

    // Tostring con overriding
    
    @Override
    public String toString() {
        return "[CPU PROCESS] " + super.toString() + " | Priority: " + priority + " | Progress: " + progress + "%";
    }
}