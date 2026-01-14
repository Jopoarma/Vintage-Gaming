import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, open_first_product, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_add_two_remove_one(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Add Two Products, Remove One"
    test_id = "TC_016"  # numeric Test Case ID
    description = "Verify that a user can add two products to the cart and remove one correctly"
    steps = (
        "1. Open Store page\n"
        "2. Add first product to cart and close modal\n"
        "3. Add second product to cart\n"
        "4. Verify cart contains 2 items\n"
        "5. Remove first item\n"
        "6. Verify cart now contains 1 item"
    )
    expected = "User can add two products and remove one, leaving 1 item in cart"

    try:
        # --- Add first product ---
        driver.get(SHOP)
        open_first_product(driver)
        driver.find_element(By.ID, "add-to-cart").click()

        # Close cart modal
        wait.until(EC.visibility_of_element_located((By.ID, "cart-modal")))
        driver.find_element(By.ID, "cart-close").click()

        # --- Add second product ---
        products = driver.find_elements(By.CLASS_NAME, "product")
        products[1].find_element(By.CLASS_NAME, "view-details").click()
        wait.until(EC.visibility_of_element_located((By.ID, "modal")))
        driver.find_element(By.ID, "add-to-cart").click()

        # Verify 2 items in cart
        items = wait.until(EC.presence_of_all_elements_located((By.CSS_SELECTOR, "#cart-items li")))
        assert len(items) == 2, f"Expected 2 items in cart, found {len(items)}"

        # Remove first item
        items[0].find_element(By.CLASS_NAME, "remove").click()

        items_after = driver.find_elements(By.CSS_SELECTOR, "#cart-items li")
        assert len(items_after) == 1, f"Expected 1 item in cart after removal, found {len(items_after)}"

        actual = "Added two products, removed one, cart updated correctly"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)
