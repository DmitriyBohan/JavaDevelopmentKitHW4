import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавления нового сотрудника в справочник
*/
public class TaskMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        addEmployee(employees,new Employee("+1234567890", "John Doe", 5));
        addEmployee(employees,new Employee("+9876543210", "Jane Smith", 3));
        addEmployee(employees,new Employee("+5555555555", "Alice Johnson", 8));


        //System.out.println(employees);

        System.out.println(searchEmployeeByExperience(employees,3));
        System.out.println(phoneNumberByName(employees, "John Doe"));
        System.out.println(searchById(employees, 1));


    }

    public static class Employee {
        private static int idCounter = 0;
        private int id ;
        private String phoneNumber;
        private String name;
        private int experience;

        public Employee(String phoneNumber, String name, int experience) {
            this.id = ++idCounter;
            this.phoneNumber = phoneNumber;
            this.name = name;
            this.experience = experience;
        }

        public int getExperience() {
            return experience;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", experience=" + experience +
                    '}';
        }
    }

    public static List<Employee> searchEmployeeByExperience(List<Employee> employees, int experience) {
         return employees.stream().filter(employee -> employee.getExperience() == experience).collect(Collectors.toList());
    }

    public static List<String> phoneNumberByName( List<Employee> employees, String nameSearch){

        return employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(nameSearch)).map(Employee::getPhoneNumber).collect(Collectors.toList());

    }

    public static Employee searchById (List<Employee> employees, int idSearch){

        return employees.stream().filter(employee -> employee.getId() == idSearch).findFirst().orElse(null);
    }

    public static void addEmployee(List<Employee> employees, Employee newEmployee){
        employees.add(newEmployee);
    }





}
