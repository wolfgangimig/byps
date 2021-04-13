const http = require('http');
const formData = require('form-data');
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
	const boundary = '60b6f822-86b9-476f-b0c4-66b6ae6f5f69';
	if (isFormData) {
		contentType = 'multipart/form-data; boundary=' + boundary;
	}

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
    
	if (isFormData) {

		var formField = "--" + boundary + "\r\n";
		formField += "content-disposition: form-data; name=\"data\"; \r\n";
		formField += "content-type: application/json \r\n";
		formField += "\r\n" + data.data + "\r\n";
		req.write(Buffer.from(formField, "utf-8"));

		var files = data.file != null && !Array.isArray(data.file) ? [data.file] : data.file;
		if (files) for (var i = 0; i < files.length; i++) {
			const fileName = "file[" + i + "]";
			formField = "--" + boundary + "\r\n";
			formField += "content-disposition: form-data; name=\"" + fileName + "\"; filename=\"" + fileName + "\"; \r\n";
			formField += "content-type: application/octet-stream \r\n";
			formField += "\r\n";
			req.write(Buffer.from(formField, "utf-8"));
			
			var file = files[i];
			if (Buffer.isBuffer(file)) {
				req.write(file);
			}
			else {
				// Funktioniert nicht!
				file.pipe(req, { end: true });
			}
		} 

		req.write(Buffer.from("\r\n--" + boundary + "--\r\n", "utf8"));
		req.end();
	}
	else {
		req.write(data);
		req.end();
	}

    //req.end();
  });
  
};

const restcall = function(path, obj, streams) {

	const contentType = streams ? 'multipart/form-data' : 'application/json';
	const jsObj = JSON.stringify(obj);
	const data = streams ? { data: jsObj, file : streams } : jsObj;

	return post(path, data, contentType)
		.then(rdata => {
	    	const obj = JSON.parse(rdata);
			if (obj.exception) throw obj.exception;
			return obj.result;
		});
}

const upload = function(fileName, contentType) {
	const buffer = fs.readFileSync(fileName);
	return post("putstream", buffer, contentType);
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

	const stream = await fs.createReadStream("testfile.txt");
	//const stream = Buffer.from('abcde');
	const putResult = await putSharedStream(123, "file[0]", [stream]);
  
	// const streamId = await upload("testfile.txt", "plain/text"); 
	// console.log('streamId=' + streamId);

	// const putResult = await putSharedStream(123, streamId);
	// console.log('putSharedStream=' + JSON.stringify(putResult));
	
	const getResult = await getSharedStream(123);
	console.log('getSharedStream=' + JSON.stringify(getResult));
  
  	const fileName = await download(getResult.url, "testfile-out.txt");
  	console.log('download=' + fileName);
  
})();


