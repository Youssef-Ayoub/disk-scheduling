package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class MyDraw{
    JFrame form;
    public int border=5;
    public Color color=Color.BLUE;
    public ArrayList<Integer>Points;
    public MyDraw(JFrame form,ArrayList<Integer>Points)
    {

        this.form=form;
        this.Points=Points;
    }
    public void drawLine()
    {
        JPanel pnl=new JPanel (  ){
            @Override
            public void paintComponent(Graphics g)
            {
                Graphics2D g2=(Graphics2D)g;
                g2.setStroke ( new BasicStroke ( border ));
                g2.setColor ( color );
                //x1 distance from left , x2 the size of width , y1 the distance from up,
              /*
               FCFS
               98 183 37 122 14 124 65 67

                 g2.drawLine (53 ,10,65,20 );
              g2.drawLine (65 ,20,67,30 );
              g2.drawLine (67 ,30,37,40 );
              g2.drawLine (37 ,40,14,50 );
              g2.drawLine (14 ,50,98,60 );
              g2.drawLine (98 ,60,122,70 );
              g2.drawLine (122 ,70,124,80 );
              g2.drawLine (124 ,80,183,90 );
               */
                int cnt=10;
                for ( int i=0;i<Points.size ()-1;i++ )
                {
                   // System.out.println ( Points.get ( i )+" "+Points.get ( i+1 ) );
                    g2.drawLine ( Points.get ( i) , cnt,Points.get ( i+1 ),cnt+10);
                    cnt+=10;
                }
//                g2.drawLine (53 ,10,98,20 );
//                g2.drawLine (98 ,20,183,30 );
//                g2.drawLine (183 ,30,37,40 );
//                g2.drawLine (37 ,40,122,50 );
//                g2.drawLine (122 ,50,14,60 );
//                g2.drawLine (14 ,60,124,70 );
//                g2.drawLine (124 ,70,65,80 );
//                g2.drawLine (65 ,80,67,90 );

            }
        };
        form.add ( pnl );
        pnl.setBounds ( 0,0,form.getWidth (),form.getHeight () );
    }
}
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
                    System.out.println ( "FCFS Results:" );
                    FCFS obj1 = new FCFS( n[0] ,list, head[0] ) ;
                    obj1.operate();
                    System.out.println ( "SCAN Results:" );
                    SCAN obj2 = new SCAN( n[0] ,list, head[0] ,200,false) ;
                    //last parameter is for direction of scan
                    // if direction is true then it will move right first else it will move left first
                    obj2.operate();
                    System.out.println ( "LOOK Results:" );
                    LOOK obj3 = new LOOK( n[0] ,list, head[0] ,false) ;
                    //last parameter is for direction of scan
                    // if direction is true then it will move right first else it will move left first
                    obj3.operate();
                    System.out.println ( "OPT Results:" );
                    OPT obj4 = new OPT( n[0] ,list, head[0] ) ;
                    obj4.operate();
                    System.out.println ( "Circle Look Results:" );
                    Circular_Look obj5 =new Circular_Look ( list,head[0],n[0] );
                    System.out.println ( "Cost = " +obj5.operate ());
                    System.out.println (  obj5.getPath ());
                    System.out.println ( "Circle SCAN Results:" );
                    Circular_SCAN obj6 =new Circular_SCAN ( list,head[0],n[0],200 );
                    System.out.println ( "Cost = " +obj6.operate ());
                    System.out.println (  obj6.getPath ());
                    System.out.println ( "SSTF Results:" );
                    SSTF obj7 =new SSTF ( list,head[0],n[0]);
                    System.out.println ( "Cost = " +obj7.operate ());
                    System.out.println (  obj7.getPath ());

                    JFrame frameFCFS=new JFrame ( "FCFS Algorithm" );
                    MyDraw m1=new MyDraw ( frameFCFS,obj1.getQueue () );
                    m1.drawLine ();
                    frameFCFS.setVisible ( true );
                    frameFCFS.setSize ( 400,400 );

                    JFrame frameSCAN=new JFrame ( "SCAN Algorithm" );
                    MyDraw m2=new MyDraw ( frameSCAN,obj2.getQueue () );
                    m2.drawLine ();
                    frameSCAN.setVisible ( true );
                    frameSCAN.setSize ( 400,400 );

                    JFrame frameLOOK=new JFrame ( "LOOK Algorithm" );
                    MyDraw m3=new MyDraw ( frameLOOK,obj3.getQueue () );
                    m3.drawLine ();
                    frameLOOK.setVisible ( true );
                    frameLOOK.setSize ( 400,400 );

                    JFrame frameOPT=new JFrame ( "OPT Algorithm" );
                    MyDraw m4=new MyDraw ( frameOPT,obj4.getQueue () );
                    m4.drawLine ();
                    frameOPT.setVisible ( true );
                    frameOPT.setSize ( 400,400 );

                    JFrame frameCircleLOOK=new JFrame ( "CircleLOOK Algorithm" );
                    MyDraw m5=new MyDraw ( frameCircleLOOK,obj5.getPath () );
                    m5.drawLine ();
                    frameCircleLOOK.setVisible ( true );
                    frameCircleLOOK.setSize ( 400,400 );

                    JFrame frameCircleSCAN=new JFrame ( "CircleSCAN Algorithm" );
                    MyDraw m6=new MyDraw ( frameCircleSCAN,obj6.getPath () );
                    m6.drawLine ();
                    frameCircleSCAN.setVisible ( true );
                    frameCircleSCAN.setSize ( 400,400 );

                    JFrame frameSSTF=new JFrame ( "SSTF Algorithm" );
                    MyDraw m7=new MyDraw ( frameSSTF,obj7.getPath () );
                    m7.drawLine ();
                    frameSSTF.setVisible ( true );
                    frameSSTF.setSize ( 400,400 );
                }
            };
         sendInputs.addActionListener ( al );
        }
       if(op!=3)
       {
           System.out.println ( "FCFS Results:" );
           FCFS obj1 = new FCFS( n[0] ,list, head[0] ) ;
           obj1.operate();
           System.out.println ( "SCAN Results:" );
           SCAN obj2 = new SCAN( n[0] ,list, head[0] ,200,false) ;
           //last parameter is for direction of scan
           // if direction is true then it will move right first else it will move left first
           obj2.operate();
           System.out.println ( "LOOK Results:" );
           LOOK obj3 = new LOOK( n[0] ,list, head[0] ,false) ;
           //last parameter is for direction of scan
           // if direction is true then it will move right first else it will move left first
           obj3.operate();
           System.out.println ( "OPT Results:" );
           OPT obj4 = new OPT( n[0] ,list, head[0] ) ;
           obj4.operate();
           System.out.println ( "Circle Look Results:" );
           Circular_Look obj5 =new Circular_Look ( list,head[0],n[0] );
           System.out.println ( "Cost = " +obj5.operate ());
           System.out.println (  obj5.getPath ());
           System.out.println ( "Circle SCAN Results:" );
           Circular_SCAN obj6 =new Circular_SCAN ( list,head[0],n[0],200 );
           System.out.println ( "Cost = " +obj6.operate ());
           System.out.println (  obj6.getPath ());
           System.out.println ( "SSTF Results:" );
           SSTF obj7 =new SSTF ( list,head[0],n[0]);
           System.out.println ( "Cost = " +obj7.operate ());
           System.out.println (  obj7.getPath ());

           JFrame frameFCFS=new JFrame ( "FCFS Algorithm" );
           MyDraw m1=new MyDraw ( frameFCFS,obj1.getQueue () );
           m1.drawLine ();
           frameFCFS.setVisible ( true );
           frameFCFS.setSize ( 400,400 );

           JFrame frameSCAN=new JFrame ( "SCAN Algorithm" );
           MyDraw m2=new MyDraw ( frameSCAN,obj2.getQueue () );
           m2.drawLine ();
           frameSCAN.setVisible ( true );
           frameSCAN.setSize ( 400,400 );

           JFrame frameLOOK=new JFrame ( "LOOK Algorithm" );
           MyDraw m3=new MyDraw ( frameLOOK,obj3.getQueue () );
           m3.drawLine ();
           frameLOOK.setVisible ( true );
           frameLOOK.setSize ( 400,400 );

           JFrame frameOPT=new JFrame ( "OPT Algorithm" );
           MyDraw m4=new MyDraw ( frameOPT,obj4.getQueue () );
           m4.drawLine ();
           frameOPT.setVisible ( true );
           frameOPT.setSize ( 400,400 );

           JFrame frameCircleLOOK=new JFrame ( "CircleLOOK Algorithm" );
           MyDraw m5=new MyDraw ( frameCircleLOOK,obj5.getPath () );
           m5.drawLine ();
           frameCircleLOOK.setVisible ( true );
           frameCircleLOOK.setSize ( 400,400 );

           JFrame frameCircleSCAN=new JFrame ( "CircleSCAN Algorithm" );
           MyDraw m6=new MyDraw ( frameCircleSCAN,obj6.getPath () );
           m6.drawLine ();
           frameCircleSCAN.setVisible ( true );
           frameCircleSCAN.setSize ( 400,400 );

           JFrame frameSSTF=new JFrame ( "SSTF Algorithm" );
           MyDraw m7=new MyDraw ( frameSSTF,obj7.getPath () );
           m7.drawLine ();
           frameSSTF.setVisible ( true );
           frameSSTF.setSize ( 400,400 );
       }


    }
}
