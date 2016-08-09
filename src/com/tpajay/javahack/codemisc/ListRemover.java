package com.tpajay.javahack.codemisc;

import java.io.*;
import java.util.*;

//Takes two lists:
//List1: main list of all items
//List2: items to be removed from List1
//Code removes the items in List2 from List1 and outputs the results
 public class ListRemover {

	public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{

		try{
			//cv list - argument 1
			BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])), 1);

			//inactive list - argument 2
			BufferedReader stdin2 = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])), 1);

			String line;
			String theid = "";
			int num_count = 0;
			StringTokenizer val;
			HashMap mainhm = new HashMap();
			HashMap hm = new HashMap();


			///////////////  First List  ///////////////////////
			while ((line = stdin.readLine()) != null){

				val = new StringTokenizer(line);

				num_count = 1;

				while (val.hasMoreTokens()){
					String token = (String)val.nextToken();

					//key,value
					switch (num_count) {
            			case 1:  hm.put("id", token.toUpperCase()); theid=token; break;
            			case 2:  hm.put("lname", token); break;
            			case 3:  hm.put("fname", token); break;
            			case 4:  hm.put("misc", token); break;
            		}
					num_count++;
				}

				for(Iterator it=hm.keySet().iterator();it.hasNext();) {
					String key=(String)it.next();
					//System.out.println("***************:"+key+"="+ (String)hm.get(key));
				}
				//System.out.println("\n\n");
				mainhm.put(theid, hm);
			}

			//////////////  Inactive List  ///////////////////
			int removed = 0;
			while ((line = stdin2.readLine()) != null){

				val = new StringTokenizer(line);
				num_count = 1;

				while (val.hasMoreTokens()){
					String token = (String)val.nextToken();

					if(num_count == 1){
						//System.out.println(token);
						if(mainhm.containsKey(token.toUpperCase())){
							mainhm.remove(token);
							removed++;
						}
					}else{
						continue;
					}
					num_count++;
				}
			}

			//////////////// create report from modified HashMap ////////////////
			StringBuffer report = new StringBuffer();
			for(Iterator it=mainhm.keySet().iterator();it.hasNext();){
				//String key = (String)it.next();
				//Map hm = (Map)it.next();
				HashMap hmtemp = (HashMap)it.next();;
				//HashMap hmtemp = (HashMap)mainhm.get(key);

				String id = (String)hmtemp.get("id");
				String lname = (String)hmtemp.get("lname");
				String fname = (String)hmtemp.get("fname");
				String misc = (String)hmtemp.get("misc");
				//report.append(id).append(",").append(lname).append(",").append(fname).append(",").append(misc).append("\n");
				System.out.println(id + "," + lname + "," + fname + "," + misc);
			}
			System.out.println(removed + " inactive users removed from main list.");

		}catch (IOException ioe){
			System.out.println("File not found.  Type \"java Counter filename\"");
		}catch (ArrayIndexOutOfBoundsException aiob){
			System.out.println("Please enter a filename.  Type \"java Counter filename\"");
		}
	}
}
