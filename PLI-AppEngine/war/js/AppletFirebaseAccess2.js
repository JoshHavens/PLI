/**
 * 
 */

var myFirebaseRef = new Firebase("https://pli-kley.firebaseio.com/Room2");
var User1;
var Selection1;
var User2;
var Selection2;
var userArray = new Array();
var selections;

function setRoundStart() {
	myFirebaseRef.child('startRound').set('true');
}

function setEndRound() {
	myFirebaseRef.child('startRound').set(null);
}

myFirebaseRef.on('value', function(dataSnapshot){
	var ss = dataSnapshot.val();
	selections = JSON.stringify(ss.Users);
	var stringJSON = JSON.stringify(ss);
	var parsedJSON = JSON.parse(stringJSON);
	var users = parsedJSON.Users;	
	for(var key in users){
		if(users.hasOwnProperty(key)){
			userArray.push(key);
		}
	}
	User1 = userArray[0];
	User2 = userArray[1];
	
	
});

myFirebaseRef.on('child_removed', function(oldChildSnapshot){
	var ss = oldChildSnapshot.val();

	
});

myFirebaseRef.on('child_added', function(childSnapshot, prevChildName){
	var ss = childSnapshot.val();
});




function getUsers() {
	myFirebaseRef.once('value', function(snap) {
		var ss = snap.val();
		var stringJSON = JSON.stringify(ss);
		var parsedJSON = JSON.parse(stringJSON);

		/**
		 * This code parses the JSON file and finds the name
		 * of all users and puts them into the userArray array
		 * 
		 */
		var users = parsedJSON.Users;	
		for(var key in users){
			if(users.hasOwnProperty(key)){
				userArray.push(key);
			}
		}
		
		for (i=0;i<userArray.length;i++)
		{
		//console.log(userArray[i]);
		}
		User1 = userArray[0];
		User2 = userArray[1];
		
		
		selections = JSON.stringify(ss.Users);
		
		
		/**
		 * Hard coded way to get user and selections
		 */
		/*
		 User1 = users.Users[1].Name; // User 1: Wally
		 Selection1 = users.Users[1].Selection; // Selection1: Paper
		 User2 = users.Users[2].Name; // User 2: Josh
		 Selection2 = users.Users[2].Selection; // Selection2: Rock
		*/
		return users;
	});
}


/**
 * Returns the array consistinig of all of the users
 * @returns {Array}
 */
function getUserArray(){
	return userArray;
}

function getSelections(){
	return selections;
}

function getUser1() {
	return User1;
}

function getSelection1() {
	return Selection1;
}

function getUser2() {
	return User2;
}

function getSelection2() {
	return Selection2;
}

function hello() {
	console.log("hello");
	return "hello";
}

function tossAlert(s){
	alert(s);
}

var debug = 0;
if (debug == 1) {
	myFirebaseRef.child('Users').child('1').child('devID').set(12345);

	myFirebaseRef.child('Users').child('2').child('devID').set(24680);

	myFirebaseRef.child('Users').child('3').child('devID').set(12486);

	myFirebaseRef.child('Users').child('1').child('devID').set(null);

	//the following is a listener that activates function(snapshot)
	//whenever anything in the room changes
	myFirebaseRef.on("value", function(snapshot) {
			//alert(snapshot.val());
			console.log('printing snapshot');
			console.log(snapshot.val());
		}, function(errorObject) {
			console.log("The read failed: " + errorObject.code);
	});
	
	x = getUsers();
	console.log('printing getUsers()');
	console.log(x);
}
