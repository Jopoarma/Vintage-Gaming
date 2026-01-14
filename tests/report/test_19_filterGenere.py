import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_filter_rpg(driver):
    scenario = "Filter RPG Products"
    test_id = "TC_019"  # numeric Test Case ID
    description = "Verify that filtering products by RPG genre displays only RPG products"
    steps = (
        "1. Open Store page\n"
        "2. Select 'RPG' in genre filter dropdown\n"
        "3. Wait for products to refresh\n"
        "4. Verify that at least one product is visible\n"
        "5. Verify that all visible products have genre 'RPG'"
    )
    expected = "Filtering by RPG shows only RPG products"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Select RPG in filter
        select = Select(driver.find_element(By.ID, "filter-genre"))
        select.select_by_value("RPG")
        time.sleep(1)  # wait for filter to apply

        # Get visible products
        products = driver.find_elements(By.CLASS_NAME, "product")
        visible = [p for p in products if p.is_displayed()]

        # Assertions
        assert len(visible) > 0, "No visible RPG products found"
        for p in visible:
            assert p.get_attribute("data-genre") == "RPG", f"Product genre is not RPG: {p.get_attribute('data-genre')}"

        actual = f"{len(visible)} RPG products are displayed correctly"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

