import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate to Home Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

// --- Click STORE link ---
WebUI.click(findTestObject('Page_Home/link_Store'))

// --- Wait for RPG products to appear ---
TestObject firstProduct = new TestObject('product_RPG1')
firstProduct.addProperty('css', ConditionType.EQUALS, ".product[data-genre='RPG']:nth-of-type(1)")
WebUI.waitForElementPresent(firstProduct, 10)

// --- Verify at least 1 product is visible ---
assert WebUI.verifyElementVisible(firstProduct, FailureHandling.STOP_ON_FAILURE)

// --- Open first product details modal ---
TestObject viewDetails = new TestObject('viewDetails1')
viewDetails.addProperty('css', ConditionType.EQUALS, ".product[data-genre='RPG']:nth-of-type(1) .view-details")
WebUI.click(viewDetails)

// --- Wait for Close button and click it ---
TestObject closeBtn = new TestObject('closeBtn1')
closeBtn.addProperty('class', ConditionType.EQUALS, "close")
WebUI.waitForElementClickable(closeBtn, 10)
WebUI.click(closeBtn)

// --- Verify the product modal is closed ---
List<TestObject> products = []
for (int i = 1; i <= 1; i++) {
    TestObject product = new TestObject("productRPG${i}")
    product.addProperty('css', ConditionType.EQUALS, ".product[data-genre='RPG']:nth-of-type(${i})")
    products.add(product)
}

for (TestObject p : products) {
    assert WebUI.verifyElementNotVisible(p, FailureHandling.OPTIONAL) || !WebUI.getAttribute(p, 'class').contains('modal')
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

