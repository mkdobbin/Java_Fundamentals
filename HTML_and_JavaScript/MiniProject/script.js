var image = null;

function loadFile(){
  var imgFile = document.getElementById("file");
  image = new SimpleImage(imgFile);
  var canvas = document.getElementById("can");
  image.drawTo(canvas);
}

function makeGray(){
  if (image == null || ! image.complete()){
    alert("Unfiltered image not loaded");
    return;
  }
  
  var imageGray = new SimpleImage(image);
  for (var pixel of imageGray.values()){
    var red = pixel.getRed();
    var blue = pixel.getBlue();
    var green = pixel.getGreen();
    var avg = (red + blue + green)/3;
    pixel.setRed(avg);
    pixel.setBlue(avg);
    pixel.setGreen(avg);
  }
  
  var canvasGray = document.getElementById("canGray");
  imageGray.drawTo(canvasGray);
  
}


function makeStripe(){
  if (image == null || ! image.complete()){
    alert("Unfiltered image not loaded");
    return;
  }
  
  var imageStripe = new SimpleImage(image);
  var width = imageStripe.getWidth();
  
  for (var pixel of imageStripe.values()){
    if (pixel.getX() < width/3) {
      pixel.setRed(255);
    }
    else if (pixel.getX() > 2*width/3) {
        pixel.setBlue(255);
      }
    else {
      pixel.setGreen(255);
      }
    }
  
  
  var canvasStripe = document.getElementById("canStripe");
  imageStripe.drawTo(canvasStripe);  
}

function clearCanvas(){
  var clear = document.getElementById("can");
  var ctx = clear.getContext("2d");
  ctx.clearRect(0, 0, clear1.width, clear.height);
  
  var clear2 = document.getElementById("cangray");
  var ctx2 = clear2.getContext("2d");
  ctx2.clearRect(0, 0, clear2.width, clear2.height);
}