import java.util.Date;
public class EmployeeUnion extends Employee {
    private int weeklyCharge;
    private int serviceCharge;
    void setweeklyCharge(int charge) { this.weeklyCharge = charge ;}
    void setserviceCharge() { this.serviceCharge = 0 ;}
    int getweeklyCharge() { return weeklyCharge;}
    int getserviceCharge(){ return serviceCharge;}
    public static EmployeeUnion getEmployeeUnion(int id , int weeklyCharge)
    {
            EmployeeUnion te = new EmployeeUnion();
            te.setID(id);
            te.setweeklyCharge(weeklyCharge);
            te.setserviceCharge();
            return te;
    }
    
}