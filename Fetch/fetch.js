let state = {
    joke: ''
};

const apiUrl = 'https://icanhazdadjoke.cm/';

//long form of
//function getJokeWithFetch(){...}

let getJokeWithFetch = function() {
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json();
    })
        //utilize unwrapped promise a javascript object
    .then((data) => {
        console.log(data);
        state.joke = data.joke;
        updateContent();
    })
        //what if there's a problem?
    .catch( (error) => {
        alert('oh no :(');
        console.log(error);
    });
}

let updateContent = function() {
    console.log(state);
    //select joke 
    const jokeElement = document.getElementById('joke-field');
    jokeElement.innerText = state.joke;
}

document.getElementById('new-joke-button').addEventListener('click',getJokeWithFetch);