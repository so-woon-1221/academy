let desktops = document.querySelectorAll('.desktop');
let mobiles = document.querySelectorAll('.mobile');

$(document).ready(() => {
    if (window.innerWidth <= 768) {
        for (let desktop of desktops) {
            desktop.style.display = 'none';
        }

        for (let mobile of mobiles) {
            mobile.style.display = 'block';
        }
    }
})

for (let desktop of desktops) {
    desktop.style.display = 'block';
}

for (let mobile of mobiles) {
    mobile.style.display = 'none';
}

window.addEventListener('resize', ev => {
    if (window.innerWidth <= 768) {
        for (let desktop of desktops) {
            desktop.style.display = 'none';
        }

        for (let mobile of mobiles) {
            mobile.style.display = 'block';
        }
    } else {
        for (let desktop of desktops) {
            desktop.style.display = 'block';
        }

        for (let mobile of mobiles) {
            mobile.style.display = 'none';
        }
    }
})