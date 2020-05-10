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
    public static void showdata()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            ResultSet rs= st.executeQuery("select * from TEmployee");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getInt(3));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception :" +e);
        }

    }
}