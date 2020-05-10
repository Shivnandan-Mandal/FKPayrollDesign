import java.sql.*;
public class DatabaseEmployee {
    DatabaseEmployee()
    {

    }
    public static void add(Employee e)
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:Payroll"))
        {
            Statement st  =  conn.createStatement();
            st.execute("create table if not exists Employee (id int , name varchar(30), mop varchar(30) , type varchar(30))");
            String sql = "insert into Employee values(?,?,?,?)";
            try(PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setInt(1, e.getID());
                ps.setString(2, e.getName());
                ps.setString(3, e.getMOP());
                ps.setString(4, e.getType());
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
        String sql = " delete from Employee where id = ?";
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
            ResultSet rs= st.executeQuery("select * from Employee");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception :" +e);
        }

    }
}