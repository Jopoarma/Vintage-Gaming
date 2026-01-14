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

WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_LOGIN (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_STORE (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_REGISTRATION (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/img (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/input_Top 3 Best Videogames_position (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/input_Top 3 Best Videogames_position_1 (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/input_Top 3 Best Videogames_position_2 (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/div_Designed by Jorge Arce                 _de57fc'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/i_REGISTRATION_fa-solid fa-cart-arrow-down (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (1)'))

WebUI.closeBrowser()

