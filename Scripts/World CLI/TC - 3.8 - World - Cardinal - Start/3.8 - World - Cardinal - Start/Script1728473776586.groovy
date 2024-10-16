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
//[3.8.1] world cardinal start
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start', Keys.ENTER))
Windows.delay(15)

def worldCardinalStartActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStart = 'Startup done'

String worldCardinalStartSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.1] World Cardinal Start.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartSS)

if (worldCardinalStartActual.contains(worldCardinalStart)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStart)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStart)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.2] world cardinal start build false
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --build=false', Keys.ENTER))
Windows.delay(15)

def worldCardinalStartBFActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartBF = 'Startup done'

String worldCardinalStartBFSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.2] World Cardinal Start Build = False.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartBFSS)

if (worldCardinalStartBFActual.contains(worldCardinalStartBF)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartBF)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartBF)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.3] world cardinal start build true
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --build=true', Keys.ENTER))
Windows.delay(3)

def worldCardinalStartBTActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartBT = '✓  built image defaultnamespace'

String worldCardinalStartBTSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.3] World Cardinal Start Build = True.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartBTSS)

if (worldCardinalStartBTActual.contains(worldCardinalStartBT)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartBT)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartBT)
}

Windows.delay(12)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.4] world cardinal start debug
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --debug', Keys.ENTER))
Windows.delay(20)

def worldCardinalStartDebugActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartDebug = 'Startup done'

String worldCardinalStartDebugSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.4] World Cardinal Start Debug.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartDebugSS)

if (worldCardinalStartDebugActual.contains(worldCardinalStartDebug)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartDebug)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartDebug)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.5] world cardinal start detach
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --detach', Keys.ENTER))
Windows.delay(10)

def worldCardinalStartDetachActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartDetach = '✓  started container defaultnamespace-cardinal'

String worldCardinalStartDetachSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.5] World Cardinal Start Detach.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartDetachSS)

if (worldCardinalStartDetachActual.contains(worldCardinalStartDetach)) {
	KeywordUtil.markPassed("World Cardinal Starting in Background: " + worldCardinalStartDetach)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartDetach)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal stop', Keys.ENTER))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.6] world cardinal start editor = false
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --editor=false', Keys.ENTER))
Windows.delay(15)

def worldCardinalStartEFActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartEF = 'Startup done'

String worldCardinalStartEFSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.6] World Cardinal Start Editor = False.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartEFSS)

if (worldCardinalStartEFActual.contains(worldCardinalStartEF)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartEF)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartEF)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.7] world cardinal start editor = true
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --editor=true', Keys.ENTER))
Windows.delay(15)

def worldCardinalStartETActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartET = 'Startup done'

String worldCardinalStartETSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.7] World Cardinal Start Editor = True.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartETSS)

if (worldCardinalStartETActual.contains(worldCardinalStartET)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartET)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartET)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.8] world cardinal start log level = info
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --log-level=info', Keys.ENTER))
Windows.delay(10)

def worldCardinalStartLLIActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartLLI = 'Startup done'

String worldCardinalStartLLISS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.8] World Cardinal Start Log Level Info.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartLLISS)

if (worldCardinalStartLLIActual.contains(worldCardinalStartLLI)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartLLI)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartLLI)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.9] world cardinal start log level = debug
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --log-level=debug', Keys.ENTER))
Windows.delay(10)

def worldCardinalStartLLBActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartLLB = 'Startup done'

String worldCardinalStartLLBSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.9] World Cardinal Start Log Level Debug.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartLLBSS)

if (worldCardinalStartLLBActual.contains(worldCardinalStartLLB)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartLLB)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartLLB)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.10] world cardinal start log level = error
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --log-level=error', Keys.ENTER))
Windows.delay(10)

def worldCardinalStartLLEActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartLLE = 'Startup done'

String worldCardinalStartLLESS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.10] World Cardinal Start Log Level Error.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartLLESS)

if (worldCardinalStartLLEActual.contains(worldCardinalStartLLE)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartLLE)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartLLE)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.11] world cardinal start log level = warn
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --log-level=warn', Keys.ENTER))
Windows.delay(10)

def worldCardinalStartLLWActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartLLW = 'Startup done'

String worldCardinalStartLLWSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.11] World Cardinal Start Log Level Warn.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartLLWSS)

if (worldCardinalStartLLWActual.contains(worldCardinalStartLLW)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartLLW)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartLLW)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(15)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//====================================================================================================================================================
//[3.8.12] world cardinal start config
//====================================================================================================================================================
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal start --config=/mnt/c/Users/yusuf/starter-game world.toml', Keys.ENTER))
Windows.delay(5)

def worldCardinalStartCfgActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCardinalStartCfg = 'Startup done'

String worldCardinalStartCfgSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.8.12] World Cardinal Start Config.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCardinalStartCfgSS)

if (worldCardinalStartCfgActual.contains(worldCardinalStartCfg)) {
	KeywordUtil.markPassed("World Cardinal Showing: " + worldCardinalStartCfg)
} else {
	KeywordUtil.markFailed("World Cardinal is not Showing: " + worldCardinalStartCfg)
}

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd  /mnt/c/Users/yusuf/starter-game', Keys.ENTER))
Windows.delay(1)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

