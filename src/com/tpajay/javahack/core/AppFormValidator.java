package com.tpajay.javahack.core;

import java.io.Serializable;
import java.util.*;
import java.util.regex.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.*;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Jason Muse
 *
 * Validates fields on web page using REG Expressions
 */
public class AppFormValidator implements Serializable {

	
	public static boolean validatedatetime( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		
		if(!theselection.equalsIgnoreCase("sel1")){

		    //first, check to see if datetime is null
		    if (value == null || value.length() < 1){
		      errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datetimeerror"));
		    }

			if (value != null && value.length() > 0){

				//check if Date pattern is valid
				boolean isValid = false;

			    //second, check to make sure date entered follows pattern
		    	Pattern p1 = Pattern.compile("\\b\\d{2}-\\d{2}-\\d{4}\\s\\d{2}:\\d{2}\\b"); // ex:01-01-2004 01:00
			    Pattern p2 = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\s\\d{2}:\\d{2}\\b"); // ex:01/01/2004 01:00
			    Matcher m1 = p1.matcher(value);
			    Matcher m2 = p2.matcher(value);

			  	if (m1.matches()){
			  		isValid = true;
			  	}else if (m2.matches()){
			  		isValid = true;
			  	}else{
			  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datetimeformaterror"));
			  	}

			  	if(isValid){
				  	//third, make sure date is valid (not > 31days, not > 12 months, etc..)
					String datetime_month = value.substring(0,2);
					String datetime_day = value.substring(3,5);
					String datetime_year = value.substring(6,10);
					String datetime_hour = value.substring(11,13);
					String datetime_mins = value.substring(14,16);

					if(Integer.parseInt(datetime_month) > 12){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datemontherror"));
						return false;
					}
					if(Integer.parseInt(datetime_day) > 31){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datedayerror"));
						return false;
					}
					if(Integer.parseInt(datetime_hour) > 24){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datehourerror"));
						return false;
					}
					if(Integer.parseInt(datetime_mins) > 59){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.dateminuteserror"));
						return false;
					}

					int datetimemonthcheck = Integer.parseInt(datetime_month);

					//30 day month check
					int[] thirtydaymonths = {4,6,9,11};
					for (int i=0; i < thirtydaymonths.length;i++){
						if (thirtydaymonths[i] == datetimemonthcheck){
							if(Integer.parseInt(datetime_day) > 30){
								errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datedaysinvalid"));
								return false;
							}
						}
					}

					//Leap Year check
					if(datetimemonthcheck == 2){
						int datetimeyearcheck = Integer.parseInt(datetime_year)-1900;
						if ((datetimeyearcheck % 4 == 0) && (!(datetimeyearcheck % 100 == 0)
							|| (datetimeyearcheck % 400) == 0)){
								//then leapyear, should be 29days total
								if(Integer.parseInt(datetime_day) > 29){
									errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datedaysinvalid_isleapyear"));
									return false;
								}
						}else{
							//should be 28days total
							if(Integer.parseInt(datetime_day) > 28){
								errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datedaysinvalid_notleapyear"));
								return false;
							}
						}
					}

					java.util.Date datetime_date = new java.util.Date(Integer.parseInt(datetime_year)-1900, Integer.parseInt(datetime_month)-1,
					Integer.parseInt(datetime_day), Integer.parseInt(datetime_hour), Integer.parseInt(datetime_mins));

				  	//fourth, make sure entered date is after current date/time
				  	Date today = new Date();
				  	today.getTime();
				  	if(datetime_date.before(today)){
				  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.datebeforeerror"));
				  	}
				 }
			 }
		}
	    return (errors.isEmpty());
	}


	public static boolean validateContactNo( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
			if (value == null || value.length() < 1){
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.contactnoerror"));
		    }

			if (value != null && value.length() > 0){

				Pattern p1 = Pattern.compile("\\b\\d{3}-\\d{3}-\\d{4}\\b"); // ex:813-555-1000
				Pattern p2 = Pattern.compile("\\b\\d{3}-\\d{3}-\\d{4}-\\d{4}\\b"); // ex:813-555-1000-1010
			    Matcher m1 = p1.matcher(value);
			    Matcher m2 = p2.matcher(value);

			  	if (m1.matches()){
			  		return true;
			  	}else if (m2.matches()){
			  		return true;
			  	}else{
			  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.contactnoformaterror"));
			  	}
			}
		}
	    return (errors.isEmpty());
	}

	
	
	public static boolean validateAA( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String distVer = (String)request.getParameter("distVer");		
		if ( distVer == null || distVer.length() < 1 )
			distVer = "2.0";
		String isWhat = (String)request.getParameter("isWhat");if(isWhat==null)isWhat="";

		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
		    String ag = (String)request.getParameter("ag");
		    String agdate = (String)request.getParameter("agdate");

		    if(value.equalsIgnoreCase("Y")){
				if(distVer.equalsIgnoreCase("1.0") || isWhat.equalsIgnoreCase("Y")) {
					if(ag == null || ag.length() < 1){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agnameerror"));
					}
		    		if(agdate == null || agdate.length() < 1){
		    			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdateerror"));
		    		}
				}
		    }

		    if(agdate != null && agdate.length() > 0){
		    	Pattern p1 = Pattern.compile("\\b\\d{2}-\\d{2}-\\d{4}\\b"); // ex:01-01-2005
		    	Pattern p2 = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b"); // ex:01/01/2005
		    	Matcher m1 = p1.matcher(agdate);
		    	Matcher m2 = p2.matcher(agdate);
		    	boolean isValid = false;

		  		if (m1.matches()){
		  			isValid = true;
			  	}else if (m2.matches()){
			  		isValid = true;
			  	}else{
			  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdateformaterror"));
			  	}

		  		if(isValid){
				  	//third, make sure date is valid (not > 31days, not > 12 months, etc..)
					String datetime_month = agdate.substring(0,2);
					String datetime_day = agdate.substring(3,5);
					String datetime_year = agdate.substring(6,10);

					if(Integer.parseInt(datetime_month) > 12){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdatemontherror"));
						return false;
					}
					if(Integer.parseInt(datetime_day) > 31){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdatedayerror"));
						return false;
					}

					int datetimemonthcheck = Integer.parseInt(datetime_month);

					//30 day month check
					int[] thirtydaymonths = {4,6,9,11};
					for (int i=0; i < thirtydaymonths.length;i++){
						if (thirtydaymonths[i] == datetimemonthcheck){
							if(Integer.parseInt(datetime_day) > 30){
								errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdatedaysinvalid"));
								return false;
							}
						}
					}

					//Leap Year check
					if(datetimemonthcheck == 2){
						int datetimeyearcheck = Integer.parseInt(datetime_year)-1900;
						if ((datetimeyearcheck % 4 == 0) && (!(datetimeyearcheck % 100 == 0)
							|| (datetimeyearcheck % 400) == 0)){
								//then leapyear, should be 29days total
								if(Integer.parseInt(datetime_day) > 29){
									errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdatedaysinvalid_isleapyear"));
									return false;
								}
						}else{
							//should be 28days total
							if(Integer.parseInt(datetime_day) > 28){
								errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.agdatedaysinvalid_notleapyear"));
								return false;
							}
						}
					}

				 }
		  	}
		}
	    return (errors.isEmpty());
	}

	public static boolean validateSSNTID( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;
	    
  
	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");if(theselection==null) theselection="";
		String ssnno = (String)request.getParameter("ssnno");if(ssnno==null) ssnno="";
		
		
		if((theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3"))){

		   
			if ((value == null || value.length() < 1) && (ssnno == null || ssnno.length() < 1)){
		    	errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.ssnnoerror"));
		    }

		    String ssnnotype = (String)request.getParameter("ssnno_type");

			if (value != null && value.length() > 0){
			    if(ssnnotype.equalsIgnoreCase("SSN")){
			    	Pattern p = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b"); // ssn ex:123-45-6789
					Matcher m = p.matcher(value);
					if (!m.matches()){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.ssnerror"));
					}
			    }

			    if(ssnnotype.equalsIgnoreCase("TAX")){
			    	Pattern p = Pattern.compile("\\b\\d{2}-\\d{7}\\b"); // taxid ex:12-3456789
					Matcher m = p.matcher(value);
					if (!m.matches()){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.taxiderror"));
					}
				}
			}
		    
		}
	    return (errors.isEmpty());
	}


	public static boolean validateVgn( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
		    String pttoorig = (String)request.getParameter("pttoorig");

		    if (pttoorig.equalsIgnoreCase("N")){
		    	if (value == null || value.length() < 1){
		    		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.vgnerror"));
		    	}
		    }

			if (value != null && value.length() > 0){

				Pattern p1 = Pattern.compile("\\b\\d{3}-\\d{3}-\\d{4}\\b"); //ex:813-555-1000
			    Matcher m1 = p1.matcher(value);

			  	if (m1.matches()){
			  		return true;
			  	}else{
			  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.vgnformaterror"));
			  	}
			}

		}
	    return (errors.isEmpty());
	}

	public static boolean validateFirstLastBusName( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		String distVer = (String)request.getParameter("distVer");
		if ( distVer == null || distVer.length() < 1 )
			distVer = "2.0";
		String isWhat = (String)request.getParameter("isWhat");if(isWhat==null)isWhat="";
		
		if(distVer.equalsIgnoreCase("1.0") || isWhat.equalsIgnoreCase("Y")) {
			if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){

				String firstname = (String)request.getParameter("firstname");
				String lastname = (String)request.getParameter("lastname");

				//if they all equal null throw error
				if((firstname == null || firstname.length() < 1) && (lastname == null || lastname.length() < 1)
					&& (value == null || value.length() < 1)){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.firstlastbusinessnameerror"));
				}else if(value == null || value.length() < 1){
					if(firstname == null || firstname.length() < 1){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.firstlastbusinessnameerror"));
					}
					if(lastname == null || lastname.length() < 1){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.firstlastbusinessnameerror"));
					}
				}else if((firstname == null || firstname.length() < 1) && (lastname == null || lastname.length() < 1)){
					if(value == null || value.length() < 1){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.firstlastbusinessnameerror"));
					}
				}
			}
		}
	    return (errors.isEmpty());
	}


	public static boolean validateStreetNo( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String streetname = (String)request.getParameter("streetname");
		String theselection = (String)request.getParameter("theselection");
		if(theselection==null) theselection="";
		if(streetname==null) streetname="";
		if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
		    //if (value == null || value.length() < 1){
		    //  errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.streetnoerror"));
		    //}
		}
	    return (errors.isEmpty());
	}

		
	public static boolean validateStreetName( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		String distVer = (String)request.getParameter("distVer");
		if(theselection==null) theselection="";
		if(distVer==null) distVer="";
		if ( distVer == null || distVer.length() < 1 )
			distVer = "2.0";
		String isWhat = (String)request.getParameter("isWhat");if(isWhat==null)isWhat="";
		
		if(distVer.equalsIgnoreCase("1.0") || isWhat.equalsIgnoreCase("Y")) {
			if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
				if (value == null || value.length() < 1){
				  errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.streetnameerror"));
				}
			}
		}
	    return (errors.isEmpty());
	}

	public static boolean validateCity( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		String distVer = (String)request.getParameter("distVer");
		if(theselection==null) theselection="";
		if(distVer==null) distVer="";		
		if ( distVer == null || distVer.length() < 1 )
			distVer = "2.0";

		String isWhat = (String)request.getParameter("isWhat");if(isWhat==null)isWhat="";
		if(distVer.equalsIgnoreCase("1.0") || isWhat.equalsIgnoreCase("Y")) {
			if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
				if (value == null || value.length() < 1){
				  errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.cityerror"));
				}
			}
		}
	    return (errors.isEmpty());
	}

	
	public static boolean validateStateZipcode( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		String distVer = (String)request.getParameter("distVer");
		if(theselection==null) theselection="";
		if(distVer==null) distVer="";		
		if ( distVer == null || distVer.length() < 1 )
			distVer = "2.0";
		String isWhat = (String)request.getParameter("isWhat");if(isWhat==null)isWhat="";

		if(theselection.equalsIgnoreCase("init") || theselection.equalsIgnoreCase("sel3")){
		    String country = (String)request.getParameter("country");
		   
		    if(isWhat.equalsIgnoreCase("Y"))
		    	if(country==null) country="WHT";
		    else
		    	if(country==null) country="USA";
		    String state = (String)request.getParameter("state");

		    //value = zipcode..

			if(!isWhat.equalsIgnoreCase("Y")){
			    if(country.equalsIgnoreCase("USA") || country.equalsIgnoreCase("WHT")){
					if(distVer.equalsIgnoreCase("1.0")) {
						if(state == null || state.length() < 1){
							errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.stateerror"));
						}
					}
					//zipcode
					if(value == null || value.length() < 1){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.zipcodeerror"));
					}
				}
	
				if(value != null && value.length() > 0){
				 	Pattern p1 = Pattern.compile("\\b\\d{5}\\b"); // ex:30062
				 	Pattern p2 = Pattern.compile("\\b\\d{5}-\\d{4}\\b"); // ex:30062-0000
				 	Pattern p3 = Pattern.compile("\\b\\w{6}\\b"); // ex:123456 for WHT
				 	Pattern p4 = Pattern.compile("\\b\\w{3}-\\w{3}\\b"); // ex:123-456 for WHT
				 	Pattern p5 = Pattern.compile("\\b\\w{3}\\s\\w{3}\\b"); // ex:123 456 for WHT
			    	Matcher m1 = p1.matcher(value);
			    	Matcher m2 = p2.matcher(value);
			    	Matcher m3 = p3.matcher(value);
			    	Matcher m4 = p4.matcher(value);
			    	Matcher m5 = p5.matcher(value);
	
			    	if(country.equalsIgnoreCase("WHT")){
			    		if (m3.matches()){
					  		return true;
					  	}else if (m4.matches()){
					  		return true;
					  	}else if (m5.matches()){
					  		return true;
					  	}else{
					  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.zipcodeWhatformaterror"));
					  	}			    		
			    	}else{
					  	if (m1.matches()){
					  		return true;
					  	}else if (m2.matches()){
					  		return true;
					  	}else{
					  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.zipcodeformaterror"));
					  	}
					}
				}
			}else{
					//What GBT validations
					if((String)request.getParameter("country")==null&& (state == null || state.length() < 1)){
						errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.Whatstateerror"));
					}
					//What GBT specific zip code Pattern check
					if(value != null && value.length() > 0){
					 	Pattern p1 = Pattern.compile("\\b\\d{5}\\b"); // ex:30062 for USA
					 	Pattern p2 = Pattern.compile("\\b\\d{5}-\\d{4}\\b"); // ex:30062-0000 for USA
					 	Pattern p3 = Pattern.compile("\\b\\w{6}\\b"); // ex:123456 for WHT
					 	Pattern p4 = Pattern.compile("\\b\\w{3}-\\w{3}\\b"); // ex:123-456 for WHT
					 	Pattern p5 = Pattern.compile("\\b\\w{3}\\s\\w{3}\\b"); // ex:123 456 for WHT
				    	Matcher m1 = p1.matcher(value);
				    	Matcher m2 = p2.matcher(value);
				    	Matcher m3 = p3.matcher(value);
				    	Matcher m4 = p4.matcher(value);
				    	Matcher m5 = p5.matcher(value);
		
				    	if(country.equalsIgnoreCase("WHT")){
				    		if (m3.matches()){
						  		return true;
						  	}else if (m4.matches()){
						  		return true;
						  	}else if (m5.matches()){
						  		return true;
						  	}else{
						  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.zipcodeWhatformaterror"));
						  	}
				    	}else{
						  	if (m1.matches()){
						  		return true;
						  	}else if (m2.matches()){
						  		return true;
						  	}else{
						  		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.zipcodeformaterror"));
						  	}
						}
					}
				}			
		}
		return (errors.isEmpty());
	}

		
	public static boolean validateRemarks( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

		String theselection = (String)request.getParameter("theselection");
		String theselection2 = (String)request.getParameter("theselection2");
		if(theselection2==null) theselection2="";
		if(theselection==null) theselection="";

		if(theselection2.length() < 1){
			if(theselection.equalsIgnoreCase("sel3")){
				if (value == null || value.length() < 1){
					errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.remarkserror"));
				}
			}
		}else{
			if(theselection2.equalsIgnoreCase("sel3")){
				if (value == null || value.length() < 1){
					errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.remarkserror"));
				}
			}
		}

	    return (errors.isEmpty());
	}

	
	public static boolean validateComments( Object bean, ValidatorAction va, Field field,
											ActionMessages errors, HttpServletRequest request){
	    String value = null;

	    if (field.getProperty() != null && field.getProperty().length() > 0){
	      value = ValidatorUtils.getValueAsString(bean, field.getProperty());
	    }

	    if (value == null || value.length() < 1){
	      errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("jsp.pt_request.error.commenterror"));
	    }
	    return (errors.isEmpty());
	}


	
	
	private static boolean isAlphaNumeric(String str)
	{

		boolean blnNumeric = false;
		boolean blnAlpha = false;

		char chr[] = null;
		if (str != null)
			chr = str.toCharArray();

		for(int i=0; i<chr.length; i++)
		{
			if (chr[i] >= '0' && chr[i] <= '9')
			{
				blnNumeric = true;
				break;
			}
		}

		for(int i=0; i<chr.length; i++)
		{
			if ( (chr[i] >= 'A' && chr[i] <= 'Z') || (chr[i] >= 'a' && chr[i] <= 'z') )
			{
				blnAlpha = true;
				break;
			}
		}

		return (blnNumeric && blnAlpha);
	}

	//Checks value passed to make sure it is just Aplphabet
	private static boolean isAlphabet(String str){

		boolean blnAlbhabet = false;

		char chr[] = null;
		if (str != null)
			chr = str.toCharArray();

		for(int i=0; i<chr.length; i++) {
			if ((chr[i] >= 'A' && chr[i] <= 'Z') || (chr[i] >= 'a' && chr[i] <= 'z')) {
				blnAlbhabet = true;
			}else{
				blnAlbhabet = false;
			}
			if(!blnAlbhabet){
				break;
			}
		}
		return (blnAlbhabet);
	}

}//end of Class.
