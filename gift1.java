/*
ID: nikhita1
LANG: JAVA
PROG: gift1
*/
import java.io.*;
public class gift1 {

	

	public static void main(String[] args) {
		String[] names = new String[0];
		int[] accounts = new int[0];
		int[] giveAmount = new int[0];
		String[][] recipients = new String[0][0];
		
		String thisLine = null;
		String[] strs = new String[2];
		int count = 0;
		int np = 0;
		String giver = "";
		String data = "";
		BufferedReader br = null;
		
		 try {
		      
	         br = new BufferedReader(new FileReader("gift1.in"));
	         
	         while ((thisLine = br.readLine()) != null) {
	        	 if (count == 0) {
	        		 np = Integer.parseInt(thisLine);
	        		 names = new String[np];
	        		 accounts = new int[np];
	        		 giveAmount = new int[np];
	        		 recipients = new String[np][];
	        		 
	        	 } else if (count > 0 && count <= np) {
	        		 names[count-1] = thisLine;
	        		 accounts[count-1] = 0;
	        		 giveAmount[count-1] = 0;
	        		 
	        	 }
	             else {
	            	
	            	 giver = thisLine;
	            	 thisLine = br.readLine();
	            	 strs = thisLine.trim().split("\\s+");
	            	 for (int i = 0; i < names.length; i++) {
	            		  if (giver.equals(names[i])) {
	            			  giveAmount[i] = Integer.parseInt(strs[0]);
	            			  recipients[i] = new String[Integer.parseInt(strs[1])];
	            			  
	            			  for (int j = 0; j < recipients[i].length; j++) {
	            				  thisLine = br.readLine();
	            				  recipients[i][j] = thisLine;
	            			  }
	            			  
	            			  break;
	            		  }
	            	 }
	             }
	        	 
	        	 count++;
	         }       
	      } catch(Exception e) {
	         e.printStackTrace();
	     
	    }
		 
		
		for (int k = 0; k < giveAmount.length; k++) {
			for (int m = 0; m < recipients[k].length; m++) {
				for (int n = 0; n < names.length; n++) {
					if ((recipients[k][m].equals(names[n])) && (recipients[k].length != 0)) {
						accounts[n] += (giveAmount[k]/recipients[k].length);
					}
				}
			}
		   if (recipients[k].length != 0) {
			   accounts[k] -= (giveAmount[k]-(giveAmount[k]%recipients[k].length)); 
		   }
		   
		}
	    
	    FileOutputStream out;
		try {
			out = new FileOutputStream("gift1.out");
			for (int p = 0; p < names.length; p++) {
				data = (names[p]) + " " + (accounts[p]) + "\n";
				out.write(data.getBytes());
			}
			
		    out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    //try {
		  // br.close();
	    //} catch (IOException e) {
		  // e.printStackTrace();
	    //}      
			

	}

	

}
