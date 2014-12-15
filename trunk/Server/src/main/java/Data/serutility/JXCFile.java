package Data.serutility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class JXCFile {
	static String time;
	String name;

	public JXCFile(String s) {
		time=getTime();
		name = "src/main/java/"+time+"/"+s;
	}

	
	public static String getTime(){
		
	
        try{
			
			File file=new File("src/main/java/init.txt");
	        if(!file.exists()){
	        	
	        	file.createNewFile();
	        	return null;
	            
	        }
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
	        String temp = null;
	        temp = br.readLine();
	        time=temp;
	        br.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
        return time;
	}
	
	public static void setTime(String s){
		
        try{		
			File file=new File("src/main/java/init.txt");
	        if(!file.exists()){   	
	        	try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

	        }
	        
	        BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			bw.write(s);	       
			bw.close();
		   }
		catch (IOException e){
			e.printStackTrace();
		}
        
}
	
	public static void init(String time){
		File outfile = new File("src/main/java/"+time+"/");                 
		  if(!outfile .exists()  && !outfile .isDirectory()){
		      outfile.mkdir();
		}
		setTime(time);
	}
	
	public ArrayList<Object> read() {
		ArrayList<Object> ls = new ArrayList<Object>();

		try {
			FileInputStream fin = new FileInputStream(name);
			if (fin.available() <= 0) {
				fin.close();
				return null;

			} else {
				ObjectInputStream in = new ObjectInputStream(fin);
				while (fin.available() > 0) {
					ls.add(in.readObject());
				}
				in.close();

				return ls;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(name + "文件不存在");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void write(ArrayList<Object> ls) {

		try {
			boolean isexist = false;
			File file = new File(name);
			if (file.exists())
				isexist = true;
			FileOutputStream fo = new FileOutputStream(name, true);
			long pos = 0;

			ObjectOutputStream os;
			os = new ObjectOutputStream(fo);
			if (isexist) {
				pos = fo.getChannel().position() - 4;
				fo.getChannel().truncate(pos);
			}

			for (Object o : ls) {
				os.writeObject(o);
			}
			os.close();

			// 当删除所有数据后，直接将这个文件删除、、、yan
			if (ls.size() == 0) {
				File f = new File(name);
				f.delete();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改的情况下，需要删除原来的数据，重新写入，所以新建一个writeM给modify方法——yan
	public void writeM(ArrayList<Object> ls) {
		File ff = new File(name);
		ff.delete();
		try {
			boolean isexist = false;
			File file = new File(name);
			if (file.exists())
				isexist = true;
			FileOutputStream fo = new FileOutputStream(name);
			long pos = 0;

			ObjectOutputStream os;
			os = new ObjectOutputStream(fo);
			if (isexist) {
				pos = fo.getChannel().position() - 4;
				fo.getChannel().truncate(pos);
			}

			for (Object o : ls) {
				os.writeObject(o);
			}
			os.close();

			// 当删除所有数据后，直接将这个文件删除、、、yan
			if (ls.size() == 0) {
				File f = new File(name);
				f.delete();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(Object o) {
		try {
			boolean isexist = false;
			File file = new File(name);
			if (file.exists())
				isexist = true;
			FileOutputStream fos = new FileOutputStream(name, true);
			long pos = 0;

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if (isexist) {
				pos = fos.getChannel().position() - 4;
				fos.getChannel().truncate(pos);
			}
			oos.writeObject(o);

			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 向文件中写入一个对象，覆盖原来的所有内容
	public void writeM(Object a) {
		File ff = new File(name);
		ff.delete();
		try {
			boolean isexist = false;
			File file = new File(name);
			if (file.exists())
				isexist = true;
			FileOutputStream fo = new FileOutputStream(name);
			long pos = 0;

			ObjectOutputStream os;
			os = new ObjectOutputStream(fo);
			if (isexist) {
				pos = fo.getChannel().position() - 4;
				fo.getChannel().truncate(pos);
			}

			os.writeObject(a);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		JXCFile.init("2014-11-01");
//		JXCFile file=new JXCFile("figures.ser");
//		Integer i=new Integer(1);
//		file.write(i);
//		ArrayList<Object> a=file.read();
//		if(a==null)
//			System.out.println("空哒！");
//		else{
//			for(Object o:a)
//				System.out.println((Integer)o);
//		}
		
	}
}
