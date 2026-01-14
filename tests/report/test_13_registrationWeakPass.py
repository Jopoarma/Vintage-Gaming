import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, REGISTER
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_registration_weak_password(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Registration Weak Password Validation"
    test_id = "TC_013"  # numeric Test Case ID
    description = "Verify that registering with a weak password shows a password validation error"
    steps = (
        "1. Open Register page\n"
        "2. Fill in registration fields with a weak password\n"
        "3. Submit the form\n"
        "4. Verify that password validation error is shown"
    )
    expected = "Password validation error is displayed for weak passwords"

    try:
        # --- Open Register page ---
        driver.get(REGISTER)

        # Fill in registration form
        driver.find_element(By.ID, "name").send_keys("Mike")
        driver.find_element(By.ID, "lastName").send_keys("Smith")
        driver.find_element(By.ID, "age").send_keys("25")
        driver.find_element(By.ID, "nickname").send_keys("PlayerX1")
        driver.find_element(By.ID, "address").send_keys("789 Queen Street")
        driver.find_element(By.ID, "emailReg").send_keys("weakpass@test.com")
        driver.find_element(By.ID, "password").send_keys("abc123")

        # Submit form
        driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

        # Wait for password error message
        password_error = wait.until(lambda d: d.find_element(By.ID, "passwordError"))
        assert password_error.text != "", "Password validation error should be shown"

        actual = f"Password validation error displayed: '{password_error.text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

