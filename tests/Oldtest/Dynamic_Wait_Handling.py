import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait, Select
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.maximize_window()
url = "http://127.0.0.1:5500/Vintage-Gaming/index.html"

driver.get(url)
time.sleep(1)
store = driver.find_element("link text", "STORE")
store.click()
time.sleep(1)

genre_select = Select(driver.find_element(By.ID, "filter-genre"))
genre_select.select_by_visible_text("RPG")
wait = WebDriverWait(driver, 10)

wait.until(lambda d: len(d.find_elements(By.CSS_SELECTOR, ".product[data-genre='RPG']")) > 0)
products = driver.find_elements(By.CSS_SELECTOR, ".product")
visible_products = [p for p in products if p.is_displayed()]
print("Visible products:", len(visible_products))
time.sleep(1)

first_product = next(p for p in products if p.is_displayed())
view_details = first_product.find_element(By.CLASS_NAME, "view-details")
view_details.click()
time.sleep(1)
close_btn = driver.find_element(By.CLASS_NAME, "close")
close_btn.click()
time.sleep(1)

second_product = visible_products[1]
view_details = second_product.find_element(By.CLASS_NAME, "view-details")
view_details.click()
time.sleep(1)
close_btn = driver.find_element(By.CLASS_NAME, "close")
close_btn.click()

time.sleep(2)
driver.quit()