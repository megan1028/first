
public class FileInvalidException extends Exception{
public FileInvalidException() {
	super( "Error: Detected Empty Field!"+
           "----------------------------"+
			"-----------------------------");
}
public FileInvalidException(String msg) {
	super("File is Invalid: Field \""+msg+"\" is empty. Processing stoped at this point. Other empty fields may be present as well.");
}
public String toString() {
	return super.getMessage();
}
}
