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

//for mark status & log
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

//for excel csv save
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.FileOutputStream as FileOutputStream
import java.io.IOException as IOException
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle as XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.eclipse.osgi.framework.util.FilePath as FilePath
import java.lang.String as String

//Open browser
//WebUI.openBrowser('')
//WebUI.navigateToUrl('http://localhost:3000/')
//WebUI.maximizeWindow()

//Creating New Persona
WebUI.setText(findTestObject('Object Repository/Create Persona/field_personaTag'), personaTag)
WebUI.click(findTestObject('Object Repository/Create Persona/btn_create'))
WebUI.delay(1)

KeywordLogger log = new KeywordLogger()
def errorText = "Persona tag must be at least 3 characters"
def errorWeb = WebUI.getText(findTestObject('Object Repository/Create Persona/error_message'))

	if (errorWeb.contains(errorText)) {
		log.logInfo("Web Error Message = " + errorWeb)
		log.logInfo("Expected Error Message = " + errorText)
		KeywordUtil.markPassed("Test Case Passed: Error Message Expected")
	} else {
		log.logInfo("Web Error Message = " + errorWeb)
		log.logInfo("Expected Error Message = " + errorText)
		KeywordUtil.markFailed("Test Case Failed: Error Message Didn't Matched")
	}

WebUI.refresh()
