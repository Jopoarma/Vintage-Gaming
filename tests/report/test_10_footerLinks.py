import pytest
from selenium.webdriver.common.by import By
from conftest import driver, INDEX
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_footer_developer_links(driver):
    scenario = "Footer Developer Links"
    test_id = "TC_010"  # numeric Test Case ID
    description = "Verify that footer contains links to the main developer websites"
    steps = (
        "1. Open Index page\n"
        "2. Get all footer sponsor/developer links\n"
        "3. Verify that links for cdprojektred.com, minecraft.net, and ubisoft.com exist"
    )
    expected = "Footer contains links to cdprojektred.com, minecraft.net, and ubisoft.com"

    try:
        driver.get(INDEX)

        footer_links = driver.find_elements(By.CSS_SELECTOR, ".sponsors2-logos a")
        expected_sites = ["cdprojektred.com", "minecraft.net", "ubisoft.com"]

        for site in expected_sites:
            assert any(site in link.get_attribute("href") for link in footer_links), \
                f"{site} link should exist in footer"

        actual = f"Footer links verified: {', '.join(expected_sites)}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

