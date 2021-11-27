package OpenSource.Automation.Tests.Test;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import OpenSource.Automation.PageObjects.PageObjectsFT;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestSetup {
	
	public static WebDriver driver;  
	public static PageObjectsFT po;
	public static ExtentReports er; 
	public static ExtentTest test; 
	public static Logger log=LogManager.getLogger(TestSetup.class.getName());
	
	@Test(dataProvider="getData")
	public void  launchLogin(String browser,String URL) 
	{
		System.out.println(browser+URL);
		String path 	=	System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println(path);
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Reports Selenium Open Source Tool ");
		reporter.config().setDocumentTitle("Web Automation Reports Selenium Open Source Tool ");
		er	= new ExtentReports(); 
		er.attachReporter(reporter);	
		er.setSystemInfo("Software Tester Name - ", "SR07" );
		
		test	=	er.createTest("Initial Demonstration");
		
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		
		if (browser=="chrome") 
		{
			driver=new ChromeDriver();  
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(URL);
		}
			
		
		try
		{
			Assert.assertEquals(driver.getTitle(), "Invest in Mutual funds Online | Mutual fund Schemes in India - Franklin Templeton India®");	
			log.info("Launch Login Executed Successfully ");
			test.info("Launch Login Executed Successfully "); 
			
		}catch(Exception e)
		{
			log.error("Launch Login Not Executed Successfully ");		
			test.fail("Launch Login Executed Successfully "); 

		}			
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[1][2]; 		// 1 data sets  with 2 columns 
		obj[0][0]	=	"chrome";
		obj[0][1]	=	"https://www.franklintempletonindia.com/"; 
		
		return(obj); 
	}
	
	@Test(description="Verifying the FT logo in  website") 
	public void verifyLogo()
	{
		po=new PageObjectsFT(driver); 
		String logo=	po.logo().getAttribute("title");
		
		try
		{
			Assert.assertEquals(logo, "Franklin Templeton Investments");	
			log.info("Verify Logo Executed Successfully ");
			test.info("Verify Logo Executed Successfully "); 
			
		}
		catch(Exception e)
		{
			log.error("Verify Logo Not Executed Successfully ");
			test.fail("Verify Logo Not Executed Successfully "); 
		}
			
	}			
		
	@Test(description="Verifying MarketInsights on FT Page") 
	public void verifyMarketInsights()
	{
		po=new PageObjectsFT(driver); 
		String mi=	po.marketInsights().getText();
			
		try
		{
			Assert.assertEquals(mi.trim(), "Market Insights");		
			log.info("Verify Market Insights Executed Successfully ");
			test.info("Verify Market Insights Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Market Insights Not Executed Successfully ");	
			test.fail("Verify Market Insights Not Executed Successfully ");
		}			
		
	}
	

	
	
	@Test(description="Verifying Report on FT Page") 
	public void verifyReports()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.reports().getText();
			
		try
		{
			Assert.assertEquals(report.trim(), "Reports");	
			log.info("Verify Reports Executed Successfully ");
			test.info("Verify Reports Executed Successfully ");

			
		}catch(Exception e)
		{
			log.error("Verify Reports Not Executed Successfully ");	
			test.fail("Verify Reports Not Executed Successfully ");	
		}			
		
	}
	
	@Test(description="Verifying Feedback on FT Page") 
	public void verifyFeedback()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.feedback().getText();
			
		try
		{
			Assert.assertEquals(report.trim(), "Feedback");		
			log.info("Verify Feedback Executed Successfully ");
			test.info("Verify Feedback Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Feedback Not Executed Successfully ");
			test.fail("Verify Feedback Executed Successfully ");
		}			
		
	}
	
	@Test(description="Verifying InvestorEducaton on FT Page") 
	public void verifyInvestorEducation()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.investerEducation().getText();
			
		try
		{
			Assert.assertEquals(report.trim(), "Investor Education");
			log.info("Verify Investor Functionality Executed Successfully ");
			test.info("Verify Investor Functionality Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Investor Functionality  Not Executed Successfully ");	
			test.fail("Verify Investor Functionality  Not Executed Successfully ");	
		}			
		
	}
	
	@Test(description="Verifying CustomerService on FT Page") 
	public void verifyCustomerService()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.CustomerService().getText();
			
		try
		{
			Assert.assertEquals(report.trim(), "Customer Service");	
			log.info("Verify Customer Service Executed Successfully ");
			test.info("Verify Customer Service Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Customer Service Not Executed Successfully ");
			test.fail("Verify Customer Service Not Executed Successfully ");
		}			
		
	}
	
	@Test(description="Verifying fundSolution on FT Page") 
	public void verifyFundSolution()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.fundSolution().getText();
			
		try
		{
			Assert.assertEquals(report.trim(), "Funds & Solutions");
			log.info("Verify Fund Solution Executed Successfully ");
			test.info("Verify Fund Solution Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Fund Solution Not Executed Successfully ");	
			test.fail("Verify Fund Solution Not Executed Successfully ");	
		}			
		
	}
		
	@Test(description="Verifying searchBox on FT Page") 
	public void verifySearchBox ()
	{
		po=new PageObjectsFT(driver); 
		String report=	po.searchBox().getAttribute("id");
			
		try
		{
			Assert.assertEquals(report.trim(), "siteSeachInputDesktop");	
			log.info("Verify Search Box  Executed Successfully ");
			test.info("Verify Search Box  Executed Successfully ");
			
		}catch(Exception e)
		{
			log.error("Verify Search Box  Not Executed Successfully ");	
			test.fail("Verify Search Box  Not Executed Successfully ");
		}			
		
	}
	
	@Test(description="Verify Login/Registration on FT WebPage")
	public void  verifyLogin()
	{
		po=new PageObjectsFT(driver);
		String login=po.Login().getAttribute("class").trim(); 
		
		try
		{
			Assert.assertEquals(login, "fti-loginBtn btn dropdown-toggle webLoginDropdownMenu"); 
			log.info("Verify Login Executed Successfully ");
			test.info("Verify Login Executed Successfully ");
		} 
		catch(Exception e)
		{
			log.error("Verify Login Not Executed Successfully ");
			test.fail("Verify Login Not Executed Successfully ");
		}
		
		
		
	}
	
	@AfterTest
	public void flushObjects ()
	{
		er.flush();
	}
	

	
	
}
