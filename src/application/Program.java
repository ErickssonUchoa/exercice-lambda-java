package application;

import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> employees = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter the salary: ");
            double wage = sc.nextDouble();

            Comparator<String> comp = (string1, string2) -> string1.toUpperCase().compareTo(string2.toUpperCase());

            List<String> emails = employees.stream()
                    .filter(p -> p.getWage() >= wage)
                    .map(p -> p.getEmail()).sorted(comp)
                    .collect(Collectors.toList());

            System.out.printf("Email of people whose salary is more than %.2f: %n", wage);
            emails.forEach(System.out::println);

            double sum = employees.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.getWage())
                    .reduce(0.0, (x,y) -> x + y);
            System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n", sum);

        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
        }

        sc.close();
    }
}
