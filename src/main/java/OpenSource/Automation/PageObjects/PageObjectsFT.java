package OpenSource.Automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsFT {
	
	WebDriver driver; 
	
	By logo					=		By.xpath("//img[@src='/content-international/campaigns/en-in-retail/fti_logo.png']");
	By loginButton			=		By.xpath("//div/a[@class='fti-loginBtn btn dropdown-toggle webLoginDropdownMenu']");
	By fundSolution			=		By.xpath("//li/a[@id='funds--solutions']"); 
	By investerEducation	=		By.xpath("//li/a[@id='investor-education']"); 
	By marketInsights		=		By.cssSelector("#market-insights");
	By CustomerService		=		By.cssSelector("#customer-service");
	By searchBox			=		By.id("siteSeachInputDesktop"); 
	By reports				=		By.linkText("Reports");
	By feedback				=		By.linkText("Feedback"); 
	
	
	
	public PageObjectsFT(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	public  WebElement logo()
	{
		return(driver.findElement(logo));	
	}
	
	public  WebElement fundSolution()
	{
		return(driver.findElement(fundSolution));  
	}
	
	public  WebElement investerEducation()
	{
		return(driver.findElement(investerEducation));
	}
	
	public  WebElement marketInsights()
	{
		return(driver.findElement(marketInsights)); 
	}
	
	public  WebElement CustomerService()
	{
		return(driver.findElement(CustomerService)); 
	}
	
	public  WebElement searchBox()
	{
		return(driver.findElement(searchBox)); 
	}
	
	public  WebElement reports()
	{
		return(driver.findElement(reports)); 
	}
	
	public  WebElement feedback()
	{
		return(driver.findElement(feedback)); 
	}
	
	public WebElement Login()
	{
		return(driver.findElement(loginButton)); 
	}
	
	
	

}
