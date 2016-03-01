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
    private String klasse;
    private String name;
    private char geschlecht;
    private String zweig;
    private String fs2;

    public String getName() {
        return name;
    }
    private String fs3;
    private String fs4;
    private String religion;
    
    public Student(String n){
        name = n;
    }
    
    public int compareTo(Student other){
         return name.compareTo(other.name);
    }
    
 }
    

