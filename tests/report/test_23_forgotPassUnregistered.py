import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, LOGIN
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_forgot_password_unregistered(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Forgot Password Unregistered User"
    test_id = "TC_023"  # numeric Test Case ID
    description = "Verify that attempting 'Forgot Password' with unregistered email shows an appropriate alert"
    steps = (
        "1. Open Login page\n"
        "2. Click 'Forgot Password'\n"
        "3. Enter unregistered email in prompt\n"
        "4. Accept prompt\n"
        "5. Verify alert message is displayed (error or info)"
    )
    expected = "Alert indicates password reset link was not sent for unregistered email"

    try:
        # --- Open Login page ---
        driver.get(LOGIN)

        # Click 'Forgot Password'
        driver.find_element(By.ID, "forgotPass").click()

        # Wait for prompt
        prompt = wait.until(EC.alert_is_present())
        prompt.send_keys("wrong@example.com")
        prompt.accept()

        # Wait for resulting alert
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        assert "password reset link" in alert_text.lower(), f"Unexpected alert text: {alert_text}"
        alert.accept()

        actual = f"Alert displayed successfully: '{alert_text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)







