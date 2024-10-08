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
import org.openqa.selenium.Alert as Alert
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

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Position Player Message/btn_msg_position_player'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Position Player Message/dropdown_persona'))
WebUI.click(findTestObject('Object Repository/Position Player Message/dropdown_select_persona'))
WebUI.setText(findTestObject('Object Repository/Position Player Message/field_direction'), direction)
WebUI.setText(findTestObject('Object Repository/Position Player Message/field_target'), target)
WebUI.click(findTestObject('Object Repository/Position Player Message/btn_send'))
WebUI.delay(2)

def positionResponse = findTestObject('Object Repository/Position Player Message/response_area')
boolean verifyPosition = WebUI.verifyElementNotPresent(positionResponse, 5)

KeywordLogger log = new KeywordLogger()

if (verifyPosition == true) {
	log.logInfo("Update position with direction empty")
	KeywordUtil.markPassed("Test Case Passed : No action as expected")
} else {
	log.logInfo("Update position with direction empty")
	KeywordUtil.markFailed("Test Failed : Position shouldn't be updated")
}

WebUI.delay(2)
//WebUI.refresh()
WebUI.closeBrowser()

WebUI.callTestCase(findTestCase("Cardinal Purge/Terminal Cardinal Purge"), [:], FailureHandling.OPTIONAL)
