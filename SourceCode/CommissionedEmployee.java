import java.util.Date;
public class CommissionedEmployee extends Employee {
    private int salary;
    private int commission;
    private Date psdate;
    private int rate;
    void setRate(int rate) { this.rate = rate ;}
    void setSalary(int salary) { this.salary = salary ;}
    void setcommision() { this.commission = 0 ;}
    int getSalary() { return salary;}
    int getRate() { return rate;}
    Date getpsDate() { return psdate;}
    void setpsDate() { this.psdate= new Date() ;}
    int getCommission() { return commission;}
    public static CommissionedEmployee getCommissionedEmployee(int id,int salary,int rate)
    {
            CommissionedEmployee ce = new CommissionedEmployee();
            ce.setID(id);
            ce.setSalary(salary);
            ce.setRate(rate);
            ce.setcommision();
            ce.setpsDate();
            return ce;
    }
    
}