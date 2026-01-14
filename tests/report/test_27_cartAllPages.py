import pytest
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import BASE
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_access_cart_from_all_pages(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Access Cart From All Pages"
    test_id = "TC_027"  # numeric Test Case ID
    description = "Verify that the cart modal can be opened from all main pages and closed successfully"
    steps = (
        "1. Visit each main page (index, shop, login, register)\n"
        "2. Click on 'View Cart' button\n"
        "3. Wait for cart modal to appear\n"
        "4. Close the cart modal"
    )
    expected = "Cart modal can be accessed and closed on all pages"

    try:
        pages = ["index.html", "shop.html", "Login.html", "Register.html"]
        for page in pages:
            driver.get(f"{BASE}/{page}")
            driver.find_element(By.ID, "view-cart-btn").click()
            wait.until(EC.visibility_of_element_located((By.ID, "cart-modal")))
            # Close cart
            driver.find_element(By.ID, "cart-close").click()

        actual = f"Cart modal accessed and closed successfully on pages: {', '.join(pages)}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)


