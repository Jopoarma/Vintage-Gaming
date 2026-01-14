import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Login Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Login.html')

// --- Perform login (using registered credentials) ---
WebUI.setText(findTestObject('Page_Login/txt_Email'), 'admin@vintage-gaming.com')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'J0p0@dmin')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// --- Handle login alert ---
if (WebUI.waitForAlert(5, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

// --- Wait for logout button ---
TestObject logoutBtn = new TestObject('navLogoutBtn')
logoutBtn.addProperty('class', ConditionType.EQUALS, 'nav-logout-btn')
WebUI.waitForElementVisible(logoutBtn, 10)

// --- Click logout ---
WebUI.click(logoutBtn)

// --- Wait for logout alert ---
if (WebUI.waitForAlert(5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getAlertText()
    assert alertText.contains("Session ended successfully") : "Logout alert incorrect"
    WebUI.acceptAlert()
}

// --- Verify loggedUser removed from localStorage ---
String loggedUser = WebUI.executeJavaScript("return localStorage.getItem('loggedUser');", null)
assert loggedUser == null : "loggedUser should be cleared after logout"

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

