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

//world doctor
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world doctor', Keys.ENTER))
Windows.delay(5)

def worldDoctor = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String dockerDaemon = '✓  Docker daemon is running'

String worldDoctorSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.4.1] World Doctor.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldDoctorSS)

if (worldDoctor.contains(dockerDaemon)) {
	KeywordUtil.markPassed("World Doctor Showing: " + dockerDaemon)
} else {
	KeywordUtil.markFailed("World Doctor is not Showing: " + dockerDaemon)
}

Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))

