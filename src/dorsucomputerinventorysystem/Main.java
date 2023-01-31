
import java.util.*;

public class Main {

    public static void main(String args[]) {

        int code;
        String Name;
        String pt;
        String employee;
        boolean found;

        String[][] offer = {{"Input Devices : ", "\nmouse,", "key board,", "graphics tablet,", "image scanner,", "barcode reader,", "\ngame controller,", "light pen,", "light gun,", "microphone,", "web cam"},
        {"Output Devices :", "\ncomputer monitor,", "speaker,", "projector,", "printer,", "\nheadphones,", "webcam"},
        {"Input/Output Devices: ", "\ndisk drive,", "solid state drive,", "USB flash drive,", "memory card,", "\ntape drive,", "modem,", "network adapter,", "multi-function printer"}};

        String[][] notavailable = {{"Input Devices :", "\ngraphics tablet,", "image scanner,", "light pen"},
        {"Output Devices :", "\nprinter,", "webcam"},
        {"Input/Output Devices :", "\nmemory card,", "solid state drive,", "network adapter"}};

        String[][] available = {{"Input Devices : ", "\nmouse,", "key board,", "barcode reader,", "\ngame controller,", "light gun,", "microphone,", "\nweb cam"},
        {"Output Devices :", "\ncomputer monitor,", "speaker,", "projector,", "\nheadphones,"},
        {"Input/Output Devices: ", "\ndisk drive,", "USB flash drive,", "\ntape drive,", "modem,", "multi-function printer"}};

        List<input> in = new ArrayList<input>();

        List<output> out = new ArrayList<>();
        List<inout> inout = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int i = 6;

        try {

            do {

                Iterator<input> it = in.iterator();
                Iterator<output> its = out.iterator();
                Iterator<inout> itss = inout.iterator();
                System.out.println("1. Add");
                System.out.println("2. View ");
                System.out.println("3. Edit");
                System.out.println("4. Delete");
                System.out.println("5. Report");
                System.out.println("6. Exit");
                System.out.print("Enter Your Choice : ");
                i = sc.nextInt();

                switch (i) {

                    case 1:
                        char z = 'D';

                        do {
                            System.out.println("A. Peripheral Input.");
                            System.out.println("B. Peripheral Output.");
                            System.out.println("C. Peripheral Input/Output.");
                            System.out.println("D. Exit");
                            System.out.print("Enter Your Choice PLease : ");
                            z = sc.next().charAt(0);

                            switch (Character.toUpperCase(z)) {

                                case 'A':

                                    System.out.println("**HERE ARE THE DEFAULT OFFERS**");
                                    System.out.println("===============================================================================");

                                    for (String[] offers : offer) {
                                        for (String off : offers) {
                                            System.out.print(off + "\t");

                                        }

                                        System.out.println();
                                        System.out.println("--------------------------------------------------------------------------------");
                                    }

                                    System.out.println("===============================================================================");

                                    System.out.print("Enter Code For PC Hardware : ");
                                    code = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Name of PC Hardware : ");
                                    Name = sc.nextLine();
                                    System.out.print("Enter The Peripheral Type : ");
                                    pt = sc.nextLine();
                                    System.out.print("Enter Employee Name :");
                                    employee = sc.nextLine();

                                    input inn = new input(code, Name, pt, employee);
                                    in.add(inn);

                                    break;
                                case 'B':
                                    System.out.print("Enter Code For PC Hardware : ");
                                    code = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Name of PC Hardware : ");
                                    Name = sc.nextLine();
                                    System.out.print("Enter The Peripheral Type : ");
                                    pt = sc.nextLine();
                                    System.out.print("Enter Employee Name : ");
                                    employee = sc.nextLine();

                                    output outt = new output(code, Name, pt, employee);
                                    out.add(outt);
                                    break;

                                case 'C':
                                    System.out.print("Enter Code For PC Hardware : ");
                                    code = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Name of PC Hardware : ");
                                    Name = sc.nextLine();
                                    System.out.print("Enter The Peripheral Type : ");
                                    pt = sc.nextLine();
                                    System.out.print("Enter Employee Name : ");
                                    employee = sc.nextLine();

                                    inout ino = new inout(code, Name, pt, employee);
                                    inout.add(ino);

                                    break;

                                case 'D':
                                    System.out.println("==================================");
                                    System.out.println("Please Proceed");
                                    System.out.println("==================================");

                                    break;

                                default:
                                    System.out.println("==================================");
                                    System.out.println("Try Again!!");
                                    System.out.println("==================================");
                                    break;

                            }

                        } while (Character.toUpperCase(z) != 'D');

                        break;

                    case 3:

                        char k = 'D';

                        do {
                            System.out.println("-------------------------------------------------");
                            System.out.println("A.Update Peripheral Input.");
                            System.out.println("B.Update Peripheral Output.");
                            System.out.println("C.Enter To Delete  Peripheral Input/Output.");
                            System.out.println("D. Enter To Exit");
                            System.out.println("-------------------------------------------------");
                            System.out.print("Enter Your Choice To Delete : ");
                            k = sc.next().charAt(0);

                            switch (Character.toUpperCase(k)) {

                                case 'A':

                                    boolean find = false;

                                    ListIterator<input> ito = in.listIterator();

                                    System.out.print("Enter Barcode to Update  : ");
                                    code = sc.nextInt();

                                    while (ito.hasNext()) {
                                        input e = ito.next();
                                        if (e.Code() == code) {

                                            System.out.print("Enter Code For PC Hardware : ");
                                            code = sc.nextInt();
                                            sc.nextLine();
                                            System.out.print("Enter New Name of PC Hardware : ");
                                            Name = sc.nextLine();
                                            System.out.print("Enter New The Peripheral Type : ");
                                            pt = sc.nextLine();
                                            System.out.print("Enter New Employee Name : ");
                                            employee = sc.nextLine();

                                            ito.set(new input(code, Name, pt, employee));
                                            find = true;

                                        }

                                    }

                                    System.out.println("================================================");

                                    if (!find) {
                                        System.out.println("Update Unsuccessful!!!!!!");
                                    } else {
                                        System.out.println("Update Successful!!!!!!");
                                        System.out.println("================================================");

                                    }

                                    break;
                                case 'B':
                                    find = false;

                                    ListIterator<output> itoo = out.listIterator();

                                    System.out.print("Enter Barcode to Update  : ");
                                    code = sc.nextInt();

                                    while (itoo.hasNext()) {
                                        output e = itoo.next();
                                        if (e.Code() == code) {

                                            System.out.print("Enter Code For PC Hardware : ");
                                            code = sc.nextInt();
                                            sc.nextLine();
                                            System.out.print("Enter New Name of PC Hardware : ");
                                            Name = sc.nextLine();
                                            System.out.print("Enter New The Peripheral Type : ");
                                            pt = sc.nextLine();
                                            System.out.print("Enter New Employee Name : ");
                                            employee = sc.nextLine();

                                            itoo.set(new output(code, Name, pt, employee));
                                            find = true;

                                        }

                                    }

                                    System.out.println("================================================");

                                    if (!find) {
                                        System.out.println("Update Unsuccessful!!!!!!");
                                    } else {
                                        System.out.println("Update Successful!!!!!!");
                                        System.out.println("================================================");
                                    }

                                    break;

                                case 'C':
                                    find = false;

                                    ListIterator<inout> itto = inout.listIterator();

                                    System.out.print("Enter Barcode to Update  : ");
                                    code = sc.nextInt();

                                    while (itto.hasNext()) {
                                        inout e = itto.next();
                                        if (e.Code() == code) {

                                            System.out.print("Enter Code For PC Hardware : ");
                                            code = sc.nextInt();
                                            sc.nextLine();
                                            System.out.print("Enter New Name of PC Hardware : ");
                                            Name = sc.nextLine();
                                            System.out.print("Enter New The Peripheral Type : ");
                                            pt = sc.nextLine();
                                            System.out.print("Enter New Employee Name : ");
                                            employee = sc.nextLine();

                                            itto.set(new inout(code, Name, pt, employee));
                                            find = true;

                                        }

                                    }

                                    System.out.println("================================================");

                                    if (!find) {
                                        System.out.println("Update Unsuccessful!!!!!!");
                                    } else {
                                        System.out.println("Update Successful!!!!!!");
                                        System.out.println("================================================");

                                    }

                                    break;
                                case 'D':
                                    System.out.println("==================================");
                                    System.out.println("You May Now Proceed");
                                    System.out.println("==================================");

                                    break;

                            }

                        } while (Character.toUpperCase(k) != 'D');

                        break;

                    case 2:
                        char t = 'H';

                        do {
                            System.out.println("A. View all Peripherals");
                            System.out.println("B. View Available Peripherals");
                            System.out.println("C. View Not Available Peripherals");
                            System.out.println("D. View all Input Devices");
                            System.out.println("E. View all Output Devices");
                            System.out.println("F. View all Input/Output Devices");
                            System.out.println("G. View all employees");
                            System.out.println("H. Exit Choices");
                            System.out.print("Enter Your Choice : ");
                            t = sc.next().charAt(0);

                            switch (Character.toUpperCase(t)) {

                                case 'A':

                                    it = in.iterator();

                                    System.out.println("===========================================");

                                    peripheral a = new input();
                                    a.devices();

                                    while (it.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(it.next().showdetails());
                                        System.out.println("----------------------------------------");

                                    }

                                    System.out.println("===========================================");

                                    a = new output();
                                    a.devices();
                                    its = out.iterator();

                                    while (its.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(its.next().showdetails());
                                        System.out.println("----------------------------------------");

                                    }

                                    System.out.println("===========================================");
                                    a = new inout();
                                    a.devices();
                                    itss = inout.iterator();

                                    while (itss.hasNext()) {

                                        System.out.println("----------------------------------------");
                                        System.out.println(itss.next().showdetails());
                                        System.out.println("----------------------------------------");
                                    }
                                    System.out.println("===========================================");

                                    break;

                                case 'B':

                                    System.out.println("**HERE ARE THE  AVAILABLE DEVICES**");
                                    System.out.println("=======================================================");
                                    for (String[] avail : available) {
                                        for (String ava : avail) {
                                            System.out.print(ava + "\t");
                                        }
                                        System.out.println();
                                        System.out.println("-------------------------------------------------------");
                                    }

                                    System.out.println("=======================================================");
                                    break;

                                case 'C':
                                    System.out.println("**HERE ARE THE NOT AVAILABLE DEVICES**");
                                    System.out.println("=======================================================");
                                    for (String[] notavail : notavailable) {
                                        for (String not : notavail) {
                                            System.out.print(not + "\t");
                                        }
                                        System.out.println();
                                        System.out.println("-------------------------------------------------------");
                                    }

                                    System.out.println("=======================================================");
                                    break;
                                case 'D':
                                    System.out.println("HERE ARE THE INPUTED INPUT DEVICES");
                                    it = in.iterator();

                                    System.out.println("===========================================");

                                    while (it.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(it.next().Name());
                                        System.out.println("----------------------------------------");

                                    }

                                    break;

                                case 'E':
                                    System.out.println("HERE ARE THE INPUTED OUTPUT DEVICES");
                                    System.out.println("===========================================");

                                    its = out.iterator();

                                    while (its.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(its.next().Name());
                                        System.out.println("----------------------------------------");

                                    }

                                    break;

                                case 'F':
                                    System.out.println("HERE ARE THE INPUTED INPUT/OUTPUT DEVICES");
                                    System.out.println("===========================================");

                                    itss = inout.iterator();

                                    while (itss.hasNext()) {

                                        System.out.println("----------------------------------------");
                                        System.out.println(itss.next().Name());
                                        System.out.println("----------------------------------------");
                                    }
                                    System.out.println("===========================================");

                                    break;

                                case 'G':
                                    it = in.iterator();

                                    System.out.println("===========================================");

                                    while (it.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(it.next().employee());
                                        System.out.println("----------------------------------------");

                                    }

                                    System.out.println("===========================================");

                                    System.out.println("===========================================");

                                    its = out.iterator();

                                    while (its.hasNext()) {
                                        System.out.println("----------------------------------------");
                                        System.out.println(its.next().employee());
                                        System.out.println("----------------------------------------");

                                    }

                                    System.out.println("===========================================");

                                    System.out.println("===========================================");

                                    itss = inout.iterator();

                                    while (itss.hasNext()) {

                                        System.out.println("----------------------------------------");
                                        System.out.println(itss.next().employee());
                                        System.out.println("----------------------------------------");
                                    }
                                    System.out.println("===========================================");

                                    break;

                                case 'H':
                                    System.out.println("==================================");
                                    System.out.println("You May Now Proceed");
                                    System.out.println("==================================");
                                    break;

                                default:
                                    System.out.println("==================================");

                                    System.out.println("Try Again!!!");
                                    System.out.println("==================================");
                                    break;
                            }

                        } while (Character.toUpperCase(t) != 'H');

                        break;

                    case 4:

                        char l = 'D';

                        do {
                            System.out.println("-------------------------------------------------");
                            System.out.println("A. Enter To Delete Peripheral Input.");
                            System.out.println("B.Enter To Delete Peripheral Output.");
                            System.out.println("C.Enter To Delete  Peripheral Input/Output.");
                            System.out.println("D. Enter To Exit");
                            System.out.println("-------------------------------------------------");
                            System.out.print("Enter Your Choice To Delete : ");
                            l = sc.next().charAt(0);

                            switch (Character.toUpperCase(l)) {

                                case 'A':
                                    System.out.print("Enter Barcode :  ");
                                    code = sc.nextInt();
                                    found = false;
                                    it = in.iterator();

                                    while (it.hasNext()) {
                                        input e = it.next();

                                        if (e.Code() == code) {
                                            it.remove();
                                            found = true;
                                        }
                                    }
                                    System.out.println("================================================");
                                    if (!found) {
                                        System.out.println("Record not Found");
                                    } else {
                                        System.out.println("Record was Deleted Successfully..!");
                                    }
                                    System.out.println("================================================");
                                    break;

                                case 'B':
                                    System.out.print("Enter Barcode :  ");
                                    code = sc.nextInt();
                                    found = false;
                                    its = out.iterator();

                                    while (its.hasNext()) {
                                        output e = its.next();

                                        if (e.Code() == code) {
                                            its.remove();
                                            found = true;
                                        }
                                    }
                                    System.out.println("================================================");
                                    if (!found) {
                                        System.out.println("Record not Found");
                                    } else {
                                        System.out.println("Record was Deleted Successfully..!");
                                    }
                                    System.out.println("================================================");
                                    break;

                                case 'C':
                                    System.out.print("Enter Barcode :  ");
                                    code = sc.nextInt();
                                    found = false;
                                    itss = inout.iterator();

                                    while (itss.hasNext()) {
                                        inout e = itss.next();

                                        if (e.Code() == code) {
                                            itss.remove();
                                            found = true;
                                        }
                                    }
                                    System.out.println("================================================");
                                    if (!found) {
                                        System.out.println("Record not Found");
                                    } else {
                                        System.out.println("Record was Deleted Successfully..!");
                                    }
                                    System.out.println("================================================");

                                    break;

                                case 'D':

                                    System.out.println("==================================");
                                    System.out.println("You May Now Proceed");
                                    System.out.println("==================================");

                                    break;

                            }

                        } while (Character.toUpperCase(l) != 'D');

                        break;

                    case 5:

                        char sw = 'F';

                        do {

                            System.out.print("Enter Your Choice : ");
                            sw = sc.next().charAt(0);
                            switch (Character.toUpperCase(sw)) {

                                case 'A':

                                    System.out.println("====================================================");
                                    int numColumns = available[0].length;

                                    System.out.println("The Number of Available Peripheral : " + numColumns);
                                    System.out.println("====================================================");
                                    break;

                                case 'B':
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Peripheral of Input Devices : " + in.size());
                                    System.out.println("=================================================================");
                                    System.out.println();
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Peripheral of Output Devices : " + out.size());
                                    System.out.println("=================================================================");
                                    System.out.println();
                                    System.out.println("==========================================================================");
                                    System.out.println("The Number of assigned Peripheral of Input/Output Devices : " + inout.size());
                                    System.out.println("==========================================================================");
                                    break;

                                case 'C':
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Peripheral of Input Devices : " + in.size());
                                    System.out.println("=================================================================");
                                    break;
                                case 'D':
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Peripheral of Output Devices : " + out.size());
                                    System.out.println("=================================================================");
                                    break;
                                case 'E':
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Employee of Input Devices : " + in.size());
                                    System.out.println("=================================================================");
                                    System.out.println();
                                    System.out.println("==================================================================");
                                    System.out.println("The Number of assigned Employee of Output Devices : " + out.size());
                                    System.out.println("=================================================================");
                                    System.out.println();
                                    System.out.println("==========================================================================");
                                    System.out.println("The Number of assigned Employee of Input/Output Devices : " + inout.size());
                                    System.out.println("==========================================================================");

                                    break;

                            }
                        } while (Character.toUpperCase(sw) != 'F');

                        break;

                    case 6:
                        System.out.println("==================================");
                        System.out.println("Thank You Very Much!!!");
                        System.out.println("==================================");
                        break;
                }

            } while (i != 6);

        } catch (Exception e) {
            System.out.println("================================================");
            System.out.println("Please Enter Numbers Only!!!!!!!!!!!!!!!");
            System.out.println("================================================");
        }

    }

}

interface peripheral {

    public String showdetails();

    public int Code();

    public void devices();

    public String Name();

    public String employee();
}

class input implements peripheral {

    private int code;
    private String inpt, Name, Employee;

    public String employee() {
        return Employee;
    }

    input() {

    }

    public String Name() {
        return Name;
    }

    public int Code() {
        return code;
    }

    input(int code, String Name, String inpt, String Employee) {
        this.code = code;
        this.Name = Name;
        this.Employee = Employee;
        this.inpt = inpt;
    }

    public void devices() {
        System.out.println("Input Devices");
    }

    public String showdetails() {
        return "Bar Code : " + code + "\n" + "Name of the PC hardware : " + Name + "\n" + "Employee Name : " + Employee + "\n" + "Kind of Peripheral :  " + inpt;
    }
}

class output implements peripheral {

    private int code;
    private String outpt, Name, Employee;

    output(int code, String Name, String outpt, String Employee) {
        this.code = code;
        this.outpt = outpt;
        this.Name = Name;
        this.Employee = Employee;
    }

    public String employee() {
        return Employee;
    }

    public int Code() {
        return code;
    }

    output() {

    }

    public String Name() {
        return Name;
    }

    public void devices() {
        System.out.println("Output Devices");
    }

    public String showdetails() {
        return "Bar Code : " + code + "\n" + "Name of the PC hardware : " + Name + "\n" + "Employee Name : " + Employee + "\n" + "Kind of Peripheral :  " + outpt;
    }

}

class inout implements peripheral {

    private int code;
    private String inout, Name, Employee;

    inout(int code, String Name, String Employee, String inout) {
        this.code = code;
        this.inout = inout;
        this.Name = Name;
        this.Employee = Employee;
    }

    public String employee() {
        return Employee;
    }

    inout() {

    }

    public int Code() {
        return code;
    }

    public String Name() {
        return Name;
    }

    public void devices() {
        System.out.println("Input/Output Devices");
    }

    public String showdetails() {
        return "Bar Code : " + code + "\n" + "Name of the PC hardware : " + Name + "\n" + "Employee Name : " + Employee + "\n" + "Kind of Peripheral :  " + inout;
    }

}
