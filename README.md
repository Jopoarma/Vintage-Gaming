# Vintage-Gaming
Web platform for selling recent video games, featuring up-to-date titles, smooth navigation, and secure checkout.

Project Description
Vintage Gaming is a web project focused on online video games distributor. The platform allows users to browse products, add items to a shopping cart, and complete a checkout process after logging in. It also includes user authentication with registration and login features.
The goal of this project is to demonstrate front end and basic back end concepts such as:
->	User authentication (login and registration)
->	Session-based access control
->	Shopping cart functionality
->	Checkout flow restricted to authenticated users
This project was developed to simulate a real online store environment and to validate proper functionality through various tests.

Login & User Access
For testing and demonstration purposes, a default admin user is preloaded:
->	Username: Admin
->	Password: Root
You can use this account to log in immediately without registering.
If you prefer to use your own account:
1.	You must first register a new user.
2.	After registration, log in using your new credentials.
Important: Users must be logged in to proceed to checkout. Guests may browse and add items to the cart, but checkout is restricted to authenticated users. Login information is stored locally to simulate persistence on a remote server.

Setup Instructions
Follow these steps to run the website locally.
1. Download or Clone the Project
If using Git:
git clone <https://github.com/Jopoarma/Vintage-Gaming> Or download the project as a ZIP file and extract it.
2. Open the Project Folder
Navigate to the root folder of the project where the main HTML file is called: index.html.
3. Run the Website
For better results, run the web page using a local server, in this case Visual Studio Code.
Using VS Code:
1.	Open the project folder in Visual Studio Code
2.	Install the extension Live Server
3.	Right click index.html
4.	Click Open with Live Server

Technologies Used
This project was built using the following technologies:
->	HTML5 — Structure of the web pages
->	CSS — Styling and responsive layout
->	JavaScript — Dynamic behavior, cart logic, form validation, login handling
•	Browser Local Storage — Temporary storage for login sessions and registration forms.

Project Folder Structure
Below is a general overview of the project structure:
Vintage-Gaming/
│
├── index.html            # Home page
├── Login.html            # Login page
├── Register.html         # User registration page
├── checkout.html         # Checkout page (login required)
├── shop.html             # Video games store (product listing)
│
├── style/
│   └── style.css
│
├── js/
│   ├── script.js
│
├── img/
│   └── logo.png
│
└── README.md             # Project documentation
This structure helps keep the project organized and separates concerns between layout, styling, logic, and local images.

Features
->	Product catalog of video games
->	Add to cart functionality
->	Modal-based or page-based cart display
->	User registration and login
->	Preloaded admin account
->	Checkout restricted to logged-in users
->	Form validation for registration and checkout

Notes
->	This project is intended for educational purposes.
->	Payment processing is simulated and does not perform real transactions.
->	User data is stored locally.

Author
Developed by Jorge Arce as part of a final project for "Software testing tools" subject.