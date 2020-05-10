package payroll;

import java.util.Scanner;
public class Employee 
{
    private int id;
    private String name;
    private String TypeEmp;
    private String MOP;
    public int getID() { return id ;}
    public String getName() { return name; }
    public String getType() { return TypeEmp; }
    public String getMOP() { return MOP; }
    public void setID(int id) { this.id = id;}
    public void setName(String name) { this.name= name; }
    public void setType(String TypeEmp) { this.TypeEmp = TypeEmp ;}
    public void setMOP(String MOP) { this.MOP = MOP ;}
    public static Employee getEmployee(int id , String name, String MOP , String Type)
    {
        Employee e = new Employee();
        e.setID(id);
        e.setName(name);
        e.setType(Type);
        e.setMOP(MOP);
        return e;
    }
}