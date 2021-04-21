const carousel = document.getElementById('myCarousel');
const indicator = carousel.querySelector('.carousel-indicators');
const lists = indicator.children;
const texts = [];

for (let list of lists){
    texts.push(list.innerText);
}

window.onload = () => {
    if (window.innerWidth <= 768) {
        for (let list of lists) {
            list.innerHTML = '';
        }
    }
}

window.addEventListener('resize', ev => {
    if (window.innerWidth <= 768) {
        for (let list of lists) {
            list.innerHTML = '';
        }
    }
    else {
        for (let i=0; i<lists.length; i++) {
            lists[i].innerHTML = texts[i];
        }
    }
})