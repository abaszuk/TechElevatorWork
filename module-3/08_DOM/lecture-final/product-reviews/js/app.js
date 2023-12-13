
function createNewBlock(color) {
  const body = document.querySelector("body");

  const newDiv = document.createElement("div");
  newDiv.classList.add("block");
  newDiv.style.backgroundColor = color;
  newDiv.innerText = color;

  body.appendChild(newDiv);
}



const bookName = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {

  const span = document.querySelector("#page-title .name");
  span.innerText = bookName;
}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  const desc = document.querySelector(".description")
  desc.innerText = description;
}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {

  const main = document.getElementById("main");

  reviews.forEach( (review) => {

        // let's first create the review container
        // any text we put in the createElement it will make
        // a set of tags for. So if I say document.createElement("something")
        // it will create <something></something>
        const reviewDiv = document.createElement("div");

        //The classList will be a collection of all the classes this 
        //element has, and we can add or remove to this collection
        reviewDiv.classList.add("review");
        //we can add multiple classes via classList.add
        //and can also remove classes with classList.remove

        //next create the h2 for the author name
        const h2 = document.createElement("h2");

        //If we want to manipulate the contents inside an html element
        //we can set the innerText.  Note: avoid using innerHtml
        h2.innerText = review.reviewer;

        //We are adding our new h2 element as a child element to the review div
        reviewDiv.appendChild(h2);

        //next create the rating div and the img inside
        const ratingDiv = document.createElement("div");

        //if we want to set an attribute inside the tag, we can specify 
        //the name value pair of the attribute, in this case we are setting
        //class="rating" ... ideally use classList because setAttribute
        //will keep overwriting itself
        ratingDiv.setAttribute("class", "rating");
        reviewDiv.appendChild(ratingDiv);

        //for as many stars as this was rated, make sure
        //to create an image tag for each one
        for(let i=0; i < review.rating; i++) {
          const ratingImg = document.createElement("img");
          ratingImg.src = "img/star.png";
          ratingImg.classList.add("ratingStar") ;
          ratingDiv.appendChild(ratingImg);   
        }

        const h3 = document.createElement("h3");
        h3.innerText = review.title;
        reviewDiv.appendChild(h3);

        const desc = document.createElement("p");
        desc.innerText = review.review;
        reviewDiv.appendChild(desc);

        main.appendChild(reviewDiv);
    }
  )


}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
