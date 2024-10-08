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

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.maximizeWindow()
WebUI.delay(1)


WebUI.click(findTestObject('Object Repository/Query Position Player/menu_query_position_player'))
WebUI.setText(findTestObject('Object Repository/Query Position Player/field_nickname'), nickname)
WebUI.click(findTestObject('Object Repository/Query Position Player/btn_send'))

//WebUI.click(findTestObject('Object Repository/Query Position Player/query_response'))
//WebUI.click(findTestObject('Object Repository/Query Position Player/player_position_status'))

def positionResponse = findTestObject('Object Repository/Query Position Player/query_response')


def jsonResponse = WebUI.getText(findTestObject('Object Repository/Query Position Player/json_response_position_error'))
def popUpResponse = WebUI.getText(findTestObject('Object Repository/Query Position Player/error_popUp_header'))
def jsonError = 'player ' + nickname + ' does not exist'

KeywordLogger log = new KeywordLogger()

if (jsonResponse.contains(jsonError)) {
	log.logInfo("Json Response = " + jsonResponse)
	log.logInfo("Pop Up Message = " + popUpResponse)
	log.logInfo("Expected Error Message = " + jsonError)
	KeywordUtil.markPassed("Test Case Passed")
} else {
	log.logInfo("Json Response = " + jsonResponse)
	log.logInfo("Pop Up Message = " + popUpResponse)
	log.logInfo("Expected Error Message = " + jsonError)
	KeywordUtil.markFailed("Test Case Failed")
}

WebUI.closeBrowser()

