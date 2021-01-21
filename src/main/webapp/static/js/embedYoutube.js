let player;
let done = false;

export let embedYoutube = {
    // script from https://developers.google.com/youtube/iframe_api_reference
    // console.log("loading")
    // 2. This code loads the IFrame Player API code asynchronously.
    init: function () {
        var tag = document.createElement('script')

        tag.src = "https://www.youtube.com/iframe_api";
        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

        // gets video url from player div and gets video ID from it using regex match:
        let r = /(v=)([^?]+)/
        let videoURL = document.querySelector('#player').dataset.src
        if (videoURL.length > 0) {
            let videoId = videoURL.match(r)[2]
            this.onYouTubeIframeAPIReady(videoId);
        }
    },

    // 3. This function creates an <iframe> (and YouTube player)
    //    after the API code downloads.

    onYouTubeIframeAPIReady: function (videoId) {
        player = new YT.Player('player', {
            height: '270',
            width: '480',
            videoId: videoId,
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChange
            }
        });
    }
}

// 4. The API will call this function when the video player is ready.
function onPlayerReady(event) {
    event.target.playVideo();
};

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING && !done) {
        setTimeout(stopVideo, 6000);
        done = true;
    }
};

function stopVideo() {
    player.stopVideo();
};
