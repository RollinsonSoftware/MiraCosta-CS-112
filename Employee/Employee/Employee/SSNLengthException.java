public class SSNLengthException extends Exception
{
	public SSNLengthException()
	{
		super("ERROR! Your SSN must be exactly 9 digits!");
	}
	public SSNLengthException(String message)
	{
		super(message);
	}
}