/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace byps
{
    public enum LogLevel
    {
        DEBUG, INFO, WARN, ERROR
    }

    public class LogConfig
    {
        public LogLevel level = LogLevel.ERROR;
        public String fileName = "";
    }

    public interface ILogWriter
    {
        void log(LogLevel level, String msg, Exception e);
    }

    public class Log
    {
        public bool isDebugEnabled()
        {
            return (int)LogFactory.c_config.level >= (int)LogLevel.DEBUG;
        }
        public bool isInfoEnabled()
        {
            return (int)LogFactory.c_config.level >= (int)LogLevel.INFO;
        }
        public bool isWarnEnabled()
        {
            return (int)LogFactory.c_config.level >= (int)LogLevel.WARN;
        }
        public bool isErrorEnabled()
        {
            return (int)LogFactory.c_config.level >= (int)LogLevel.ERROR;
        }

        public void debug(String msg)
        {
            LogFactory.c_writer.log(LogLevel.DEBUG, msg, null);
        }
        public void debug(String msg, Exception e)
        {
            LogFactory.c_writer.log(LogLevel.DEBUG, msg, e);
        }
        public void info(String msg)
        {
            LogFactory.c_writer.log(LogLevel.INFO, msg, null);
        }
        public void info(String msg, Exception e)
        {
            LogFactory.c_writer.log(LogLevel.INFO, msg, e);
        }
        public void warn(String msg)
        {
            LogFactory.c_writer.log(LogLevel.WARN, msg, null);
        }
        public void warn(String msg, Exception e)
        {
            LogFactory.c_writer.log(LogLevel.WARN, msg, e);
        }
        public void error(String msg)
        {
            LogFactory.c_writer.log(LogLevel.ERROR, msg, null);
        }
        public void error(String msg, Exception e)
        {
            LogFactory.c_writer.log(LogLevel.ERROR, msg, e);
        }

        internal Log(String name)
        {
            this.name = name;
        }

        protected String name;
    }

    public interface ILogFactory
    {
        Log createLogger(String name);
    }

    public class LogFactory
    {
        public static Log getLog(Type type)
        {
            return c_fact.createLogger(type.Name);
        }

        public static void setLogFactory(ILogFactory fact)
        {
            c_fact = fact;
        }

        public static void setLogWriter(ILogWriter writer)
        {
            c_writer = writer;
        }

        public static void setConfig(LogConfig config)
        {
            c_config = config;
        }

        internal static ILogFactory c_fact = new DefaultLogFactory();
        internal static ILogWriter c_writer = new DefaultLogWriter();
        internal static LogConfig c_config = new LogConfig();
    }

    class DefaultLogFactory : ILogFactory
    {
        public Log createLogger(string name)
        {
            return new Log(name);
        }
    }

    class DefaultLogWriter : ILogWriter
    {
        public void log(LogLevel level, string msg, Exception e)
        {
            if ((int)LogFactory.c_config.level > (int)level) return;
            reopenIfConfigChanged();

            StackFrame callStack = new StackFrame(2, true);
            String fileName = callStack.GetFileName();
            fileName = Path.GetFileName(fileName);
            int lineNumber = callStack.GetFileLineNumber();

            String iso = DateTime.Now.ToString("HH':'mm':'ss','fff");
            String threadName = "thread-" + Thread.CurrentThread.ManagedThreadId;

            String logline = iso + " " + threadName + " " + level + " " + fileName + ":" + lineNumber + " " + msg;

            lock (this)
            {
                if (writer != null)
                {
                    writer.WriteLine(logline);
                    if (e != null)
                    {
                        writer.WriteLine(e.ToString());
                        writer.WriteLine(e.StackTrace);
                    }
                    writer.Flush();
                }
                else
                {
                    // I do not see this output in my console-debug window - why?
                    System.Diagnostics.Trace.TraceInformation(logline);
                    if (e != null)
                    {
                        System.Diagnostics.Trace.TraceInformation(e.ToString());
                        System.Diagnostics.Trace.TraceInformation(e.StackTrace);
                    }
                }
            }
        }

        protected void reopenIfConfigChanged()
        {
            bool configChanged = (fileName == null && LogFactory.c_config.fileName != null) ||
                (fileName != null && LogFactory.c_config.fileName == null) ||
                (LogFactory.c_config.fileName != null && writer == null) ||
                (fileName != null && LogFactory.c_config.fileName != null && !fileName.Equals(LogFactory.c_config.fileName));

            if (configChanged)
            {
                if (writer != null)
                {
                    writer.Close();
                    writer = null;
                }

                if (LogFactory.c_config.fileName != null)
                {
                    try
                    {
                        writer = new StreamWriter(LogFactory.c_config.fileName);
                        fileName = LogFactory.c_config.fileName;
                    }
                    catch (Exception) { }
                }
            }

        }

        protected String fileName;
        protected StreamWriter writer;
    }

}
