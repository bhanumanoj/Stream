package com.cg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> xlist=new ArrayList<String>();
		File fileX=new File("x.txt");
		@SuppressWarnings("resource")
		Stream<String> streamX = Files.lines(Paths.get(fileX.getAbsolutePath()));
		streamX.forEach(xlist::add);
		
		
		List<String> ylist=new ArrayList<String>();
		File fileY=new File("y.txt");
		@SuppressWarnings("resource")
		Stream<String> streamY = Files.lines(Paths.get(fileY.getAbsolutePath()));
		streamY.forEach(ylist::add);
		
		
		StringBuilder equals = new StringBuilder();
		StringBuilder weak = new StringBuilder();
		StringBuilder breaks= new StringBuilder();
		    
		    
		for(int i=0; i<8; i++){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate date1 = LocalDate.parse(xlist.get(i).substring(15,26), formatter);
		LocalDate date2 = LocalDate.parse(ylist.get(i).substring(15,26), formatter);   
			long noOfDaysBetween = ChronoUnit.DAYS.between(date1,date2);
			
			
		float v1 = Float.parseFloat(ylist.get(i).substring(27,34));
		float v2 = Float.parseFloat(xlist.get(i).substring(27,34));
		float diff = v1-v2;

		    
		        if(xlist.get(i).substring(2).equals(ylist.get(i).substring(2))){
		            equals.append(xlist.get(i).substring(0,2)+ylist.get(i).substring(0,2)+" ,");
		    }
		    
		    else if(noOfDaysBetween>1 || diff>0.015){
		        breaks.append(xlist.get(i).substring(0,2)+ylist.get(i).substring(0,2)+" ,");
		    }
		    
		    
		        else if(!(xlist.get(i).substring(4,13).equals(ylist.get(i).substring(4,13)))){
		        	breaks.append(xlist.get(i).substring(0,2)+ylist.get(i).substring(0,2)+" ,");
		        }
		        else{
		            weak.append(xlist.get(i).substring(0,2)+ylist.get(i).substring(0,2)+" ,");
		        }
		}    

		System.out.println("equals "+equals);
		System.out.println("weak "+weak);
		System.out.println("break "+breaks);

		
		
	}

}
