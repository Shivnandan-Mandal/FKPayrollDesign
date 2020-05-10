import java.util.Scanner;
public class PayrollSystem {
    public static void addEmployee()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID:");
        int id=sc.nextInt();
        System.out.print("Enter name:");
        String name = sc.nextLine();
        System.out.print("Enter Type:");
        String type = sc.next();
        System.out.print("Enter Method of Payment:");
        String MOP = sc.next();
        Employee e = Employee.getEmployee(id,name , MOP , type);
        DatabaseEmployee.add(e);
        DatabaseEmployee.showdata();
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
