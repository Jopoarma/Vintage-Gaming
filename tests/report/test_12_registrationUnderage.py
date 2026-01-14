import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, REGISTER
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_registration_underage(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "Registration Underage Validation"
    test_id = "TC_012"  # numeric Test Case ID
    description = "Verify that registering a user under 18 shows an age validation error"
    steps = (
        "1. Open Register page\n"
        "2. Fill in registration fields with age under 18\n"
        "3. Submit the form\n"
        "4. Verify that age validation error is shown"
    )
    expected = "Age validation error is displayed for users under 18"

    try:
        # --- Open Register page ---
        driver.get(REGISTER)

        # Fill in registration form
        driver.find_element(By.ID, "name").send_keys("Ana")
        driver.find_element(By.ID, "lastName").send_keys("Test")
        driver.find_element(By.ID, "age").send_keys("15")
        driver.find_element(By.ID, "nickname").send_keys("Tester99")
        driver.find_element(By.ID, "address").send_keys("456 Main Street")
        driver.find_element(By.ID, "emailReg").send_keys("underage@test.com")
        driver.find_element(By.ID, "password").send_keys("Strong@123")

        # Submit form
        driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

        # Wait for age error message
        age_error = wait.until(lambda d: d.find_element(By.ID, "ageError"))
        assert age_error.text != "", "Age validation error should be shown"

        actual = f"Age validation error displayed: '{age_error.text}'"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)

