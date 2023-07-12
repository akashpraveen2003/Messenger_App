package messenger_app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService
{
	void sendMessage();
}
class SMSMessagingService implements MessagingService
{
	private String message;
	private String contact_number;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	
	public boolean valid_number(String number)
	{
		// condition for false
		 Pattern regex = Pattern.compile("^(\\+91|0)?[6789]\\d{9}$");
		 Matcher matcher = regex.matcher(number);
		 return matcher.matches();
	}
	
	public void sendMessage()
	{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your mobile Number : ");
			String number=sc.nextLine();
			if(this.valid_number(number))
			{
				this.setContact_number(number);
			}
			else
			{
				System.out.println("Invalid contact number");
				return;
			}
			System.out.println("Enter Your message : ");
			String str=sc.nextLine();
			this.message=str;
			System.out.println(this.getMessage()+" message is successfully sent using SMSMessagingService");	
	}
	
}
class EmailMessagingService implements MessagingService
{
	private String email;
	private String message;
	private String subject;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public boolean valid_email(String email)
	{
		 Pattern regex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		 Matcher matcher = regex.matcher(email);
		 return matcher.matches();
	}
	public void sendMessage()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Email_id : ");
		String email=sc.nextLine();
		if(this.valid_email(email))
		{
			this.setEmail(email);
		}
		else
		{
			System.out.println("Invalid email id");
			return;
		}
		System.out.println("Enter your subject : ");
		
		String subject=sc.nextLine();
		this.setSubject(subject);
		System.out.println("Enter your message : ");
		
		String str=sc.nextLine();
		this.setMessage(str);
			System.out.println("Subject of the email "+this.getSubject());
			System.out.println(this.getMessage()+" message is successfully sent using EmailMessagingService");
		
		}
	}

class WhatsAppMessagingService implements MessagingService
{
	private String number;
	private String message;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public boolean valid_number(String number)
	{
		// condition for false
		 Pattern regex = Pattern.compile("^(\\+91|0)?[6789]\\d{9}$");
		 Matcher matcher = regex.matcher(number);
		 return matcher.matches();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private boolean whatsapp_user_or_not(String number)			// checks whether number is present or not
	{
	 ArrayList<String> numbers= new ArrayList<String>();
	 numbers.add("9879879879");			//demo number
	 numbers.add("8546546546");
	 return numbers.contains(number);
	}
	public void sendMessage()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Number : ");
		String number=sc.nextLine();
		if(this.valid_number(number))
		{
			this.setNumber(number);
			
		}
		else
		{
			System.out.println(number+" Invalid Number entered");
			return;
		}
		if(this.whatsapp_user_or_not(number))
		{
			System.out.println("Enter your message : ");
			String str=sc.nextLine();
			this.setMessage(str);
		   System.out.println(this.getMessage()+" message is successfully sent usingWhatsAppMessagingService");
		}
		else
		{
			System.out.println("The entered number is not in the database");
			return;
		}
			
	}
}
public class Messenger_App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MessagingService whatsapp=new WhatsAppMessagingService();
		MessagingService sms=new SMSMessagingService ();
		MessagingService email=new EmailMessagingService();
		System.out.println("System started");
		while(true)
		{
			System.out.println("Enter 1 to send message in whatsapp \nEnter 2 to send message in sms \nEnter 3 to send message in email \nEnter 4 to exit");
			int input=sc.nextInt();
			switch(input)
			{	
			case 1:
			{
				
				whatsapp.sendMessage();
				break;
				
			}
			case 2:
			{
				sms.sendMessage();
				break;
			}
			case 3:
			{
				email.sendMessage();
				break;
			}
			case 4:
			{
				break;
			}
			default:
			{
				System.out.println("Enter a valid input");
			}
			}
			if(input==4)
			{
				System.out.println("System closed");
				break;
			}
		}

	}

}
