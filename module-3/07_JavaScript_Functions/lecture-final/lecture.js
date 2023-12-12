/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 * @returns {number} the product of the multiplication
 */
function multiplyTogether(firstParameter, secondParameter){

  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 * @returns {number} the product of the multiplication
 */
  function multiplyNoUndefined(firstParameter=0, secondParameter=0) {
    return firstParameter * secondParameter;
  }

  /** What if we don't know how many parameters are being passed in? */
  function multiplyAll( ){

    if(!arguments.length){
      return 0;
    }


    //to reference all the parameters being passed into a function
    //we can use the arguments keyword

    let product = 1;
    for(let i = 0; i < arguments.length; i++){
      product *= arguments[i];
    }

    return product;
  }

  function multiplyAllSpread( ...params) {
     //... is the spread operator and it will essentially unpack an object for us
     // ultimately params is going to look similar to the arguments keyword in the 
     // last function
     let product = 1;
    
     for(let i = 0; i < params.length; i++){
       product *= params[i];
     }
 
     return product;

  }

  function multiplyAllSpreadParams(){
    
    //We can also convert the arguments using the ... operator to unpack our arguments object
    // so that it's just a simple array
    let myParams = [...arguments];
    let product = 1;
    for(let i = 0; i < myParams.length; i++){
      product *= myParams[i];
    }

    return product;

  }


 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 * @returns {number} the result of the chosen arithmetic operation
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {

 //let description = name + "is currently " + age + " years old. Their quirks are" + 

  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/************
 * 
 * Array Functions
 * 
 *************/



//This is an example of a named function. The name being "isEven"
function isEven(num) {
  return ( num % 2 ) == 0;
}

//To convert it to an anonymous function remove the function declaration, the name
// of the function, and then add an arrow between the parameters and the code block
(num) => {
  return ( num % 2 ) == 0;
}

//I want to return only even numbers from the myArray variable
function filterEvens(){

    let myArray = [1,2,3,4,5,6,100, 200, 201];

    //In javascript there are some pre-built functions
    //specific to arrays. One of them is filter. The idea 
    //here is that it understands the idea of filtering but
    //we have to pass it instructions for how to filter

    //return myArray.filter(isEven);

    //if I don't feel it's necessary to create an entire named function
    //for something I'm only going to use here, then I can utilize anonymous functions

    return myArray.filter((num) => {
      return ( num % 2 ) == 0;
    });

    /*
    let evensOnly = [];
    for(let num of myArray){
      if(isEven(num)) {
        evensOnly.push(num);
      }
    }

    return evensOnly;
    */
}

//Another array function is .map()  and this is going to transform each value
//in the array into another value 
function mapExample(){

  let myNums = [1,2,3,4,5];

  //let's say that I want to transform each value so that it is
  //double its original value

  return myNums.map((val) => {
    return val * 2;
  });

  //old way
  /*
  let doubleVals = [];
  for(num of myNums){
    doubleVals.push(2 * num);
  };
  return doubleVals;
  */
}

function mapExample2(){

  let nasaData = [
    {
        copyright: "José Rodrigues",
        date: "2023-12-01",
        explanation: "The core of the Milky Way is rising beyond the Chilean mountain-top La Silla Observatory in this deep night skyscape. Seen toward the constellation Sagittarius, our home galaxy's center is flanked on the left, by the European Southern Observatory's New Technology Telescope which pioneered the use of active optics to accurately control the shape of large telescope mirrors. To the right stands the ESO 3.6-meter Telescope, home of the exoplanet hunting HARPS and NIRPS spectrographs. Between them, the galaxy's central bulge is filled with obscuring clouds of interstellar dust, bright stars, clusters, and nebulae. Prominent reddish hydrogen emission from the star-forming Lagoon Nebula, M8, is near center. The Trifid Nebula, M20, combines blue light of a dusty reflection nebula with reddish emission just left of the cosmic Lagoon. Both are popular stops on telescopic tours of the galactic center. The composited image is a stack of separate exposures for ground and sky made in April 2023, all captured consecutively with the same framing and camera equipment.",
        hdurl: "https://apod.nasa.gov/apod/image/2312/_MG_2485-mod_APOD.jpg",
        media_type: "image",
        service_version: "v1",
        title: "Milky Way Rising",
        url: "https://apod.nasa.gov/apod/image/2312/_MG_2485-mod_APOD1024.jpg"
    },
    {
        copyright: "Jeff Dai",
        date: "2023-12-02",
        explanation: "You can take a subway ride to visit this observatory in Beijing, China but you won't find any telescopes there. Starting in the 1400s astronomers erected devices at the Beijing Ancient Observatory site to enable them to accurately measure and track the positions of naked-eye stars and planets. Some of the large, ornate astronomical instruments are still standing. You can even see stars from the star observation platform today, but now only the very brightest celestial beacons are visible against the city lights. In this time series of exposures from a camera fixed to a tripod to record graceful arcing startrails, the brightest trail is actually the Moon. Its broad arc is seen behind the ancient observatory's brass armillary sphere. Compare this picture from the Beijing Ancient Observatory taken in September 2023 to one taken in 1895.",
        hdurl: "https://apod.nasa.gov/apod/image/2312/StartrailsBeijingAncientObservatory-3.jpg",
        media_type: "image",
        service_version: "v1",
        title: "Startrails over Beijing Ancient Observatory",
        url: "https://apod.nasa.gov/apod/image/2312/StartrailsBeijingAncientObservatory-3_1024.jpg"
    },
    {
        copyright: "El Cielo de Canarias",
        date: "2023-12-03",
        explanation: "These people are not in danger. What is coming down from the left is just the Moon, far in the distance. Luna appears so large here because she is being photographed through a telescopic lens.  What is moving is mostly the Earth, whose spin causes the Moon to slowly disappear behind Mount Teide, a volcano in the Canary Islands off the northwest coast of Africa. The people pictured are 16 kilometers away and  many are facing the camera because they are watching the Sun rise behind the photographer. It is not a coincidence that a full moon rises just when the Sun sets because the Sun is always on the opposite side of the sky from a full moon. The featured video was made in 2018 during the full Milk Moon.  The video is not time-lapse -- this was really how fast the Moon was setting.",
        media_type: "video",
        service_version: "v1",
        title: "Moon Setting Behind Teide Volcano",
        url: "https://www.youtube.com/embed/afHfMMC-MJE?rel=0"
    }];

    return nasaData.map( (picOfDay) => {
      return {
        photographer: picOfDay.copyright,
        date: picOfDay.date,
        description: picOfDay.explanation,
        location: picOfDay.url
      }
    })

}

function forEachExample(){

  let names = ["Bob", "Jane", "Tim"];

  names.forEach( (name) => {
    console.log("Hello " + name + "!");
  })

  /*
  for(let name of names){
    console.log("Hello " + name + "!");
  }
  */

}

function findExample() {

  let picsOfDay = mapExample2();

  //keep in mind find will return the first element that is true
  //so if there are other pics by Jeff Dai I will only find the first one
  return picsOfDay.find( (pic) => {
    return pic.photographer == "Jeff Dai";
  });

  /*
  for(let pic of picsOfDay){

    if(pic.photographer == "Jeff Dai"){
      return pic;
    }

  }
  */
}



/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  //reduce takes an array and reduces it to a single value
  return numbersToSum.reduce( (previousVal, currentVal) => {
    return previousVal + currentVal;
  }, 0); //if we want to indicate an initial value, we can include it as a second 
        //parameter right after our anonymous function

        /*
  let sum = 0;
  for(let num of numbersToSum){
    sum += num;
  }

  return sum;
  */
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {}
