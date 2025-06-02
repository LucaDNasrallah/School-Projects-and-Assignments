let images = [
    "https://www.stockvault.net/data/2007/03/01/100210/thumb16.jpg",
    "https://www.stockvault.net/data/2010/10/17/115392/thumb16.jpg",
    "https://www.stockvault.net/data/2012/05/18/130998/thumb16.jpg",
    "https://www.stockvault.net/data/2011/08/21/126300/thumb16.jpg"
];
let currentIndex = 0;

function showImage() {
    document.getElementById("slide").src = images[currentIndex];
    changeDescription();  // Update description each time image changes
}

function nextSlide() {
    currentIndex = (currentIndex + 1) % images.length;
    showImage();
}

function prevSlide() {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showImage();
}

function changeDescription() {
    let name;
    let age;
    let breed;
    let description;
    
    switch(currentIndex) {
        case 0:
            name = "Rex";
            age = 5;
            breed = "Breed1";
            description = `This is ${name}, the happiest dog in the world.
            He loves to play and run around the park.
            He is very friendly and loves to meet new people.
            He is ${age} years old and is a ${breed}.`;
            break;
        case 1:
            name = "Bella";
            age = 3;
            breed = "Bengal Tiger";
            description = `Meet ${name}, a playful and energetic TIGER.
            She loves to run and fetch balls.
            At ${age} years old, she is a ${breed} and loves human company.`;
            break;
        case 2:
            name = "Max";
            age = 4;
            breed = "Breed3";
            description = `This is ${name}, a calm and loving dog.
            He enjoys long walks and quiet time with his family.
            He is ${age} years old and is a ${breed}.`;
            break;
        case 3:
            name = "Luna";
            age = 2;
            breed = "Norwegian Forest Cat";
            description = `Here is ${name}, a curious and the dumbbest cat.
            She loves exploring new places and playing with other dogs.
            She is ${age} years old and is a ${breed}.`;
            break;
    }
    
    // Update description in the HTML
    document.getElementById("description").innerHTML = description;
}

// Initialize the first image
window.onload = showImage;
