package bank.methods;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumOperations
{
	     public static WebDriver driver=null;
	     
	     public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	    
	   // Browser Launch
	   public static Hashtable<String,Object> browserLaunch(Object[] inputParameters)
	   {
		 
		      try{
			    String strBrowserName=(String) inputParameters[0];
			    String webDriverExePath=(String) inputParameters[1];
		   
		if(strBrowserName.equalsIgnoreCase("Chrome"))
		{
			
			    System.setProperty("webdriver.chrome.driver",webDriverExePath );	
				driver=new ChromeDriver();
				driver.manage().window().maximize();	   
		      //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		        
		} 
		else if(strBrowserName.equalsIgnoreCase("FF"))
		{
			
			    System.setProperty("webdriver.gecko.driver",webDriverExePath );	
				driver=new FirefoxDriver();
				driver.manage().window().maximize();	   
			  //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			    
		} 
		         outputParameters.put("STATUS", "PASS");
		         outputParameters.put("MESSAGE", "Action:Browser Launch, Input Given:"+inputParameters[0].toString());
		      
		      }catch(Exception e)
		      {
			      
		    	     outputParameters.put("STATUS", "FAIL");
			         outputParameters.put("MESSAGE", "Action:Browser Launch, Input Given:"+inputParameters[0].toString());

		      }
		      
		   return outputParameters;   
		   
	   }
		      
	
	   
	   
	   
	   
	   
	   //Application Launch
	  public static  Hashtable<String,Object> applicationLaunch(Object[] inputParameters)
	   { 
		  
		 
		        try{
				String strgURL=(String) inputParameters[0];
				
				   driver.get(strgURL);
				 //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				   
				  outputParameters.put("STATUS", "PASS");
				  outputParameters.put("MESSAGE", "Action: Application Launch, Input GIven:"+inputParameters[0].toString());
					
		           }catch(Exception e)
	                     {
		        	   outputParameters.put("STATUS", "FAIL");
						  outputParameters.put("MESSAGE", "Action: Application Launch, Input GIven:"+inputParameters[0].toString());
	                     }
		        
		        
		  return outputParameters;    
		      
	  }
	  
	//Send Key 
	public static Hashtable<String,Object> sendKey(Object[] inputParameters)
	{
		
		
		         try{
				  String xpath=(String) inputParameters[0];
				  String value=(String) inputParameters[1];
				//  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				  WebElement obj=driver.findElement(By.xpath(xpath));
							 obj.clear();
							 obj.sendKeys(value);
							 
							     outputParameters.put("STATUS", "PASS");
							     outputParameters.put("MESSAGE", "Action: SendKey, Input Given:"+inputParameters[1].toString());			 
							
							 
		            }catch(Exception e)
	                      {
		            	  outputParameters.put("STATUS", "FAIL");
						     outputParameters.put("MESSAGE", "Action: SendKey, Input Given:"+inputParameters[1].toString());			 
						
	                      }	
		         
		return outputParameters;         
	}
	
	
	
	 //Click 
	public static Hashtable<String,Object> click(Object[]inputParameters)
	{
		
		          try{
				  String xpath=(String) inputParameters[0];
				//  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				  
				  WebElement obj1=driver.findElement(By.xpath(xpath));
					         obj1.click();
					         
					         outputParameters.put("STATUS", "PASS");
						     outputParameters.put("MESSAGE", "Action: Click, Input Given:"+inputParameters[0].toString());			 
							         
					       
		             }
		          
		          
		               catch(Exception e)
		                  {
		            	   outputParameters.put("STATUS", "FAIL");
						     outputParameters.put("MESSAGE", "Action: Click, Input Given:"+inputParameters[0].toString());	
		                  }		
	return outputParameters;	          
		       
	}
	
	//DropDown
	public static Hashtable<String,Object> dropDown(Object[]inputParameters)
	{
		
	              try{
				  String xpath=(String) inputParameters[0];
				  String name =(String) inputParameters[1];
				  
			//	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				  
				  Select sel=new Select(driver.findElement(By.xpath(xpath)));
				  sel.selectByVisibleText(name);
				  outputParameters.put("STATUS", "PASS");
				     outputParameters.put("MESSAGE", "Action: dropdown, Input Given:"+inputParameters[1].toString());	  
				  
	                 }catch(Exception e)
                           {
	                	 outputParameters.put("STATUS", "FAIL");
					     outputParameters.put("MESSAGE", "Action: dropdown, Input Given:"+inputParameters[1].toString());	
                           }	
	              

	return outputParameters;	
	}
	
	

	public static Hashtable<String,Object> validation(Object[]inputParameters)
	{
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String xpath=(String)inputParameters[0];// we are giving xpath of webelement 
		String String1=(String)inputParameters[1]; // we r giving  String of that xpath 
		
		 WebElement web=driver.findElement(By.xpath(xpath));
		 
		String String2= web.getText();
		
			try 
			{	
			     if(String1.equalsIgnoreCase(String2))
				{
	 outputParameters.put("STATUS", "PASS");
	 outputParameters.put("MESSAGE", "Action: validation, Input Given:"+inputParameters[1].toString());	 
	 System.out.println("PASS");
				} 
			     
			     
			     else 
				{
			    	 outputParameters.put("STATUS", "FAIL");
				     outputParameters.put("MESSAGE", "Action: validation, Input Given:"+inputParameters[1].toString());	
				     System.out.println("FAIL");
				}  
			       
			}
			catch (Exception e)
			{	  
			   System.out.println(e);   
				
			}	
	return outputParameters;	
			
    }
}
