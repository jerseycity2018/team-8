// Initialize Firebase
  var config = {
    apiKey: "AIzaSyDkyx0sStSDqd_wj_IbsGGNMiDZbSg18GY",
    authDomain: "jphack-21831.firebaseapp.com",
    databaseURL: "https://jphack-21831.firebaseio.com",
    projectId: "jphack-21831",
    storageBucket: "jphack-21831.appspot.com",
    messagingSenderId: "893931299090"
  };
  firebase.initializeApp(config);

const db = firebase.firestore();
// Require firestore
const firebase = require("firebase");
// Required for side-effects
require("firebase/firestore");


// Initialize Google fireStore
firebase.initializeApp({
  apiKey: 'AIzaSyDkyx0sStSDqd_wj_IbsGGNMiDZbSg18GY',
  authDomain: 'jphack-21831.firebaseapp.com',
  projectId: 'jphack-21831'
});

// Initialize Cloud Firestore through Firebase


// Disable deprecated features
db.settings({
  timestampsInSnapshots: true
});
