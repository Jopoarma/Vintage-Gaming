import csv
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.maximize_window()

url = "http://127.0.0.1:5500/Vintage-Gaming/Login.html"

with open(r"c:\Users\jopoa\Documents\GitHub\Test_pytest\users_test.csv", newline='') as file:
    reader = csv.DictReader(file)

    for row in reader:
        username = row["username"]
        password = row["password"]

        driver.get(url)
        time.sleep(1)

        user_input = driver.find_element(By.ID, "loginEmail")
        pass_input = driver.find_element(By.ID, "loginPassword")
        login_btn = driver.find_element(By.ID, "loginBtn")

        user_input.clear()
        pass_input.clear()
        user_input.send_keys(username)
        pass_input.send_keys(password)
        login_btn.click()
        time.sleep(1)

        WebDriverWait(driver, 10).until(EC.alert_is_present())
        alert = driver.switch_to.alert
        #print(alert.text)
        alert_text = alert.text
        alert.accept()
        time.sleep(1)
        if "Login Successfully!" in alert_text:
            print(f" TEST PASS (login ok): User: {username} and Password: {password} are correct")
            time.sleep(1)
            logout_btn = driver.find_element(By.ID, "logoutBtn")
            logout_btn.click()
            time.sleep(1)
            alert = driver.switch_to.alert
            alert.accept()
            time.sleep(1)
        elif "Error: No account found with this email!" in alert_text:
            print(f" TEST FAIL (invalid user): User: {username} is invalid")
        elif "Error: Incorrect password!" in alert_text:
            print(f" TEST FAIL (invalid password): Password {password} is invalid")

        else:
            print(f" TEST FAIL (invalid credentials): User: {username} and Password {password} are invalid")

driver.quit()
