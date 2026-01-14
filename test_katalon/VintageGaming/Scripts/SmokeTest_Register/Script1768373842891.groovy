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

WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/register.html')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Full Name_name (1)'), 'tester1')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Last Name_lastName (1)'), 'tester')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Age_age (1)'), '25')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Nickname_nickname (1)'), 'tester123')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Address_address (1)'), '12 montreal')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Email_emailReg (1)'), 'tester1@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Vintage Gamers/input_Password_password (1)'), '3IidCaElDWbEDKnNOrAwtg==')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Register (1)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_LOGIN (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_STORE (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/i_REGISTRATION_fa-solid fa-cart-arrow-down (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/span_ (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/img (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_REGISTRATION (2)'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Register (1)'))

WebUI.closeBrowser()

