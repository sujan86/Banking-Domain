package bank.cucumbermap;
import java.util.Hashtable;

import bank.methods.HTMLReportGenerator;
import bank.methods.SeleniumOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login
{
	
	@When ("^user opens the \"(.*)\" browser and exe \"(.*)\"$")
	
	public void brwserLaunch(String bname,String exe)
	{
		Object[] input=new Object[2];
		input[0]=bname;
		input[1]=exe;
		 SeleniumOperations.browserLaunch(input);			 
	}
	
	@When ("^user enters the url \"(.*)\"$")
	public void url(String uname)
	{
		
		Object[] input1=new Object[1];
		input1[0]= uname;
		SeleniumOperations.applicationLaunch(input1);
	}
	
	@When("^user enters \"(.*)\" as username$")
	public void user_enters_as_username(String uname) throws Throwable
	{
	   
		Object[] input2=new Object[2];
		input2[0]= "//*[@id='txtuId']";
		input2[1]=uname;
      Hashtable<String,Object>input2op=SeleniumOperations.sendKey(input2);
  
   HTMLReportGenerator.StepDetails(input2op.get("STATUS").toString(),"user enters \"(.*)\" as username",input2op.get("MESSAGE").toString());   
      
	}

	@When("^user enters \"([^\"]*)\" as password$")
	public void user_enters_as_password(String pass) throws Throwable
	{
		Object[] input3=new Object[2];
		input3[0]="//*[@id='txtPword']";
		input3[1]=pass;
		Hashtable<String,Object>input3op=SeleniumOperations.sendKey(input3);
		
 HTMLReportGenerator.StepDetails(input3op.get("STATUS").toString(),"user enters \"([^\"]*)\" as password",input3op.get("MESSAGE").toString());   			
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable
	{
		Object[] input4=new Object[1];
		input4[0]= "//*[@id='login']"; 
		Hashtable<String,Object>input4op=SeleniumOperations.click(input4);
		
 HTMLReportGenerator.StepDetails(input4op.get("STATUS").toString(),"user click on Login button",input4op.get("MESSAGE").toString());  		
		
	}

	@Then("^user is on \"([^\"]*)\" main page and get msg as welcome to Admin$")
	public void user_is_on_main_page_and_get_msg_as_welcome_to_Admin(String name) throws Throwable 
	{
		 Object[] login=new Object[2];
		 login[0]="//*[text()='Admin']";
		 login[1]=name;
		 Hashtable<String,Object>loginop=SeleniumOperations.validation(login);
		 HTMLReportGenerator.StepDetails(loginop.get("STATUS").toString(),"user is on \"([^\"]*)\" main page and get msg as welcome to Admin",loginop.get("MESSAGE").toString());  
		
	}



}