
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammed_aljohani
 */
public class MysqlDatabase {

    private String uri = "jdbc:mysql://localhost/project_DBCA?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "1412Mm";

    Connection conn = null;

    public MysqlDatabase() {

    }
// connect method 

    public boolean connect() throws DLException {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(uri, user, password);
            return true;
        } catch (ClassNotFoundException cnfe) {
            return false;
        } catch (Exception sql) {
            throw new DLException(sql, "There is a problem with connecting with the database for the follwoing information: URI = "
                    + this.uri + " Password =" + this.password + " Username = " + this.user);
        }

    }// end of method 

    //close method 
    public boolean close() throws DLException {

        try {
            if (connect()) {
                conn.close();
            }
            return true;
        } catch (SQLException sql) {
             throw new DLException(sql, "There is a problem in close method ");
        }

    }// end of method 

    // getData method that accept an array and the query statment. 
    public ArrayList<String[]> getData(String sql, ArrayList<String> value) throws DLException {
        try {
            this.connect();
            PreparedStatement statment = this.prepare(sql, value);
            ResultSet rs = statment.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsmd.getColumnCount();
            ArrayList<String[]> table = new ArrayList<String[]>();

            while (rs.next()) {
                String[] row = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getString(i);
                }
                table.add(row);
            }
            this.close();
            return table;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in getData method with the follwoing query " + sql);
        }
    }// end of method

    // getdata method with query only 
    public ArrayList<String[]> getData(String query) throws DLException {
        try {
            this.connect();
            ArrayList<String[]> table = new ArrayList<>();
            Statement stmnt = this.conn.createStatement();
            ResultSet resultSet = stmnt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numFeild = rsmd.getColumnCount();
            while (resultSet.next()) {

                String[] row = new String[numFeild];
                for (int iCol = 1; iCol <= numFeild; iCol++) {
                    row[iCol - 1] = resultSet.getString(iCol);
                }
                table.add(row);
            }

            // this.close();
            stmnt.close();
            // this.conn.setAutoCommit(false);
            return table;

        } catch (SQLException sql) {
            throw new DLException(sql, "There is a problem in getData method with the follwoing query " + sql);
        }

    }// end of method 

    // prepared statment method
    public PreparedStatement prepare(String sql, ArrayList<String> value) throws Exception {
        try {
            PreparedStatement statment = this.conn.prepareStatement(sql);
            for (int i = 1; i <= value.size(); i++) {
                statment.setString(i, value.get(i - 1));
            }
//            this.close();
            System.out.println("statment " + statment.toString());
            return statment;

        } catch (SQLException e) {
           throw new DLException(e, "There is a problem in prepare method with the follwoing query " + sql);
        }

    }// end of method 

    // excute method that accept an array and the query statment. 
    public int executeStmt(String sql, ArrayList<String> values) throws Exception {
        try {
            System.out.println("SQL from executeStmt " + sql);
            PreparedStatement stmt = prepare(sql, values);
            int rowCount = stmt.executeUpdate();
            System.out.println(" number of updated columns " + rowCount);
            return rowCount;
        } catch (SQLException e) {
            throw new DLException(e, "There is a problem in executeStmt method with the follwoing query ");
        }

    }// end of method 

    // setData mehtod that accept an array and the query statment. 
    public int setData(String sql, ArrayList<String> values) throws DLException {
        try {
            this.connect();
            int numberOfre = 0;
            numberOfre = this.executeStmt(sql, values);
            this.close();
            return numberOfre;
        } catch (Exception e) {
              throw new DLException(e, "There is a problem in setData method with the follwoing query "+ sql);
        }
    }

    // setData method with query only 
    public boolean setData(String query) throws DLException {

        try {
            this.connect();
            Statement stmnt = this.conn.createStatement();
            int flag = stmnt.executeUpdate(query);
            if (flag > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
              throw new DLException(ex, "There is a problem in setData method with the follwoing query "+ query);

        }

    }//end mehtod 

    public void rollbackTrans() throws DLException {
        try {
            this.conn.rollback();
        } catch (SQLException ex) {
       throw new DLException(ex, "There is a problem in rollbackTrans method with the follwoing query ");

        }
    }

    public void endTrans() throws SQLException, DLException {
        try {
            this.connect();
            boolean autoCommit = this.conn.getAutoCommit();
            System.out.print("Auto commit result " + autoCommit);
            if (autoCommit == false) {
                this.conn.commit();
                this.conn.setAutoCommit(true);
            } else {
                this.conn.setAutoCommit(false);
                this.conn.commit();
                this.conn.setAutoCommit(true);
            }
            this.close();

        } catch (SQLException ex) {
            throw new DLException(ex, "There is a problem in endTrans method with the follwoing query ");

        }
    }

}
