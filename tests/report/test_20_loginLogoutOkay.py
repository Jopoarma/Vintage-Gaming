import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, login
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_login_and_logout_registered_user(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Login and Logout Registered User"
    test_id = "TC_020"  # numeric Test Case ID
    description = "Verify that a registered user can login and logout successfully"
    steps = (
        "1. Login as a registered user\n"
        "2. Wait for logout button to appear\n"
        "3. Click logout\n"
        "4. Accept logout confirmation alert\n"
        "5. Verify localStorage 'loggedUser' is removed"
    )
    expected = "User can login and logout successfully, 'loggedUser' removed from localStorage"

    try:
        # --- Login ---
        login(driver)

        # Wait for logout button and click it
        logout_btn = wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "nav-logout-btn")))
        logout_btn.click()

        # Wait for alert and accept
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        assert "Session ended successfully" in alert_text
        alert.accept()

        # Verify localStorage cleared
        logged_user = driver.execute_script("return localStorage.getItem('loggedUser');")
        assert logged_user is None, "loggedUser should be removed from localStorage"

        actual = "User logged in and out successfully, localStorage cleared"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)





