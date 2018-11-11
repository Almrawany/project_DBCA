
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
public class People_projects {

    //constractor that has two parameters. 
    public People_projects(int ProjectID, int PeopleID) {
        this.PeopleID = PeopleID;
        this.ProjectID = ProjectID;
    } //end of method. 

    //constractor that has no parameters 
    public People_projects() {

    }// end of method

    MysqlDatabase Mysql = new MysqlDatabase();
    private int ProjectID;
    private int PeopleID;
    private String projectName;
    private String peopleName;
    private String Descritpion;
    private String projectType;
    private String projectcomment;
    private String status;
    //-----------get the variables------------------

    public String getStatus() {
        return status;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public int getPeopleID() {
        return PeopleID;
    }

    public String getprojectName() {
        return projectName;
    }

    public String getpeopleName() {
        return peopleName;
    }

    public String getDescritpion() {
        return Descritpion;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getProjectcomment() {
        return projectcomment;
    }
    //-------------set the variables;-------------------

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setPeopleID(int PeopleID) {
        this.PeopleID = PeopleID;
    }

    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }

    public void setpeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public void setDescritpion(String Descritpion) {
        this.Descritpion = Descritpion;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setProjectcomment(String projectcomment) {
        this.projectcomment = projectcomment;
    }

    //fetch method
    public boolean fetch() throws DLException {
        System.out.println("here is the fetch for project People");
        try {
            String sql = "select people_projects.projectID, people_projects.peopleID, projectName,name, Descritpion  from people_projects join people on id=peopleID join projects "
                    + "on projects.ProjectID = people_projects.projectID where projects.ProjectID =" + this.getProjectID()
                    + " and peopleID =" + this.getPeopleID() + ";";

            ArrayList<String[]> data = Mysql.getData(sql);
            if (data.size() > 0) {
                this.setPeopleID(Integer.parseInt(data.get(0)[0]));
                this.setProjectID(Integer.parseInt(data.get(0)[1]));
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetch method, People_projects class ");
        }
    }//end of method

    //listing all the projects 
    public ArrayList<People_projects> ListingProjectPeople() throws DLException {
        String allPeoplequery = "select people_projects.projectID, people_projects.peopleID from people_projects "
                + "join people on id=peopleID join projects on projects.ProjectID = people_projects.projectID;";

        ArrayList<People_projects> peopleproject = new ArrayList<>();
        try {
            System.out.println("try ListOfAllprojectpeople ");
            for (String[] info : this.Mysql.getData(allPeoplequery)) {
                for (int i = 0; i < info.length; i++) {
                    peopleproject.add(new People_projects(Integer.parseInt(info[i]), Integer.parseInt(info[i])));
                }
            }
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in ListingProjectPeople method, People_projects class ");
        }
        return peopleproject;
    }//end of method

    // inserting into the people_projects table  
    public boolean post(int PeopleID) throws DLException {
        try {
            String sql = "insert into people_projects( ProjectID, PeopleID, comment ,status) "
                    + "values (?,?,?,?)";
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(this.getProjectID()));
            values.add(Integer.toString(PeopleID));
            values.add(" ");
            values.add("creator");
            Mysql.setData(sql, values);
            return true;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in post method, People_projects class ");
        }
    }//end of method

        public boolean post() throws DLException {
        try {
            String sql = "insert into people_projects( ProjectID, PeopleID, comment ,status) "
                    + "values (?,?,?,?)";
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(this.getProjectID()));
            values.add(Integer.toString(PeopleID));
            values.add(this.getProjectcomment());
            values.add("pending");
            Mysql.setData(sql, values);
            return true;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in post method, People_projects class ");
        }
    }
    //deleting from the people_projects table
    public int delete(int ProjectID) throws DLException {
        try {
            System.out.println(" this is the begining of the delete method in people_projects ");
            String sql = "delete from people_projects where ProjectID = ? ";
            System.out.println("sql " + sql);
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(ProjectID));
            int numberOfre = Mysql.setData(sql, values);
            return numberOfre;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in delete method, People_projects class ");
        }
    }//end of method 

    public boolean put() throws DLException {
        try {
            String sql = "update people_projects set status = ? , comment = ? where ProjectID = ? and PeopleID = ? ";
            ArrayList<String> values = new ArrayList<>();
            values.add(this.getStatus());
            values.add(this.getProjectcomment());
            values.add(Integer.toString(this.getProjectID()));
            values.add(Integer.toString(this.getPeopleID()));
            int numberOfrec = Mysql.setData(sql, values);
            return true;

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in put method, people class ");
        }

    }
}
