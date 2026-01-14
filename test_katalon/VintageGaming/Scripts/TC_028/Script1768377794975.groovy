import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Shop Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

// --- Create TestObject for first product "View Details" button ---
TestObject firstProductDetails = new TestObject('btn_FirstProductDetails')
firstProductDetails.addProperty('css', ConditionType.EQUALS, '.view-details')

// --- Click first product details ---
WebUI.click(firstProductDetails)

// --- Create TestObject for Add to Cart button ---
TestObject addToCartBtn = new TestObject('btn_AddToCart')
addToCartBtn.addProperty('id', ConditionType.EQUALS, 'add-to-cart')

// --- Click Add to Cart ---
WebUI.click(addToCartBtn)

// --- Create TestObject for Checkout button ---
TestObject checkoutBtn = new TestObject('btn_Checkout')
checkoutBtn.addProperty('id', ConditionType.EQUALS, 'checkout-btn')

// --- Click Checkout ---
WebUI.click(checkoutBtn)

// --- Wait for alert and verify text ---
if (WebUI.waitForAlert(5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getAlertText()
    assert alertText.toLowerCase().contains("must be logged") : "Expected login alert not shown"
    WebUI.acceptAlert()
} else {
    assert false : "Expected checkout alert did not appear"
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

