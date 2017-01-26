package com.tpajay.javahack.core;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.naming.*;
import javax.sql.*;

public class ParseStringTest {

	public static void main(String args[]) {



		try {

			String filename = "fil.2538_54865898_01_8824_6214_FILE_020620122029.doc";

			int x = filename.lastIndexOf(".");
			String newString1 = filename.substring(0,x); //trim the .doc off
			int i = newString1.lastIndexOf("_");
			String result = newString1.substring(i+1);


			System.out.println(">>> filename: " + filename);
			System.out.println(">>> newString1: " + newString1);
			System.out.println(">>> i: " + i);
			System.out.println(">>> result: " + result);

			String month= result.substring(0,2);
			String daytmp= result.substring(2,4);
			String year	= result.substring(4,8);
			String hour	= result.substring(8,10);
			String min	= result.substring(10,12);

			System.out.println(">>> month: " + month);
			System.out.println(">>> daytmp: " + daytmp);
			System.out.println(">>> year: " + year);
			System.out.println(">>> hour: " + hour);
			System.out.println(">>> min: " + min);


			//difference in mins between two Timestamps
			//int mins = (laterDate.getTime()/60000) - (earlierDate.getTime()/60000);
			//System.out.println(">>>> mins: " +  mins);




		}catch( Exception e ) {
			 e.printStackTrace();
		}

	}

}