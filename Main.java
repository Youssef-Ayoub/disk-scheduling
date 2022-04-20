package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer>list = new ArrayList<Integer>() ;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println ( "1- Take input from command line \n" +
                "2- Take input from file\n"
         +"3- Take input from GUI \n");
        int op;
        op=input.nextInt ();
        final Integer[] n = {0};
        final Integer[] head = {0};
        if(op==1)
        {
            System.out.println("enter the number of requests ahead");
            n[0] = input.nextInt() ;

            System.out.println("enter the head start");
            head[0] = input.nextInt() ;

            System.out.println("enter the disk queue");

            for( int i = 0; i < n[0]; ++i){
                list.add( input.nextInt() );
            }
        }

       else if(op==2)
        {
            String path="E:\\compuer science material\\CS-3_S2\\Advanced os\\Assign2\\input.txt";
            File myObj = new File (path ); // created a file object named myObj
            String str="";
            int lineNum=0;
            try (Scanner MyReader = new Scanner ( myObj )) {
                while (MyReader.hasNextLine ( )) {
                    lineNum++;
                    String info = MyReader.nextLine ( );
                    if(lineNum==1)
                    {
                      n[0] = Integer.parseInt ( info);
                    }
                    else if(lineNum==2)
                    {
                        head[0] =Integer.parseInt ( info );
                    }
                    else{
                        String temp="";
                        info+=' ';
                        for ( int i=0;i<info.length ();i++ )
                        {
                            if(info.charAt ( i )==' ')
                            {
                                list.add(Integer.parseInt ( temp ));
                                temp="";
                            }
                            else
                            {
                               temp+=info.charAt ( i );
                            }
                        }
                    }
                 // System.out.println ( info );
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace ( );
            }
        }
       else
        {

            final int[] tempn = {0};
            JFrame GUIFrame = new JFrame ( "inputs" );
            GUIFrame.setLayout ( new FlowLayout (  ) );
            JLabel numElmeMessage=new JLabel ( "Enter the number of request a head" );
            JLabel numHeadMessage=new JLabel ( "Enter the head start" );
            JLabel DiskQueueMessage=new JLabel ( "Enter the disk queues" );
            JTextField numElmeMessageField =new JTextField (30 );
            JTextField numHeadField =new JTextField (30 );
            JTextField DiskQueuesField=new JTextField (30 );
            JButton sendInputs=new JButton ( "Send" );
            sendInputs.setPreferredSize ( new Dimension ( 100,50 ) );
            numElmeMessage.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            numHeadMessage.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            DiskQueueMessage.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            sendInputs.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            numElmeMessageField.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            numHeadField.setFont ( new Font("SansSerif", Font.BOLD, 15)  );
            DiskQueuesField.setFont ( new Font("SansSerif", Font.BOLD, 15)  );

            GUIFrame.setVisible ( true );
            GUIFrame.setSize ( 400,400 );
            GUIFrame.add ( numElmeMessage );
            GUIFrame.add ( numElmeMessageField );
            GUIFrame.add ( numHeadMessage );
            GUIFrame.add ( numHeadField );
            GUIFrame.add (DiskQueueMessage );
            GUIFrame.add (DiskQueuesField);
            GUIFrame.add ( sendInputs );
            ActionListener al=new ActionListener ( ) {
                @Override
                public void actionPerformed ( ActionEvent e ) {
                  n[0] =Integer.parseInt ( numElmeMessageField.getText ());
                  head[0] =Integer.parseInt ( numHeadField.getText () );
                  String info="";
                  info=DiskQueuesField.getText ();
                  info+=' ';
                  String temp="";
                    for ( int i=0;i<info.length ();i++ )
                    {
                        if(info.charAt ( i )==' ')
                        {
                            //System.out.println ( temp );
                            list.add(Integer.parseInt ( temp ));
                            temp="";
                        }
                        else
                        {
                            temp+=info.charAt ( i );
                        }
                    }
                    FCFS obj1 = new FCFS( n[0] ,list, head[0] ) ;
                    obj1.operate();

                    SCAN obj2 = new SCAN( n[0] ,list, head[0] ,200,false) ;
                    //last parameter is for direction of scan
                    // if direction is true then it will move right first else it will move left first
                    obj2.operate();

                    LOOK obj3 = new LOOK( n[0] ,list, head[0] ,false) ;
                    //last parameter is for direction of scan
                    // if direction is true then it will move right first else it will move left first
                    obj3.operate();

                    OPT obj4 = new OPT( n[0] ,list, head[0] ) ;
                    obj4.operate();
                    Circular_Look obj5 =new Circular_Look ( list,head[0],n[0] );
                    System.out.println ( "Cost = " +obj5.operate ());
                    System.out.println (  obj5.getPath ());
                    Circular_SCAN obj6 =new Circular_SCAN ( list,head[0],n[0],200 );
                    System.out.println ( "Cost = " +obj6.operate ());
                    System.out.println (  obj6.getPath ());
                    SSTF obj7 =new SSTF ( list,head[0],n[0]);
                    System.out.println ( "Cost = " +obj7.operate ());
                    System.out.println (  obj7.getPath ());

                }
            };
         sendInputs.addActionListener ( al );
        }
       if(op!=3)
       {
           FCFS obj1 = new FCFS( n[0] ,list, head[0] ) ;
           obj1.operate();

           SCAN obj2 = new SCAN( n[0] ,list, head[0] ,200,false) ;
           //last parameter is for direction of scan
           // if direction is true then it will move right first else it will move left first
           obj2.operate();

           LOOK obj3 = new LOOK( n[0] ,list, head[0] ,false) ;
           //last parameter is for direction of scan
           // if direction is true then it will move right first else it will move left first
           obj3.operate();

           OPT obj4 = new OPT( n[0] ,list, head[0] ) ;
           obj4.operate();
           Circular_Look obj5 =new Circular_Look ( list,head[0],n[0] );
           System.out.println ( "Cost = " +obj5.operate ());
           System.out.println (  obj5.getPath ());
           Circular_SCAN obj6 =new Circular_SCAN ( list,head[0],n[0],200 );
           System.out.println ( "Cost = " +obj6.operate ());
           System.out.println (  obj6.getPath ());
           SSTF obj7 =new SSTF ( list,head[0],n[0]);
           System.out.println ( "Cost = " +obj7.operate ());
           System.out.println (  obj7.getPath ());
       }


    }
}
