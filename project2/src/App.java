import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start");
        testDB();
        System.out.println("End");
    }
    private static void testDB() throws ClassNotFoundException, SQLException{
        //Load driver
        Class.forName("org.h2.Driver");
        
        String url="jdbc:h2:mem:test";
        String user ="sa";
        String password="";
        Connection cn = DriverManager.getConnection(url, user, password);
        System.out.printf("Conected to %s@%s\n",user,url);

        //Create table
        var sql ="""
            CREATE TABLE  PRODUCT (
                id INTEGER not NULL, 
                description VARCHAR(50),   
                brand VARCHAR(30), 
                price number, 
                PRIMARY KEY ( id ))""";     
        var st = cn.createStatement();
        st.executeUpdate(sql);
        System.out.printf("Table %s created\n", "product");

        String insertString ="insert into PRODUCT (id, description, brand, price) values ('%s','%s','%s',%f)";
        
        //Populate table
        st.executeUpdate(String.format(insertString, 1, "Test product1", "Acme", 100.98));
        st.executeUpdate(String.format(insertString, 2, "Test product 1","TNT",1786.0));
        
        //Get rows from table
        sql= "select * from product";
        var rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.printf("Product-> id:%d, description:%s, brand:%s, price: %.2f\n",
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDouble(4)
            );
        }
        cn.close();
    }
}
