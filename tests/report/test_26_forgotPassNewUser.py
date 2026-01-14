import pytest
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_register_and_forgot_password(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Register and Forgot Password"
    test_id = "TC_026"  # numeric Test Case ID
    description = "Verify that a newly registered user can use the 'Forgot Password' feature successfully"
    steps = (
        "1. Open Register page\n"
        "2. Fill registration form and submit\n"
        "3. Accept registration alert\n"
        "4. Go to Login page\n"
        "5. Click 'Forgot Password'\n"
        "6. Enter registered email in prompt\n"
        "7. Accept confirmation alert"
    )
    expected = "User registers successfully and receives a confirmation alert when using 'Forgot Password'"

    try:
        # --- 1. Register a new user ---
        register_url = "http://127.0.0.1:5500/Vintage-Gaming/Register.html"
        driver.get(register_url)

        driver.find_element(By.ID, "name").send_keys("Jorge")
        driver.find_element(By.ID, "lastName").send_keys("Arce")
        driver.find_element(By.ID, "age").send_keys("20")
        driver.find_element(By.ID, "nickname").send_keys("Jopoarma")
        driver.find_element(By.ID, "address").send_keys("123 St Laurent Blvd")
        driver.find_element(By.ID, "emailReg").send_keys("jorge.arce@example.com")
        driver.find_element(By.ID, "password").send_keys("StrongPass1!")
        driver.find_element(By.CSS_SELECTOR, "form#registrationForm button[type='submit']").click()

        # Accept registration alert if present
        try:
            alert = wait.until(EC.alert_is_present())
            registration_alert_text = alert.text
            alert.accept()
        except:
            registration_alert_text = "No registration alert"

        time.sleep(1)  # ensure localStorage is updated

        # --- 2. Go to Login page ---
        login_url = "http://127.0.0.1:5500/Vintage-Gaming/Login.html"
        driver.get(login_url)
        time.sleep(1)  # wait for page load

        # --- 3. Click 'Forgot Password' ---
        forgot_btn = driver.find_element(By.ID, "forgotPass")
        forgot_btn.click()
        time.sleep(1)  # wait for prompt

        # --- 4. Handle prompt ---
        try:
            prompt = driver.switch_to.alert
            prompt.send_keys("jorge.arce@example.com")
            time.sleep(0.5)
            prompt.accept()
        except:
            raise Exception("Forgot Password prompt did not appear")

        # --- 5. Handle confirmation alert ---
        try:
            time.sleep(0.5)
            confirm_alert = driver.switch_to.alert
            forgot_alert_text = confirm_alert.text
            confirm_alert.accept()
        except:
            raise Exception("Forgot Password confirmation alert did not appear")

        actual = f"Registration alert: '{registration_alert_text}' | Forgot Password alert: '{forgot_alert_text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

