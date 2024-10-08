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

//for keyword log and mark status
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Create Player/btn_menu_create_player'))
//WebUI.click(findTestObject('Object Repository/Create Player/dropdown_select_persona'))
//WebUI.click(findTestObject('Object Repository/Position Player Message/dropdown_select_persona'))
WebUI.setText(findTestObject('Object Repository/Create Player/field_nickname'), nickname)
WebUI.click(findTestObject('Object Repository/Create Player/btn_send'))
WebUI.delay(1)

KeywordLogger log = new KeywordLogger()

// Get target value from excel file
TestData excelData = findTestData('Data Files/Create Player/P - Create New Player')
String valueFromExcel = excelData.getValue(2,4)

// Change global variable target value to the data get from excel file
GlobalVariable.nickname = valueFromExcel
log.logInfo("Global Variable value : " + GlobalVariable.nickname)

// Change static xpath to global variable based on parameter "target"
TestObject nickname = findTestObject('Object Repository/Create Player/entity_area')
nicknamePlayer = WebUI.modifyObjectProperty(nickname, 'xpath', 'equals', "//div[@class='px-3 py-2 space-y-2'][contains(.,'nickname: " + '"' + GlobalVariable.nickname + '"' + "')]" , true)
boolean verifyPlayer = WebUI.verifyElementNotPresent(nicknamePlayer, 5)

if (verifyPlayer == true) {
	KeywordUtil.markPassed("Test Case Passed : Player shouldn't created")
} else {
	KeywordUtil.markFailed("Test Case Failed : Player Created")
}

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase("Cardinal Purge/Terminal Cardinal Purge"), [:], FailureHandling.OPTIONAL)
