import java.sql.*;
import java.util.Date;
public class DatabaseTempEmployee {
    public static void add(TempEmployee e)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            st.execute("create table if not exists TEmployee (id int , rate int , dueSalary int)");
            String sql = "insert into TEmployee values(?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setInt(1, e.getID());
                ps.setInt(2, e.getRate());
                ps.setInt(3, e.getdueSalary());
                ps.executeUpdate();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception :" + e);
        }
    }
    public static void delete(int id)
    {
        String sql = " delete from TEmployee where id = ?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll") ; PreparedStatement ps = conn.prepareStatement(sql))
        { 
            ps.setInt(1,id);
            ps.executeUpdate();

        }
        catch(Exception e)
        {
            System.out.println("Exception:"+e);
        }
    }
    public static void postTimeCard(int id , int hrs)
    {
        int time1=0 ,time2=0;
        if(hrs<=8)
        time1=hrs;
        else
        {
            time1=hrs;
            time2=hrs-8;
        }
        String sql = " update TEmployee set dueSalary=dueSalary+rate*?+1.5*rate*? where id = ?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll") ; PreparedStatement ps = conn.prepareStatement(sql))
        { 
            ps.setInt(1,time1);
            ps.setInt(2,time2);
            ps.setInt(3,id);
            ps.executeUpdate();

        }
        catch(Exception e)
        {
            System.out.println("Exception:"+e);
        }
    }
    public static void updateRate(int id,int rate)
    {
        String sql = " update TEmployee set rate=? where id = ?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll") ; PreparedStatement ps = conn.prepareStatement(sql))
        { 
            ps.setInt(1,rate);
            ps.setInt(2,id);
            ps.executeUpdate();

        }
        catch(Exception e)
        {
            System.out.println("Exception:"+e);
        }
    }
    public static void showdata()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            ResultSet rs= st.executeQuery("select * from TEmployee");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception :" +e);
        }

    }
}