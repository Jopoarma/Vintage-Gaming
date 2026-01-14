import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Login Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Login.html')

// --- Click Forgot Password button ---
TestObject forgotPassBtn = new TestObject('btn_ForgotPassword')
forgotPassBtn.addProperty('id', ConditionType.EQUALS, 'forgotPass')
WebUI.click(forgotPassBtn)

// --- Wait for prompt and enter unregistered email ---
WebUI.executeJavaScript("""
    var p = window.prompt;
    window.prompt = function(){ return 'wrong@example.com'; }
""", null)

// --- Click Forgot Password again to trigger prompt (if needed) ---
WebUI.click(forgotPassBtn)

// --- Wait for resulting alert ---
if (WebUI.waitForAlert(5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getAlertText()
    assert alertText.toLowerCase().contains("password reset link") : "Alert should indicate password reset"
    WebUI.acceptAlert()
} else {
    assert false : "Expected alert did not appear"
}

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

