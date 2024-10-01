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
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable

import org.codehaus.groovy.ast.stmt.AssertStatement
import org.openqa.selenium.Keys as Keys

//Open browser
WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.maximizeWindow()

//Creating New Persona
WebUI.setText(findTestObject('Object Repository/Create Persona/field_personaTag'), personaTag)
WebUI.click(findTestObject('Object Repository/Create Persona/btn_create'))

//Validation for New Persona
WebUI.waitForElementPresent(findTestObject('Object Repository/Create Persona/popup_message'), 10)

KeywordLogger log = new KeywordLogger()
def actualText = 'Successfully created persona '
def popupMessage = WebUI.getText(findTestObject('Object Repository/Create Persona/popup_message'))
//def popupErrorMessage = WebUI.getText(findTestObject('Object Repository/Create Persona/popup_error_message'))

	if (popupMessage.contains(actualText + personaTag)) {
		log.logInfo("Web Message = " + popupMessage)
		log.logInfo("Expected Message = " + actualText + personaTag)
		KeywordUtil.markPassed("Test Case Passed")
	} else {
		def popupErrorMessage = WebUI.getText(findTestObject('Object Repository/Create Persona/popup_error_message'))
		log.logInfo("Web Message = " + popupMessage)
		log.logInfo("Web Error Message = " + popupErrorMessage)
		log.logInfo("Expected Message = " + actualText + personaTag)
		KeywordUtil.markFailed("Test Failed " + popupErrorMessage)
	}

WebUI.refresh()
WebUI.delay(2)

WebUI.closeBrowser()

