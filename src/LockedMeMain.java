import java.io.File;
import java.nio.*;
import java.util.Scanner;

public class LockedMeMain {
	
	static FileOperations file = new FileOperations();
	
	
	public static void main (String[] args)
	{
	
	System.out.println("----------Lockerz-----------");
	System.out.println("Developed by: Bibin Francis");
	System.out.println("----------------------------");
		
	Scanner input = new Scanner(System.in);

	//Take inputs
	System.out.println("1. View the files.");
	System.out.println("2. Add a new file.");
	System.out.println("3. Delete a file.");
	System.out.println("4. Search for a file.");
	System.out.println("5. Exit.");
	System.out.println("----------------------------");
	
	System.out.println("Enter your choice number: ");
	
	
	String s = input.next();
	try {
	int n = Integer.parseInt(s);
	
	switch(n)
	{
	case 1:
	try {
	file.displayFileNames();
	}
	catch(Exception e) {
		System.out.println("Cannot list file names!");
		e.printStackTrace();
	}
	finally {
		main(null);}
	break;
	
	case 2:
	System.out.println("Enter the name of the new file: ");
	String fileName = input.next();
	if (fileName != "fileList.txt") {
		try {
			file.CreateNewFile(fileName);
			}
			catch(Exception e) {
				System.out.println("Cannot create file!");
				e.printStackTrace();
				}
			finally {
			main(null);
			}		
		}
	else {
		System.out.println("Cannot overwrite system file!");
		System.out.println("Use another file name.");
	}
	break;
	
	case 3:
	System.out.println("Enter the name of the file you want to delete: ");
	String fileToDelete = input.next();
	file.deleteFile(fileToDelete);
	main(null);
	break;
	
	case 4:
	System.out.println("Enter the name of the file you want to search: ");
	String fileToSearch = input.next();
	file.searchFile(fileToSearch);
	main(null);
	break;
	
	case 5:
	System.out.println("Exiting...");
	System.exit(0);
	break;
	
	default:
	System.out.println("Invalid input. Please enter a valid choice number!");
	System.out.println("\n");
	main(null);
	}	
	}
	catch(Exception e)
	{
		System.out.println("Invalid input. Please enter a valid choice number!");
		System.out.println("\n");
		main(null);
	}
	
	}
}
