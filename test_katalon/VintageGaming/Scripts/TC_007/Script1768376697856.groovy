import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate to Homepage ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

// --- Find all sponsor links dynamically ---
TestObject sponsorLinksObj = new TestObject('sponsorLinks')
sponsorLinksObj.addProperty('css', ConditionType.EQUALS, '.sponsor-links a')

// Get the number of sponsor links
int count = WebUI.findWebElements(sponsorLinksObj, 10).size()

// Assert at least 3 links
assert count >= 3 : "There should be at least 3 sponsor links"

// --- Verify each link ---
List links = WebUI.findWebElements(sponsorLinksObj, 10)
for (def link : links) {
    String href = link.getAttribute('href')
    String target = link.getAttribute('target')
    assert href.startsWith("http") : "Link ${href} should be valid"
    assert target == "_blank" : "Link should open in a new tab"
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

