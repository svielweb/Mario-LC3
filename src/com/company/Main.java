package com.company;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = -1;
        boolean valid = false;
        String build;
        String choice = "";
        String route ="MarioPyramid.txt";
        ArrayList<String> pyramid = new ArrayList<> ();

        while(!valid){
            try{
                System.out.println("How should the result be output?(Console or Text?");
                choice = sc.nextLine();



                if(choice.equalsIgnoreCase("Console")|| choice.equalsIgnoreCase("Text")){
                    valid = true;
                } else {
                    System.out.println("Please choose either Console or Text");
                }
            } catch(Exception e){
                System.out.println("Invalid entry. Please choose an output method. (Console or Text");

            }


        }
        valid = false;

        if(choice.equalsIgnoreCase("Console")){
            System.out.println("How high would you like the pyramid?(0-23)");
            while(!valid ){
                try{

                    height = sc.nextInt();
                    while(height < 0 || height > 23){
                        System.out.println("Please enter an integer between 0-23.");
                        System.out.println();
                        height = sc.nextInt();
                    }
                    valid = true;
                } catch(Exception e){
                    System.out.println("Please enter an integer between 0-23.");
                    System.out.println();
                    height = -1;
                }
            }

            for(int i = 0; i < height; i++){
                int run = 0;
                build = "";
                for( int l = 0; l < height - i - 1; l++ ){

                    build += " ";
                    run++;
                }
                for( int l = 0; l < height - run + 1; l++){
                    build += "#";
                }
                System.out.println(build);
            }


        } else if(choice.equalsIgnoreCase("Text")){

             String path;
             boolean append = false;



            JFileChooser f = new JFileChooser(".");

            f.setDialogTitle("Select Quiz File");
            FileNameExtensionFilter filter =
                    new FileNameExtensionFilter("Text File (*.txt)", "txt");
            f.setFileFilter(filter);
            JDialog dg = new JDialog();
            int rval = f.showOpenDialog(dg);

            route = f.getSelectedFile().getAbsolutePath();



            try {
                System.out.println("How high would you like the pyramid?(0-23)");
                while(!valid ){
                    try{

                        height = sc.nextInt();
                        while(height < 0 || height > 23){
                            System.out.println("Please enter an integer between 0-23.");
                            System.out.println();
                            height = sc.nextInt();
                        }
                        valid = true;
                    } catch(Exception e){
                        System.out.println("Please enter an integer between 0-23.");
                        System.out.println();
                        height = -1;
                    }
                }
                PrintWriter out = new PrintWriter(
                        new FileWriter(route));
                for(int i = 0; i < height; i++){
                    int run = 0;
                    build = "";
                    for( int l = 0; l < height - i - 1; l++ ){

                        build += " ";
                        run++;
                    }
                    for( int l = 0; l < height - run + 1; l++){
                        build += "#";
                        pyramid.add(build);
                    }
                    out.println(build);


                }
                out.close();

            } catch(Exception e){
                System.out.println("Error");


            }

        }
        //end of elseif
    }
}