const http = require('http');
const FormData = require('form-data');
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

	const isFormData = contentType && contentType == 'multipart/form-data';
	
    const request = Object.assign({}, options);
    request.path = basePath + path;
    request.headers['content-type'] = contentType || 'application/json';
	if (isFormData) {
		Object.assign(request.headers, data.getHeaders());
	}

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
    
	if (isFormData) {
		data.pipe(req);
	}
	else {
		req.write(data);
		req.end();
	}
  });
  
};

const restcall = function(path, obj, streams) {

	const contentType = streams ? 'multipart/form-data' : 'application/json';
	const jsObj = JSON.stringify(obj);
	
	var data = null;
	
	if (streams) {
		data = new FormData();
		data.append('data', jsObj);
		if (Array.isArray(streams)) {
			for (var i = 0; i < streams.length; i++) {
				data.append('file[' + i + ']', streams[i], 'file.dat');
			}	
		}
		else {
			data.append('file', streams, 'file.dat');
		}
	}
	else {
		data = jsObj;
	}

	return post(path, data, contentType)
		.then(rdata => {
	    	const obj = JSON.parse(rdata);
			if (obj.exception) throw obj.exception;
			return obj.result;
		});
}

const upload = function(fileName, contentType) {
	const buffer = fs.readFileSync(fileName);
	return post("putstream", buffer, contentType || 'application/octet-stream');
}

const download = function(path, fileName) {

	return new Promise((resolve, reject) => {

	    const request = Object.assign({}, options);
	    request.path = basePath + path;
	    request.method = "GET";
    
    	const req = http.request(request, res => {

    		if (res.statusCode == 200) {
	    		try { 
	    			const file = fs.createWriteStream(fileName);
	    			res.pipe(file);
	    			file.on('finish', function() {
	    			  resolve(fileName);
	    			});
	    		}
	    		catch (ex) {
	    			reject(ex);
	    		}
	    	}
	    	else {
	    		reject(new Error('HTTP ' + res.statusCode));
	    	}	
    	});
    	
	    req.on('error', ex => {
	      reject(ex);
	    });
	    
	    req.end();
    });
};


const putSharedStream = function(id, streamId, streams) {

	const data = {
	  id : id,
	  stream : {
	    file : streamId
	  }
	};
	
	return restcall('RemoteStreams/putSharedStream', data, streams); 
};

const getSharedStream = function(id) {
	
	const data = {
		id : id
	};

	return restcall('RemoteStreams/getSharedStream', data);
};


(async () => {

	var useFormData = true;

	if (useFormData) {
		const stream = await fs.createReadStream("testfile.txt");
		await putSharedStream(123, "file", stream);
	}
	else {
		const streamId = await upload("testfile.txt", "plain/text"); 
		await putSharedStream(123, streamId);
	}

	const getResult = await getSharedStream(123);
	console.log('getSharedStream=' + JSON.stringify(getResult));
  
  	const fileName = await download(getResult.url, "testfile-out.txt");
  	console.log('download=' + fileName);
  
})();


