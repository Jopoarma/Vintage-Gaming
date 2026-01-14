import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_register_and_login(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Register and Login User"
    test_id = "TC_025"  # numeric Test Case ID
    description = "Verify that a new user can register and then login successfully"
    steps = (
        "1. Open Register page\n"
        "2. Fill in registration form with valid data\n"
        "3. Submit form and accept any alert\n"
        "4. Open Login page\n"
        "5. Fill in login credentials\n"
        "6. Submit login form and accept alert\n"
        "7. Verify that user is logged in (logout button visible)"
    )
    expected = "User can register successfully and login, logout button is visible"

    try:
        # --- 1. Register the user ---
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
            alert_text = alert.text
            alert.accept()
        except:
            alert_text = "No alert displayed during registration"

        # --- 2. Login ---
        login_url = "http://127.0.0.1:5500/Vintage-Gaming/Login.html"
        driver.get(login_url)

        driver.find_element(By.ID, "loginEmail").send_keys("jorge.arce@example.com")
        driver.find_element(By.ID, "loginPassword").send_keys("StrongPass1!")
        driver.find_element(By.ID, "loginBtn").click()

        # Accept login alert
        alert = wait.until(EC.alert_is_present())
        login_alert_text = alert.text
        alert.accept()

        # Verify logout button
        logout_btn = wait.until(
            EC.visibility_of_element_located((By.ID, "logoutBtn"))
        )
        assert logout_btn.is_displayed(), "Logout button not visible, login failed"

        actual = f"Registration alert: '{alert_text}' | Login alert: '{login_alert_text}' | Logout button visible"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)
