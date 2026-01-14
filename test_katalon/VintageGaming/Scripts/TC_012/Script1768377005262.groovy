import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Register.html')

// --- Fill Registration Form with underage data ---
WebUI.setText(findTestObject('Page_Register/txt_Name'), 'Ana')
WebUI.setText(findTestObject('Page_Register/txt_LastName'), 'Test')
WebUI.setText(findTestObject('Page_Register/txt_Age'), '15')
WebUI.setText(findTestObject('Page_Register/txt_Nickname'), 'Tester99')
WebUI.setText(findTestObject('Page_Register/txt_Address'), '456 Main Street')
WebUI.setText(findTestObject('Page_Register/txt_Email'), 'underage@test.com')
WebUI.setText(findTestObject('Page_Register/txt_Password'), 'Strong@123')

// --- Click Submit ---
WebUI.click(findTestObject('Page_Register/btn_Submit'))

// --- Wait for age validation error ---
TestObject ageErrorObj = new TestObject('ageError')
ageErrorObj.addProperty('id', ConditionType.EQUALS, 'ageError')
WebUI.waitForElementVisible(ageErrorObj, 5)

// --- Assert age error is shown ---
String ageErrorText = WebUI.getText(ageErrorObj)
assert ageErrorText != "" : "Age validation error should be shown"

// --- Close Browser ---
WebUI.closeBrowser()
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

