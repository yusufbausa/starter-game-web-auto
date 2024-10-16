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
//[3.7.1] world cardinal dev
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev', Keys.ENTER))
Windows.delay(8)

def worldCardinalDevActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevExpected = 'New world stage: "Running"'

String worldCardinalDevSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.1] World Cardinal Dev.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevSS)

if (worldCardinalDevActual.contains(worldCardinalDevExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Showing: " + worldCardinalDevExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev is not Showing: " + worldCardinalDevExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.7.2] world cardinal dev editor = false
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev --editor=false', Keys.ENTER))
Windows.delay(3)

def worldCardinalDevEFActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevEFExpected = 'Cardinal Editor → [disabled]'

String worldCardinalDevEFSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.2] World Cardinal Dev Editor = False.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevEFSS)

if (worldCardinalDevEFActual.contains(worldCardinalDevEFExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Editor Showing: " + worldCardinalDevEFExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev Editor is not Showing: " + worldCardinalDevEFExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.7.3] world cardinal dev editor = true
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev --editor=true', Keys.ENTER))
Windows.delay(3)

def worldCardinalDevETActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevETExpected = 'Cardinal Editor → localhost:3000'

String worldCardinalDevETSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.3] World Cardinal Dev Editor = True.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevETSS)

if (worldCardinalDevETActual.contains(worldCardinalDevETExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Editor Showing: " + worldCardinalDevETExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev Editor is not Showing: " + worldCardinalDevETExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.7.4] world cardinal dev config
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev --config=/mnt/c/Users/yusuf/starter-game world.toml', Keys.ENTER))
Windows.delay(3)

def worldCardinalDevCfgActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevCfgExpected = 'Cardinal Editor → localhost:3000'

String worldCardinalDevCfgSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.4] World Cardinal Dev Config.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevCfgSS)

if (worldCardinalDevCfgActual.contains(worldCardinalDevCfgExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Editor Showing: " + worldCardinalDevCfgExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev Editor is not Showing: " + worldCardinalDevCfgExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.7.5] world cardinal dev pretty log = false
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd  /mnt/c/Users/yusuf/starter-game', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev --pretty-log=false', Keys.ENTER))
Windows.delay(8)

def worldCardinalDevPLFActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevPLFExpected = 'New world stage: "Running"'

String worldCardinalDevPLFSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.5] World Cardinal Dev Pretty Log = False.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevPLFSS)

if (worldCardinalDevPLFActual.contains(worldCardinalDevPLFExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Showing: " + worldCardinalDevPLFExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev is not Showing: " + worldCardinalDevPLFExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.7.6] world cardinal dev pretty log = true
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev --pretty-log=true', Keys.ENTER))
Windows.delay(8)

def worldCardinalDevPLTActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalDevPLTExpected = 'New world stage: "Running"'

String worldCardinalDevPLTSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.7.6] World Cardinal Dev Pretty Log = True.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalDevPLTSS)

if (worldCardinalDevPLTActual.contains(worldCardinalDevPLTExpected)) {
	KeywordUtil.markPassed("World Cardinal Dev Showing: " + worldCardinalDevPLTExpected)
} else {
	KeywordUtil.markFailed("World Cardinal Dev is not Showing: " + worldCardinalDevPLTExpected)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
