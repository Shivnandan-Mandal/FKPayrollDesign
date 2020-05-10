import java.util.Date;
public class PermanentEmployee  extends Employee{
    private int salary;
    private Date psdate;
    void setSalary(int salary) { this.salary = salary ;}
    void setpsDate() { this.psdate= new Date() ;}
    int getSalary() { return salary;}
    Date getpsDate() { return psdate;}
    public static PermanentEmployee getPermanentEmployee(int id,int salary)
    {
            PermanentEmployee te = new PermanentEmployee();
            te.setID(id);
            te.setSalary(salary);
            te.setpsDate();
            return te;
    }
    
}