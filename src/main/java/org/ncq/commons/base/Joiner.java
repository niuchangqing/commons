package org.ncq.commons.base;

import org.ncq.commons.collect.Lists;

import java.util.Iterator;
import java.util.StringJoiner;

import static org.ncq.commons.StringUtil.EMPTY;
import static org.ncq.commons.base.Objects.isNull;
import static org.ncq.commons.base.Preconditions.checkNotNull;
import static org.ncq.commons.collect.Iterables.size;
/**
 * @author niuchangqing
 * 数组/集合以指定字符串连接转字符串
 */
public class Joiner {

    private final String separator;

    /**
     * 私有构造方法
     */
    private Joiner(String separator) {
        this.separator = isNull(separator) ? EMPTY : separator;
    }

    /**
     * 返回一个以指定字符串的连接器
     * @param separator         指定连接字符串
     * @return                  Joiner
     */
    public static Joiner on(String separator) {
        return new Joiner(separator);
    }
    /**
     * 返回一个以指定字符的连接器
     * @param separator         指定连接字符
     * @return                  Joiner
     */
    public static Joiner on(char separator) {
        return new Joiner(String.valueOf(separator));
    }

    /**
     * 以指定字符拼接
     * 样例：
     * String[] strings = new String[]{"2","3","1"}
     * Joiner.on(",").join(strings);
     * 结果:2,3,1
     * @param objects               数组
     * @return                      拼接结果字符串
     */
    public final String join(final Object[] objects) {
        if (isNull(objects)) {
            return null;
        }
        return join(objects, 0, objects.length);
    }
    /**
     * 以指定字符拼接
     * 样例:
     * String[] strings = new String[]{"2","3","1"}
     * Joiner.on(",").join(strings, 0, 2);
     * 结果:2,3
     * @param objects               数组
     * @param startIndex            指定下标开始进行处理
     * @param endIndex              指定下标截止终止处理
     * @return                      拼接结果字符串
     */
    public final String join(final Object[] objects, final int startIndex, final int endIndex) {
        if (isNull(objects)) {
            return null;
        }
        return join(Lists.newArrayList(objects), startIndex, endIndex);
    }

    /**
     * 以指定字符拼接
     * 样例:
     * List<String> list = Lists.newLinkedList("3","2","1");
     * Joiner.on(",").join(list);
     * 结果:3,2,1
     * @param iterable              集合
     * @return                      拼接结果字符串
     */
    public final String join(final Iterable<?> iterable) {
        if (isNull(iterable)) {
            return null;
        }
        int size = size(iterable);
        return join(iterable, 0, size);
    }

    /**
     * 以指定字符拼接
     * 样例:
     * List<String> list = Lists.newLinkedList("3","2","1");
     * Joiner.on(",").join(list,1,3);
     * 结果:2,1
     * @param iterable              集合
     * @param startIndex            指定位置开始处理
     * @param endIndex              指定位置终止处理
     * @return                      拼接结果字符串
     */
    public final String join(final Iterable<?> iterable, final  int startIndex, final int endIndex) {
        if (isNull(iterable)) {
            return null;
        }
        return join(iterable.iterator(), startIndex, endIndex);
    }

    /**
     * 以指定字符拼接
     * 样例:
     * List<String> list = Lists.newLinkedList("3","2","1");
     * Joiner.on(",").join(list.iterator(), 0, Iterators.size(list.iterator()));
     * 结果:3,2,1
     * @param iterator              迭代器
     * @param startIndex            指定位置开始处理
     * @param endIndex              指定位置终止处理
     * @return                      拼接结果字符串
     */
    public final String join(final Iterator<?> iterator, final int startIndex, final int endIndex) {
        if (isNull(iterator)) {
            return null;
        }
        if (endIndex - startIndex <= 0) {
            return EMPTY;
        }
        final StringJoiner stringJoiner = newStringJoiner();
        int index = -1;
        while (iterator.hasNext()) {
            index++;
            if (index < startIndex) {
                iterator.next();
                continue;
            }
            if (index >= endIndex) {
                break;
            }
            stringJoiner.add(toString(iterator.next()));
        }
        return stringJoiner.toString();
    }


    CharSequence toString(Object obj) {
        checkNotNull(obj);
        return (obj instanceof CharSequence) ? (CharSequence) obj : obj.toString();
    }

    private StringJoiner newStringJoiner() {
        return new StringJoiner(separator);
    }
}
