import java.util.Scanner;
public class PayrollSystem {
    public static void addEmployee()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter ID:");
        int id=Integer.parseInt(sc.nextLine());
        System.out.print("Enter name:");
        String name = sc.nextLine();
        System.out.print("Enter Type:");
        String type = sc.next();
        System.out.print("Enter Method of Payment:");
        String MOP = sc.next();
        Employee e = Employee.getEmployee(id,name , MOP , type);
        DatabaseEmployee.add(e);
        if(e.getType().equalsIgnoreCase("temp")==true)
        {
            System.out.print("Enter Hourly Rate:");
            int rate=sc.nextInt();
            TempEmployee te = TempEmployee.getTempEmployee(e.getID(), rate);
            DatabaseTempEmployee.add(te);
            DatabaseTempEmployee.showdata();
        }
        else if(e.getType().equalsIgnoreCase("permanent")==true)
        {
            System.out.print("Enter Salary:");
            int salary=sc.nextInt();
            PermanentEmployee pe = PermanentEmployee.getPermanentEmployee(e.getID(), salary);
            DatabasePermanentEmployee.add(pe);
            DatabasePermanentEmployee.showdata();

        }
        else
        {
            System.out.println("Wrong Type of Employee...");
            System.out.println("Restart The Program");
        }
        sc.close();
    }
    public static void main(String args[] )
    {
        System.out.println("1.Add Employee");
        System.out.println("Enter Choice:");
        Scanner sc = new Scanner(System.in);
        int ch =  sc.nextInt();
        switch(ch)
        {
            case 1:
            addEmployee();
            break;
            default: 
            System.out.print("Wrong Choice");
        }
        sc.close();
    }

}
