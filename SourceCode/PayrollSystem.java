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
        else if(e.getType().equalsIgnoreCase("commissioned")==true)
        {
            System.out.print("Enter Salary:");
            int salary=sc.nextInt();
            System.out.print("Enter Commission Rate:");
            int rate=sc.nextInt();
            CommissionedEmployee ce = CommissionedEmployee.getCommissionedEmployee(e.getID(), salary, rate);
            DatabaseCommissionedEmployee.add(ce);
            DatabaseCommissionedEmployee.showdata();

        }
        else 
        {
            System.out.println("Wrong Type of Employee...");
            System.out.println("Restart The Program");
        }
        sc.close();
    }
    public static void delEmployee()
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter Employee id: ");
        int id = sc.nextInt();
        DatabaseEmployee.delete(id);
        DatabasePermanentEmployee.delete(id);
        DatabaseCommissionedEmployee.delete(id);
        DatabaseTempEmployee.delete(id);
        DatabaseEmployeeUnion.delete(id);
        sc.close();
    }
    public static void runPayroll()
    {
        Payroll.Pay();
    }
    public static void postCard()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Emp id:");
        int id = sc.nextInt();
        System.out.print("Enter Hours:");
        int hrs= sc.nextInt();
        DatabaseTempEmployee.postTimeCard(id, hrs);
        sc.close();
    }
    public static void postReceipt()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Emp id:");
        int id = sc.nextInt();
        System.out.print("Enter Amount:");
        int amount= sc.nextInt();
        DatabaseCommissionedEmployee.postSalesReceipt(id, amount);
        sc.close();
    }
    public static void updateTable()
    {
        Scanner sc = new Scanner(System.in);
         System.out.println("1.hourly rate 2.commission rate");
         System.out.print("Enter choice:");
         int ch=sc.nextInt();
         System.out.print("Enter Employee id to update:");
         int id= sc.nextInt();
         System.out.print("Enter new Rate:");
         int rate = sc.nextInt();
         switch(ch)
         {
             case 1:
             DatabaseTempEmployee.updateRate(id, rate);
             break;
             case 2:
             DatabaseCommissionedEmployee.updateRate(id, rate);
             default:
             System.out.println("Wrong Choice");
         }
         sc.close();
    }
    public static void unionMember()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee id: ");
        int id = sc.nextInt();
        System.out.print("Enter WeeklyCharge:");
        int WeeklyCharge = sc.nextInt();
        EmployeeUnion e = EmployeeUnion.getEmployeeUnion(id, WeeklyCharge);
        DatabaseEmployeeUnion.add(e);
    }
    public static void main(String args[] )
    {
        System.out.println("1.Add Employee");
        System.out.println("2.Delete Employee");
        System.out.println("3.Run Payroll");
        System.out.println("4.Post a Time Card");
        System.out.println("5.Post a Sales Receipt");
        System.out.println("6.Update Details");
        System.out.println("7:Union Membership");
        System.out.println("Enter Choice:");
        Scanner sc = new Scanner(System.in);
        int ch =  sc.nextInt();
        switch(ch)
        {
            case 1:
            addEmployee();
            break;
            case 2:
            delEmployee();
            break;
            case 3:
            runPayroll();
            break;
            case 4:
            postCard();
            break;
            case 5:
            postReceipt();
            break;
            case 6:
            updateTable();
            break;
            case 7:
            unionMember();
            break;
            default: 
            System.out.print("Wrong Choice");
        }
        sc.close();
    }

}
