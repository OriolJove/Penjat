/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.m03.uf2a1;

import java.util.Scanner;

/**
 *
 * @author orjon
 */
public class ordenacioPaisosBombolla {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
       
        String[] paisos = new String[n];
        for (int i = 0; i < n; i++){
            String pais = sc.nextLine();
            paisos[i] = pais;
        }
       
        ordenaBombolla(paisos);
        System.out.println("Països ordenats: ");
        mostrarElements(paisos);      
    }

    static void mostrarElements(String[]p) {
        for (String pais : p) {
            System.out.println(pais);
        }
    }
   
    static void ordenaBombolla(String[]array){
        for (int i = 0; i < array.length -1; i++){
            for (int j = 0; j < array.length-i-1; j++){
                if(array[j].compareTo(array[j+1]) > 0){
                    String aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
    }
}

    
