// Initialize Firebase
var config = {
    apiKey: "",
    authDomain: "jphack-21831.firebaseapp.com",
    databaseURL: "https://jphack-21831.firebaseio.com",
    projectId: "jphack-21831",
    storageBucket: "jphack-21831.appspot.com",
    messagingSenderId: "893931299090"
  };

const db = firebase.firestore();
// Require firestore
const firebase = require("firebase");
// Required for side-effects
require("firebase/firestore");


// Initialize Google firestore
firebase.initializeApp({
  apiKey: '',
  authDomain: 'jphack-21831.firebaseapp.com',
  projectId: 'jphack-21831'
});

const docRef = db.collection("users").doc("VTpqXygWydQfF3lswb98")
const docLocRef = db.collection("location").doc("eIJ7iOOsyBeLwvST3QP2b98")

loadButton.addEventListener("click", function(){
  docRef.get().then(function (doc) {
    if (doc && doc.exists) {
      const myData = doc.data();
    }
  }).catch(function (error) {
    console.log("Got an error: ", error);
  })
});
// Initialize Cloud Firestore through Firebase

// Disable deprecated features
db.settings({
  timestampsInSnapshots: true
});

firebase.initializeApp(config);
