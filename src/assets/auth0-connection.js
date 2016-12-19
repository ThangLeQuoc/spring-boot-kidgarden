function login(username, password, callback) {
  var connection = mysql({
    host: '0.tcp.ngrok.io',
    port: '18795',
    user: 'root',
    password: 'root',
    database: 'kidgarden'
  });

  connection.connect();

  var query = "SELECT * FROM useraccount WHERE username = ?";

  connection.query(query, [username], function (err, results) {
    if (err) return callback(err);
    if (results.length === 0) return callback(new WrongUsernameOrPasswordError(username));
    var user = results[0];

    bcrypt.compare(password, user.password, function (err, isValid) {
      if (err) {
        callback(err);
      } else if (!isValid) {
        callback(new WrongUsernameOrPasswordError(username));
      } else {
        callback(null, {
          username: user.username,
          name: user.name,
          googlegmailinfo: user.googlegmailinfo,
          twitterinfo: user.twitterinfo,
          phonenumber: user.phonenumber
        });
      }
    });

  });
}


//=====================================================================================//
// Get user account
function getByEmail (email, callback) {
  var connection = mysql({
    host: '0.tcp.ngrok.io',
    port: '18795',
    user: 'root',
    password: 'root',
    database: 'kidgarden'
  });
  connection.connect();
  
  //check if email exist
  var query = "SELECT * FROM useraccount WHERE googlegmailinfo = ?";

  connection.query(query, [email], function (err, results) {
    if (err) return callback(err);
    // not found
    if (results.length === 0) return callback();
    
    var profile = results[0];
    callback(null,profile);
  });
}


  
