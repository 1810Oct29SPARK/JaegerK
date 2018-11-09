

let getUniversityWithPromise = function(){
    fetch('https://opentdb.com/api.php?amount=10')
    .then(r => r.json())
    .then(response => {
        let myArray=[];
        for(i=0;i<10;i++){
            const resultQuestion = document.getElementById(i);
            // resultQuestion.innerText = response.results[i].question;
            myArray.push(response.results[i].question);
            // console.log(response.results[i].question)
        }
        var ul = document.createElement("ul");
        document.getElementById("myList").appendChild(ul);

        for (i=0;i<myArray.length;i++) {
            var li = document.createElement("li");
            ul.appendChild(li);
            li.innerText = myArray[i];
        }


      console.log(response.results);
      console.log(myArray)
    });
}

window.onload(getUniversityWithPromise());

