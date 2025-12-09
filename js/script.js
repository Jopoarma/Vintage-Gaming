console.log("Script loaded");


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
