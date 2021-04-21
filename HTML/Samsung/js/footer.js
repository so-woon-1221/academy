const footHeaders = document.querySelectorAll('.footPanelHead');

$(document).ready(() => {
    if (window.innerWidth <= 768) {
        for (let footHeader of footHeaders) {
            let footPanel = footHeader.querySelector('.footPanel');
            footPanel.style.display = 'none';
            footHeader.classList.add('active');
        }
    } else {
        for (let footHeader of footHeaders) {
            footHeader.classList.remove('active');
        }
    }
})

for (let footHeader of footHeaders) {
    let footPanel = footHeader.querySelector('.footPanel');
    footHeader.addEventListener('click', function () {
        if (footPanel.style.display === 'block' && footHeader.classList.contains('active')) {
            footPanel.style.display = 'none';
            footHeader.classList.remove('open');
        } else {
            footPanel.style.display = 'block';
            footHeader.classList.add('open')

        }
    })
}

window.addEventListener('resize', ev => {
    if (window.innerWidth <= 768) {
        for (let footHeader of footHeaders) {
            let footPanel = footHeader.querySelector('.footPanel');
            footPanel.style.display = 'none';
            footHeader.classList.add('active');
        }
    } else {
        for (let footHeader of footHeaders) {
            footHeader.classList.remove('active');
            let footPanel = footHeader.querySelector('.footPanel');
            footPanel.style.display = 'block';
        }
    }
})