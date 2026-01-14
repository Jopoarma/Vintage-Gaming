import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, open_first_product
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_checkout_without_login(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Checkout Without Login"
    test_id = "TC_015"  # numeric Test Case ID
    description = "Verify that attempting to checkout without logging in shows an alert"
    steps = (
        "1. Open the first product details\n"
        "2. Add the product to the cart\n"
        "3. Click checkout\n"
        "4. Verify that an alert appears requiring login"
    )
    expected = "Alert is shown indicating the user must be logged in to checkout"

    try:
        # --- Open first product ---
        open_first_product(driver)

        # Add to cart and click checkout
        driver.find_element(By.ID, "add-to-cart").click()
        driver.find_element(By.ID, "checkout-btn").click()

        # Wait for alert and validate message
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        alert.accept()

        assert "logged in" in alert_text.lower(), "Alert message should indicate login requirement"

        actual = f"Alert displayed successfully: '{alert_text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)

