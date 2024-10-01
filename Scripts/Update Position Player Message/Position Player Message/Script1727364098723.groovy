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

//WebUI.openBrowser('')
//WebUI.maximizeWindow()
//WebUI.navigateToUrl('http://localhost:3000/')
//WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Position Player Message/btn_msg_position_player'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Position Player Message/dropdown_persona'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Position Player Message/dropdown_select_persona'))
WebUI.setText(findTestObject('Object Repository/Position Player Message/field_direction'), direction)
WebUI.setText(findTestObject('Object Repository/Position Player Message/field_target'), target)
WebUI.click(findTestObject('Object Repository/Position Player Message/btn_send'))
WebUI.delay(1)

String positionResponse = WebUI.getText(findTestObject('Object Repository/Position Player Message/response_area'))

KeywordLogger log = new KeywordLogger()

filePath = 'C:\\Argus Data Test\\Starter Game\\Position Player Msg.xlsx'

FileInputStream fileInputStream
XSSFWorkbook workbook
XSSFSheet sheet

// Open existing Excel file or create a new one
try {
    fileInputStream = new FileInputStream(filePath)
    workbook = new XSSFWorkbook(fileInputStream)
    sheet = workbook.getSheet('Position Response')
}
catch (FileNotFoundException e) {
    workbook = new XSSFWorkbook()
    sheet = workbook.createSheet('Position Response')
} 

// Get the last row number and increment it for the new data
int lastRow = sheet.getLastRowNum() + 1

// Create a new row
Row row = sheet.createRow(lastRow)

// Get target value from excel file
TestData excelData = findTestData('Data Files/Position Player Message/Position Player Msg')
String valueFromExcel = excelData.getValue(2,lastRow)

// Change global variable target value to the data get from excel file
GlobalVariable.target = valueFromExcel
log.logInfo("Global Variable value : " + GlobalVariable.target)

// Change static xpath to global variable based on parameter "target"
TestObject target = findTestObject('Object Repository/Position Player Message/entity_area')
targetPlayer = WebUI.modifyObjectProperty(target, 'xpath', 'equals', "//div[@class='px-3 py-2 space-y-2'][contains(.,'nickname: " + '"' + GlobalVariable.target + '"' + "')]" , true)
//log.logInfo("xpath value : " + targetPlayer)
String entityData = WebUI.getText(targetPlayer)
WebUI.scrollToElement(targetPlayer, 5)
WebUI.takeFullPageScreenshot()

// Write the data into the first cell
Cell cell = row.createCell(0)
cell.setCellValue(positionResponse)
Cell cell2 = row.createCell(1)
cell2.setCellValue(entityData)

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

