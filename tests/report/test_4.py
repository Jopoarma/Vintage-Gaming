import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from conftest import driver, INDEX
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_youtube_video_iframe(driver):
    wait = WebDriverWait(driver, 10)

    scenario = "YouTube Video Iframe"
    test_id = "TC_004"  # numeric Test Case ID
    description = "Verify that the YouTube iframe is present, visible, and can be interacted with"
    steps = (
        "1. Open Index page\n"
        "2. Wait for YouTube iframe to load\n"
        "3. Scroll iframe into view\n"
        "4. Switch to iframe and click video body\n"
        "5. Switch back to main content\n"
        "6. Verify iframe is still visible"
    )
    expected = "YouTube iframe is visible and can be clicked/interacted with"

    try:
        # --- Open Index page ---
        driver.get(INDEX)

        # Wait for YouTube iframe
        video_iframe = wait.until(EC.presence_of_element_located(
            (By.XPATH, "//iframe[contains(@src,'youtube')]")
        ))

        # Scroll iframe into view
        driver.execute_script("arguments[0].scrollIntoView({block:'center'});", video_iframe)

        # Switch to iframe and click
        driver.switch_to.frame(video_iframe)
        video_area = wait.until(EC.presence_of_element_located((By.TAG_NAME, "body")))
        video_area.click()

        # Minimal wait to simulate playback
        wait.until(lambda d: True)

        # Switch back to main content
        driver.switch_to.default_content()

        # Assert iframe is visible
        assert video_iframe.is_displayed(), "YouTube iframe should be visible"

        actual = "YouTube iframe present, clicked, and visible"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        # --- Log result ---
        log_test(scenario, test_id, description, steps, expected, actual, status)
