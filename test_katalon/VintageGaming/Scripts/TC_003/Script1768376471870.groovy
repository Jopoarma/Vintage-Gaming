import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate to Home Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

// --- Click STORE link ---
WebUI.click(findTestObject('Page_Home/link_Store'))

// --- Select RPG from Genre Filter ---
TestObject genreDropdown = findTestObject('Page_Store/dropdown_Genre')
WebUI.selectOptionByLabel(genreDropdown, 'RPG', false)

// --- Wait for RPG products to appear ---
WebUI.waitForElementPresent(findTestObject('Page_Store/product_RPG1'), 10)
WebUI.waitForElementPresent(findTestObject('Page_Store/product_RPG2'), 10)

// --- Collect visible products dynamically ---
List<TestObject> visibleProducts = []
for (int i = 1; i <= 2; i++) {
    TestObject product = new TestObject("product_RPG" + i)
    product.addProperty("css", ConditionType.EQUALS, ".product[data-genre='RPG']:nth-of-type(${i})")
    if (WebUI.verifyElementVisible(product, FailureHandling.OPTIONAL)) {
        visibleProducts.add(product)
    }
}

// --- Assert at least 2 RPG products are visible ---
assert visibleProducts.size() >= 2 : "Expected at least 2 RPG products, found ${visibleProducts.size()}"

// --- Open and Close first 2 product modals ---
for (int i = 0; i < 2; i++) {
    TestObject viewDetails = new TestObject("viewDetails${i}")
    viewDetails.addProperty("css", ConditionType.EQUALS, ".product[data-genre='RPG']:nth-of-type(${i+1}) .view-details")
    WebUI.click(viewDetails)

    // Wait for Close button and click it
    TestObject closeBtn = new TestObject("closeBtn${i}")
    closeBtn.addProperty("class", ConditionType.EQUALS, "close")
    WebUI.waitForElementClickable(closeBtn, 10)
    WebUI.click(closeBtn)
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

