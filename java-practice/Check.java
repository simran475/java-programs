class Patient {
    
    // Private data
    private String patientName;
    private int age;
    private double temperature;
    
    // Method to admit patient
    public void admitPatient(String name, int age, double temp) {
        this.patientName = name;
        this.age = age;
        this.temperature = temp;
    }
    
    // Method to check condition
    public void checkCondition() {
        if(temperature > 102) {
            System.out.println(patientName + " has High Fever - Critical");
        } else if(temperature > 99) {
            System.out.println(patientName + " has Mild Fever - Normal");
        } else {
            System.out.println(patientName + " is Healthy");
        }
    }
    
    // Method to display patient info
    public void displayInfo() {
        System.out.println("Patient Name  : " + patientName);
        System.out.println("Age           : " + age);
        System.out.println("Temperature   : " + temperature);
    }
}

public class Check {
    public static void main(String[] args) {
        
        Patient p = new Patient();
        p.admitPatient("Shyam", 25, 103.5);
        p.displayInfo();
        p.checkCondition();
    }
}