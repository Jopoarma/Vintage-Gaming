import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, LOGIN
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_forgot_password_registered(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Forgot Password Registered User"
    test_id = "TC_022"  # numeric Test Case ID
    description = "Verify that registered users receive a password reset link when using 'Forgot Password'"
    steps = (
        "1. Open Login page\n"
        "2. Override prompt to provide registered email\n"
        "3. Click 'Forgot Password'\n"
        "4. Verify alert message indicates password reset link"
    )
    expected = "Alert shows that password reset link has been sent"

    try:
        # --- Open Login page ---
        driver.get(LOGIN)

        # Override prompt for email input
        driver.execute_script("window.prompt = () => 'admin@vintage-gaming.com';")

        # Click 'Forgot Password'
        driver.find_element(By.ID, "forgotPass").click()

        # Wait for alert
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        assert "password reset link" in alert_text.lower(), "Alert should indicate password reset link"
        alert.accept()

        actual = f"Alert displayed successfully: '{alert_text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)


