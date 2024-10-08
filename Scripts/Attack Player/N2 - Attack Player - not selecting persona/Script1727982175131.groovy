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
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.maximizeWindow()
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Attack Player/btn_menu_attack_player'))
//WebUI.click(findTestObject('Object Repository/Attack Player/dropdown_select_persona'))
//WebUI.click(findTestObject('Object Repository/Attack Player/option_persona'))
WebUI.setText(findTestObject('Object Repository/Attack Player/field_target'), targetPlayer)
WebUI.click(findTestObject('Object Repository/Attack Player/btn_send'))

//WebUI.click(findTestObject('Object Repository/Attack Player/response_area'))
def attackResponse = findTestObject('Object Repository/Attack Player/response_area')
boolean verifyPlayer = WebUI.verifyElementNotPresent(attackResponse, 5)

KeywordLogger log = new KeywordLogger()

if (verifyPlayer == true) {
	log.logInfo("Attacking with not selecting Persona")
	KeywordUtil.markPassed("Test Case Passed : No action as expected")
} else {
	log.logInfo("Attacking with not selecting Persona")
	KeywordUtil.markFailed("Test Failed : Attack shouldn't be performed")
}





//if (attackResponse.contains('"damage": 10')) {
//	log.logInfo("Attack Response = " + attackResponse)
//	KeywordUtil.markPassed("Test Case Passed")
//} else {
//	KeywordUtil.markFailed("Test Case Failed")
//}
//
//filePath = 'C:\\Argus Data Test\\Starter Game\\Attack Player.xlsx'
//
//FileInputStream fileInputStream
//XSSFWorkbook workbook
//XSSFSheet sheet
//
//try {
//	fileInputStream = new FileInputStream(filePath)
//	workbook = new XSSFWorkbook(fileInputStream)
//	sheet = workbook.getSheet('Attack Response')
//}
//catch (FileNotFoundException e) {
//	workbook = new XSSFWorkbook()
//	sheet = workbook.createSheet('Attack Response')
//}
//
//int lastRow = sheet.getLastRowNum() + 1
//Row row = sheet.createRow(lastRow)
//
//Cell cell = row.createCell(0)
//cell.setCellValue(attackResponse)
//
//if (fileInputStream != null) {
//	fileInputStream.close()
//}
//
//FileOutputStream fileOutputStream = new FileOutputStream(filePath)
//workbook.write(fileOutputStream)
//fileOutputStream.close()

WebUI.refresh()
WebUI.closeBrowser()

WebUI.callTestCase(findTestCase("Cardinal Purge/Terminal Cardinal Purge"), [:], FailureHandling.OPTIONAL)

