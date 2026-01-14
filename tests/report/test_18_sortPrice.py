import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time
from conftest import driver, SHOP
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_sort_low_to_high(driver):
    scenario = "Sort Products Low to High"
    test_id = "TC_018"  # numeric Test Case ID
    description = "Verify that sorting products by price low to high works correctly"
    steps = (
        "1. Open Store page\n"
        "2. Select 'Low to High' in sort dropdown\n"
        "3. Collect all product prices\n"
        "4. Verify that prices are sorted in ascending order"
    )
    expected = "Product prices are sorted from low to high"

    try:
        # --- Open Store page ---
        driver.get(SHOP)

        # Select sort by price low to high
        select = Select(driver.find_element(By.ID, "sort-price"))
        select.select_by_value("asc")
        time.sleep(1)  # wait for sorting to update

        # Get product prices
        products = driver.find_elements(By.CLASS_NAME, "product")
        prices = [float(p.get_attribute("data-price")) for p in products]

        # Verify ascending order
        assert prices == sorted(prices), f"Prices are not sorted ascending: {prices}"

        actual = f"Product prices sorted correctly: {prices}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

