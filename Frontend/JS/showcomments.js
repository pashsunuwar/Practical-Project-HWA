let commentID = sessionStorage.getItem("commentID");

const commentsContainer = document.querySelector("#commentsContainer");
const showcommsURL = "http://localhost:8010/comment/showall";
function showall() {
  fetch(showcommsURL)
    .then((response) => {
      //200 status check
      if (response.status !== 200) {
        console.warn(
          "Looks like there was a problem. Status Code: " + response.status
        );
        return;
      }
      //Examine the text in the response
      response.json().then(function appendData(data) {
        console.log(data)
        for (let i = 0; i <= data.length; i++) {
          // console.log(data[i].commentID);
          commentsContainer.appendChild(mycommentRow(data[i]));
        }
      });
    })
    .catch(function (error) {
      console.log("Request failed", error);
    });
}

function mycommentRow(data) {
  let row = document.createElement("tr");
  // let rowTh = document.createElement("th");
  // rowTh.setAttribute("scope", "row");
  let commentIDTd = document.createElement("td");
  let nameTd = document.createElement("td");
  let reviewTd = document.createElement("td");
  let dateTd = document.createElement("td");
  let functionalityTd = document.createElement("td");
  let editbutton = document.createElement("button");
  let deletebutton = document.createElement("button");

  commentIDTd.innerHTML = data.commentID;
  nameTd.innerText = data.name;
  // rowTh.innerText = data.commentID
  reviewTd.innerText = data.review;
  dateTd.innerText = data.createdDate;

  deletebutton.classList = "btn btn-outline-danger";
  deletebutton.innerText = "Delete";

  deletebutton.setAttribute(
    "href",
    `http://localhost:8010/comment/delete/${data.commentID}`
  );
  deletebutton.addEventListener("click", (event) => {
    event.preventDefault();
    deleteData(deletebutton.getAttribute("href"));
    location.reload();
  });

  // editbutton.addEventListener("onClick", "updateCommentForm()");

  let down = document.getElementById("myeditbutton");
  function showForm() {
    let form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "#");
    form.setAttribute("id", "updateform");
    // form.setAttribute("href", `http://localhost:8010/comment/edit/${data.commentID}`);

// so here we will create the id text box ( non-edit)

    // let idForm = document.createElement("text")
    // idForm.commentIDTd;

    let reviewform = document.createElement("input");
    reviewform.setAttribute("type", "textarea");
    reviewform.setAttribute("name", "review_box2");
    reviewform.setAttribute("class", "updateCommentBox");
    reviewform.setAttribute("placeholder", "Update Comment");


    let s = document.createElement("button");
    s.setAttribute("type", "submit");
    s.setAttribute("id", "editfetch");
    s.setAttribute("value", "submit");
    s.classList = "btn btn-outline-primary";
    s.innerText = "Update";
    //   s.setAttribute("href", `http://localhost:8010/comment/edit/${data.commentID}`)

    // form.appendChild(idForm);
    form.appendChild(reviewform);
    form.appendChild(s);
    //   document.getElementsByTagName("body")[0].appendChild(form);
    let formdiv = document.getElementById("editForm");
    formdiv.appendChild(form);
    //   return form;
  }

  editbutton.classList = "btn btn-outline-warning";
  editbutton.innerText = "Edit";
  editbutton.setAttribute("id", "myeditbutton");
  //   editbutton.setAttribute("onClick", "showForm()");
  editbutton.addEventListener("click", (event) => {
    showForm();
    editData();
    // editData(id)
  });

  functionalityTd.appendChild(editbutton);
  functionalityTd.appendChild(deletebutton);

  row.appendChild(commentIDTd);
  row.appendChild(nameTd);
  row.appendChild(reviewTd);
  row.appendChild(dateTd);
  row.appendChild(functionalityTd);

  return row;
}

window.onload = () => {
  showall();

  deleteData = (showcommsURL) => {
    fetch(showcommsURL, {
      method: "DELETE",
    })
      .then((response) => {
        if (response.ok) {
          return response;
        }
        return Promise.reject({
          status: response.status,
          statusText: response.statusText,
        });
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(`Error: ${error.status}, ${error.statusText}`);
      });
  };

  editData = (showcommsURL) => {
    // showall();
    document
      .getElementById("updateform")
      .addEventListener("submit", function (event) {
        event.preventDefault();

        let data = {
          // commentID: 
          review: this.review_box2.value,
          // name: this.name_box.value,
        };
        console.log(data);
        fetch(`http://localhost:8010/comment/edit/${data.commentID}`, {
          method: "POST",
          headers: {
            "Content-type": " application/json;",
          },
          body: JSON.stringify(data),
        })
          .then((response) => response.json())
          .then(function (data) {
            console.log("Request succeeded with JSON response", data);
          })
          .catch(function (error) {
            console.log("Request failed", error);
          });
        
      });
  };
};
