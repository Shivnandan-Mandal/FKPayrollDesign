import java.sql.*;
import java.util.Date;
public class DatabaseCommissionedEmployee {
    public static void add(CommissionedEmployee e)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            st.execute("create table if not exists CEmployee (id int ,salary int,psdate int, rate int ,commission int,flag int)");
            String sql = "insert into CEmployee values(?,?,?,?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setInt(1, e.getID());
                ps.setInt(2, e.getSalary());
                java.util.Date d = e.getpsDate();
                java.sql.Date sqlDate =  new java.sql.Date(d.getTime()); 
                ps.setDate(3, sqlDate);
                ps.setInt(4, e.getRate());
                ps.setInt(5,e.getCommission());
                ps.setInt(6,0);
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
        String sql = " delete from CEmployee where id = ?";
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
            ResultSet rs= st.executeQuery("select * from CEmployee");
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