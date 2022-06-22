class Employee {

    String name;
    int salary;
    String address;

    public Employee() {


        this.address = "unknown";
        this.salary = 0;
        this.name = "unknown";
    }

    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
        this.address = "unknown";
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}