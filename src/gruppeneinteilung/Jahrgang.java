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
    private ArrayList<Klasse> klassen;
    private ArrayList<Student> alle;
    private int stufe;
    private int schüleranzahl;
    private int weiblich;
    private int maennlich;
    private int katholisch;
    private int evangelisch;
    private int ethik;
    private int GY;
    private int GY_MU;
    private int GY_TH;
    private int GY_NTG;
    private int GY_WSG;
    private int GY_SG;
    private int klassenanzahl;
    private boolean nachReligion;
    private boolean nachZweig;
    private boolean nachFremdsprache;
    
    public static void main(String[] args){
        Gruppeneinteilung ge = new Gruppeneinteilung("ASV.csv");
        Jahrgang j = ge.jahrgaenge.get(3);
       j.test();
    }
    
    
 public Jahrgang(int n){
     
     
     jahrgang = n;
     alle = new ArrayList<>();
 }   
    
    
    //Methoden---------------------------

    public int getJahrgang(){
        return jahrgang;
        
    }

    
    public int getSchuelerAnzahl()
    {
        return alle.size();
    }
    public ArrayList<Klasse> getKlassen() {
        return klassen;
    }
    public int getKlassenanzahl() {
        return klassenanzahl;
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
        geschlechterBerechnen();
        religionenBerechnen();
        zweigeBerechnen();
    }
    
    public void ausgabeAlle() {
        for (Student student : alle) {
            System.out.println(student);
        }
    }
    
    public ArrayList<Student> gibAlle(){
        return alle;
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
    public int getGY(){
        return GY;
    }
    public int getGY_MU(){
        return GY_MU;
    }
    public int getGY_TH(){
        return GY_TH;
    }
    public int getGY_NTG(){
        return GY_NTG;
    }
    public int getGY_WSG(){
        return GY_WSG;
    }
    public int getGY_SG(){
        return GY_SG;
    }
    
    public void geschlechterBerechnen(){
        maennlich = 0;
        weiblich = 0;
     for(int i=0; i<alle.size();i++)  {
         if(alle.get(i).getGeschlecht().equals("W")){
             weiblich++;
         }else if(alle.get(i).getGeschlecht().equals("M")){
             maennlich++;
         }else{
             System.out.println("geschlechter f");
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
             System.out.println("reli f");
         }
     }
     }
     public void zweigeBerechnen(){
     for(int i=0; i<alle.size();i++)  {
         if(alle.get(i).getZweig().equals("GY")){
             GY++;
         }else if(alle.get(i).getZweig().equals("GY_MU")){
             GY_MU++;
         }else if(alle.get(i).getZweig().equals("GY_TH")){
             GY_TH++;
         }else if(alle.get(i).getZweig().equals("GY_NTG_8")){
             GY_NTG++;
             }else if(alle.get(i).getZweig().equals("GY_WSG-S_8")){
             GY_WSG++;
             }else if(alle.get(i).getZweig().equals("GY_SG_8")){
             GY_SG++;
         }else{
             System.out.println("zweig f");
         }
     }
     
    }
     
     
     public void test()
     {
              
        System.out.println("Schüleranzahl: " + getSchuelerAnzahl());
        geschlechterBerechnen();
        religionenBerechnen();
        System.out.println("Männlich: " + getMaennlich());
        System.out.println("Weiblich: " + getWeiblich());
        System.out.println("EV: " + getEvangelisch());
     }
     
     public void inKlassenEinteilen()
     {
         for(int i = 0; i < getSchuelerAnzahl(); i ++)
         {
             
         }
     }
    }
