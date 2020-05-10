import java.sql.*;
import java.util.Date;
public class DatabasePermanentEmployee {
    public static void add(PermanentEmployee e)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            st.execute("create table if not exists PEmployee (id int ,salary int,psdate int)");
            String sql = "insert into PEmployee values(?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setInt(1, e.getID());
                ps.setInt(2, e.getSalary());
                java.util.Date d = e.getpsDate();
                java.sql.Date sqlDate =  new java.sql.Date(d.getTime()); 
                ps.setDate(3, sqlDate);
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
        String sql = " delete from PEmployee where id = ?";
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
            ResultSet rs= st.executeQuery("select * from PEmployee");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getDate(3));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception :" +e);
        }

    }
}