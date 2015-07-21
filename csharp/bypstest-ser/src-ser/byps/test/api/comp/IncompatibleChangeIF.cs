using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.comp
{
	
	/// <summary>
	/// This interface with incompatible changes.
	/// </summary>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface IncompatibleChangeIF : BRemote {
	
		/// <summary>
		/// Function with changed return type.
		/// </summary>
		/// <remarks>
		/// The return type was int in version 793. In 794 it has been changed to String.
		/// Calling this function must cause an exception.
		/// </remarks>
		int ChangedReturnType();
		void ChangedReturnType(BAsyncResult<int> asyncResult) ;
		/// <summary>
		/// Function with changed return type.
		/// </summary>
		/// <remarks>
		/// The return type was int in version 793. In 794 it has been changed to String.
		/// Calling this function must cause an exception.
		/// </remarks>
		Task<int> ChangedReturnTypeAsync();
		
		/// <summary>
		/// Function with changed parameter type.
		/// </summary>
		/// <remarks>
		/// The parameter type was int in version 793. In 794 it has been changed to String.
		/// Calling this function must cause an exception.
		/// </remarks>
		void ChangedParameterType(int intParamChangedToString);
		void ChangedParameterType(int intParamChangedToString, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Function with changed parameter type.
		/// </summary>
		/// <remarks>
		/// The parameter type was int in version 793. In 794 it has been changed to String.
		/// Calling this function must cause an exception.
		/// </remarks>
		Task ChangedParameterTypeAsync(int intParamChangedToString);
		
		/// <summary>
		/// Function with changed parameter class.
		/// </summary>
		/// <remarks>
		/// The class has been incompatibly changed in version 794.
		/// Calling this function must cause an exception.
		/// </remarks>
		void ChangedClass(IncompatibleChangeInfo param);
		void ChangedClass(IncompatibleChangeInfo param, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Function with changed parameter class.
		/// </summary>
		/// <remarks>
		/// The class has been incompatibly changed in version 794.
		/// Calling this function must cause an exception.
		/// </remarks>
		Task ChangedClassAsync(IncompatibleChangeInfo param);
		
		
	}
}  // end namespace
