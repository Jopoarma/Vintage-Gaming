import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate to Shop ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

// --- Select RPG in genre filter ---
TestObject genreDropdown = new TestObject('genreDropdown')
genreDropdown.addProperty('id', ConditionType.EQUALS, 'filter-genre')
WebUI.selectOptionByValue(genreDropdown, 'RPG', false)

// --- Small delay to allow filtering ---
WebUI.delay(1)

// --- Get all products ---
TestObject productObj = new TestObject('products')
productObj.addProperty('class', ConditionType.EQUALS, 'product')
List products = WebUI.findWebElements(productObj, 5)

// --- Filter visible products ---
List visibleProducts = products.findAll { WebUI.verifyElementVisible(it, FailureHandling.OPTIONAL) }

// --- Assert at least 1 product is visible ---
assert visibleProducts.size() > 0 : "No RPG products are visible"

// --- Assert all visible products have genre RPG ---
visibleProducts.each { p ->
    assert p.getAttribute('data-genre') == 'RPG' : "Product genre is not RPG"
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

