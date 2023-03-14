/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package penjat;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author orjon
 */
public class Penjat {
public static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
        
       final char[][] estatPenjatInicial =
        {
          {' ',' ',' ',' ','_','_','_','_',' ',' ',' ',' '},                                      
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ','_','_','|','_',' ',' ',' ',' ',' ',' ',' '},                                      
          {'|',' ',' ',' ',' ','|','_','_','_','_','_',' '},
          {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
          {'|','_','_','_','_','_','_','_','_','_','_','|'}
         };   
        
        
        final String[] paraules = {"patata","armari","bicicleta",
                            "advocat","ascensor","astronauta","autopista",
                            "avinguda","bigoti","carretera","castanya",
                            "cervell","civada","cultura","dentista","esquena",
                            "estrella","formatge","gendre","genoll",
                            "infermera","internet","maduixa","malaltia",
                            "maluc","mandarina","maquinista","motocicleta",
                            "nebot","pastanaga","patinet","perruqueria",
                            "pissarra","professor","quadrat","taronja",
                            "tramvia","trapezi","tricicle","violeta"};
        
        
        final int MAXINTENTS = 7;
        
            
            // Estat gràfic del joc durant la partida
            char[][] estatPenjat = 
              new char[estatPenjatInicial.length][estatPenjatInicial[0].length];
            
            
            // Inicialitzar el dibuix del penjat
            inicialitzarEstatPenjat(estatPenjatInicial,estatPenjat);
            
            
            mostrarEstatPenjat(estatPenjat);
            
            // Seleccionar la paraula aleatòriament
            int index = (int)(Math.random()*paraules.length);
            String paraula = paraules[index];
            // Eliminar aquesta línia quan el joc estigui completat
            paraula = "patata";
            
            
            int totalEncerts = 0,totalErrors = 0;
            
            // Estructra de dades (array) per saber quines lletres portem 
            //encertades            
            boolean[] lletresEncertades = new boolean[paraula.length()];
            
            // Llistat de lletres que hem introduït
            String lletres = "";
            
            do {
            
                
            } while(totalEncerts < paraula.length() && totalErrors < MAXINTENTS);
        
    }
    
    
    static void mostrarEstatPenjat(char[][] estat) {
        
        for (char[] fila : estat) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            System.out.println("");
        }
        
    }
    
    static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {
    
        for (int i = 0; i < estatPenjatIni.length; ++i) {
            for (int j = 0; j < estatPenjatIni[0].length; ++j) {
                estat[i][j] = estatPenjatIni[i][j];
            }
        }
        
    }
    
    static void mostrarParaula(String paraula, boolean[] encertades) {
        
       for (int i = 0; i < paraula.length(); i++){
            if (encertades[i] == true){
                System.out.print(paraula.charAt(i));
            }
            else{
                System.out.print("*");
            }
        }
        System.out.println("");
        
    }
    
    static void mostrarLletresIntroduides(String lletres) {
         for (int i = 0; i < lletres.length(); i++){
            System.out.print(lletres.charAt(i));
        }
        System.out.println("");
        
    }
    
    static String demanarLletra(String lletres) {
        String lletraDemanada = sc.nextLine();
        return lletraDemanada;      
    }
    
    static boolean existeixLletra(String lletres, char lletra) {
        boolean estaLletra = false;
        for (int i = 0; i < lletres.length(); i++){
            if (lletres.charAt(i) == Character.toLowerCase(lletra)){
                estaLletra = true;
            }
        }
        return estaLletra;
    
    }
    
    static void actualitzarEstatPenjat(char[][] penjat,int errors) {
         int fila = 1;
        int columna = 8;
        switch (errors){
            case 1:
                penjat[fila][columna] = '|';
                break;
            case 2:
                penjat[fila+1][columna] = 'o';
                break;
            case 3:
                penjat[fila+2][columna] = '|';
                break;
            case 4:
                penjat[fila+2][columna-1] = '/';
                break;
            case 5:
                penjat[fila+2][columna+1] = '\\';
                break;
            case 6:
                penjat[fila+3][columna] = '|';
                break;
            case 7:
                penjat[fila+4][columna-1] = '/';
                break;  
            case 8:
                penjat[fila+4][columna+1] = '\\';
                break;
        }
    }
    
    static void netejaPantalla() {
        try{
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").
                    inheritIO().start().waitFor();
                } else{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
        }catch(IOException | InterruptedException ex){}
    }
    
    }