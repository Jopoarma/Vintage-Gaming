import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Login.html')

// --- Login ---
WebUI.setText(findTestObject('Page_Login/txt_Username'), 'admin@vintage-gaming.com')
WebUI.setText(findTestObject('Page_Login/txt_Password'), 'J0p0@dmin')
WebUI.click(findTestObject('Page_Login/btn_Login'))

// --- Handle Login Alert ---
if (WebUI.waitForAlert(10)) {
    String alertText = WebUI.getAlertText()
    assert alertText.contains('Login Successfully!') : "Login failed"
    WebUI.acceptAlert()
}

// --- Navigate to Store ---
WebUI.click(findTestObject('Page_Home/link_Store'))

// --- Open Product Modal using Dynamic XPATH ---
TestObject productLink = new TestObject('dynamicProductLink')
productLink.addProperty('xpath', ConditionType.EQUALS, "//a[@data-product='cyberpunk']")
WebUI.click(productLink)

// --- Add to Cart ---
WebUI.click(findTestObject('Page_Product/btn_AddToCart'))

// --- Checkout ---
WebUI.click(findTestObject('Page_Cart/btn_Checkout'))

// --- Switch to Payment Iframe ---
TestObject paymentIframe = new TestObject('iframe_Payment')
paymentIframe.addProperty('css', ConditionType.EQUALS, 'iframe')
WebUI.switchToFrame(paymentIframe, 10)

// --- Enter Card Information ---
WebUI.setText(findTestObject('Page_Checkout/input_CardNumber'), '7777 7777 7777 7777')
WebUI.setText(findTestObject('Page_Checkout/input_Expiry'), '02/27')
WebUI.setText(findTestObject('Page_Checkout/input_CVC'), '777')

// --- Pay ---
WebUI.click(findTestObject('Page_Checkout/btn_Pay'))

// --- Handle Payment Alert ---
WebUI.switchToDefaultContent()
if (WebUI.waitForAlert(10)) {
    WebUI.acceptAlert()
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

