
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class People {

    MysqlDatabase Mysql = new MysqlDatabase();

    public People() {

    }

    public People(String useName) {
        this.userName = useName;
    }

    public People(int peopleiID) {
        this.peopleiID = peopleiID;
    }

    //database attributes
    private int peopleiID;
    private String type;
    private String userName;
    private String password;
    private String name;
    private String tagline;
    private String title;
    private String interestArea;
    private String office;
    private String website;
    private String phone;
    private String email;

// get methods
    public int getPeopleiID() {
        return this.peopleiID;
    }

    public String getType() {
        return this.type;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getTagline() {
        return this.tagline;
    }

    public String gettitle() {
        return this.title;
    }

    public String getInterestArea() {
        return this.interestArea;
    }

    public String getOffice() {
        return this.office;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

//set methods
    public void setPeopleiID(int peopleiID) {
        this.peopleiID = peopleiID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setInterestArea(String interestArea) {
        this.interestArea = interestArea;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// fetch method by user name 
    public boolean fetch() throws DLException {
        try {
            String sql = "Select id, Type, username, name, password, tagline, title, interestArea, office, website, phone, email from people Where username =\"" + this.getUserName() + "\";";
            System.out.println(" the get sql is : " + sql);
            ArrayList<String[]> data = Mysql.getData(sql);
            if (data.size() > 0) {
                this.setPeopleiID(Integer.parseInt(data.get(0)[0]));
                System.out.println("this.setPeopleiID(Integer.parseInt(data.get(0)[0]))" + data.get(0)[0]);
                this.setType(data.get(0)[1]);
                System.out.println("this.setType(data.get(0)[1]);" + data.get(0)[1]);
                this.setUserName(data.get(0)[2]);
                System.out.println("this.setUserName(data.get(0)[2]) " + data.get(0)[2]);
                this.setName(data.get(0)[3]);
                System.out.println("this.setName(data.get(0)[3]) " + data.get(0)[3]);
                this.setPassword(data.get(0)[4]);
                System.out.println("this.setPassword(data.get(0)[4]) " + data.get(0)[4]);
                this.setTagline(data.get(0)[5]);
                System.out.println("this.setTagline(data.get(0)[5]) " + data.get(0)[5]);
                this.settitle(data.get(0)[6]);
                System.out.println("this.settitle(data.get(0)[6]) " + data.get(0)[6]);
                this.setInterestArea(data.get(0)[7]);
                System.out.println("this.setInterestArea(data.get(0)[7]) " + data.get(0)[7]);
                this.setOffice(data.get(0)[8]);
                System.out.println("this.setInterestArea(data.get(0)[8]) " + data.get(0)[8]);
                this.setWebsite(data.get(0)[9]);
                System.out.println("this.setInterestArea(data.get(0)[9]) " + data.get(0)[9]);
                this.setPhone(data.get(0)[10]);
                System.out.println("this.setInterestArea(data.get(0)[10]) " + data.get(0)[10]);
                this.setEmail(data.get(0)[11]);
                System.out.println("this.setInterestArea(data.get(0)[11]) " + data.get(0)[11]);

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetch method, people class ");
        }

    }//end of method 

    // fetch method by ID 
    public boolean fetch2() throws DLException {
        try {
            String sql = "Select id, name ,Type, username, password, tagline, title, interestArea, office, website, phone, email from people Where id =\"" + this.getPeopleiID() + "\";";
            ArrayList<String[]> data = Mysql.getData(sql);
            if (data.size() > 0) {
                this.setPeopleiID(Integer.parseInt(data.get(0)[0]));
                this.setName(data.get(0)[1]);
                this.setType(data.get(0)[2]);
                this.setUserName(data.get(0)[3]);
                this.setPassword(data.get(0)[4]);
                this.setTagline(data.get(0)[5]);
                this.settitle(data.get(0)[6]);
                this.setInterestArea(data.get(0)[7]);
                this.setOffice(data.get(0)[8]);
                this.setWebsite(data.get(0)[9]);
                this.setPhone(data.get(0)[10]);
                this.setEmail(data.get(0)[11]);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetch2 method, people class ");
        }

    }//end of method 

    //fetch method by name 
    public boolean fetchByName(String name) throws DLException {
        try {
            String sql = "Select id, name ,Type, username, password, tagline, title, interestArea, office, website, phone, email from people Where name =\"" + name + "\";";
            ArrayList<String[]> data = Mysql.getData(sql);
            if (data.size() > 0) {
                this.setPeopleiID(Integer.parseInt(data.get(0)[0])); // id 
                this.setName(data.get(0)[1]); // name 
                this.setType(data.get(0)[2]); //type 
                this.setUserName(data.get(0)[3]); //username 
                this.setPassword(data.get(0)[4]); //password
                this.setTagline(data.get(0)[5]); //tagline
                this.settitle(data.get(0)[6]); //title
                this.setInterestArea(data.get(0)[7]); // interest area 
                this.setOffice(data.get(0)[8]); // office 
                this.setWebsite(data.get(0)[9]); //website 
                this.setPhone(data.get(0)[10]); //phone
                this.setEmail(data.get(0)[11]); //email 
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in fetchByName method, people class ");

        }

    }//end of method 

//put method
    public int put() throws DLException {
        try {
            String sql = "update people set Type = ?" + ",username=?" + ",password =?,"
                    + "name = ? ," + "tagline =? ," + "title = ? ," + "interestArea = ? ,"
                    + " office = ? , " + " website = ? , " + " phone = ? ," + " email = ? "
                    + " where id = ? ";
            ArrayList<String> values = new ArrayList<>();
            values.add(this.type);
            values.add(this.userName);
            values.add(this.password);
            values.add(this.name);
            values.add(this.tagline);
            values.add(this.title);
            values.add(this.interestArea);
            values.add(this.office);
            values.add(this.website);
            values.add(this.phone);
            values.add(this.email);
            values.add(Integer.toString(this.peopleiID));
            int numberOfrec = Mysql.setData(sql, values);
            return numberOfrec;

        } catch (Exception e) {
            throw new DLException(e, "There is a problem in put method, people class ");
        }

    }//end of method 

    //post method
    public boolean post() throws DLException {
        try {
            String sql = "insert into people ( id, Type, username,password, name,tagline,title,interestArea, office, website ,phone,email ) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            ArrayList<String> values = new ArrayList<>();
            values.add(Integer.toString(this.peopleiID));
            values.add(this.type);
            values.add(this.userName);
            values.add(this.password);
            values.add(this.name);
            values.add(this.tagline);
            values.add(this.title);
            values.add(this.interestArea);
            values.add(this.office);
            values.add(this.website);
            values.add(this.phone);
            values.add(this.email);
            int numberOfrec = Mysql.setData(sql, values);
            return true;
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in post method, people class ");
        }
    }//end of method 

    // delete method
    public boolean delete() throws Exception {
        String deletePeople = "DELETE FROM people WHERE id = " + this.getPeopleiID() + ";";
        System.out.print("deleting script " + deletePeople);
        boolean checkInsert = false;
        try {
            checkInsert = Mysql.setData(deletePeople);
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in delete method, people class ");
        }
        return checkInsert;

    }// end of method

    // method for checknig the password
    public boolean passwordChecker(String thePassword) throws NoSuchAlgorithmException {
        // getting the MD5 algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");
        // initializing a byte object to store the resutl in it 
        byte[] dataBytes = new byte[1024];
        md.update(thePassword.getBytes());
        dataBytes = md.digest();
        // putting the result of conversion into a new string object
        String sb = "";
        for (int i = 0; i < dataBytes.length; i++) {
            sb += Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        if (sb.equals(this.getPassword())) {
            System.out.print("pass true");
            return true;
        } else {
            System.out.print("else pass true");
            return true;
        }
    }

    // This mehtod for searching a person.  
    public ArrayList<People> ListingPeople(String name) throws DLException {
        String allPeoplequery = "select id from people where name like '" + name + "%';";
        System.out.println("allPeoplequery :" + allPeoplequery);
        ArrayList<People> departmentPeople = new ArrayList<>();
        ArrayList<String[]> table = this.Mysql.getData(allPeoplequery);
        try {
            for (String[] info : table) {
                for (int i = 0; i < info.length; i++) {
                    People temp = new People(Integer.parseInt(info[i]));
                    departmentPeople.add(temp);
                }
            }
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in ListingPeople method, people class ");
        }
        return departmentPeople;
    }

    //this method is used to get all the people from the table for the admin.
    public ArrayList<People> ListingPeople() throws DLException {
        String allPeoplequery = "select id from people where type != 'Admin' ;";
        ArrayList<People> departmentPeople = new ArrayList<>();
        ArrayList<String[]> table = this.Mysql.getData(allPeoplequery);
        try {
            for (String[] info : table) {
                for (int i = 0; i < info.length; i++) {
                    departmentPeople.add(new People(Integer.parseInt(info[i])));
                }
            }
        } catch (Exception e) {
            throw new DLException(e, "There is a problem in ListingPeople method, people class ");
        }
        return departmentPeople;
    }

    // the converting method
    public String convertToMD5(String password) throws NoSuchAlgorithmException {
        // initilizing:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // setting up a byte object
        byte[] dataBytes = new byte[1024];
        md.update(password.getBytes());
        dataBytes = md.digest();
        String sb = "";
        for (int i = 0; i < dataBytes.length; i++) {
            sb += Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return sb;
    }

    private void peopleiID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void type(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void userName(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
