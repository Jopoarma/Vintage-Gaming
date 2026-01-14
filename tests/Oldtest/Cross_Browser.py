import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def get_driver(browser): # cross-browser driver setup
    if browser == "chrome":
        return webdriver.Chrome()
    elif browser == "firefox":
        return webdriver.Firefox()
    else:
        raise ValueError("Unsupported browser")

def test_open_store_and_click_product(driver): # test function
    driver.get("http://127.0.0.1:5500/Vintage-Gaming/shop.html")

    products = WebDriverWait(driver, 10).until(
        EC.presence_of_all_elements_located((By.CLASS_NAME, "product"))
    )

    visible_products = [p for p in products if p.is_displayed()]
    visible_products[0].find_element(By.CLASS_NAME, "view-details").click()
    time.sleep(1)
    close_btn = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.CLASS_NAME, "close"))
    )
    close_btn.click()
    time.sleep(1)


browsers = ["chrome", "firefox"] # Testing list of browsers
for browser in browsers:
    driver = get_driver(browser)
    driver.maximize_window()

    try:
        test_open_store_and_click_product(driver)
        print(f"{browser} TEST PASS")
    except Exception as e:
        print(f"{browser} TEST FAIL", e)
    finally:
        driver.quit()
