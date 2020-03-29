/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahdeed Azhar
 */
public class Node {
    Node parent;
    int state;
    int action;
    int pathCost;

    public Node() {
    }

    public Node(Node parent, int state, int action, int pathCost) {
        this.parent = parent;
        this.state = state;
        this.action = action;
        this.pathCost = pathCost;
    }

    public int getState() {
        return state;
    }
    
    
    
}
