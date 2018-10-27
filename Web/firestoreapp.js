var config = {
  apiKey: "",
  authDomain: "jphack-21831.firebaseapp.com",
  databaseURL: "https://jphack-21831.firebaseio.com",
  projectId: "jphack-21831",
  storageBucket: "jphack-21831.appspot.com",
  messagingSenderId: "893931299090"
};
firebase.initializeApp(config);
// initializeApp command


var firestore = firebase.firestore();

const docRef = firestore.collection("users").doc("VTpqXygWydQfF3lswb98");

// Event listener to get DB data
var Retrieve = document.getElementById("Retrieve")
Retrieve.addEventListener("click", function() {
  docRef.get().then(function (doc) {
    if (doc && doc.exists) {
      const myData = doc.data();
         }
      }).catch(function (error) {
     console.log("Got an error: ", error);
    // })
  })
})
var dataDisplay = document.getElementById("data")
//dataDisplay.innerHTML =
