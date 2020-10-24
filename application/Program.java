package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.*;


public class Program {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int totalEmployees = sc.nextInt();

        for (int i = 0; i <totalEmployees ; i++) {
            System.out.println("Employee data [" + (i+1) + "/" + totalEmployees + "]:");
            System.out.print("Outsourced (y/n): ");
            String outsourced = sc.next();

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            Integer hours = sc.nextInt();

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            Employee worker = null;

            if (outsourced.equals("y") || outsourced.equals("Y")) {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                worker = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
            } else if (outsourced.equals("n") || outsourced.equals("N"))
                  worker = new Employee(name, hours, valuePerHour);

            employees.add(worker);
        }

        System.out.println("PAYMENTS:");

        for(Employee worker : employees){
            System.out.println(worker.getName()
                                + " - "
                                + " $ "
                                + String.format("%.2f",worker.payment()));
        }
    }
}
