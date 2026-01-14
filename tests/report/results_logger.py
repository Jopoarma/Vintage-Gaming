import pandas as pd

# Initialize results list
test_results = []

def log_test(
    scenario, test_id, description, steps, expected, actual, status
):
    """
    Log a single test result
    """
    test_results.append({
        "Test Case Scenario": scenario,
        "Test Case ID": test_id,
        "Testcase Description": description,
        "Testcase Steps": steps,
        "Expected Result": expected,
        "Actual Result": actual,
        "Testdata Status": status
    })

def save_results(filename="test_results.xlsx"):
    """
    Save all logged test results to Excel
    """
    if test_results:
        df = pd.DataFrame(test_results)
        df.to_excel(filename, index=False)
        print(f"✅ Test results saved to {filename}")
    else:
        print("⚠️ No test results to save.")
