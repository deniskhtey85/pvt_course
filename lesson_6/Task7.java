package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task7 {

	public static void main(String[] args) {
		
				
	//	int n; //количество строк
		
		//1
		System.out.println("Task7_1");
		int n;
        String[] rows;
        Scanner scan = new Scanner (System.in);
        System.out.println("Input number of rows:\n> ");
        if (scan.hasNextInt ()) { 
        	n = Integer.parseInt (scan.nextLine ());
        	     	
            int indexMax = 0;
            int indexMin = 0;
            rows = new String[n]; 

            for (int i = 0; i < n; i++) {
            	System.out.println("Input row " + (i + 1) + " :\n> ");
                rows[i] = scan.nextLine ();
                if (rows[i].length () <= rows[indexMin].length ())
                    indexMin = i;
                if (rows[i].length () >= rows[indexMax].length ())
                    indexMax = i;
            	}
         
            System.out.printf("MIN row (length %d): \"%s\"%n", rows[indexMin].length (), rows[indexMin]);
            System.out.printf("MAX row (length %d): \"%s\"%n", rows[indexMax].length (), rows[indexMax]);
			}
        
        //2
        System.out.println("Task7_2");
        System.out.println("Input number of rows:\n> ");
        if (scan.hasNextInt ()) {
            n = Integer.parseInt (scan.nextLine ());
            List<String> list = new ArrayList<String> ();
            for (int i = 0; i < n; i++) {
            	System.out.println("Input row " + (i + 1) + " :\n> ");
                list.add (scan.nextLine ());
            }
            StringLengthSort sort = new StringLengthSort ();
            Collections.sort (list, sort);
            for (int i = 0; i < n; i++) {
                System.out.println ("(" + list.get (i).length () + "): \"" + list.get (i) + "\"");
            }
        }
        
        //3
        System.out.println("Task7_3");
        System.out.println("Input number of rows:\n> ");
        if (scan.hasNextInt ()) {
            n = Integer.parseInt (scan.nextLine ());
        int average = 0;
        rows = new String[n];
        for (int i = 0; i < n; i++) {
        	System.out.println("Input row " + (i + 1) + " :\n> ");
            rows[i] = scan.nextLine ();
            average += rows[i].length ();
        }
        average = average / n;

        System.out.printf ("AVERAGE (%d)\n", average);
        for (int i = 0; i < n; i++) {
            if (rows[i].length () < average)
                System.out.println ("(" + rows[i].length () + "): \"" + rows[i] + "\"");
        }
        } 
        
        //4
        System.out.println("Task7_4");
        String[] words;
        String textCopy;
        System.out.println("Input number of rows:\n> ");
        if (scan.hasNextInt ()) {
            n = Integer.parseInt (scan.nextLine ());
            textCopy = scan.nextLine ();
            
            words = textCopy.split (" ", n);
            String wordMinChar = words[0];
            int sizeMinChar = new HashSet<String> (Arrays.asList (words[0].split (""))).size ();
	
            for (String word :	words) {
            	Set<String> set = new HashSet<String> (Arrays.asList (word.split ("")));
            	if (set.size () < sizeMinChar) {
            		wordMinChar = word;
            		sizeMinChar = set.size ();
            	}
            }
        System.out.println (wordMinChar);
        }   
        
        //5
        
        
        
	}
        
}
