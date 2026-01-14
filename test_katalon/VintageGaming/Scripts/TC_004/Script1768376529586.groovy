import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

// --- Locate YouTube Iframe ---
TestObject youtubeIframe = new TestObject('iframe_YouTube')
youtubeIframe.addProperty('xpath', ConditionType.EQUALS, "//iframe[contains(@src,'youtube')]")

WebUI.waitForElementPresent(youtubeIframe, 10)

// --- Scroll iframe into view ---
WebUI.scrollToElement(youtubeIframe, 10)

// --- Switch to iframe ---
WebUI.switchToFrame(youtubeIframe, 10)

// --- Click on video body to start playback (best effort) ---
TestObject videoBody = new TestObject('video_Body')
videoBody.addProperty('tag', ConditionType.EQUALS, 'body')
WebUI.waitForElementPresent(videoBody, 10)
WebUI.click(videoBody)

// --- Minimal wait to simulate playback ---
WebUI.delay(3)

// --- Switch back to main content ---
WebUI.switchToDefaultContent()

// --- Verify iframe is still visible ---
assert WebUI.verifyElementVisible(youtubeIframe, FailureHandling.STOP_ON_FAILURE)

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

