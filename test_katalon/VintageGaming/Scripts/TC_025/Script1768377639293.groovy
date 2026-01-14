import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Registration Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Register.html')

// --- Fill Registration Form ---
WebUI.setText(findTestObject('Page_Register/txt_Name'), 'Jorge')
WebUI.setText(findTestObject('Page_Register/txt_LastName'), 'Arce')
WebUI.setText(findTestObject('Page_Register/txt_Age'), '20')
WebUI.setText(findTestObject('Page_Register/txt_Nickname'), 'Jopoarma')
WebUI.setText(findTestObject('Page_Register/txt_Address'), '123 St Laurent Blvd')
WebUI.setText(findTestObject('Page_Register/txt_Email'), 'jorge.arce@example.com')
WebUI.setText(findTestObject('Page_Register/txt_Password'), 'StrongPass1!')

// --- Submit Registration ---
TestObject submitBtn = new TestObject('btn_RegisterSubmit')
submitBtn.addProperty('css', ConditionType.EQUALS, 'form#registrationForm button[type="submit"]')
WebUI.click(submitBtn)

// --- Accept alert if present ---
if (WebUI.waitForAlert(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

// --- Navigate to Login Page ---
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Login.html')

// --- Fill Login Form ---
WebUI.setText(findTestObject('Page_Login/txt_Email'), 'jorge.arce@example.com')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'StrongPass1!')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// --- Accept login alert ---
if (WebUI.waitForAlert(3, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

// --- Verify logout button is visible ---
TestObject logoutBtn = new TestObject('btn_Logout')
logoutBtn.addProperty('id', ConditionType.EQUALS, 'logoutBtn')
WebUI.waitForElementVisible(logoutBtn, 5)
assert WebUI.verifyElementVisible(logoutBtn, FailureHandling.STOP_ON_FAILURE) : "Login failed: Logout button not visible"

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

