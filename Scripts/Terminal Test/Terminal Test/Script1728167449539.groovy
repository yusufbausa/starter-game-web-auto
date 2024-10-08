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


Windows.startApplicationWithTitle('C:\\WINDOWS\\system32\\cmd.exe', 'cmd')

KeywordLogger log = new KeywordLogger()

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('wsl', Keys.ENTER))
Windows.delay(1)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd  /mnt/c/Users/yusuf/starter-game', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

//world version check
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world version', Keys.ENTER))
Windows.delay(1)
def worldVersionCheck = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
if (worldVersionCheck.contains(worldVersion)) {
	log.logInfo("World Version is  = " + worldVersionCheck)
	KeywordUtil.markPassed("World Version Matched with: " + worldVersion)
} else {
	log.logInfo("World Version is  = " + worldVersionCheck)
	KeywordUtil.markFailed("World Version is not Matched with: " + worldVersion)
}
Windows.delay(2)

//world cardinal purge check
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal purge', Keys.ENTER))
Windows.delay(5)
def purgeStatus = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String purge = 'Cardinal successfully purged'
if (purgeStatus.contains(purge)) {
	log.logInfo("Purge Status  = " + purgeStatus)
	KeywordUtil.markPassed("Purge Successfully")
} else {
	KeywordUtil.markFailed("Purge Failed")
}
Windows.delay(2)

//world cardinal dev check
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world cardinal dev', Keys.ENTER))
Windows.delay(10)
def cardinalDevStatus = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String cardinalDev = 'Cardinal is running'
if (cardinalDevStatus.contains(cardinalDev)) {
	log.logInfo("Cardinal Status  = " + cardinalDev)
	KeywordUtil.markPassed("Cardinal successfully running")
} else {
	KeywordUtil.markFailed("Cardinal is not run")
}
Windows.delay(2)

//stopping cardinal
Windows.setText(findWindowsObject('Object Repository/Terminal Test/TerminalTab'), Keys.chord(Keys.LEFT_CONTROL, 'c'))
Windows.delay(2)
def cardinalStopStatus = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String cardinalStop = 'Container redis  Stopped'
if (cardinalStopStatus.contains(cardinalStop)) {
	log.logInfo("Cardinal Status  = " + cardinalStop)
	KeywordUtil.markPassed("Cardinal successfully stopped")
} else {
	KeywordUtil.markFailed("Cardinal is not run")
}


//exit from WSL
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('exit', Keys.ENTER))
Windows.delay(2)
def wslExitStatus = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String wslStatus = 'logout'
if (wslExitStatus.contains(wslStatus)) {
	log.logInfo("WSL Status  = " + wslStatus)
	KeywordUtil.markPassed("Exiting from WSL")
} else {
	KeywordUtil.markFailed("WSL is not exit")
}
Windows.delay(3)

//close terminal APP/Tab
Windows.closeApplication()

