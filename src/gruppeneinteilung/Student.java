/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

import java.io.Serializable;

/**
 *
 * @author behl.claus
 */
public class Student implements Comparable<Student>, Serializable{
    private String klasse;
    private int jahrgang;
    private final String name;
    private final String geschlecht;
    private final String zweig;
    private final String fs2;
    private final String fs3;
    private final String fs4;
    private String religion;
    
   
    public Student( int jahrgang, String klasse, String name, String geschlecht, String zweig, String fs2, String fs3, String fs4, String religion) {
        this.klasse = klasse;
        this.jahrgang = jahrgang;
        this.name = name;
        this.geschlecht = geschlecht;
        this.zweig = zweig;
        this.fs2 = fs2;
        this.fs3 = fs3;
        this.fs4 = fs4;
        this.religion = religion;
    }

    
    
    public int compareTo(Student other){
         return name.compareTo(other.name);
    }
    
    public String getName() {
        return name;
    }
    
    public String toString(){
        return jahrgang+" "+klasse+" "+name+" "+geschlecht+" "+zweig+" "+fs2+" "+fs3+" "+fs4+" "+religion;
    }
    public String getKlasse(){
         return klasse;
     }
    public int getJahrgang(){
        return jahrgang;
    }
    public String getGeschlecht(){
        return geschlecht;
    }
    
    public String getZweig(){
        return zweig;
    }
    
    public String getFs2(){
        return fs2;
    }
    
    public String getFs3(){
        return fs3;
    }
    
    public String getFs4(){
        return fs4;
    }
    
    public String getReligion(){
        return religion;
    }
    
    public void setKlasse(String klasse){
        this.klasse = klasse;
    }
    
    public void setReligion(String religion){
       this.religion = religion;
    }
    
    public void setJahrgang(int jahrgang){
        this.jahrgang = jahrgang;
    }
 }
    

