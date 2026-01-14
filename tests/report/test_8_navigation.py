import pytest
from selenium.webdriver.common.by import By
from conftest import driver, INDEX
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_navigation_links(driver):
    scenario = "Navigation Links"
    test_id = "TC_008"  # numeric Test Case ID
    description = "Verify that the main navigation contains LOGIN, STORE, and REGISTRATION links"
    steps = (
        "1. Open Index page\n"
        "2. Get all navigation links\n"
        "3. Verify that 'LOGIN', 'STORE', and 'REGISTRATION' are present in nav links"
    )
    expected = "Navigation contains LOGIN, STORE, and REGISTRATION links"

    try:
        driver.get(INDEX)

        nav_links = driver.find_elements(By.CSS_SELECTOR, "nav .nav-links a")
        nav_texts = [link.text for link in nav_links]
        expected_texts = ["LOGIN", "STORE", "REGISTRATION"]

        for text in expected_texts:
            assert text in nav_texts, f"{text} should be present in navigation"

        actual = f"Navigation links verified: {', '.join(nav_texts)}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

