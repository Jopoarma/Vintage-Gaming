import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import login
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_login_username_display(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Login Username Display"
    test_id = "TC_028"  # numeric Test Case ID
    description = "Verify that after login, the username is displayed correctly in the navigation bar"
    steps = (
        "1. Login using registered credentials\n"
        "2. Wait for username span to appear\n"
        "3. Verify that the displayed username matches expected"
    )
    expected = "After login, the username is visible in the nav bar"

    try:
        # --- Login ---
        login(driver)

        # Wait for username span
        username_span = wait.until(
            EC.visibility_of_element_located((By.ID, "logged-nickname"))
        )

        # Assert username text
        assert "SuperUser" in username_span.text or "TestUser123" in username_span.text, \
            f"Unexpected username displayed: {username_span.text}"

        actual = f"Username displayed correctly: '{username_span.text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

