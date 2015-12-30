package lab.synah.cd.monairteletmoi.model;

import java.io.Serializable;

/**
 * Created by Michelo on 29/12/15.
 */
public class Suscriber implements Serializable {

    private int id;
    private String fullname;
    private String phonenumber;
    private String town;


    public Suscriber(){
        //Null constructor
    }

    public Suscriber(int id, String fullname, String phonenumber, String town){
        this.id=id;
        this.fullname=fullname;
        this.phonenumber=phonenumber;
        this.town=town;
    }

    private int getId(){return id;}

    private String getFullname(){return fullname;}

    private String getPhonenumber(){return phonenumber;}

    private  String getTown(){ return town;}



}
