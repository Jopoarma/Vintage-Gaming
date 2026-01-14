import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_open_store_and_click_product(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Store Product Modal"
    test_id = "TC_006"  # numeric Test Case ID
    description = "Verify that clicking 'view details' on the first product opens and closes the modal correctly"
    steps = (
        "1. Open Store page\n"
        "2. Wait for all products to load\n"
        "3. Verify at least one product is visible\n"
        "4. Click 'view details' on the first product\n"
        "5. Close the product modal\n"
        "6. Verify modal is closed"
    )
    expected = "First product modal opens and closes successfully"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Wait for all products
        products = wait.until(
            EC.presence_of_all_elements_located((By.CLASS_NAME, "product"))
        )

        visible_products = [p for p in products if p.is_displayed()]
        assert visible_products, "No visible products found"

        # Open first product modal
        visible_products[0].find_element(By.CLASS_NAME, "view-details").click()

        # Close the modal
        close_btn = wait.until(EC.element_to_be_clickable((By.CLASS_NAME, "close")))
        close_btn.click()

        # Verify modal is closed
        modals = driver.find_elements(By.CLASS_NAME, "product")
        assert all("modal" not in p.get_attribute("class") for p in modals), \
            "Product modal did not close properly"

        actual = "First product modal opened and closed successfully"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)

