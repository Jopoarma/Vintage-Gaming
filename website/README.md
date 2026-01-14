# Vintage-Gaming
Web platform for selling recent video games, featuring up-to-date titles, smooth navigation, and secure checkout.

Project Description
Vintage Gaming is a web project focused on online video games distributor. The platform allows users to browse products, add items to a shopping cart, and complete a checkout process after logging in. It also includes user authentication with registration and login features.
The goal of this project is to demonstrate front end and basic back end concepts such as:<br>
->	User authentication (login and registration)<br>
->	Session-based access control<br>
->	Shopping cart functionality<br>
->	Checkout flow restricted to authenticated users<br>
This project was developed to simulate a real online store environment and to validate proper functionality through various tests.<br><br>

Login & User Access
For testing and demonstration purposes, a default admin user is preloaded:<br>
->	Username: Admin<br>
->	Password: Root<br>
You can use this account to log in immediately without registering, but if you prefer to use your own account:<br>
1.	You must first register a new user.<br>
2.	After registration, log in using your new credentials.<br>
Important: Users must be logged in to proceed to checkout. Guests may browse and add items to the cart, but checkout is restricted to authenticated users. Login information is stored locally to simulate persistence on a remote server.<br><br>

Setup Instructions
Follow these steps to run the website locally.<br>
1. Download or Clone the Project<br>
If using Git:
git clone <https://github.com/Jopoarma/Vintage-Gaming> Or download the project as a ZIP file and extract it.<br>
2. Open the Project Folder<br>
Navigate to the root folder of the project where the main HTML file is called: index.html.<br>
3. Run the Website<br>
For better results, run the web page using a local server, in this case Visual Studio Code.<br>
Using VS Code:<br>
1.	Open the project folder in Visual Studio Code<br>
2.	Install the extension Live Server<br>
3.	Right click index.html<br>
4.	Click Open with Live Server<br><br>

Technologies Used
This project was built using the following technologies:<br>
->	HTML5 — Structure of the web pages<br>
->	CSS — Styling and responsive layout<br>
->	JavaScript — Dynamic behavior, cart logic, form validation, login handling<br>
->	Browser Local Storage — Temporary storage for login sessions and registration forms.<br><br>

Project Folder Structure
Below is a general overview of the project structure:<br>
Vintage-Gaming/<br>
│<br>
├── index.html            # Home page<br>
├── Login.html            # Login page<br>
├── Register.html         # User registration page<br>
├── checkout.html         # Checkout page (login required)<br>
├── shop.html             # Video games store (product listing)<br>
│<br>
├── style/<br>
│   └── style.css<br>
│<br>
├── js/<br>
│   ├── script.js<br>
│<br>
├── img/<br>
│   └── logo.png<br>
│<br>
└── README.md             # Project documentation<br>
This structure helps keep the project organized and separates concerns between layout, styling, logic, and local images.<br><br>

Features
->	Product catalog of video games<br>
->	Add to cart functionality<br>
->	Modal-based or page-based cart display<br>
->	User registration and login<br>
->	Preloaded admin account<br>
->	Checkout restricted to logged-in users<br>
->	Form validation for registration and checkout<br><br>

Notes
->	This project is intended for educational purposes.<br>
->	Payment processing is simulated and does not perform real transactions.<br>
->	User data is stored locally.<br><br>

Author
Developed by Jorge Arce as part of a final project for "Software testing tools" subject.
