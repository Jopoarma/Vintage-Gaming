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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/img (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_1 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_2 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_3 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_4 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_5 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_6 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_7 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_8 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_9 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_10 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details_11 (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (3) (1)'))

WebUI.openBrowser('')

WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Vintage Gamers/select_All Genres                Action    _8d8ae2 (1)'), 
    'RPG', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Vintage Gamers/select_All Platforms                PC     _4835e2 (1)'), 
    'PC', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Vintage Gamers/select_Sort by Price                Lowest _b748c9 (1)'), 
    'desc', true)

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Add to Cart (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Add to Cart (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Remove (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/i_REGISTRATION_fa-solid fa-cart-arrow-down (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Remove (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_View Details (1) (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Add to Cart (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/i_REGISTRATION_fa-solid fa-cart-arrow-down (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/i_REGISTRATION_fa-solid fa-cart-arrow-down (4)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Checkout (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Remove (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (4)'))

WebUI.closeBrowser()

