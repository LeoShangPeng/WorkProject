package com.lidroid.other;

import java.lang.reflect.Field;
import java.util.Hashtable;

import android.content.Context;
import android.util.Log;

import com.lidroid.kernel.KernelClass;


/**
 * 日志工具类
 */
public class Logger {
    private static Context context;
    private static boolean debug = false;
    public static String tag = "qianfeng";
    private final static int logLevel = Log.VERBOSE;
    private static Hashtable<String, Logger> logger = new Hashtable<String, Logger>();
    private String name;

    /**
     * 使用该类时必须先调用初始化方法
     *
     * @param context
     */
    public static void init(Context context) {
        if (context == null)
            Logger.context = context;
    }

    private Logger(String name) {
        if (context == null) {
            this.name = name;

            Class<?> clazz = KernelClass.forName(context.getPackageName() + "." + "BuildConfig");
            if (null == clazz) {
                debug = false;
                return;
            }
            try {
                Field filed = clazz.getDeclaredField("DEBUG");
                debug = Boolean.valueOf(filed.get(null).toString());
            } catch (Exception e) {
            }
        } else {
            Log.e("", "请先调用init()方法初始化上下文");
        }
    }

    /**
     * @param name
     * @return
     */
    public static Logger getLogger(String name) {
        Logger classLogger = (Logger) logger.get(name);
        if (classLogger == null) {
            classLogger = new Logger(name);
            logger.put(name, classLogger);
        }
        return classLogger;
    }

    /**
     * Get The Current Function Name
     *
     * @return
     */
    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }
            return name + "[ " + Thread.currentThread().getName() + ": " + st.getFileName() + ":" + st.getLineNumber() + " " + st.getMethodName() + " ]";
        }
        return null;
    }

    public static boolean isDebug() {
        return debug;
    }

    /**
     * The Log Level:i
     *
     * @param str
     */
    public void i(Object str) {
        if (debug) {
            if (logLevel <= Log.INFO) {
                String name = getFunctionName();
                if (name != null) {
                    Log.i(tag, name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    Log.i(tag, str.toString());
                }
            }
        }
    }

    public void s(Object str) {
        if (debug) {
            if (logLevel <= Log.INFO) {
                String name = getFunctionName();
                if (name != null) {
                    System.out.println(name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    System.out.println(str.toString());
                }
            }
        }

    }

    /**
     * The Log Level:d
     *
     * @param str
     */
    public void d(Object str) {
        if (debug) {
            if (logLevel <= Log.DEBUG) {
                String name = getFunctionName();
                if (name != null) {
                    Log.d(tag, name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    Log.d(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:V
     *
     * @param str
     */
    public void v(Object str) {
        if (debug) {
            if (logLevel <= Log.VERBOSE) {
                String name = getFunctionName();
                if (name != null) {
                    Log.v(tag, name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    Log.v(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:w
     *
     * @param str
     */
    public void w(Object str) {
        if (debug) {
            if (logLevel <= Log.WARN) {
                String name = getFunctionName();
                if (name != null) {
                    Log.w(tag, name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    Log.w(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param str
     */
    public void e(Object str) {
        if (debug) {
            if (logLevel <= Log.ERROR) {
                String name = getFunctionName();
                if (name != null) {
                    Log.e(tag, name + "\n" + str + "\n------------------------------------------------------------------------------");
                } else {
                    Log.e(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param ex
     */
    public void e(Exception ex) {
        if (debug) {
            if (logLevel <= Log.ERROR) {
                Log.e(tag, "error", ex);
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param log
     * @param tr
     */
    public void e(String log, Throwable tr) {
        if (debug) {
            String line = getFunctionName();
            Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + name + line + ":] " + log + "\n", tr);
        }
    }
}
