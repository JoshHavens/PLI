/**
 * 
 */

var myFirebaseRef = new Firebase("https://pli-kley.firebaseio.com/Room1");
var User1;
var Selection1;
var User2;
var Selection2;

function setRoundStart() {
	myFirebaseRef.child('startRound').set('true');
}

function setEndRound() {
	myFirebaseRef.child('startRound').set(null);
}

function getUsers() {
	myFirebaseRef.once('value', function(snap) {
		var ss = snap.val();
		//return a JSObject
		var ex = JSON.stringify(ss);
		
		var users = JSON.parse(ex);
		console.log(users.Users["auhf"]);
		console.log(users);
		var name = users.Users[1].Name;
		console.log(name);
		var selection = users.Users[1].Selection;
		console.log(selection);
		User1 = users.Users[1].Name;
		Selection1 = users.Users[1].Selection;
		User2 = users.Users[2].Name;
		Selection2 = users.Users[2].Selection;
		console.log(User2);
		console.log(Selection2);
		
		console.log(ss);
		console.log(ex);
		console.log(users);
		return users;
		//return a JSON object
		//return JSON.stringify(ss);
	});
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
