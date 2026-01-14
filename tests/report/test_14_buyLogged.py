import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, login, open_first_product
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_checkout_logged_user(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Checkout Logged-in User"
    test_id = "TC_014"  # numeric Test Case ID
    description = "Verify that a logged-in user can add a product to cart and see the payment iframe during checkout"
    steps = (
        "1. Login as a valid user\n"
        "2. Open the first product details\n"
        "3. Add the product to the cart\n"
        "4. Click checkout\n"
        "5. Verify that payment iframe is displayed"
    )
    expected = "Payment iframe is displayed for checkout"

    try:
        # --- Login and open first product ---
        login(driver)
        open_first_product(driver)

        # Add to cart and checkout
        driver.find_element(By.ID, "add-to-cart").click()
        driver.find_element(By.ID, "checkout-btn").click()

        # Wait for payment iframe
        iframe = wait.until(EC.visibility_of_element_located((By.ID, "payment-iframe")))
        assert iframe.is_displayed(), "Payment iframe should be visible"

        actual = "Payment iframe displayed successfully for logged-in user"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)

