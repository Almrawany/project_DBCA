/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammed_aljohani
 */
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DLException extends Exception {

    private Exception E;

    public DLException(Exception E) {
        this.E = E;

    }

    public DLException(Exception E, String... x) {
        this.E = E;
        this.WriteLog(x);

    }

    public void WriteLog(String... x) {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        try {

            BufferedWriter PW = new BufferedWriter(new FileWriter("log.txt", true));
            PrintWriter print = new PrintWriter(PW, true);
            print.print(timeStamp); // print date and time in the log
            for (int i = 0; i < x.length; i++) {
                print.println(x[i]);
                print.println();
            }
            PW.flush();
            PW.close();
            print.flush();
            print.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // log(e.printStackTrace());
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
