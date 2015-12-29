package lab.synah.cd.monairteletmoi.model;

import java.io.Serializable;

/**
 * Created by Michelo on 29/12/15.
 */
public class Ussd implements Serializable {

    private String name;
    private String text;

    public Ussd(){
        //Necessary for firebase's deserializer
    }

    public Ussd(String name, String text){
        this.name=name;
        this.text=text;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }


}
