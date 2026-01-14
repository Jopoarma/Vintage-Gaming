import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, LOGIN
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_login_unregistered_user(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Login Unregistered User"
    test_id = "TC_021"  # numeric Test Case ID
    description = "Verify that logging in with unregistered credentials shows an alert and does not set localStorage"
    steps = (
        "1. Open Login page\n"
        "2. Enter unregistered email and password\n"
        "3. Click login\n"
        "4. Verify alert message indicates no account found\n"
        "5. Verify localStorage 'loggedUser' is not set"
    )
    expected = "Alert shows 'No account found' and localStorage remains empty"

    try:
        # --- Open Login page ---
        driver.get(LOGIN)

        # Enter unregistered credentials
        driver.find_element(By.ID, "loginEmail").send_keys("wrong@example.com")
        driver.find_element(By.ID, "loginPassword").send_keys("12345678")
        driver.find_element(By.ID, "loginBtn").click()

        # Wait for alert
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        assert "No account found" in alert_text
        alert.accept()

        # Verify localStorage is empty
        logged_user = driver.execute_script("return localStorage.getItem('loggedUser');")
        assert logged_user is None, "localStorage 'loggedUser' should be None"

        actual = f"Alert displayed: '{alert_text}', localStorage empty as expected"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

