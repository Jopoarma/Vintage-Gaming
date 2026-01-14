import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from results_logger import log_test, save_results  # import your logger

def test_login_and_purchase_flow():
    driver = webdriver.Chrome()
    driver.maximize_window()
    wait = WebDriverWait(driver, 10)

    scenario = "Login and Purchase Flow"
    test_id = "TC_001"
    description = "Verify a user can login, add product to cart, and checkout successfully"
    steps = (
        "1. Open Login page\n"
        "2. Enter credentials and login\n"
        "3. Navigate to Store\n"
        "4. Open product modal\n"
        "5. Add product to cart\n"
        "6. Checkout\n"
        "7. Enter payment info and pay"
    )
    expected = "Login successful, product added to cart, checkout completed, payment accepted"
    
    try:
        url = "http://127.0.0.1:5500/Vintage-Gaming/Login.html"
        username = "admin@vintage-gaming.com"
        password = "J0p0@dmin"

        driver.get(url)

        # --- Login ---
        user_input = wait.until(EC.element_to_be_clickable((By.ID, "loginEmail")))
        pass_input = driver.find_element(By.ID, "loginPassword")
        login_btn = driver.find_element(By.ID, "loginBtn")

        user_input.clear()
        pass_input.clear()
        user_input.send_keys(username)
        pass_input.send_keys(password)
        login_btn.click()

        # --- Login Alert ---
        alert = wait.until(EC.alert_is_present())
        actual_login = alert.text
        alert.accept()
        assert "Login Successfully!" in actual_login

        # --- Go to Store ---
        store = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "STORE")))
        store.click()

        # --- Open Product Modal ---
        details = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, "a[data-product='cyberpunk']"))
        )
        details.click()

        # --- Add to Cart ---
        addCart = wait.until(EC.element_to_be_clickable((By.ID, "add-to-cart")))
        addCart.click()

        # --- Checkout ---
        checkout = wait.until(EC.element_to_be_clickable((By.ID, "checkout-btn")))
        checkout.click()

        # --- Switch to Payment Iframe ---
        iframe = wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "iframe")))
        driver.switch_to.frame(iframe)

        # --- Enter Card Info ---
        driver.find_element(By.ID, "card-number").send_keys("7777 7777 7777 7777")
        driver.find_element(By.ID, "card-exp").send_keys("02/27")
        driver.find_element(By.ID, "card-cvc").send_keys("777")

        # --- Pay ---
        driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

        # --- Payment Alert ---
        driver.switch_to.default_content()
        payment_alert = wait.until(EC.alert_is_present())
        actual_payment = payment_alert.text
        payment_alert.accept()

        actual = f"{actual_login} | {actual_payment}"
        status = "PASS"

        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        log_test(scenario, test_id, description, steps, expected, actual, status)
        raise  # re-raise so pytest sees the failure

    finally:
        time.sleep(2)
        driver.quit()
        # Optional: save after each test or save once in conftest.py
        save_results("Selenium_Test_Results.xlsx")
