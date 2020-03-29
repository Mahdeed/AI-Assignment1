
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahdeed Azhar
 */
public class Driver {
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        String initial,goal;
        System.out.println("Enter initial state: ");
        initial=s.nextLine();
        System.out.println(initial);
        System.out.println("Enter goal state: ");
        Scanner s1=new Scanner(System.in);
        goal=s1.nextLine();
    
        GraphSearch g=new GraphSearch();
        g.getPlan(initial, goal);
        
                    
    }
    
}

