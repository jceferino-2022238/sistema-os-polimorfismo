// Clase abstracta de la que heredan los diferentes tipos de procesos
public abstract class Process{
    protected int pid;
    protected String name;
    protected String state;
    protected int executionTime;
    // Constructor con overloading (mismo nombre, diferente número de parámetros)
    public Process(int pid, String name) {
        this.pid = pid;
        this.name = name;
        this.state = "READY";
        this.executionTime = 0;
    }

    public Process(int pid, String name, String state){
        this.pid = pid;
        this.name = name;
        this.state = state;
        this.executionTime = 0;
    }

    public int getPid() {
        return pid;
    }
    
    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public int getExecutionTime() {
        return executionTime;
    }
    
    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }
    
    @Override
    public String toString() {
        return "PID: " + pid + " | Name: " + name + " | State: " + state + " | Execution Time: " + executionTime + "ms";
    }
    

    // Método abstracto que debe ser implementado por las subclases
    public abstract void execute();


}