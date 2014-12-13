/**
 * 
 */

var myFirebaseRef = new Firebase("https://pli-kley.firebaseio.com/Room1");
var Selection1;
var Selection2;
var userArray = new Array();
var selections;
var stringSelections;

function setRoundStart() {
    myFirebaseRef.update({"startRound":"true"});
}

function setEndRound() {
    myFirebaseRef.child('startRound').set(null);
}

myFirebaseRef.on('value', function(dataSnapshot) {
    var ss = dataSnapshot.val();
    selections = JSON.stringify(ss.Users);
    
    var stringJSON = JSON.stringify(ss);
    stringSelections = stringJSON;
    var parsedJSON = JSON.parse(stringJSON);
    
    var users = parsedJSON.Users;
    for ( var key in users) {
        if (users.hasOwnProperty(key)) {
            userArray.push(key);
        }
    }
});

myFirebaseRef.child('Users').on('child_removed', function(oldChildSnapshot) {
    var ss = oldChildSnapshot.val();
    // alert("child removed!");
});

myFirebaseRef.child('Users').on('child_added',
        function(childSnapshot, prevChildName) {
            var ss = childSnapshot.val();
            // alert("child added!");
        });

function getUsers() {
    myFirebaseRef.once('value', function(snap) {
        var ss = snap.val();
        console.log(ss);
        
        
        var stringJSON = JSON.stringify(ss);
        stringSelections = stringJSON;
        
        var parsedJSON = JSON.parse(stringJSON);
       
        /**
         * This code parses the JSON file and finds the name of all users and
         * puts them into the userArray array
         * 
         */
        
        var users = parsedJSON.Users;
        
        for ( var key in users) {
            if (users.hasOwnProperty(key)) {
                userArray.push(key);
                console.log(key);
                //console.log(userArray[userArray.length - 1].child('Name'));
            }
        }

        for (i = 0; i < userArray.length; i++) {
            // console.log(userArray[i]);
        }
        //selections = JSON.stringify(ss.Users);
        
        return users;
    });
}

/**
 * Returns the array consistinig of all of the users
 * 
 * @returns {Array}
 */
function getUserArray() {
    return userArray;
}

function getStringSelections() {
    return stringSelections;
}

function getSelections() {
    return selections;
}

function getUser(i){
    return userArray[i];
}

function getUser1() {
    return getUser(0);
}

function getSelection1() {
    return getUser(1);
}

function getUser2() {
    return userArray[1];
}

function getSelection2() {
    return Selection2;
}

function hello() {
    console.log("hello");
    return "hello";
}

function tossAlert(s) {
    alert(s);
}

var debug = 0;
if (debug == 1) {
    myFirebaseRef.child('Users').child('1').child('devID').set(12345);

    myFirebaseRef.child('Users').child('2').child('devID').set(24680);

    myFirebaseRef.child('Users').child('3').child('devID').set(12486);

    myFirebaseRef.child('Users').child('1').child('devID').set(null);

    // the following is a listener that activates function(snapshot)
    // whenever anything in the room changes
    myFirebaseRef.on("value", function(snapshot) {
        // alert(snapshot.val());
        console.log('printing snapshot');
        console.log(snapshot.val());
    }, function(errorObject) {
        console.log("The read failed: " + errorObject.code);
    });

    x = getUsers();
    console.log('printing getUsers()');
    console.log(x);
}
