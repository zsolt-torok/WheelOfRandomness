import {embedYoutube} from "./embedYoutube.js";

export let modal = {

    showModal: function (response) {
        console.log(response);
        let movie = response;

        let modal = document.querySelector(".modal");
        modal.classList.remove("hidden");
        let modalBody = modal.querySelector(".modal-body");

        let movieData = `
            <div class="card" style="width: 33rem">
              <div class="card-body">
                <h5 class="card-title">${movie.title}</h5>
                <p class="card-text">${movie.overview !== null ? movie.overview : 'No overview available'}</p>
              </div>
              
              <div class="align-center">
              <div class="card-video-top" id="player" data-src="${movie.trailer !== null ? movie.trailer : ""}"></div>
              </div>
              <ul class="list-group list-group-flush">
                <li class="runtime">Runtime: ${movie.runtime} min</li>
                <li class="year">Year: ${movie.year}</li>
                <li class="rating">Rating: ${movie.rating} &#9734</li>
              </ul>
              <div class="card-body">
                <div class="align-right">
                <a href="${movie.homepage}" class="card-link" target="_blank">Home Page</a>
                </div>
              </div>
            </div>
           `;

        modalBody.innerHTML = movieData;
        embedYoutube.init();
    },

    closeModal: function (event) {
        let closeButton = event.target;
        let modal = closeButton.closest(".modal");
        modal.classList.add("hidden");
    }

}