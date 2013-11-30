/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace byps
{
    public class BAsyncProgModel<T> : IAsyncResult, BAsyncResultIF<T>
    {
        private readonly object _state;
        private readonly AsyncCallback _callback;
        private T _result;
        private Exception _ex;
        private EventWaitHandle _waitHandle;
        private bool _completed;

        public BAsyncProgModel(AsyncCallback callback, object state)
        {
            this._state = state;
            this._callback = callback;
        }

        public object AsyncState
        {
            get { return _state; }
        }

        public WaitHandle AsyncWaitHandle
        {
            get
            {
                lock (this)
                {
                    if (_waitHandle != null)
                    {
                        _waitHandle = new EventWaitHandle(_completed, EventResetMode.ManualReset);
                    }
                    return _waitHandle;
                }
            }
            
        }

        public bool CompletedSynchronously
        {
            get
            {
                return false;
            }
        }

        public bool IsCompleted
        {
            get 
            {
                lock (this)
                {
                    return _completed;
                }
            }
        }

        public void setAsyncResult(T obj, Exception e)
        {
            lock (this)
            {
                _result = obj;
                _ex = e;
                _completed = true;
                if (_waitHandle != null) _waitHandle.Set();
                if (_callback != null) _callback(this);
            }
        }

        public T Result
        {
            get
            {
                WaitHandle wh = null;

                lock (this)
                {
                    if (_completed)
                    {
                        if (_ex != null) throw _ex;
                        return _result;
                    }
                    
                    wh = AsyncWaitHandle;
                }

                wh.WaitOne();

                return _result;
            }
        }
    }


}
