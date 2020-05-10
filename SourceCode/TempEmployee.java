import java.util.Date;
public class TempEmployee {
    private int id;
    private int rate;
    private int dueSalary;
    void setID(int id) { this.id = id ;}
    void setRate(int rate) { this.rate = rate ;}
    void setdueSalary(int dueSalary) { this.dueSalary = dueSalary ;}
    int getID()  { return id; }
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