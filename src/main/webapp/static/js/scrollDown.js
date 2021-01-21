function initScrollDown(){
    window.scroll({
        top: 965,
        behavior: 'smooth'
    });
}

document.querySelector(".container").addEventListener("click", initScrollDown);