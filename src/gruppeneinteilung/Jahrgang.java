/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

/**
 *
 * @author floth.rene
 */

import java.util.ArrayList;
public class Jahrgang 
{
    //Variablen--------------------------
    private final int jahrgang;
    private ArrayList<Student>[] klassen;
    private ArrayList<Student> alle;
    private int stufe;
    private int schüleranzahl;
    private int weiblich;
    private int maennlich;
    private int katholisch;
    private int evangelisch;
    private int ethik;
    private int klassenanzahl;
    private boolean nachReligion;
    private boolean nachZweig;
    private boolean nachFremdsprache;
    
 public Jahrgang(int n){
     jahrgang = n;
     alle = new ArrayList<>();
 }   
    
    
    //Methoden---------------------------

    public int getJahrgang(){
        return jahrgang;
        
    }

    
    public int getSchülerAnzahl()
    {
        return alle.size();
    }
    
    public void setKlassenanzahl(int i)
    {
        klassenanzahl = i;
    }
    
    public void setNachReligion()
    {
        nachReligion = true;
        nachZweig = false;
        nachFremdsprache = false;
    }
    public void setNachZweig()
    {
        nachReligion = false;
        nachZweig = true;
        nachFremdsprache = false;
    }
    
    public void setNachFremdsprache()
    {
        nachReligion = false;
        nachZweig = false;
        nachFremdsprache = true;
    }
    public void studentEinfuegen(Student s)
    {
        alle.add(s);
    }
    
    public void gibAlle(){
        for(Student student: alle)
            System.out.println(student);
    }
    
    public int getMaennlich(){
     return maennlich  ; 
    }
    
    public int getWeiblich(){
     return weiblich;   
    }
    
    public int getKatholisch(){
    return katholisch;    
    }
    
    public int getEvangelisch(){
        return evangelisch;
        }
    
    public int getEthik(){
        return ethik;
    }
    
    public void geschlechterBerechnen(){
     for(int i=0; i<alle.size();i++)  {
         if(alle.get(i).getGeschlecht().equals("W")){
             weiblich++;
         }else if(alle.get(i).getGeschlecht().equals("M")){
             maennlich++;
         }else{
             System.out.println("Fehler");
         }
     } 
    }
    
     public void religionenBerechnen(){
     for(int i=0; i<alle.size();i++)  {
         if(alle.get(i).getReligion().equals("RK")){
             katholisch++;
         }else if(alle.get(i).getReligion().equals("ETH")){
             ethik++;
         }else if(alle.get(i).getReligion().equals("EV")){
             evangelisch++;}else{
             System.out.println("Fehler");
         }
     } 
    }
    }

    

