package com.tsc.utility;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tsc.model.StudentModel;
import com.tsc.paging.Direction;

public class StudentComparatorsHelper {
	
	static class Key {
        String name;
        Direction dir;
        
        public Key(String name, Direction dir) {
        	this.name = name;
        	this.dir = dir;
        }
        
		public String getName() {
			return name;
		}
		public Direction getDir() {
			return dir;
		}
    }
	
	static Map<Key, Comparator<StudentModel>> map = new HashMap<>();
	
	static {
        map.put(new Key("name", Direction.asc), Comparator.comparing(StudentModel::getName));
        map.put(new Key("name", Direction.desc), Comparator.comparing(StudentModel::getName).reversed());

        map.put(new Key("grade_level", Direction.asc), Comparator.comparing(StudentModel::getGradeLevel));
        map.put(new Key("grade_level", Direction.desc), Comparator.comparing(StudentModel::getGradeLevel).reversed());

        map.put(new Key("gender", Direction.asc), Comparator.comparing(StudentModel::getGender));
        map.put(new Key("gender", Direction.desc), Comparator.comparing(StudentModel::getGender).reversed());

        map.put(new Key("gpa", Direction.asc), Comparator.comparing(StudentModel::getGpa));
        map.put(new Key("gpa", Direction.desc), Comparator.comparing(StudentModel::getGpa).reversed());

        map.put(new Key("notebooks", Direction.asc), Comparator.comparing(StudentModel::getNotebooks));
        map.put(new Key("notebooks", Direction.desc), Comparator.comparing(StudentModel::getNotebooks).reversed());
        
        map.put(new Key("bikedetails", Direction.asc), Comparator.comparing(StudentModel::getBikedetails));
        map.put(new Key("bikedetails", Direction.desc), Comparator.comparing(StudentModel::getBikedetails).reversed());
        
        map.put(new Key("activities", Direction.asc), Comparator.comparing(StudentModel::getActivities));
        map.put(new Key("activities", Direction.desc), Comparator.comparing(StudentModel::getActivities).reversed());
        
        map.put(new Key("admissiondate", Direction.asc), Comparator.comparing(StudentModel::getAdmissiondate));
        map.put(new Key("admissiondate", Direction.desc), Comparator.comparing(StudentModel::getAdmissiondate).reversed());
    }

	
	 public static Comparator<StudentModel> getComparator(String name, Direction dir) {
		 
		 List<Key> keysfound = map.keySet()
				 				  .stream()
				 				  .filter(k -> k.getName().equals(name) && k.getDir().equals(dir))				 				
				 				  .collect(Collectors.toList());
		 		
		
		 if (keysfound != null && keysfound.size()==1) {
			 return map.get(keysfound.get(0));
		 }else {
			 return null;
		 }
	 }
	 
	 private StudentComparatorsHelper() {}
}
