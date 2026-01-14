import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Shop ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

// --- Add first product ---
TestObject firstProduct = new TestObject('firstProduct')
firstProduct.addProperty('css', ConditionType.EQUALS, '.product:nth-of-type(1)')
WebUI.click(firstProduct.findPropertyValue('css'))

WebUI.click(findTestObject('Page_Store/btn_AddToCart'))

// --- Wait for cart modal and close it ---
TestObject cartModal = new TestObject('cartModal')
cartModal.addProperty('id', ConditionType.EQUALS, 'cart-modal')
WebUI.waitForElementVisible(cartModal, 5)
WebUI.click(findTestObject('Page_Store/btn_CartClose'))

// --- Add second product ---
TestObject secondProduct = new TestObject('secondProduct')
secondProduct.addProperty('css', '.product:nth-of-type(2) .view-details')
WebUI.click(secondProduct)

WebUI.click(findTestObject('Page_Store/btn_AddToCart'))

// --- Verify 2 items in cart ---
TestObject cartItems = new TestObject('cartItems')
cartItems.addProperty('css', '#cart-items li')
List items = WebUI.findWebElements(cartItems, 5)
assert items.size() == 2 : "Cart should contain 2 items"

// --- Remove first item ---
TestObject firstItemRemove = new TestObject('firstItemRemove')
firstItemRemove.addProperty('css', '#cart-items li:nth-of-type(1) .remove')
WebUI.click(firstItemRemove)

// --- Verify only 1 item remains ---
List itemsAfter = WebUI.findWebElements(cartItems, 5)
assert itemsAfter.size() == 1 : "Cart should contain 1 item after removal"

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

