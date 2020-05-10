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

    public static void Pay()
    {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int lastday = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(today);
        System.out.println(lastday);
        if(dayOfWeek==1)
        {
            payTempEmployee();
            //payCommissioned();
        }
        else if(today == lastday)
        {   
            //payPermEmployee();
            //payCommissionedEmployee();
        }

 }   
}