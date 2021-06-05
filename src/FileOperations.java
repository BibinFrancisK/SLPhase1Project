import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperations {
	
	private String path;
		
	public void CreateNewFile(String fileName) throws IOException
	{
		this.path = ".\\FileFolder\\"+fileName;
		File file1 = new File(path);
		if(file1.exists()) {
			System.out.println("This file already exists!");
		}
		else {
		file1.createNewFile();
		System.out.println("File created successfully !");
		File file2 = new File(".\\FileFolder\\fileList.txt");		
		
		FileWriter fw = new FileWriter(file2, true);
		PrintWriter pw = new PrintWriter(fw);	
		pw.println(fileName);
		pw.close();
		}
		
		System.out.println("\n");
		System.out.println("Press Enter key to return to main menu...");
        try
        {
            System.in.read();
        }  
        catch(Exception e) {}
        
        System.out.println("\n");
		System.out.println("Returning to main menu...");	
		System.out.println("\n");	
	}
	
	public void displayFileNames() throws IOException {
		
		
		BufferedReader bufReader = new BufferedReader(new FileReader(".\\FileFolder\\fileList.txt"));
	    ArrayList<String> listOfLines = new ArrayList<>();

	    String line = bufReader.readLine();
	    while (line != null) {
	      listOfLines.add(line);
	      line = bufReader.readLine();
	    }
	    bufReader.close();
	    Collections.sort(listOfLines);
	    System.out.println("Current list of files:");
	    for (String element : listOfLines) {System.out.println(element);}
	    
		
		System.out.println("\n");
		System.out.println("Press Enter key to return to main menu...");
        try
        {
            System.in.read();
        }  
        catch(Exception e) {}
        
        System.out.println("\n");
		System.out.println("Returning to main menu...");	
		System.out.println("\n");
	}

	public void deleteFile(String fileName) throws IOException
	{
		
		if(fileName != "fileList.txt")  //delete the file if it is not a system file
		{
		String path = ".\\FileFolder\\"+fileName;
		try {
		Files.deleteIfExists(Paths.get(path));
		System.out.println("File deleted successfully");
		
		//modify fileList
		File file = new File(".\\FileFolder\\fileList.txt");
	    List<String> out = Files.lines(file.toPath())
	                        .filter(line -> !line.contains(fileName))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		displayFileNames(); 
		 
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Cannot delete file!");
		}
		}
		else {
			System.out.println("Cannot delete system file!");
		}
		
		 	System.out.println("\n");
			System.out.println("Press Enter key to return to main menu...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e) {}
	        System.out.println("\n");
			System.out.println("Returning to main menu...");	
			System.out.println("\n");	
	}
		
	
	public void searchFile(String fileName) throws IOException {
		
		int flag  = 0;
		
		// add fileList contents to an arraylist and search for filename
		
		BufferedReader bufReader = new BufferedReader(new FileReader(".\\FileFolder\\fileList.txt"));
	    ArrayList<String> listOfLines = new ArrayList<>();

	    String line = bufReader.readLine();
	    while (line != null) {
	      listOfLines.add(line);
	      line = bufReader.readLine();
	    }

	    bufReader.close();
	    
	    for (String element : listOfLines){
	         if (element.contains(fileName)){
	               System.out.println("File exists in the directory!");
	               flag = 1;
	         }
	         
	    }
	    if (flag == 0) {System.out.println("File does not exist in the directory!");}
	    
	    System.out.println("\n");
		System.out.println("Press Enter key to return to main menu...");
        try
        {
            System.in.read();
        }  
        catch(Exception e) {}
        System.out.println("\n");
		System.out.println("Returning to main menu...");	
		System.out.println("\n");	
}
}
	

