public class UnknownCommandException extends Exception
{
	public UnknownCommandException()
	{
		super("Please enter a valid command!");
	}
	public UnknownCommandException(String message)
	{
		super(message);
	}
}