import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Base URL ---
String BASE = 'http://127.0.0.1:5500/Vintage-Gaming/website'
List<String> pages = ['index.html', 'shop.html', 'Login.html', 'Register.html']

// --- Create TestObject for Cart Button ---
TestObject cartBtn = new TestObject('btn_ViewCart')
cartBtn.addProperty('id', ConditionType.EQUALS, 'view-cart-btn')

// --- Create TestObject for Cart Modal ---
TestObject cartModal = new TestObject('modal_Cart')
cartModal.addProperty('id', ConditionType.EQUALS, 'cart-modal')

// --- Create TestObject for Close Cart Button ---
TestObject cartCloseBtn = new TestObject('btn_CartClose')
cartCloseBtn.addProperty('id', ConditionType.EQUALS, 'cart-close')

// --- Open Browser ---
WebUI.openBrowser('')
WebUI.maximizeWindow()

// --- Loop through pages and test cart access ---
for (String page : pages) {
    WebUI.navigateToUrl(BASE + '/' + page)
    
    // Click cart button
    WebUI.click(cartBtn)
    
    // Wait for cart modal
    WebUI.waitForElementVisible(cartModal, 5)
    assert WebUI.verifyElementVisible(cartModal, FailureHandling.STOP_ON_FAILURE) : "Cart modal not visible on " + page
    
    // Close cart modal
    WebUI.click(cartCloseBtn)
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

