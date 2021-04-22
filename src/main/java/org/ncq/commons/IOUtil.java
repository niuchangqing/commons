package org.ncq.commons;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.ncq.commons.base.Objects.isNull;
import static org.ncq.commons.base.Objects.nonNull;
import static org.ncq.commons.base.Preconditions.checkNotNull;

/**
 * @author niuchangqing
 * IO工具类
 */
public class IOUtil {

    /**
     * 私有构造方法
     */
    private IOUtil(){
    }

    private static final Logger logger = Logger.getLogger(IOUtil.class.getName());

    /**
     * 默认buffer size大小
     */
    private static final int DEFAULT_BUFFER_SIZE = 8192;

    /**
     * 关闭
     * 不抛出异常
     * @param closeable         要关闭的对象
     */
    public static void closeQuietly(final Closeable closeable) {
        if (nonNull(closeable)) {
            try {
                closeable.close();
            }catch (IOException e) {
                logger.log(Level.WARNING, "exception thrown when closing " + closeable, e);
            }
        }
    }

    /**
     * 批量关闭
     * 不抛出异常
     * @param closeables           要关闭的数组
     */
    public static void closeQuietly(final Closeable... closeables) {
        if (isNull(closeables)) {
            return;
        }
        for (Closeable closeable : closeables) {
            closeQuietly(closeable);
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

    /**
     * 关闭
     * 抛出异常
     * @param closeable         要关闭的对象
     * @throws IOException      io异常
     */
    public static void close(final Closeable closeable) throws IOException {
        if (nonNull(closeable)) {
            closeable.close();
        }
    }

    /**
     * 批量关闭
     * 抛出异常
     * @param closeables        要关闭的对象
     * @throws IOException      IO异常
     */
    public static void close(final Closeable... closeables) throws IOException {
        if (isNull(closeables)) {
            return;
        }
        for (final Closeable closeable : closeables) {
            close(closeable);
        }
    }

    /**
     * input转byte[]
     * @param inputStream       InputStream
     * @return                  byte[]
     * @throws IOException      IOException
     * @throws NullPointerException inputStream为空抛出
     */
    public static byte[] toByteArray(final InputStream inputStream) throws IOException {
        checkNotNull(inputStream);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int n = 0;
        while (-1 != (n = inputStream.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    /**
     * Reader转byte[]
     * @param reader            Reader
     * @return                  byte[]
     * @throws IOException      IOException
     * @throws NullPointerException  reader为空抛出
     */
    public static byte[] toByteArray(final Reader reader) throws IOException {
        checkNotNull(reader);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(reader, output);
        return output.toByteArray();
    }

    /**
     * Reader转byte[]
     * @param reader                Reader
     * @param encoding              指定编码方式
     * @return                      byte[]
     * @throws IOException          IOException
     * @throws NullPointerException reader为空时抛出
     */
    public static byte[] toByteArray(final Reader reader, final String encoding) throws IOException {
        checkNotNull(reader);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(reader, output, encoding);
        return output.toByteArray();
    }

    /**
     * 将reader中的char复制给output
     * @param reader                Reader
     * @param output                OutputStream
     */
    public static void copy(final Reader reader, final OutputStream output) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(reader, out);
        out.flush();
    }

    /**
     * 将reader中的内容复制给output，并指定编码方式
     * @param reader                Reader
     * @param output                OutputStream
     * @param encoding              encoding
     * @throws IOException          IOException
     */
    public static void copy(final Reader reader, final OutputStream output, String encoding) throws IOException {
        if (isNull(encoding)) {
            copy(reader, output);
        }else {
            OutputStreamWriter out = new OutputStreamWriter(output, encoding);
            copy(reader, out);
            out.flush();
        }
    }

    /**
     * 将reader中的内容复制给writer
     * @param reader                Reader
     * @param writer                Writer
     */
    public static long copy(final Reader reader, Writer writer) throws IOException {
        char[] chars = new char[DEFAULT_BUFFER_SIZE];
        int n = 0;
        long count = 0;
        while (-1 != (n = reader.read(chars))) {
            writer.write(chars, 0, n);
            count += n;
        }
        return count;
    }
}
