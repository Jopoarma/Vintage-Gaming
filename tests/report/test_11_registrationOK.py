import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, REGISTER
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_register_new_user(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Register New User"
    test_id = "TC_011"  # numeric Test Case ID
    description = "Verify that a new user can register successfully"
    steps = (
        "1. Open Register page\n"
        "2. Fill in all registration fields\n"
        "3. Submit the form\n"
        "4. Accept registration alerts\n"
        "5. Verify registration completion"
    )
    expected = "New user registers successfully and alert confirms registration"

    try:
        # --- Open Register page ---
        driver.get(REGISTER)

        # Fill registration form
        driver.find_element(By.ID, "name").send_keys("Jorge")
        driver.find_element(By.ID, "lastName").send_keys("Arce")
        driver.find_element(By.ID, "age").send_keys("20")
        driver.find_element(By.ID, "nickname").send_keys("Jopoarma")
        driver.find_element(By.ID, "address").send_keys("123 St Laurent Blvd")
        driver.find_element(By.ID, "emailReg").send_keys("jorge.arce@example.com")
        driver.find_element(By.ID, "password").send_keys("StrongPass1!")

        # Submit form
        driver.find_element(By.CSS_SELECTOR, "form#registrationForm button[type='submit']").click()

        # Accept alert
        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        alert.accept()

        # Check for any follow-up alert (optional)
        try:
            follow_up_alert = WebDriverWait(driver, 3).until(EC.alert_is_present())
            follow_up_alert_text = follow_up_alert.text
            follow_up_alert.accept()
            alert_text += f" | Follow-up alert: {follow_up_alert_text}"
        except:
            pass

        actual = f"Registration alerts accepted: {alert_text}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

