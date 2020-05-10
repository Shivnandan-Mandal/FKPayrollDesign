import java.sql.*;
import java.util.Date;
public class DatabaseEmployeeUnion {
    public static void add(EmployeeUnion e)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            st.execute("create table if not exists UEmployee (id int , weekly int , service int)");
            String sql = "insert into UEmployee values(?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setInt(1, e.getID());
                ps.setInt(2, e.getweeklyCharge());
                ps.setInt(3, e.getserviceCharge());
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
        String sql = " delete from UEmployee where id = ?";
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
            ResultSet rs= st.executeQuery("select * from UEmployee");
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