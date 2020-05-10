import java.util.Date;
public class PermanentEmployee {
    private int id;
    private int salary;
    private Date psdate;
    void setID(int id) { this.id = id ;}
    void setSalary(int salary) { this.salary = salary ;}
    void setpsDate() { this.psdate= new Date() ;}
    int getID()  { return id; }
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