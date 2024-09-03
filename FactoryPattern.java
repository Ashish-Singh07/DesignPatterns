package DesignPatterns;

public class FactoryPattern {

    public static void main(String[] args) {
        Employee manager = EmployeeFactory.getEmployee("Manager");
        System.out.println(manager.salary());

        Employee developer = EmployeeFactory.getEmployee("Developer");
        System.out.println(developer.salary());
    }
}

interface Employee{
    public int salary();
}

class Manager implements Employee{

    @Override
    public int salary() {
        return 10000;
    }
}

class Developer implements Employee{
    @Override
    public int salary() {
        return 5000;
    }
}

class EmployeeFactory{

    public static Employee getEmployee(String type){
        if(type.equals("Manager")){
            return new Manager();
        }else if(type.equals("Developer")){
            return new Developer();
        }else{
            return null;
        }
    }
}

