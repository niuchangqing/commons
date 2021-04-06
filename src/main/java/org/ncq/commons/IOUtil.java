package org.ncq.commons;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.ncq.commons.base.Objects.isNull;
import static org.ncq.commons.base.Objects.nonNull;

/**
 * @author niuchangqing
 * IO工具类
 */
public class IOUtil {

    private static final Logger logger = Logger.getLogger(IOUtil.class.getName());

    /**
     * 关闭流
     * @param closeable         要关闭的流对象
     */
    public static void close(final Closeable closeable) {
        if (nonNull(closeable)) {
            try {
                closeable.close();
            }catch (IOException e) {
                logger.log(Level.WARNING, "exception thrown when closing " + closeable, e);
            }
        }
    }

    /**
     * 批量关闭流
     * @param closeables           要关闭的流数组
     */
    public static void close(final Closeable... closeables) {
        if (isNull(closeables)) {
            return;
        }
        for (Closeable closeable : closeables) {
            close(closeable);
        }
    }

    /**
     * 关闭一个URLConnection
     * @param conn                  URLConnection
     */
    public static void close(final URLConnection conn) {
        if (isNull(conn)) {
            return;
        }
        if (conn instanceof HttpURLConnection) {
            ((HttpURLConnection) conn).disconnect();
        }
    }
}
