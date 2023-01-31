package dorsucomputerinventorysystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DORSUComputerInventorySystem {

    static ArrayList<Peripheral> data = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        boolean isContinue = true;
        String componentType = "";
        do {
            System.out.println("\nDORSU Computer Inventory System");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.next();

            switch (choice.toLowerCase()) {
                case "1":

                    boolean continueCreate = true;
                    boolean isInputValid = false;

                    do {
                        System.out.println("\nEnter Component Type");
                        System.out.println("a -> input device");
                        System.out.println("b -> output device");
                        System.out.println("c -> input/output device");
                        System.out.println("d -> Back");
                        System.out.print("Enter Choice: ");
                        char deviceType = sc.next().charAt(0);
                        switch (deviceType) {
                            case 'a' -> {
                                componentType = "input";
                                isInputValid = true;
                                System.out.println(isInputValid);
                            }

                            case 'b' -> {
                                componentType = "output";
                                isInputValid = true;
                            }
                            case 'c' -> {
                                componentType = "input/output";
                                isInputValid = true;
                            }
                            case 'd' ->
                                continueCreate = false;

                            default -> {
                                System.out.println(
                                        ANSI_RED + "INVALID INPUT" + ANSI_RESET
                                );
                                break;
                            }
                        }
                    } while (continueCreate && !isInputValid);

                    if (isInputValid) {
                        System.out.print("Enter Component Name:");
                        String componentName = sc.next();
                        System.out.print("Assign Peripheral to employee? y/n");
                        char isPeripheralAssigned = sc.next().charAt(0);
                        String employee;
                        if (isPeripheralAssigned == 'y') {
                            System.out.print("Enter Employee FirstName:");
                            employee = sc.next();
                        } else {
                            employee = "N/A";
                        }
                        create(componentName, componentType, employee);
                    }
                    break;

                case "2":
                    read();
                    break;

                case "3":
                    update();
                    break;

                case "4":
                    delete();
                    break;

                case "5":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println(
                            ANSI_RED + "INVALID INPUT" + ANSI_RESET
                    );
                    break;
            }
        } while (isContinue);
    }

    static int codeNum = 1;

    static void create(String name, String peripheralType, String employeeName) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        String codeNumber = String.format("%04d", codeNum++);
        String code = Integer.toString(year) + codeNumber;

        data.add(new Peripheral(code, name, peripheralType, employeeName));
    }

    static void read() {

        System.out.println("1. View all peripherals");
        System.out.println("2. View available peripherals");
        System.out.println("3. View not available peripherals");
        System.out.println("4. View all input devices");
        System.out.println("5. View all output devices");
        System.out.println("6. View all input/output devices");
        System.out.println("7. View all employees");

        System.out.print("Enter your choice: ");
        int userChoice = sc.nextInt();

        data.forEach(object -> {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Code: " + object.getPeripheralCode());
                    System.out.println("Employee: " + object.getEmployee());
                    System.out.println("Peripheral: " + object.getPeripheralName());
                    System.out.println("Type: " + object.getPeripheralType());
                    System.out.println("----------------------------------");
                }

                case 2 -> {
                    if (object.getEmployee().equals("N/A")) {
                        System.out.println("----------------------------------");
                        System.out.println("Code: " + object.getPeripheralCode());
                        System.out.println("Employee: " + object.getEmployee());
                        System.out.println("Peripheral: " + object.getPeripheralName());
                        System.out.println("Type: " + object.getPeripheralType());
                        System.out.println("----------------------------------");
                    }
                }
                case 3 -> {
                    if (!object.getEmployee().equals("N/A")) {
                        System.out.println("----------------------------------");
                        System.out.println("Code: " + object.getPeripheralCode());
                        System.out.println("Employee: " + object.getEmployee());
                        System.out.println("Peripheral: " + object.getPeripheralName());
                        System.out.println("Type: " + object.getPeripheralType());
                        System.out.println("----------------------------------");
                    }
                }
                case 4 -> {
                    if ("input".equals(object.getPeripheralType())) {
                        System.out.println("----------------------------------");
                        System.out.println("Code: " + object.getPeripheralCode());
                        System.out.println("Employee: " + object.getEmployee());
                        System.out.println("Peripheral: " + object.getPeripheralName());
                        System.out.println("Type: " + object.getPeripheralType());
                        System.out.println("----------------------------------");
                    }
                }
                case 5 -> {
                    if ("output".equals(object.getPeripheralType())) {
                        System.out.println("----------------------------------");
                        System.out.println("Code: " + object.getPeripheralCode());
                        System.out.println("Employee: " + object.getEmployee());
                        System.out.println("Peripheral: " + object.getPeripheralName());
                        System.out.println("Type: " + object.getPeripheralType());
                        System.out.println("----------------------------------");
                    }
                }
                case 6 -> {
                    if ("input/output".equals(object.getPeripheralType())) {
                        System.out.println("----------------------------------");
                        System.out.println("Code: " + object.getPeripheralCode());
                        System.out.println("Employee: " + object.getEmployee());
                        System.out.println("Peripheral: " + object.getPeripheralName());
                        System.out.println("Type: " + object.getPeripheralType());
                        System.out.println("----------------------------------");
                    }
                }

            }
        });

    }

    static void update() {
        System.out.print("Enter index: ");
        String editTerm = sc.next();
        boolean isFound = false;
        int index = 0;
        for (var object : data) {
            if (object.getPeripheralCode().equals(editTerm)) {
                isFound = true;
                if (object.getEmployee().equals("N/A")) {
                    System.out.println("----------------------------------");
                    System.out.println("Code: " + object.getPeripheralCode());
                    System.out.print("Enter New Employee: ");
                    String newEmployee = sc.next();
                    System.out.print("Enter New Peripheral Name:(" + object.getPeripheralName() + ")");
                    String newPeripheralName = sc.next();
                    System.out.print("Enter New Peripheral Type:(" + object.getPeripheralType() + ")");
                    String newPeripheralType = sc.next();
                    System.out.println("----------------------------------");

                    Peripheral newPeripheral = new Peripheral(
                            object.getPeripheralCode(), newPeripheralName,
                            newPeripheralType, newEmployee
                    );

                    data.set(index, newPeripheral);

                    System.out.println(ANSI_GREEN + "Peripheral Successfully Updated!" + ANSI_RESET);
                } else {
                    System.out.println(
                            ANSI_RED + "Peripheral with code "
                            + object.getPeripheralCode()
                            + " is already assigned!" + ANSI_RESET
                    );
                }
            }
            index++;
        }
        if (!isFound) {
            System.out.println(ANSI_RED + "Peripheral Code not found!" + ANSI_RESET);
        }

    }

    static void delete() {
        System.out.print("Enter Peripheral Code: ");
        String deleteTerm = sc.next();
        Iterator<Peripheral> itr = data.iterator();
        boolean isFound = false;
        int index = 0;
        try {
            for (Peripheral object : data) {
                if (deleteTerm.equals(object.getPeripheralCode())) {
                    isFound = true;
                    data.remove(index);
                    System.out.println(ANSI_GREEN + "Data deleted successfully" + ANSI_RESET);
                } else {
                    index++;
                }
            }
        } catch (Exception e) {
        }
        if (!isFound) {
            System.out.println(ANSI_RED + "Peripheral code not found!" + ANSI_RESET);
        }

    }

}

class Peripheral {

    private String code;
    private String name;
    private String peripheralType;
    private String employee;

    public Peripheral(String code, String name, String peripheralType, String employee) {
        this.code = code;
        this.name = name;
        this.peripheralType = peripheralType;
        this.employee = employee;

    }

    public String getPeripheralCode() {
        return this.code;
    }

    public String getPeripheralName() {
        return this.name;
    }

    public String getPeripheralType() {
        return this.peripheralType;
    }

    public String getEmployee() {
        return this.employee;
    }

    public String getPeripheral() {
        return this.code + this.name + this.peripheralType + this.employee;
    }

}
