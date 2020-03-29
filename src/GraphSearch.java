
import java.util.Arrays;
import java.util.LinkedList;
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
public class GraphSearch {
     
    Queue<Node> frontier;
    Queue<Node> ExploredSet;
      int m;
        int n;
        int t;
    int [][] transitionTable;
    String [] states;
    String [] permissibleActions;
    int goal=-1;
    
    public GraphSearch() {
        m=8;
        n=3;
        t=2;
        states=new String[]{"AgentInRoom1, Room1Dusty, Room2Dusty",
          "AgentInRoom1, Room1Dusty, Room2Clean",
          "AgentInRoom1, Room1Clean, Room2Dusty",
          "AgentInRoom1, Room1Clean, Room2Clean",
          "AgentInRoom2, Room1Dusty, Room2Dusty",
          "AgentInRoom2, Room1Dusty, Room2Clean", 
          "AgentInRoom2, Room1Clean, Room2Dusty",
          "AgentInRoom2, Room1Clean, Room2Clean"};
       
        permissibleActions=new String[]{"Clean","MoveToRoom1","MoveToRoom2"};
        
        transitionTable=new int[][]{{2, 0, 4},
            {3, 1, 5},
            {2, 2, 6},
            {3, 3, 7},
            {5, 0, 4},
            {5, 1, 5},
            {7, 2, 6},
            {7, 3, 7}};
        
        frontier=new LinkedList<>();
        ExploredSet=new LinkedList<>();
    }

    public void getPlan(String initialState, String finalState)
    {
        Boolean[] added = new Boolean[m];
        Arrays.fill(added, Boolean.FALSE);
        int initial=-1;
        for(int i=0;i<m;i++)
        {
            if(states[i].equals(initialState))
            {
                initial=i;
            }
        }
        if(initial==-1)
        {
            System.out.println("invalid initial state");
        }
        
        for(int i=0;i<m;i++)
        {
            if(states[i].equals(finalState))
            {
                goal=i;
            }
        }
        if(goal==-1)
        {
            System.out.println("invalid goal state");
        }
        
       frontier.add(new Node(null,initial,-1, 0));
       while(!frontier.isEmpty())
       {          
           if(frontier.peek().state==goal)
           {
               ExploredSet.add(frontier.peek());
               break;
           }
           
           added[frontier.peek().state]=true;
                    
           for(int i=0;i<n;i++)
           {
               if(!added[transitionTable[frontier.peek().state][i]]){
               frontier.add(new Node(frontier.peek(),transitionTable[frontier.peek().state][i],i,0));
               added[frontier.peek().state]=true;
               }
           }
           ExploredSet.add(frontier.peek());
           frontier.remove();
        
       }
       ExploredSet.remove();
       System.out.println("path is:");
       
       while(!ExploredSet.isEmpty())
           {
               
               System.out.println(permissibleActions[ExploredSet.remove().action]);
                  
           }
           
           
           
     
   
    }
    
}

