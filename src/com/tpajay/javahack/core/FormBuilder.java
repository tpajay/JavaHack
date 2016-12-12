package com.tpajay.javahack.core;

import java.io.*;
import java.util.*;

/*
 *
 * Given parameters builds a JSP, app.prop fields, formnameForm.java(getters/setters)
 *
 * use:
 *   with object/bean class(use propercase per actual object):
 						  sectionname = section/form/or header name
 *		"java FormBuilder sectionname C:\path\filename.csv BeanClassName"
 *   without object/bean uses HashMap:
 *		"java FormBuilder sectionname C:\path\filename.csv HM"
 *
 * csv/commadel file structure(each section seperated by line return):
 *   field,field description,field length
 *   field,field description,field length
 *
 * property file entry output:
 *   c:\path\formname_prop.txt
 *
 *	Sample comma-del file (using format "field,fielddescription,fieldlength <return>"):
 *	FNAME,First Name,15
 *	LNAME,Last Name,15
 *	STREET, Address, 100
 *
 */

 public class FormBuilder{

	public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException{

		try{
			StringBuffer newpage = new StringBuffer();
			StringBuffer propertyfile = new StringBuffer();
			StringBuffer hiddenfieldsonly = new StringBuffer();
			String formname = (String)args[0];
			String objecttype = (String)args[2];
			if(objecttype==null) objecttype="HM";
			String formaction="ACTION";

			//usual JSP heading info
			newpage.append("<%@ page language=\"java\" import=\"java.util.*\" contentType=\"text/html\"%>\n");
			newpage.append("<%@ taglib uri=\"/WEB-INF/struts-bean.tld\" prefix=\"bean\" %>\n");
			newpage.append("<%@ taglib uri=\"/WEB-INF/struts-html.tld\" prefix=\"html\" %>\n");
			newpage.append("<%@ taglib uri=\"/WEB-INF/struts-logic.tld\" prefix=\"logic\" %>\n");
			newpage.append("<%@ page import=\"com.tpajay.product.common.*\" %>\n");
			newpage.append("<%@ page import=\"com.tpajay.product.queue.*\" %>\n");
			newpage.append("<%@ page import=\"java.text.SimpleDateFormat\" %>\n");
			newpage.append("\n");
			newpage.append("<html:html locale=\"true\">\n");
			newpage.append("\n");
			newpage.append("<head>\n");
			newpage.append("\n");
			newpage.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
			newpage.append("<meta http-equiv=\"Cache-Control\" content=\"no-cache\">\n");
			newpage.append("<meta http-equiv=\"Expires\" content=\"0\">\n");
			newpage.append("<meta http-equiv=\"Pragma\" content=\"no-cache\" >\n");
			newpage.append("\n");

			newpage.append("<%");
			newpage.append("\n");

			if(objecttype.equalsIgnoreCase("HM")){
				newpage.append("\tArrayList results_hm = (ArrayList)request.getAttribute(\"results_hm\");\n");
				newpage.append("\tif(results_hm == null) results_hm = new ArrayList();\n");
			}else{
				newpage.append("\t" + objecttype + " " + objecttype.toLowerCase() + " = (" + objecttype + ")request.getAttribute(\"" + objecttype.toLowerCase() + "\");\n");
			}
			newpage.append("\tboolean displaymode = false;\n");
			newpage.append("\n");

			BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])), 1);
			String line;
			StringTokenizer num;
			String token = "";
			boolean firsttokenprocessed = true; //not using

			int count = 1;
			String field = "";
			String field_description = "";
			String field_length = "";

			//Returning from Validation
			stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])), 1);
			newpage.append("\t//if from Validation Errors, use parameters to populate fields");
			newpage.append("\n");

			while ((line = stdin.readLine()) != null){
				num = new StringTokenizer(line,",");
				count = 1;
				field = "";
				field_description = "";
				field_length = "";
				while (num.hasMoreTokens()){
					token = (String)num.nextToken();
					if(count==1){
						field=token.replaceAll(" ","_");
					}
					if(count==2){
						field_description=token;
					}
					if(count==3){
						field_length=token;
					}
					count++;
				}

				newpage.append("\t");
				newpage.append("String " + field + " = request.getParameter(\"" + field + "\") == null ? \"\" : request.getParameter(\"" + field + "\");");
				newpage.append("\n");
			}

			newpage.append("\n");
			newpage.append("\n");

			//If not from validation then use Hashmap or Object
			if(objecttype.equalsIgnoreCase("HM")){
				newpage.append("\tif(results_hm != null && results_hm.size() > 0){");
			}else{
				newpage.append("\tif(" + objecttype.toLowerCase() + " != null){");
			}
			newpage.append("\n");

			stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])), 1);
			newpage.append("\t\t//If not from validation then use Hashmap or Object");
			newpage.append("\n");

			while ((line = stdin.readLine()) != null){
				num = new StringTokenizer(line,",");
				count = 1;
				field = "";
				field_description = "";
				field_length = "";
				while (num.hasMoreTokens()){
					token = (String)num.nextToken();
					if(count==1){
						field=token.replaceAll(" ","_");
					}
					if(count==2){
						field_description=token;
					}
					if(count==3){
						field_length=token;
					}
					count++;
				}

				newpage.append("\t\t");
				if(objecttype.equalsIgnoreCase("HM")){
					newpage.append(field + " = (String)results_hm.get(\"" + field + "\") == null ? \"\" : (String)results_hm.get(\"" + field + "\");\n");
				}else{
					newpage.append(field + " = " + objecttype.toLowerCase() + "." + field + " == null ? \"\" : " + objecttype.toLowerCase() + "." + field + ";\n");
				}
			}

			newpage.append("\t}");

			newpage.append("\n");
			newpage.append("%>");
			newpage.append("\n");
			newpage.append("\n");

			newpage.append("<title><bean:message key=\"" + formname + ".title\"/></title>\n");
			propertyfile.append("\n\n");
			propertyfile.append("################ BEGIN: "+ formname + " ################\n");
			propertyfile.append(formname + ".title=" + formname + "\n");
			newpage.append("\n");
			newpage.append("<script language=\"JavaScript\">\n");
			newpage.append("</script>\n");

			newpage.append("\n");

			newpage.append("<link href=\"./resources/css/app.css\" type=\"text/css\" rel=\"stylesheet\">\n");

			newpage.append("\n");

			newpage.append("</head>\n");

			newpage.append("\n");

			newpage.append("<body bgcolor=\"#f1f1f1\">\n");

			newpage.append("\n");

			newpage.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n");
			newpage.append("\t<tr>\n");
			newpage.append("\t\t<td>\n");
			newpage.append("\t\t\t<div class=\"Heading\"><b><bean:message key=\"heading_fallout_manager\"/></b></div>\n");
			newpage.append("\t\t</td>\n");
			newpage.append("\t</tr>\n");
			newpage.append("</table>\n");

			newpage.append("\n");

			newpage.append("<div class=\"subHeading\"><b><bean:message key=\"" + formname + ".banner\"/></b></div>\n");
			propertyfile.append(formname + ".banner=" + formname + "\n");

			newpage.append("\n");

			newpage.append("<html:errors/>\n");

			newpage.append("\n");

			newpage.append("<html:form action=\"/" + formaction + ".do\">\n");

			newpage.append("\n");

			newpage.append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"5px\" width=\"100%\">\n");
			newpage.append("<tr><td valign=\"top\">\n");

			newpage.append("\n");


			//build sections
			stdin = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])), 1);

			newpage.append("<!--HEADER NAME-->\n");
			newpage.append("\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
			newpage.append("\t\t<tr height=\"20\">\n");
			newpage.append("\t\t\t<td valign=\"bottom\" height=\"20\"><i><bean:message key=\"jsp." + formname + ".heading." + field + "\"/></i></td>\n");
			propertyfile.append("jsp." + formname.replaceAll(" ","_") + ".heading." + formname.replaceAll(" ","_") + "=" + formname + "\n");
			newpage.append("\t\t\t<td height=\"20\"></td>\n");
			newpage.append("\t\t</tr>\n");

			while ((line = stdin.readLine()) != null){
				num = new StringTokenizer(line,",");
				count = 1;
				field = "";
				field_description = "";
				field_length = "";
				while (num.hasMoreTokens()){
					token = (String)num.nextToken();
					if(count==1){
						field=token.replaceAll(" ","_");
					}
					if(count==2){
						field_description=token;
					}
					if(count==3){
						field_length=token;
					}
					count++;
				}

				newpage.append("\t\t<tr height=\"23\">\n");
				newpage.append("\t\t\t<td nowrap><b><bean:message key=\"jsp." + formname + "." + field + "\"/></b></td>\n");
				propertyfile.append("jsp." + formname + "." + field + "=" + field_description + "\n");

				newpage.append("\t\t\t<td>\n");
				newpage.append("\t\t\t\t<%if(displaymode){%>\n");
				newpage.append("\t\t\t\t\t<%=" + field + "%><html:hidden property=\"" + field + "\" value=\"<%=" + field + "%>\"/>\n");
				hiddenfieldsonly.append("<html:hidden property=\"" + field + "\" value=\"<%=" + field + "%>\"/>\n");
				newpage.append("\t\t\t\t<%}else{%>\n");
				newpage.append("\t\t\t\t\t<html:text property=\"" + field + "\" size=\"20\" maxlength=\"" + field_length + "\" value=\"<%=" + field + "%>\"/>\n");
				newpage.append("\t\t\t\t<%}%>\n");
				newpage.append("\t\t\t</td>\n");
				newpage.append("\t\t</tr>\n");
			}

			newpage.append("\t</table>\n");
			newpage.append("\n");

			//build JSP ending
			newpage.append("</td>\n");
			newpage.append("</tr>\n");
			newpage.append("</table>\n");
			newpage.append("</html:form>\n");
			newpage.append("</body>\n");
			newpage.append("</html:html>\n");

			propertyfile.append("################ END: "+ formname + " ################\n");

        	String path = "";
        	if(args[1].lastIndexOf("\\") > -1){
				path = args[1].substring(0,args[1].lastIndexOf("\\")) + "\\";
			}
			System.out.println("Path: " + path);
			System.out.println("File: " + path + formname + ".jsp");
			System.out.println("File: " + path + formname + "_prop.txt");

			boolean direxists = false;
			direxists = checkDirectory(formname);

			if(direxists) {

				BufferedWriter out = new BufferedWriter(new FileWriter(path + formname + "\\" + formname + ".jsp"));
				out.write(newpage.toString());
				out.close();

				BufferedWriter out2 = new BufferedWriter(new FileWriter(path + formname + "\\" + formname + "_prop.txt"));
				out2.write(propertyfile.toString());
				out2.close();

				BufferedWriter out5 = new BufferedWriter(new FileWriter(path + formname + "\\" + formname + "_hiddenFields.txt"));
				out5.write(hiddenfieldsonly.toString());
				out5.close();

			}

		}catch (IOException ioe){
			System.out.println("File not found.  Type \"java FormBuilder2 formname x:\\path\\filename\"");
		}catch (ArrayIndexOutOfBoundsException aiob){
			System.out.println("Please enter a filename.  java FormBuilder2 formname x:\\path\\filename\"");
		}
	}


	public static boolean checkDirectory(String strDirectoy){
		File file=new File("sections");
		boolean exists = file.exists();
		if (!exists) {
			//System.out.println("the file or directory you are searching does not exist : " + exists);
			boolean success = (new File(strDirectoy)).mkdir();
			//if (success) {
			//	System.out.println("Directory: " + strDirectoy + " created");
			//}
		}
		return true;
	}
}
