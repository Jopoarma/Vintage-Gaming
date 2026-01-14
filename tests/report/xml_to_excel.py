# xml_to_excel.py
import pandas as pd
import xml.etree.ElementTree as ET

tree = ET.parse("results.xml")
root = tree.getroot()

data = []
for testcase in root.iter("testcase"):
    classname = testcase.attrib.get("classname")
    name = testcase.attrib.get("name")
    time_taken = testcase.attrib.get("time")
    status = "passed"
    message = ""

    failure = testcase.find("failure")
    skipped = testcase.find("skipped")
    
    if failure is not None:
        status = "failed"
        message = failure.attrib.get("message", failure.text)
    elif skipped is not None:
        status = "skipped"
        message = skipped.attrib.get("message", skipped.text)

    data.append([classname, name, status, time_taken, message])

df = pd.DataFrame(data, columns=["Class", "Test", "Status", "Time (s)", "Message"])
df.to_excel("pytest_results.xlsx", index=False)
print("Excel report created: pytest_results.xlsx")
