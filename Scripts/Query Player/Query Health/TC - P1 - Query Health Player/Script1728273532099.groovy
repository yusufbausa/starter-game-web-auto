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
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Query Player/Query Health Player/btn_query_player_health'))
WebUI.setText(findTestObject('Object Repository/Query Player/Query Health Player/field_nickname'), nickname)
WebUI.click(findTestObject('Object Repository/Query Player/Query Health Player/btn_send'))

//WebUI.click(findTestObject('Object Repository/Query Player/Query Health Player/json_response_health'))
//WebUI.click(findTestObject('Object Repository/Query Player/Query Health Player/entity_player_area'))

def hpResponse = WebUI.getText(findTestObject('Object Repository/Query Player/Query Health Player/json_response_health'))

KeywordLogger log = new KeywordLogger()

if (hpResponse.contains('"HP":')) {
	log.logInfo("Query Response = " + hpResponse)
	KeywordUtil.markPassed("Test Case Passed")
} else {
	KeywordUtil.markFailed("Test Case Failed")
}


WebUI.closeBrowser()

