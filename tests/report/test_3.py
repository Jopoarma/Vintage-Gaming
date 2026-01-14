import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait, Select
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_store_rpg_filter(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Store RPG Filter"
    test_id = "TC_003"  # numeric Test Case ID
    description = "Verify that selecting RPG genre filter displays at least 2 RPG products and product modals work correctly"
    steps = (
        "1. Open Store page\n"
        "2. Select RPG in genre filter\n"
        "3. Verify at least 2 RPG products are visible\n"
        "4. Open and close the first product modal\n"
        "5. Open and close the second product modal"
    )
    expected = "At least 2 RPG products are visible and product modals can open and close successfully"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Click STORE link (optional if SHOP already opens store)
        store_link = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "STORE")))
        store_link.click()

        # --- Apply RPG filter ---
        genre_select = Select(wait.until(EC.presence_of_element_located((By.ID, "filter-genre"))))
        genre_select.select_by_visible_text("RPG")

        # Wait for RPG products to appear
        wait.until(lambda d: len(d.find_elements(By.CSS_SELECTOR, ".product[data-genre='RPG']")) > 0)

        products = driver.find_elements(By.CSS_SELECTOR, ".product")
        visible_products = [p for p in products if p.is_displayed()]

        # Assert at least 2 RPG products are visible
        assert len(visible_products) >= 2, f"Expected at least 2 RPG products, found {len(visible_products)}"

        # --- Test opening and closing first product modal ---
        first_product = visible_products[0]
        view_details = first_product.find_element(By.CLASS_NAME, "view-details")
        view_details.click()

        close_btn = wait.until(EC.element_to_be_clickable((By.CLASS_NAME, "close")))
        close_btn.click()

        # --- Test opening and closing second product modal ---
        second_product = visible_products[1]
        view_details = second_product.find_element(By.CLASS_NAME, "view-details")
        view_details.click()

        close_btn = wait.until(EC.element_to_be_clickable((By.CLASS_NAME, "close")))
        close_btn.click()

        actual = f"{len(visible_products)} RPG products visible, modals opened/closed successfully"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log the result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)
