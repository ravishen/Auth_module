import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String commaSeperated;
		Scanner input = new Scanner(System.in);
		commaSeperated = input.nextLine();
		String[] values = convert(commaSeperated);
		for(String current : values) {
			checkPassword(current);
		}
	}
	
	public static String[] convert(String input) {
		String[] inputArr = input.split(",");
		return inputArr;
	}
	
	public static void checkPassword(String input) {
		if(!checkLength(input))return ;
		if(!checkOccurence(input))return;
		if(!checkNonOccurence(input))return;
		System.out.println(input +" Success");
	}
	
	public static boolean checkLength(String input) {
		if(input.length()>=6&&input.length()<=12) {
			return true;
		}
		if(input.length()<6) {
			System.out.println(input+" Failure Password must be at least 6 characters long.");
			return false;
		}
		if(input.length()>12) {
			System.out.println(input+" Failure Password must be at max 12 characters long.");
			return false;
		}
		return false;
	}
	
	public static boolean checkOccurence(String input) {
		String regex ="[a-z]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		boolean isPresent = false;
		while(m.find()) {
			isPresent = true;
		}
		if(!isPresent) {
			System.out.println(input+" Failure Password must contain at least one letter from a-z.");
			return false;
		}
		
		isPresent = false;
		regex = "[0-9]";
		p=Pattern.compile(regex);
		m = p.matcher(input);
		while(m.find()) {
			isPresent = true;
		}
		if(!isPresent) {
			System.out.println(input+" Failure Password must contain at least one letter from 0-9.");
			return false;
		}
		
		isPresent = false;
		regex = "[A-Z]";
		p=Pattern.compile(regex);
		m = p.matcher(input);
		while(m.find()) {
			isPresent = true;
		}
		if(!isPresent) {
			System.out.println(input+" Failure Password must contain at least one letter from A-Z.");
			return false;
		}
		
		isPresent = false;
		regex = "[*$_#=@]";
		p=Pattern.compile(regex);
		m = p.matcher(input);
		while(m.find()) {
			isPresent = true;
		}
		if(!isPresent) {
			System.out.println(input+" Failure Password must contain at least one letter from *$_#=@.");
			return false;
		}
		return true;
	}

	public static boolean checkNonOccurence(String input) {
		String regex ="[%!)(]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		boolean isPresent = false;
		while(m.find()) {
			isPresent = true;
		}
		if(isPresent) {
			System.out.println(input+"  Failure Password cannot contain %!)(.");
			return false;
		}
		return true;
	}
}