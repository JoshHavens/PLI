/**
 * 
 */

var myFirebaseRef = new Firebase("https://pli-kley.firebaseio.com/Room1");

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
		return ss;
		//return a JSON object
		//return JSON.stringify(ss);
	});
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
