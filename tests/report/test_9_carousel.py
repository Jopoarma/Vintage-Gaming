import pytest
from selenium.webdriver.common.by import By
from conftest import driver, INDEX
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_carousel_links(driver):
    scenario = "Carousel Links"
    test_id = "TC_009"  # numeric Test Case ID
    description = "Verify that the homepage carousel has exactly 3 items and their links are valid"
    steps = (
        "1. Open Index page\n"
        "2. Get all carousel item links\n"
        "3. Verify there are exactly 3 items\n"
        "4. Verify each link starts with 'http'"
    )
    expected = "Homepage carousel has exactly 3 items and all links are valid"

    try:
        driver.get(INDEX)

        carousel_items = driver.find_elements(By.CSS_SELECTOR, "#carousel .item .item-link")
        assert len(carousel_items) == 3, f"Expected 3 carousel items, found {len(carousel_items)}"

        for link in carousel_items:
            href = link.get_attribute("href")
            assert href.startswith("http"), f"Carousel link {href} should be valid"

        actual = f"{len(carousel_items)} carousel links verified successfully"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

