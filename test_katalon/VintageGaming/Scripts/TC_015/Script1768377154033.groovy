import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// --- Open Browser and Navigate to Store Page ---
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://127.0.0.1:5500/Vintage-Gaming/website/shop.html')

// --- Open first product dynamically ---
TestObject firstProduct = new TestObject('firstProduct')
firstProduct.addProperty('css', ConditionType.EQUALS, '.product:nth-of-type(1)')
WebUI.click(firstProduct)

// --- Add to cart ---
TestObject addToCartBtn = new TestObject('btn_AddToCart')
addToCartBtn.addProperty('id', ConditionType.EQUALS, 'add-to-cart')
WebUI.click(addToCartBtn)

// --- Click Checkout ---
TestObject checkoutBtn = new TestObject('btn_Checkout')
checkoutBtn.addProperty('id', ConditionType.EQUALS, 'checkout-btn')
WebUI.click(checkoutBtn)

// --- Wait for alert ---
if (WebUI.waitForAlert(5, FailureHandling.OPTIONAL)) {
    String alertText = WebUI.getAlertText()
    WebUI.acceptAlert()

    // --- Assert alert text contains "logged in" ---
    assert alertText.toLowerCase().contains("logged in") : "Alert should notify user to login first"
} else {
    assert false : "Expected alert did not appear"
}

// --- Close Browser ---
WebUI.closeBrowser()


