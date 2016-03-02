/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

/**
 *
 * @author behl.claus
 */
public class Student implements Comparable<Student>{
    private final String klasse;
    private final String name;
    private final String geschlecht;
    private final String zweig;
    private final String fs2;
    private final String fs3;
    private final String fs4;
    private final String religion;
    
   
    public Student(String klasse, String name, String geschlecht, String zweig, String fs2, String fs3, String fs4, String religion) {
        this.klasse = klasse;
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
        return klasse+" "+name+" "+geschlecht+" "+zweig+" "+fs2+" "+fs3+" "+fs4+" "+religion;
    }
    
 }
    

