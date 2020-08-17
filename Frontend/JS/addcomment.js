//add comments 

//button functionality
function manage(completeform) {
  let bt = document.getElementById('btSubmit');
 if (completeform.value == '' ){
     bt.disabled = true;
 }
 else { 
     bt.disabled = false;
 }
 }
document
  .getElementById("commentForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();
  
    const data = {
      "review": this.review_box.value
    }

    document.querySelector('form').reset();

    fetch("http://localhost:8010/comment/new", {
      method: "POST",
      headers: {
        "Content-type": " application/json;",
      },
      body: JSON.stringify(data),
    })
      .then(response => response.json())
      .then(function (data) {
        console.log("Request succeeded with JSON response", data);
      })
      .catch(function (error) {
        console.log("Request failed", error);
      });
    location.reload();
  });

