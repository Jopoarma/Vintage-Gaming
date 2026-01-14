# import pytest
# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.support.ui import WebDriverWait
# from selenium.webdriver.support import expected_conditions as EC

# BASE = "http://127.0.0.1:5500/Vintage-Gaming"
# SHOP = f"{BASE}/shop.html"
# LOGIN = f"{BASE}/Login.html"

# EMAIL = "admin@vintage-gaming.com"
# PASSWORD = "J0p0@dmin"


# @pytest.fixture
# def driver():
#     d = webdriver.Chrome()
#     d.maximize_window()
#     d.get(SHOP)

#     # clear localStorage before each test
#     d.execute_script("localStorage.clear();")
#     d.refresh()

#     yield d
#     d.quit()


# def login(driver):
#     driver.get(LOGIN)

#     driver.find_element(By.ID, "loginEmail").send_keys(EMAIL)
#     driver.find_element(By.ID, "loginPassword").send_keys(PASSWORD)
#     driver.find_element(By.ID, "loginBtn").click()

#     WebDriverWait(driver, 5).until(EC.alert_is_present())
#     driver.switch_to.alert.accept()

#     driver.get(SHOP)


# def open_first_product(driver):
#     product = WebDriverWait(driver, 10).until(
#         EC.presence_of_element_located((By.CLASS_NAME, "product"))
#     )
#     product.find_element(By.CLASS_NAME, "view-details").click()

#     WebDriverWait(driver, 5).until(
#         EC.visibility_of_element_located((By.ID, "modal"))
#     )
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from results_logger import save_results

BASE = "http://127.0.0.1:5500/Vintage-Gaming"
SHOP = f"{BASE}/shop.html"
LOGIN = f"{BASE}/Login.html"
REGISTER = f"{BASE}/Register.html"
INDEX = f"{BASE}/index.html"

EMAIL = "admin@vintage-gaming.com"
PASSWORD = "J0p0@dmin"

@pytest.fixture
def driver():
    d = webdriver.Chrome()
    d.maximize_window()
    
    # clear localStorage before starting any test
    d.get(BASE)
    d.execute_script("localStorage.clear();")
    
    yield d
    d.quit()


def login(driver, email=None, password=None):
    driver.get(LOGIN)
    driver.find_element(By.ID, "loginEmail").send_keys(email or EMAIL)
    driver.find_element(By.ID, "loginPassword").send_keys(password or PASSWORD)
    driver.find_element(By.ID, "loginBtn").click()

    # Wait for alert if login shows one
    WebDriverWait(driver, 5).until(EC.alert_is_present())
    driver.switch_to.alert.accept()

    # Go to shop page
    driver.get(SHOP)



def open_first_product(driver):
    product = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.CLASS_NAME, "product"))
    )
    product.find_element(By.CLASS_NAME, "view-details").click()
    WebDriverWait(driver, 5).until(
        EC.visibility_of_element_located((By.ID, "modal"))
    )

def pytest_sessionfinish(session, exitstatus):
    # This runs after all tests finish
    save_results("Selenium_Test_Results.xlsx")