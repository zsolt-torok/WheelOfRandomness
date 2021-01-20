export let modal = {

    showModal: function (response) {
        console.log(response);
        let movie = response;

        let modal = document.querySelector(".modal");
        modal.classList.remove("hidden");
        let modalBody = modal.querySelector(".modal-body");

        let movieData = `
            <div class="card" style="width: 33rem;">
            <iframe class="card-video-top" width="360" height="250" src="${movie.trailer !== null ? movie.trailer.replace("watch?v=", "embed/") : ""}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
              <div class="card-body">
                <h5 class="card-title">${movie.title}</h5>
                <p class="card-text">${movie.overview}</p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="runtime">Runtime: ${movie.runtime} min</li>
                <li class="year">Year: ${movie.year}</li>
                <li class="rating">Rating: ${movie.rating}</li>
              </ul>
              <div class="card-body">
                <a href="${movie.homepage}" class="card-link" target="_blank">Home Page</a>
              </div>
            </div>
           `;

        modalBody.innerHTML = movieData;
    },

    closeModal: function (event) {
        let closeButton = event.target;
        let modal = closeButton.closest(".modal");
        modal.classList.add("hidden");
    }

}