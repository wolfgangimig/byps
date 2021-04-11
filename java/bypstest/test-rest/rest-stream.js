const http = require('http');
const fs = require('fs');

const basePath = '/bypstest-srv/bypsservlet/rest/';

var options = {
  host : 'localhost',
  port : 6080,
  method: 'POST',
  headers : {
    'content-type': 'application/json',
    'cookie': 'JSESSIONID=',
  },
};

const clientInfo = {
  language: 'de',
  country: 'DE',
  timeZone: 'UTC',
  ticket: 'de.elo.ix.client.ticket_from_cookie'
};

var CONST = {};

const post = function(path, data, contentType) {

  return new Promise((resolve, reject) => {
    
    const request = Object.assign({}, options);
    request.path = basePath + path;
    request.headers['content-type'] = contentType || 'application/json';
    
    const req = http.request(request, res => {
      let rdata = '';
    
      res.on('data', chunk => {
      	rdata += chunk;
      });
      
      res.on('end', () => {
      
      	if (res.statusCode == 200) {
      
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
	
	          resolve(rdata);
	        }
	        catch (ex) {
	          reject(ex);
	        }
	    }
	    else {
	    	reject(new Error('HTTP ' + res.statusCode));
	    }
      });
    });
    
    req.on('error', ex => {
      reject(ex);
    });
    
    req.write(data);
    req.end();
  });
  
};

const restcall = function(path, obj) {

	return post(path, JSON.stringify(obj))
		.then(rdata => {
	    	const obj = JSON.parse(rdata);
			if (obj.exception) throw obj.exception;
			return obj;
		});
}

const upload = function(fileName, contentType) {
	const buffer = fs.readFileSync(fileName);
	return post("putstream", buffer, contentType);
}

const download = function(streamId, fileName) {
	const 
}


const putSharedStream = function(id, streamId) {

	const data = {
	  id : id,
	  stream : {
	    file : streamId
	  }
	};
	
	return restcall('RemoteStreams/putSharedStream', data); 
};

(async () => {
  
	const streamId = await upload("testfile.txt", "plain/text"); 
	console.log('streamId=' + streamId);

	const putResult = await putSharedStream(123, streamId);
	console.log('putSharedStream=' + putResult);
	
  
})();


