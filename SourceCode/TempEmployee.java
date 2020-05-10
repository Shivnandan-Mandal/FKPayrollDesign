import java.util.Date;
public class TempEmployee extends Employee {
    private int rate;
    private int dueSalary;
    void setRate(int rate) { this.rate = rate ;}
    void setdueSalary(int dueSalary) { this.dueSalary = dueSalary ;}
    int getRate() { return rate;}
    int getdueSalary() { return dueSalary;}
    public static TempEmployee getTempEmployee(int id,int rate)
    {
            TempEmployee te = new TempEmployee();
            te.setID(id);
            te.setRate(rate);
            te.setdueSalary(0);
            return te;
    }
    
}