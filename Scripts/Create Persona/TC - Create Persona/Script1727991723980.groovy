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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.ui.SystemOutputInterceptor as SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.codehaus.groovy.ast.stmt.AssertStatement as AssertStatement
import org.openqa.selenium.Keys as Keys
//for mark status & log
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
WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:3000/')
WebUI.maximizeWindow()

//Creating New Persona
WebUI.setText(findTestObject('Object Repository/Create Persona/field_personaTag'), newPersonaTag)
WebUI.click(findTestObject('Object Repository/Create Persona/btn_create'))

//Validation for New Persona
WebUI.waitForElementPresent(findTestObject('Object Repository/Create Persona/popup_message'), 10)
KeywordLogger log = new KeywordLogger()
def actualText = 'Successfully created persona '
def popupMessage = WebUI.getText(findTestObject('Object Repository/Create Persona/popup_message'))

if (popupMessage.contains(actualText + newPersonaTag)) {
    log.logInfo('Web Message = ' + popupMessage)
    log.logInfo(('Expected Message = ' + actualText) + newPersonaTag)
    KeywordUtil.markPassed('Test Case Passed')
} else {
    def popupErrorMessage = WebUI.getText(findTestObject('Object Repository/Create Persona/popup_error_message'))
    log.logInfo('Web Message = ' + popupMessage)
    log.logInfo('Web Error Message = ' + popupErrorMessage)
    log.logInfo(('Expected Message = ' + actualText) + newPersonaTag)
    KeywordUtil.markFailed('Test Failed ' + popupErrorMessage)
}

filePath = 'C:\\Argus Data Test\\Starter Game\\Create Persona.xlsx'

FileInputStream fileInputStream
XSSFWorkbook workbook
XSSFSheet sheet

try {
    fileInputStream = new FileInputStream(filePath)
    workbook = new XSSFWorkbook(fileInputStream)
    sheet = workbook.getSheet('Create Persona Response')
}
catch (FileNotFoundException e) {
    workbook = new XSSFWorkbook()
    sheet = workbook.createSheet('Create Persona Response')
} 

int lastRow = sheet.getLastRowNum() + 1
Row row = sheet.createRow(lastRow)

TestData excelData = findTestData('Data Files/Create Persona/Create Persona')
String valueFromExcel = excelData.getValue(2, 1)

// Change global variable target value to the data get from excel file
GlobalVariable.personaTag = valueFromExcel
log.logInfo('Global Variable personaTag value : ' + GlobalVariable.personaTag)

// Change static xpath to global variable based on parameter "target"
TestObject persona = findTestObject('Object Repository/Create Persona/persona_area')
personaTag = WebUI.modifyObjectProperty(persona, 'xpath', 'equals', ((('//div[@class=\'px-3 py-2 space-y-2\'][contains(.,\'PersonaTag: ' + '"') + GlobalVariable.personaTag) + '"') + '\')]', true)

String personaData = WebUI.getText(personaTag)
WebUI.scrollToElement(personaTag, 5)
WebUI.takeElementScreenshot(personaTag)

Cell cell = row.createCell(0)
cell.setCellValue(personaData)

if (fileInputStream != null) {
    fileInputStream.close()
}

FileOutputStream fileOutputStream = new FileOutputStream(filePath)
workbook.write(fileOutputStream)
fileOutputStream.close()

WebUI.refresh()

