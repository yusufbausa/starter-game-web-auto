import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//for logging text
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

//for taking screenshot
import com.kms.katalon.core.windows.driver.WindowsDriverFactory
import com.kms.katalon.core.windows.keyword.helper.WindowsActionHelper
import com.kms.katalon.core.configuration.RunConfiguration


KeywordLogger log = new KeywordLogger()


//world check
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world', Keys.ENTER))
Windows.delay(1)
def worldCheck = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String world = 'A swiss army knife for World Engine projects'

String worldSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.1.1] World.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldSS)

if (worldCheck.contains(world)) {
	KeywordUtil.markPassed("World Showing: " + world)
} else {
	KeywordUtil.markFailed("World is not Showing: " + world)
}
Windows.delay(2)


//world version check
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world version', Keys.ENTER))
Windows.delay(1)
def worldVersionCheck = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))

String worldVersionSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.1.2] World Version.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldVersionSS)

if (worldVersionCheck.contains(worldVersion)) {
	log.logInfo("World Version is  = " + worldVersionCheck)
	KeywordUtil.markPassed("World Version Matched with: " + worldVersion)
} else {
	log.logInfo("World Version is  = " + worldVersionCheck)
	KeywordUtil.markFailed("World Version is not Matched with: " + worldVersion)
}
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
