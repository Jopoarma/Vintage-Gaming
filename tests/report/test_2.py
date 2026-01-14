import csv
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import LOGIN
from results_logger import log_test

def load_users(csv_path):
    users = []
    with open(csv_path, newline='') as file:
        reader = csv.DictReader(file)
        for idx, row in enumerate(reader, start=2):  # start=2 for TC_002
            users.append((idx, row["username"], row["password"]))
    return users

@pytest.mark.parametrize(
    "tc_num,username,password",
    load_users(r"c:\Users\jopoa\Documents\tests\report\users_test.csv")
)
def test_login_csv(driver, tc_num, username, password):
    wait = WebDriverWait(driver, 10)

    scenario = "Login Functionality"
    test_id = f"TC_{tc_num:03}"
    description = "Verify login using CSV-driven users"
    steps = (
        "1. Open Login page\n"
        "2. Enter username and password\n"
        "3. Click login button\n"
        "4. Verify alert message and logout if successful"
    )
    expected = "Login succeeds for valid users, fails for invalid users"

    try:
        driver.get(LOGIN)
        driver.find_element(By.ID, "loginEmail").clear()
        driver.find_element(By.ID, "loginPassword").clear()
        driver.find_element(By.ID, "loginEmail").send_keys(username)
        driver.find_element(By.ID, "loginPassword").send_keys(password)
        driver.find_element(By.ID, "loginBtn").click()

        alert = wait.until(EC.alert_is_present())
        alert_text = alert.text
        alert.accept()

        if "Login Successfully!" in alert_text:
            driver.find_element(By.ID, "logoutBtn").click()
            WebDriverWait(driver, 5).until(EC.alert_is_present()).accept()
            actual = f"Login successful for {username} | Alert: {alert_text}"
            status = "PASS"
        elif "No account found" in alert_text:
            actual = f"Invalid user: {username} | Alert: {alert_text}"
            status = "FAIL"
        elif "Incorrect password" in alert_text:
            actual = f"Invalid password for user: {username} | Alert: {alert_text}"
            status = "FAIL"
        else:
            actual = f"Unexpected login failure for {username} | Alert: {alert_text}"
            status = "FAIL"

        assert status == "PASS", actual

    except Exception as e:
        actual = f"Exception occurred: {str(e)}"
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)
