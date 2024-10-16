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

//====================================================================================================================================================
//[3.8.23] world cardinal start telemetry log-level=info
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal purge', Keys.ENTER))
Windows.delay(5)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
Windows.delay(1)

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --telemetry --log-level=info', Keys.ENTER))
Windows.delay(30)

def worldCardinalStartTmLLIActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartTmLLI = 'Startup done'

String worldCardinalStartTmLLISS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.23] World Cardinal Start Telemetry Log Level Info.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartTmLLISS)

if (worldCardinalStartTmLLIActual.contains(worldCardinalStartTmLLI)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartTmLLI)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartTmLLI)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
