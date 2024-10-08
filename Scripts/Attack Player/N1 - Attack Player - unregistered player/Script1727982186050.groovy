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
WebUI.click(findTestObject('Object Repository/Attack Player/dropdown_select_persona'))
WebUI.click(findTestObject('Object Repository/Attack Player/option_persona_default'))
WebUI.setText(findTestObject('Object Repository/Attack Player/field_target'), target)
WebUI.click(findTestObject('Object Repository/Attack Player/btn_send'))

WebUI.click(findTestObject('Object Repository/Attack Player/response_area'))

String errorExpected = 'failed to inflict damage:'
def attackResponse = WebUI.getText(findTestObject('Object Repository/Attack Player/response_area'))

KeywordLogger log = new KeywordLogger()

if (attackResponse.contains(errorExpected)) {
	log.logInfo("Attack Response = " + errorExpected)
	KeywordUtil.markPassed("Test Case Passed")
} else {
	KeywordUtil.markFailed("Test Case Failed")
}

filePath = 'C:\\Argus Data Test\\Starter Game\\Attack Player.xlsx'

FileInputStream fileInputStream
XSSFWorkbook workbook
XSSFSheet sheet

// Open existing Excel file or create a new one
try {
	fileInputStream = new FileInputStream(filePath)
	workbook = new XSSFWorkbook(fileInputStream)
	sheet = workbook.getSheet('Attack Response')
}
catch (FileNotFoundException e) {
	workbook = new XSSFWorkbook()
	sheet = workbook.createSheet('Attack Response')
}

// Get the last row number and increment it for the new data
int lastRow = sheet.getLastRowNum() + 1

// Create a new row
Row row = sheet.createRow(lastRow)

// Write the data into the first cell
Cell cell = row.createCell(0)
cell.setCellValue(attackResponse)

// Close the input stream
if (fileInputStream != null) {
	fileInputStream.close()
}

// Write the updated workbook to the file
FileOutputStream fileOutputStream = new FileOutputStream(filePath)
workbook.write(fileOutputStream)

// Close the output stream
fileOutputStream.close()

WebUI.refresh()
WebUI.closeBrowser()

WebUI.callTestCase(findTestCase("Cardinal Purge/Terminal Cardinal Purge"), [:], FailureHandling.OPTIONAL)

