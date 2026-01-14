import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_store_first_product_details(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Store First Product Details"
    test_id = "TC_005"  # numeric Test Case ID
    description = "Verify that the first visible RPG product details modal opens and closes correctly"
    steps = (
        "1. Open Store page\n"
        "2. Wait for RPG products to load\n"
        "3. Verify at least 1 product is visible\n"
        "4. Open the first product details modal\n"
        "5. Close the modal\n"
        "6. Verify the modal is no longer visible"
    )
    expected = "The first product modal opens and closes successfully"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Click STORE link (optional if SHOP already opens store)
        store_link = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "STORE")))
        store_link.click()

        # Wait for RPG products to appear
        wait.until(lambda d: len(d.find_elements(By.CSS_SELECTOR, ".product[data-genre='RPG']")) > 0)

        products = driver.find_elements(By.CSS_SELECTOR, ".product")
        visible_products = [p for p in products if p.is_displayed()]

        # Assert at least 1 visible product
        assert len(visible_products) > 0, "No visible RPG products found"

        # Open and close first product modal
        first_product = visible_products[0]
        view_details = first_product.find_element(By.CLASS_NAME, "view-details")
        view_details.click()

        close_btn = wait.until(EC.element_to_be_clickable((By.CLASS_NAME, "close")))
        close_btn.click()

        # Verify modal is closed
        modals = driver.find_elements(By.CLASS_NAME, "product")
        assert all(not p.is_displayed() or "modal" not in p.get_attribute("class") for p in modals), \
            "Product details modal did not close properly"

        actual = f"First product modal opened and closed successfully, {len(visible_products)} products visible"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)
