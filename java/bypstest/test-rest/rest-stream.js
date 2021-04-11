const http = require('http');

const basePath = '/ix-elo210/byps/rest/IXServicePortIF/';
const loginUser = 'Administrator';
const loginPwd = 'elo';

var options = {
  host : 'localhost',
  port : 8084,
  method: 'POST',
  headers : {
    'content-type': 'application/json',
    'cookie': 'JSESSIONID=',
    'elo-approved': ''
  },
};

const clientInfo = {
  language: 'de',
  country: 'DE',
  timeZone: 'UTC',
  ticket: 'de.elo.ix.client.ticket_from_cookie'
};

var CONST = {};

const post = function(path, data) {

  return new Promise((resolve, reject) => {
    
    options.path = basePath + path;
    
    const req = http.request(options, res => {
      let rdata = '';
    
      res.on('data', chunk => {
      	rdata += chunk;
      });
      
      res.on('end', () => {
        try {

          const setcookies = res.headers['set-cookie'];
          if (setcookies) {
            setcookies.forEach(c => {
              if (c.startsWith('JSESSIONID')) {
                const jsessionid = c.split(";")[0].trim();
                options.headers['cookie'] = jsessionid;
              }
            });
          }

          const eloapproved = res.headers['elo-approved'];
          if (eloapproved) {
         	 options.headers['elo-approved'] = eloapproved;
          }
          	
          const obj = JSON.parse(rdata);
          if (obj.exception) throw obj.exception;
          resolve(obj.result);
        }
        catch (ex) {
          reject(ex);
        }
      });
    });
    
    req.on('error', ex => {
      reject(ex);
    });
    
    req.write(JSON.stringify(data));
    req.end();
  });
  
};

const login = function(loginUser, loginPwd) {

	const loginData = {
	  ci: clientInfo,
	  userName: loginUser,
	  userPwd: loginPwd,
	  computerName: 'Node REST Client',
	  runAs: ''
	}
	
	return post('login', loginData); 
};

const getConstants = function() {
	
	const getConstantsData = {
	  ci: clientInfo
	};
	
	return post('getConstants', getConstantsData);
};

const createDoc = function(parentId) {

	const createDocData = {
	  ci: clientInfo,
	  parentId: parentId,
	  maskId: "",
	  editInfoZ: CONST.EDIT_INFO.mbSordDocAtt
	};

	return post('createDoc', createDocData);
};



(async () => {
  
	const loginResult = await login(loginUser, loginPwd); 
	console.log('ticket=' + loginResult.clientInfo.ticket);

    CONST = await getConstants();	
	console.log('const.EDIT_INFO.mbAll=', JSON.stringify(CONST.EDIT_INFO.mbAll));
	
  	const ed = await createDoc(1);
	console.log('ed=', JSON.stringify(ed));
	
	
  
})();


