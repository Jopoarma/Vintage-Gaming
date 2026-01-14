import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.maximize_window()

url = "http://127.0.0.1:5500/Vintage-Gaming/Login.html"


username = ["admin@vintage-gaming.com"]
password = ["J0p0@dmin"]

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
alert_text = alert.text
alert.accept()
time.sleep(1)
if "Login Successfully!" in alert_text:
    print(f" Login correct")
    time.sleep(1)
    store = driver.find_element("link text", "STORE")
    store.click()
    time.sleep(1)
    details = driver.find_element("css selector", "a[data-product='cyberpunk']")
    details.click()
    time.sleep(1)
    addCart = driver.find_element(By.ID, "add-to-cart")
    addCart.click()
    time.sleep(1)
    checkout = driver.find_element(By.ID, "checkout-btn")
    checkout.click()
    time.sleep(1)
    iframe = driver.find_element("css selector", "iframe")
    driver.switch_to.frame(iframe)
    card_input1 = driver.find_element(By.ID, "card-number")
    card_input1.send_keys("7777777777777777")
    time.sleep(1)
    card_input2 = driver.find_element(By.ID, "card-exp")
    card_input2.send_keys("0227")
    time.sleep(1)
    card_input3 = driver.find_element(By.ID, "card-cvc")
    card_input3.send_keys("777")
    time.sleep(1)
    pay = driver.find_element("css selector", "button[type='submit']")
    pay.click()
    WebDriverWait(driver, 10).until(EC.alert_is_present())
    time.sleep(1)
    alert = driver.switch_to.alert
    alert.accept()
    time.sleep(2)
    print(f" Payment processed successfully")
    print(f" TEST PASS (successful purchase): Login and payment are successful")
else:
    print(f" TEST FAIL (invalid credentials): User: {username} and Password {password} are invalid")
driver.quit()