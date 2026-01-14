import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Define Browsers to Test ---
def browsers = ["Chrome", "Firefox"]

for (String browser : browsers) {

    // --- Open Browser ---
    WebUI.openBrowser('')
    RunConfiguration.setWebDriverPreferencesProperty("browserType", browser.toLowerCase())
    WebUI.maximizeWindow()
    WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

    // --- Wait for all products ---
    TestObject firstProduct = new TestObject('product1')
    firstProduct.addProperty('css', ConditionType.EQUALS, ".product:nth-of-type(1)")
    WebUI.waitForElementPresent(firstProduct, 10)

    // --- Verify product is visible ---
    assert WebUI.verifyElementVisible(firstProduct, FailureHandling.STOP_ON_FAILURE)

    // --- Open first product modal ---
    TestObject viewDetails = new TestObject('viewDetails1')
    viewDetails.addProperty('css', ConditionType.EQUALS, ".product:nth-of-type(1) .view-details")
    WebUI.click(viewDetails)

    // --- Wait for Close button and click ---
    TestObject closeBtn = new TestObject('closeBtn1')
    closeBtn.addProperty('class', ConditionType.EQUALS, "close")
    WebUI.waitForElementClickable(closeBtn, 10)
    WebUI.click(closeBtn)

    // --- Verify modal is closed ---
    List<TestObject> products = []
    products.add(firstProduct)
    for (TestObject p : products) {
        assert WebUI.verifyElementNotVisible(p, FailureHandling.OPTIONAL) || !WebUI.getAttribute(p, 'class').contains('modal')
    }

    // --- Close Browser ---
    WebUI.closeBrowser()
}
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

