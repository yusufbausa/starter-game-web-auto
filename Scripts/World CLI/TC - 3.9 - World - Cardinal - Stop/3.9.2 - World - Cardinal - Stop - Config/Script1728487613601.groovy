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

//world cardinal start
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start', Keys.ENTER))
Windows.delay(15)
String worldCardinalStart = 'Startup done'
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal stop --config=/mnt/c/Users/yusuf/starter-game/world.toml', Keys.ENTER))
Windows.delay(3)

def worldCardinalStopActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStopExpected = 'Cardinal successfully stopped'

String worldCardinalStopSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.9.2] World Cardinal Stop Config.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStopSS)

if (worldCardinalStopActual.contains(worldCardinalStopExpected)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStopExpected)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStopExpected)
}

Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd /mnt/c/Users/yusuf/starter-game', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

