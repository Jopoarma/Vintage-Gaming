//console.log("Script loaded");

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("sponsor-search-form");
    const input = document.getElementById("search-input");
    const paragraphs = document.querySelectorAll(".test1 p");

    const originalTexts = Array.from(paragraphs).map(p => p.textContent);

    form.addEventListener("submit", (e) => {
        e.preventDefault();
        const query = input.value.toLowerCase().trim();

        paragraphs.forEach((p, index) => {
            const originalText = originalTexts[index];

            if (query === "") {

                p.style.display = "block";
                p.innerHTML = originalText;
            } else {
                const text = originalText.toLowerCase();
                if (text.includes(query)) {
                    p.style.display = "block";

                    const regex = new RegExp(`(${query})`, 'gi');
                    const highlighted = originalText.replace(regex, '<mark>$1</mark>');
                    p.innerHTML = highlighted;
                } else {
                    p.style.display = "none";
                }
            }
        });
    });
});

document.addEventListener("DOMContentLoaded", () => {
    const hamburger = document.querySelector('.hamburger');
    const navLinks = document.querySelector('.nav-links');

    hamburger.addEventListener('click', (e) => {
        navLinks.classList.toggle('menu-open');
        e.stopPropagation();
    });

    navLinks.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', () => {
            navLinks.classList.remove('menu-open');
        });
    });

    document.addEventListener('click', (e) => {
        if (navLinks.classList.contains('menu-open')) {
            const isClickInsideMenu = navLinks.contains(e.target) || hamburger.contains(e.target);
            if (!isClickInsideMenu) {
                navLinks.classList.remove('menu-open');
            }
        }
    });

    navLinks.addEventListener('mouseleave', () => {
        if (window.innerWidth <= 768) {
            navLinks.classList.remove('menu-open');
        }
    });
});

function updateWatch() {
    const now = new Date();
    const hours = String(now.getHours()).padStart(2, "0");
    const minutes = String(now.getMinutes()).padStart(2, "0");
    const seconds = String(now.getSeconds()).padStart(2, "0");

    document.getElementById("watch").textContent = `${hours}:${minutes}:${seconds}`;
}

setInterval(updateWatch, 1000);
updateWatch();

// User Login State in Navigation Bar
window.addEventListener("DOMContentLoaded", () => {
    const user = localStorage.getItem("loggedUser");
    const nav = document.querySelector(".bar2-L");

    if (user) {
        const nickname = JSON.parse(localStorage.getItem("user_" + user)).nickname;
        const loggedHTML = `
            <span class="sponsor-title" style="color:var(--fonts-menu); margin:auto 15px auto 50px; text-transform: uppercase">Hi, ${nickname}</span>
            <a href="javascript:void(0)" class="nav-logout-btn" onclick="logoutFromNav()">Logout</a>
        `;
        nav.innerHTML += loggedHTML;
    }
});

function logoutFromNav() {
    localStorage.removeItem("loggedUser");
    alert("Session ended successfully. See you soon!");
    location.reload();
}

// Registration Form in local storage
const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
const regForm = document.getElementById("registrationForm");
// registration form
if (regForm) {
    regForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const name = document.getElementById("name").value.trim();
        const lastName = document.getElementById("lastName").value.trim();
        const ageInput = document.getElementById("age").value.trim();
        const age = parseInt(ageInput, 10);
        const nickname = document.getElementById("nickname").value.trim();
        const address = document.getElementById("address").value.trim();
        const email = document.getElementById("emailReg").value.trim();
        const password = document.getElementById("password").value;

        document.querySelectorAll(".error").forEach(e => e.textContent = "");
        let valid = true;

        // Validation of each field
        if (name.length < 2) {
            document.getElementById("nameError").textContent = "Name must be at least 2 characters.";
            valid = false;
        }

        if (lastName.length < 2) {
            document.getElementById("lnameError").textContent = "Last Name must be at least 2 characters.";
            valid = false;
        }

        if (!ageInput || isNaN(age)) {
            document.getElementById("ageError").textContent = "Please enter a valid age.";
            valid = false;
        } else if (age < 18) {
            document.getElementById("ageError").textContent = "The minimum age is 18.";
            valid = false;
        }

        if (nickname.length < 6) {
            document.getElementById("nicknameError").textContent = "Nickname must be at least 6 characters.";
            valid = false;
        }

        if (address.length < 6) {
            document.getElementById("addressError").textContent = "Address must be at least 6 characters.";
            valid = false;
        }

        if (!email.includes("@")) {
            document.getElementById("emailError").textContent = "Enter a valid email.";
            valid = false;
        }

        if (!passwordRegex.test(password)) {
            document.getElementById("passwordError").textContent = "Password does not meet requirements.";
            valid = false;
        }

        if (!valid) return;

        // Save in local storage
        const userData = { name, lastName, age, nickname, address, email, password };

        localStorage.setItem("user_" + email, JSON.stringify(userData));
        alert("Registration successful!");
        this.reset();
    });
}

// Forgot Password prompt simulation
function forgotPassword() {
    const email = prompt("Enter your account email:");
    if (!email) return;

    const user = localStorage.getItem("user_" + email);

    if (user) {
        alert("A password reset link has been sented to your email.");
    } else {
        alert("ERROR: Email not found in our System. Try again.");
    }
}

// Login Form
const loginForm = document.getElementById("loginForm");

if (loginForm) {
    loginForm.addEventListener("submit", function (e) {
        e.preventDefault();

        const email = document.getElementById("loginEmail").value.trim();
        const password = document.getElementById("loginPassword").value;

        document.getElementById("loginEmailError").textContent = "";
        document.getElementById("loginPasswordError").textContent = "";
        // Validate inputs
        const userData = localStorage.getItem("user_" + email);
        if (!userData) {
            document.getElementById("loginEmailError").textContent = "No account found with this email.";
            return;
        }

        const user = JSON.parse(userData);
        if (user.password !== password) {
            document.getElementById("loginPasswordError").textContent = "Incorrect password.";
            return;
        }

        // Successful login
        localStorage.setItem("loggedUser", email);
        alert("Login Successfully!");
        window.location.reload();
    });
}
// Logout Button
const logoutBtn = document.getElementById("logoutBtn");
const forgotPass = document.getElementById("forgotPass");

if (logoutBtn) {
    logoutBtn.addEventListener("click", function () {
        localStorage.removeItem("loggedUser");
        alert("Session ended successfully. See you soon!");
        window.location.reload();
    });
}

window.addEventListener("DOMContentLoaded", function () {
    const loggedUser = localStorage.getItem("loggedUser");
    if (loggedUser && logoutBtn) {
        logoutBtn.style.display = "block";
        forgotPass.style.display = "none";
    }
});

document.addEventListener("DOMContentLoaded", () => {
    // Product filtering and sorting
    const catalog = document.getElementById("game-catalog");
    const genreFilter = document.getElementById("filter-genre");
    const platformFilter = document.getElementById("filter-platform");
    const sortSelect = document.getElementById("sort-price");

    if (catalog && genreFilter && platformFilter && sortSelect) {
        function updateCatalog() {
            const genre = genreFilter.value;
            const platform = platformFilter.value;
            const sort = sortSelect.value;

            const products = Array.from(catalog.querySelectorAll(".product"));

            // Filter
            products.forEach(p => {
                const matchesGenre = !genre || genre === p.dataset.genre;
                const matchesPlatform = !platform || platform === p.dataset.platform;
                p.style.display = (matchesGenre && matchesPlatform) ? "block" : "none";
            });

            // Sort
            if (sort) {
                const sorted = products.sort((a, b) =>
                    sort === "asc"
                        ? parseFloat(a.dataset.price) - parseFloat(b.dataset.price)
                        : parseFloat(b.dataset.price) - parseFloat(a.dataset.price)
                );
                sorted.forEach(p => catalog.appendChild(p));
            }
        }

        genreFilter.addEventListener("change", updateCatalog);
        platformFilter.addEventListener("change", updateCatalog);
        sortSelect.addEventListener("change", updateCatalog);
        updateCatalog();
    }
}
);