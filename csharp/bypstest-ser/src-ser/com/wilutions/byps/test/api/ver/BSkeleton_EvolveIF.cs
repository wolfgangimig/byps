﻿using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface EvolveIF.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_EvolveIF : BSkeleton, EvolveIF {	
		
		public readonly static long serialVersionUID = 2078696281L;
		
		public virtual void SetEvolve(Evolve obj) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetEvolveAsync(Evolve obj, BAsyncResult<Object> asyncResult) {
			try {
				SetEvolve(obj);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetEvolve(Evolve obj, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetEvolve(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual Evolve GetEvolve() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetEvolveAsync(BAsyncResult<Evolve> asyncResult) {
			try {
				Evolve ret = GetEvolve();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetEvolve(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Evolve EndGetEvolve(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetClient(EvolveIF partner) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetClientAsync(EvolveIF partner, BAsyncResult<Object> asyncResult) {
			try {
				SetClient(partner);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetClient(EvolveIF partner, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual EvolveIF GetClient() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetClientAsync(BAsyncResult<EvolveIF> asyncResult) {
			try {
				EvolveIF ret = GetClient();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetClient(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public EvolveIF EndGetClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SendEvolveToClient() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SendEvolveToClientAsync(BAsyncResult<Object> asyncResult) {
			try {
				SendEvolveToClient();
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendEvolveToClient(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSendEvolveToClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
