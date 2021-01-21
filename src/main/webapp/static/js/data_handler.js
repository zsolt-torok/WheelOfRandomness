export let dataHandler = {
    _api_get: function (url, callback) {
        // it is not called from outside
        // loads data from API, parses it and calls the callback with it

        fetch(url, {
            method: 'GET',
            credentials: 'same-origin'
        })
            .then(response => response.json())  // parse the response as JSON
            .then(json_response => callback(json_response));  // Call the `callback` with the returned object
    },

    _api_post: function (url, data, callback) {
        // it is not called from outside
        // sends the data to the API, and calls callback function

        fetch(url, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data),
            credentials: "same-origin"
        })
            .then(response => response.json())  // parse the response as JSON
            .then(json_response => callback(json_response))
            .catch(error => {
                console.log("Fetch error: " + error);
            });
    },

    getRandomMovie: function (categoryId, callback) {
        dataHandler._api_get(`http://localhost:8080/random-show?genre-id=${categoryId}`, callback);
    },

    getCategoryNames: function (callback) {
        dataHandler._api_get("http://localhost:8080/get-all-categories", callback)
    }
}