import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// --- Open Browser and Navigate ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/index.html')

// --- Find all footer developer links dynamically ---
TestObject footerLinksObj = new TestObject('footerLinks')
footerLinksObj.addProperty('css', ConditionType.EQUALS, '.sponsors2-logos a')

// Get all footer link elements
List footerLinks = WebUI.findWebElements(footerLinksObj, 10)

// --- Expected sites ---
List expectedSites = ["cdprojektred.com", "minecraft.net", "ubisoft.com"]

// --- Verify each expected site exists ---
for (String site : expectedSites) {
	assert footerLinks.any { it.getAttribute('href').contains(site) } : "${site} link should exist in footer"
}

// --- Close Browser ---
WebUI.closeBrowser()
