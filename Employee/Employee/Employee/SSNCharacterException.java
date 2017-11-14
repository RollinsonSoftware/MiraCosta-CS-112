public class SSNCharacterException extends Exception
{
	public SSNCharacterException()
	{
		super("ERROR! Please only enter digits for your SSN!");
	}
	public SSNCharacterException(String message)
	{
		super(message);
	}
}