let clearbtn;
let strokeSize = 10;

let onColor = '#abafae';
let offColor = '#dae2df';

let parentDiv = "drawDiv";

function setup() {
  
  var canvasDiv = document.getElementById('drawDiv');
  var width = canvasDiv.offsetWidth;


  var myCanvas = createCanvas(width,512);
  myCanvas.parent(parentDiv);
  background(200);

}

function draw() {
  if (mouseIsPressed){
    strokeWeight(strokeSize);
    line(mouseX,mouseY,pmouseX,pmouseY);
   }
}

function clearAllColor(){
  strokeBlue.style('background-color', offColor);
  strokeRed.style('background-color', offColor);
  strokeGreen.style('background-color', offColor);
  strokeBlack.style('background-color', offColor);
	strokeWhite.style('background-color', offColor);
}

function changeColor(element){
	element.style('background-color', onColor);
}

function increaseSize(){
  strokeSize +=1;
}

function decreaseSize(){
  strokeSize -=1;
  if(strokeSize <= 0){
     strokeSize = 1;      
     }
}


function clearDrawing (){
  background(200);
}

function changeColor(){
  let colorInput = document.querySelector('#color');
  let color = colorInput.value;
  console.log(color);
  stroke(color);

}