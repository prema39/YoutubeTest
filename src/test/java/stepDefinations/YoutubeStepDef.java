package stepDefinations;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.YouTubeChannelPage;
import pages.YoutubeChannelResultsPage;
import pages.YoutubeChannelSearchPage;
import utils.ConfigReader;
import utils.DriverManager;

public class YoutubeStepDef {

	WebDriver driver;
	ConfigReader cr = new ConfigReader();

	YoutubeChannelSearchPage ycsp;
	YoutubeChannelResultsPage ycrp;
	YouTubeChannelPage ycp;

	@Before
	public void initialize() {
		driver = DriverManager.getDriver();
	}

	@After
	public void teardown() {
		DriverManager.quit();
	}

	@Given("open the browser with url")
	public void open_the_browser_with_url() {
		driver.get(cr.getProperty("url"));

	}

	@When("search selenium tutorials")
	public void search_dulipa_songs() throws InterruptedException {
		new YoutubeChannelSearchPage(driver).NavigateToReultPage();

	}

	@When("click on channel name")
	public void click_on_channel_name() {
		new YoutubeChannelResultsPage(driver).navigateToSongs();
	}

	@Then("validate channel title")
	public void validate_channel_title() throws InterruptedException {
		String expected = "How to Download and Install Eclipse IDE for Java Programming - YouTube";
		String actual = new YouTubeChannelPage(driver).getTitle();
		Assert.assertEquals(expected, actual);
		System.out.println(expected);
	}

}
