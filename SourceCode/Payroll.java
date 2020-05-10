import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
public class Payroll 
{
    public static int getUnionCharges(int id)
    {
        return 0;
    }
    public static void payTempEmployee()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select id,dueSalary  from TEmployee");
            while(rs.next())
            {
                int charges = getUnionCharges(rs.getInt(1));
                System.out.println("Paid Employee "+ rs.getInt(1)+ " weekly salary of "+ (rs.getInt(2)-charges));
            }
            String sql = " update TEmployee set dueSalary=0";
            try(PreparedStatement ps = conn.prepareStatement(sql))
                { 
                    ps.executeUpdate();
                }
        }
        catch(Exception e)
        {
            System.out.println("Exception Found:"+e);
        }
    }
    public static void payPermEmployee()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select *  from PEmployee");
            Date today = new Date();
            java.sql.Date date = new java.sql.Date(today.getTime());
            while(rs.next())
            {
                int charges = getUnionCharges(rs.getInt(1));
                java.sql.Date sqlDate =rs.getDate(3);
                long diff = date.getTime()-sqlDate.getTime();
                long daysBetween = (diff / (1000*60*60*24));
                long salary = rs.getInt(2)*(daysBetween/30);
                System.out.println("Paid Employee "+ rs.getInt(1)+ " salary of "+ (salary-charges));
            }
            String sql = " update PEmployee set psdate=?";
            try(PreparedStatement ps = conn.prepareStatement(sql))
                { 
                    ps.setDate(1, date);
                    ps.executeUpdate();
                }
        }
        catch(Exception e)
        {
            System.out.println("Exception Found:"+e);
        }
    }
    public static void payCommissionedEmployee()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select *  from CEmployee");
            Date today = new Date();
            java.sql.Date date = new java.sql.Date(today.getTime());
            while(rs.next())
            {
                int charges = getUnionCharges(rs.getInt(1));
                java.sql.Date sqlDate =rs.getDate(3);
                long diff = date.getTime()-sqlDate.getTime();
                long daysBetween = (diff / (1000*60*60*24));
                long salary = rs.getInt(2)*(daysBetween/30);
                System.out.println("Paid Employee "+ rs.getInt(1)+ " salary of "+ (salary-charges));
            }
            String sql = " update CEmployee set psdate=?";
            try(PreparedStatement ps = conn.prepareStatement(sql))
                { 
                    ps.setDate(1, date);
                    ps.executeUpdate();
                }
        }
        catch(Exception e)
        {
            System.out.println("Exception Found:"+e);
        }
    }
    public static void payCommissioned()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select *  from CEmployee where flag=0");
            while(rs.next())
            {
                System.out.println("Paid Employee "+ rs.getInt(1)+ " commission of "+ rs.getInt(5));
            }
            String sql = " update CEmployee set commission=0 where flag=0";
            try(PreparedStatement ps = conn.prepareStatement(sql))
                { 
                    ps.executeUpdate();
                }
            sql = " update CEmployee set flag=(flag+1)%10 where flag=0";
            try(PreparedStatement ps = conn.prepareStatement(sql))
                { 
                     ps.executeUpdate();
                }
        }
        catch(Exception e)
        {
            System.out.println("Exception Found:"+e);
        }
    }

    public static void Pay()
    {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int lastday = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        if(dayOfWeek==6)
        {
            payTempEmployee();
            payCommissioned();
        }
        else if(today == lastday)
        {   
            payPermEmployee();
            payCommissionedEmployee();
        }

 }   
}