import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

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

// --- Click Submit ---
WebUI.click(findTestObject('Page_Register/btn_Submit'))

// --- Handle Alert ---
if (WebUI.waitForAlert(5)) {
    String alertText = WebUI.getAlertText()
    WebUI.acceptAlert()
    println "Registration alert: ${alertText}"
}

// Optional: handle second alert if exists
try {
    if (WebUI.waitForAlert(3)) {
        WebUI.acceptAlert()
    }
} catch (Exception e) {
    // No second alert; continue
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

