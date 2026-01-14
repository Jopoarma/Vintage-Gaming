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

wait = WebDriverWait(driver, 10)

video_iframe = wait.until(EC.presence_of_element_located((By.XPATH, "//iframe[contains(@src,'youtube')]"))) # locate iframe
driver.execute_script("arguments[0].scrollIntoView({block:'center'});", video_iframe)

video_area = wait.until(EC.presence_of_element_located((By.TAG_NAME, "body")))
video_area.click()
time.sleep(5)  # play for 5 seconds

driver.switch_to.default_content() # switch back to main content
time.sleep(2)
driver.quit()