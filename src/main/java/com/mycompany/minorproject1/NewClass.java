/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minorproject1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Shivani
 */
public class NewClass extends JFrame {

    private static void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int[][] Maze=
    {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}, 
    };
    //inside arraylist we store co-ordinate of path this co ordinate responsible to reach at destination point .
    public List<Integer>path=new ArrayList<>();
    public NewClass()
    {
        setTitle("Maze solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //it will execute an dclosed window;
        Depthfirst.searchpath(Maze, 1, 1, path);
       // System.out.println(path);
    }
    @Override
    public void paint(Graphics g)
    { 
        g.translate(50,50);
        for(int i=0;i<Maze.length;i++)
        {
            for(int j=0;j<Maze[0].length;j++)
         {
             //set color
        Color color = null;
        switch(Maze[i][j])
        {
            case 1:color=Color.BLACK;break;
            case 9:color=Color.RED;break;
            default:color=Color.WHITE;break;
        }
        g.setColor(color);
        g.fillRect(30*j,30*i,30,30);
        g.setColor(Color.RED);
        g.drawRect(30*j,30*i,30,30);
       }
      }
        for(int i=0;i<path.size();i+=2)
        {
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println("X coordinates"+pathx);
            System.out.println("Y coordinates"+pathy);
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx,30*pathy,20,20);
        }
}
    public static void main(String[]args)
    {
        NewClass s= new NewClass();
        s.setVisible(true);
    }
    
}

