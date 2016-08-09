package com.tpajay.codemisc;

import java.io.*;
import java.util.*;

//Takes a reduced/scrubbed list of all Lottery winning numbers
//and counts the number of times a certain number has hit
//Example input:
//  04 48 45 08 01 12
//  11 46 53 17 30 35
//  49 13 34 17 33 40
//  46 20 05 01 33 12
//  15 21 41 03 33 02
 public class LottoNumberCounter{

	public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{

		try{
			BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])), 1);

			String line;
			StringTokenizer num;
			int count = 0;
			String num_count_s;
			int num_count = 0;

			HashMap hm = new HashMap();

			while ((line = stdin.readLine()) != null){

				num = new StringTokenizer(line);

				while (num.hasMoreTokens()){
					String token = (String)num.nextToken();
					int thenumber = Integer.parseInt(token);

					if(hm.containsKey(token)){
						num_count_s = (String)hm.get(token);
						num_count = Integer.parseInt(num_count_s);
						num_count++;
						hm.put(token, num_count+"");
					}else{
						//key,value
						hm.put(token, "1");
					}
					//System.out.println("Token: "+token +", Value: "+num_count+"");
					count++;
				}
			}
			for(Iterator it=hm.keySet().iterator();it.hasNext();) {
				String key=(String)it.next();
				System.out.println(""+key+" = "+((String)hm.get(key)));
			}
			//System.out.println("\n" + count + " numbers read");

		}catch (IOException ioe){
			System.out.println("File not found.  Type \"java Counter filename\"");
		}catch (ArrayIndexOutOfBoundsException aiob){
			System.out.println("Please enter a filename.  Type \"java Counter filename\"");
		}
	}
}
