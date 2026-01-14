import pytest
from conftest import driver, login
from conftest import SHOP, LOGIN
from results_logger import log_test

@pytest.mark.usefixtures("driver")
def test_login_and_go_to_shop(driver):
    scenario = "Login and Navigate to Shop"
    test_id = "TC_024"  # numeric Test Case ID
    description = "Verify that a registered user can login and is redirected to the Shop page"
    steps = (
        "1. Open Login page\n"
        "2. Login with registered credentials\n"
        "3. Verify that the user is redirected to the Shop page"
    )
    expected = "After login, user is redirected to shop.html"

    try:
        # --- Login ---
        login(driver)

        # Verify redirection to shop page
        assert "shop.html" in driver.current_url, f"Expected 'shop.html' in URL, got {driver.current_url}"

        actual = f"User redirected to: {driver.current_url}"
        status = "PASS"

    except Exception as e:
        actual = str(e)
        status = "FAIL"
        raise

    finally:
        log_test(scenario, test_id, description, steps, expected, actual, status)


