
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
public class Projects {

    private int ProjectID;
    private String projectName;
    private String projectType;
    private String Descritpion;

    //object of the MysqlDatabase
    MysqlDatabase Mysql = new MysqlDatabase();

    public Projects(String projectName) {
        this.projectName = projectName;
    }

    public Projects(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public Projects() {

    }

    //get methods
    public int getProjectID() {
        return this.ProjectID;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getProjectType() {
        return this.projectType;
    }

    public String getDescritpion() {
        return this.Descritpion;
    }

    //set methods
    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setDescritpion(String Descritpion) {
        this.Descritpion = Descritpion;
    }

    //fetch method
    public boolean fetch() throws DLException {
        try {
            String sql = "Select ProjectID, projectName, projectType, Descritpion from projects Where ProjectID= ? ";
            ArrayList<String> value = new ArrayList<>();
            value.add(Integer.toString(this.getProjectID()));
            System.out.println("this.getProjectID() : "+this.getProjectID()); 
            ArrayList<String[]> data = Mysql.getData(sql,value);
            if (data.size() > 0) {
                this.setProjectID(Integer.parseInt(data.get(0)[0]));
                this.setProjectName(data.get(0)[1]);
                this.setProjectType(data.get(0)[2]);
                this.setDescritpion(data.get(0)[3]);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetch method, projects class ");
        }
    }//end of method

    public boolean fetch2() throws DLException {
        try {
            String sql = "Select ProjectID, projectName, projectType, Descritpion from projects Where  projectName ='"+this.getProjectName()+"';";
            ArrayList<String> value = new ArrayList<>();
            //value.add(Integer.toString(this.ProjectID));
            value.add(this.getProjectName());
            ArrayList<String[]> data = Mysql.getData(sql);
            if (data.size() > 0) {
                this.setProjectID(Integer.parseInt(data.get(0)[0]));
                this.setProjectName(data.get(0)[1]);
                this.setProjectType(data.get(0)[2]);
                this.setDescritpion(data.get(0)[3]);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetch method, projects class ");
        }
    }//end of method

    //put method
    public int put() throws DLException {
        try {
            String sql = "update projects set projectName = ?" + ",projectType=?" + ",Descritpion =?"
                    + "name = ? "
                    + "where ProjectID = ? ";
            ArrayList<String> values = new ArrayList<>();
            values.add(this.projectName);
            values.add(this.projectType);
            values.add(this.Descritpion);
            values.add(Integer.toString(this.ProjectID));
            int numberOfrec = Mysql.setData(sql, values);
            return numberOfrec;

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in put method, projects class ");
        }

    }// end of method

    //post method
    public int post() throws DLException {
        try {
            String sql = "insert into projects ( ProjectID, projectName, projectType,Descritpion) "
                    + "values (?,?,?,?)";
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(this.getProjectID()));
            values.add(this.getProjectName());
            values.add(this.getProjectType());
            values.add(this.getDescritpion());
            int numberOfrec = Mysql.setData(sql, values);
            return numberOfrec;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in post method, projects class ");
        }
    }//end of method 

    //Delete method
    public int delete(int ID) throws DLException {
        try {
            String sql = "delete from projects where ProjectID = ? ";
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(ID));
            int numberOfre = Mysql.setData(sql, values);
            return numberOfre;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in delete method, projects class ");
        }
    }//end of method
}
