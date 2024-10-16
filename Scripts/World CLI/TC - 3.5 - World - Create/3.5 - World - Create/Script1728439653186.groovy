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

Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd', Keys.ENTER))
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('cd  /mnt/c/Users/yusuf', Keys.ENTER))

//world create
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world create', Keys.ENTER))
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('test-game-one', Keys.ENTER))
Windows.delay(15)

def worldCreateActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCreateExpected = 'Successfully created a starter game shard in ./test-game-one'

String worldCreateSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.5.1] World Create.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCreateSS)

if (worldCreateActual.contains(worldCreateExpected)) {
	KeywordUtil.markPassed("World Create Showing: " + worldCreateExpected)
} else {
	KeywordUtil.markFailed("World Create is not Showing: " + worldCreateExpected)
}
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))


//world create with directory name
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('world create test-game-two', Keys.ENTER))
Windows.delay(1)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord(Keys.ENTER))
Windows.delay(15)
def worldCreateNameActual = Windows.getText(findWindowsObject('Object Repository/Terminal Test/TextArea'))
String worldCreateNameExpected = 'Successfully created a starter game shard in ./test-game-two'

String worldCreateNameSS = RunConfiguration.getProjectDir() + '/Terminal Screenshot/[3.5.2] World Create with Name.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(worldCreateNameSS)

if (worldCreateNameActual.contains(worldCreateNameExpected)) {
	KeywordUtil.markPassed("World Create Name Showing: " + worldCreateNameExpected)
} else {
	KeywordUtil.markFailed("World Create Name is not Showing: " + worldCreateNameExpected)
}
Windows.delay(2)
Windows.sendKeys(findWindowsObject('Object Repository/Terminal Test/TextArea'), Keys.chord('clear', Keys.ENTER))
