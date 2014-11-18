package Data.serutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class JXCFile {
	  String name;
	  
      public JXCFile(String s){
    	  name=s;
      }
      
      public ArrayList<Object>read(){
    	  ArrayList<Object> a=new ArrayList<Object>();
		  Object b;
		    try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
	            b=(Object)ois.readObject();
	            while(b!=null){
	            a.add(b) ;
	            b=(Object)ois.readObject();
	            }
	            ois.close();
	    } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	    }
		return a;  
      }
      
      public void write(ArrayList<Object> a){
    	  try {
              ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name)); 
              for(int i=0;i<a.size();i++)
                 oos.writeObject(a.get(i));
              oos.close();                       
          } catch (Exception ex) {  
        	ex.printStackTrace();     	
          }
      }
      
      public void write(Object a){
    	  try {
              ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name,true)); 
              oos.writeObject(a);
              oos.close();                       
          } catch (Exception ex) {  
        	ex.printStackTrace();     	
          }
      }
      
      
}
