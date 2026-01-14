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

WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/Login.html')

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Email_loginEmail'), 'ttttttt')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/div_Login                                  _fb40a8'))

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Email_loginEmail'), 'test1@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Vintage Gamers/input_Password_loginPassword'), '1qa697miWrZOiS7q4aCu7g==')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Forgot Password'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/div_Login                                  _d5631a'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/div_Login                                  _d5631a'))

WebUI.setText(findTestObject('Object Repository/Page_Vintage Gamers/input_Email_loginEmail'), 'admin@vintage-gaming.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Vintage Gamers/input_Password_loginPassword'), '1qa697miWrZOiS7q4aCu7g==')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/div_Login                                  _d5631a'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Vintage Gamers/input_Password_loginPassword'), 'tDmGG/8W55YrPyD55Vo3pw==')

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/a_Logout'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Forgot Password'))

WebUI.click(findTestObject('Object Repository/Page_Vintage Gamers/button_Forgot Password'))

WebUI.closeBrowser()

