
import {dataHandler} from "./data_handler.js";
import {modal} from "./modal.js";


const sectors = [
];

const rand = (m, M) => Math.random() * (M - m) + m;

let tot = sectors.length;       // must be changed
const EL_spin = document.querySelector("#spin");
const ctx = document.querySelector("#wheel").getContext('2d');
const dia = ctx.canvas.width;
const rad = dia / 2;
const PI = Math.PI;
const TAU = 2 * PI;
let arc = TAU / sectors.length;
const friction = 0.991; // 0.995=soft, 0.99=mid, 0.98=hard

let angVel = 0; // Angular velocity
let ang = 0; // Angle in radians
const getIndex = () => Math.floor(tot - ang / TAU * tot) % tot;

function drawSector(sector, i) {
    console.log(sector, " ", i);
    const ang = arc * i;
    ctx.save();
    // COLOR
    ctx.beginPath();
    ctx.fillStyle = sector.color;
    ctx.moveTo(rad, rad);
    ctx.arc(rad, rad, rad, ang, ang + arc);
    ctx.lineTo(rad, rad);
    ctx.fill();
    // TEXT
    ctx.translate(rad, rad);
    ctx.rotate(ang + arc / 2);
    ctx.textAlign = "right";
    ctx.fillStyle = "#fff";
    ctx.font = "bold 30px sans-serif";
    ctx.fillText(sector.label, rad - 10, 10);
    //
    ctx.restore();
}

function rotate() {
    const sector = sectors[getIndex()];
    ctx.canvas.style.transform = `rotate(${ang - PI / 2}rad)`;
    if (!angVel) {
        dataHandler.getRandomMovie(sector.id, showRandomMovie)
    }
    EL_spin.textContent = !angVel ? "SPIN" : sector.label;
    EL_spin.style.background = sector.color;
}

function frame() {
    if (!angVel) return;
    angVel *= friction; // Decrement velocity by friction
    if (angVel < 0.002) angVel = 0; // Bring to stop
    ang += angVel; // Update angle
    ang %= TAU; // Normalize angle
    rotate();
}

function engine() {
    frame();
    requestAnimationFrame(engine)
}

function showRandomMovie(response) {
    let closeButton = document.querySelector(".modal .close");
    closeButton.addEventListener("click", modal.closeModal);

    modal.showModal(response)
}


function uploadWheelWithCategoryNames(data) {
    for (let category of data) {
        let randColor = "#" + Math.floor(Math.random()*16777215).toString(16);
        let genre = {color: randColor, label: category.name, id: category.id}
        sectors.push(genre);
    }
    setAttributes();
    startEngine();
}


function setAttributes() {
    tot = sectors.length;
    arc = TAU / sectors.length;
}


function initWheelWithCategoryNames() {
    dataHandler.getCategoryNames(uploadWheelWithCategoryNames);
}


function startEngine() {
    sectors.forEach(drawSector);
    engine();       // Start engine
    EL_spin.addEventListener("click", () => {
        if (!angVel) angVel = rand(0.25, 0.35);
    });
}


initWheelWithCategoryNames();
