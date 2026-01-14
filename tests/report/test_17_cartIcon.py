import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_open_cart_with_icon(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Open Cart With Icon"
    test_id = "TC_017"  # numeric Test Case ID
    description = "Verify that clicking the cart icon opens the cart modal"
    steps = (
        "1. Open Store page\n"
        "2. Click on the cart icon/button\n"
        "3. Verify that the cart modal is displayed"
    )
    expected = "Cart modal is displayed when cart icon is clicked"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Click cart icon
        driver.find_element(By.ID, "view-cart-btn").click()

        # Wait for cart modal
        cart = wait.until(EC.visibility_of_element_located((By.ID, "cart-modal")))
        assert cart.is_displayed(), "Cart modal should be visible"

        actual = "Cart modal displayed successfully"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

