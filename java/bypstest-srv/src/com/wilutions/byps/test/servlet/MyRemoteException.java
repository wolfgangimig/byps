package com.wilutions.byps.test.servlet;

import java.io.IOException;
import java.util.Arrays;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteException;
import com.wilutions.byps.test.api.remote.FirstException;
import com.wilutions.byps.test.api.remote.SecondException;

public class MyRemoteException extends BSkeleton_RemoteException {
	
	@Override
	public void throwBException(int code, String msg) throws BException,
			InterruptedException {
		throw new BException(code, msg, new IOException("Hello IOException"));
	}

	@Override
	public void throwFirstException() throws BException, InterruptedException,
			FirstException {
		throw new FirstException(Arrays.asList("string1", "string2"),
				new SecondException("illegal state thrown from MyRemoteException"));
	}

	@Override
	public void throwException(int what) throws BException,
			InterruptedException, FirstException, SecondException {
		if (what == 1) throw new FirstException();
		if (what == 2) throw new SecondException();
	}
	
	@Override
	public void throwNullPointerException() throws BException,
			InterruptedException {
		throw new NullPointerException();
	}
}
