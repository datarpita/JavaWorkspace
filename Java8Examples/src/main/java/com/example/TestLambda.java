package com.example;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestLambda {
	
	public static void main(String[] args) {
		/** Example 1
		 * 
		 */
		// Implementation for FileFilter interface as anonymous class
		/*FileFilter f = new FileFilter() {			
			public boolean accept(File pathname) {				
				return pathname.getName().endsWith(".java");
			}
		};*/
		
		FileFilter fLambda = (File pathname) -> pathname.getName().endsWith(".java");
		
		File dir = new File("D:\\Arpita\\eclipse-workspace\\auth-web_basic\\src\\main\\java\\com\\pluralsight\\security");
		//File[] files = dir.listFiles(f);
		File[] files = dir.listFiles(fLambda);
		for (File file : files) {
			System.out.println(file.getName());
		}
		
		/** Example 2
		 * 
		 */
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length()==s2.length())
					return 0;
				else if (s1.length()<s2.length())
					return -1;
				else
					return 1;
			}
		};
		
		Comparator<String> compLambda = (String s1, String s2) -> {
			if (s1.length()==s2.length())
				return 0;
			else if (s1.length()<s2.length())
				return -1;
			else
				return 1;
		};
		
		ArrayList<String> strArrList = new ArrayList<>();
		strArrList.add("Bhaswati");
		strArrList.add("Ranjit");
		strArrList.add("Arpit");
		strArrList.add("Snigdha");
		Collections.sort(strArrList, compLambda);
		
		System.out.println("After sorting by length"); 
		for (String s : strArrList) {
			System.out.println(s);
		}
		
		
	}

}
