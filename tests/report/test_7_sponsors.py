import pytest
from selenium.webdriver.common.by import By
from conftest import driver, INDEX
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_header_sponsor_links(driver):
    scenario = "Header Sponsor Links"
    test_id = "TC_007"  # numeric Test Case ID
    description = "Verify that the header has at least 3 sponsor links and they open in a new tab"
    steps = (
        "1. Open Index page\n"
        "2. Count sponsor links\n"
        "3. Verify at least 3 links exist\n"
        "4. Verify each link's href starts with 'http'\n"
        "5. Verify each link opens in a new tab (target='_blank')"
    )
    expected = "At least 3 sponsor links exist and each opens in a new tab with a valid URL"

    try:
        # --- Open Index page ---
        driver.get(INDEX)

        sponsor_links = driver.find_elements(By.CSS_SELECTOR, ".sponsor-links a")
        assert len(sponsor_links) >= 3, f"Expected at least 3 sponsor links, found {len(sponsor_links)}"

        for link in sponsor_links:
            href = link.get_attribute("href")
            target = link.get_attribute("target")
            assert href.startswith("http"), f"Link {href} should be valid"
            assert target == "_blank", f"Link {href} should open in a new tab"

        actual = f"{len(sponsor_links)} sponsor links verified successfully"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

