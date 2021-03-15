package org.ncq.commons.collect;
import static org.ncq.commons.base.Preconditions.checkNotNull;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author niuchangqing
 */
public final class Iterators {
    private Iterators() {}

    /**
     * iterator to collection
     * <p>
     *     Set<String> set = new HashSet();
     *     set.add("1");
     *     List<String> list = new ArrayList<>();
     *     addAll(list,set.iterator());
     * </p>
     * @param collection                集合对象
     * @param iterator                  Iterator迭代器参数
     * @return
     */
    public static <E> boolean addAll(Collection<E> collection, Iterator<? extends E> iterator) {
        checkNotNull(collection);
        checkNotNull(iterator);
        boolean flag = false;
        while (iterator.hasNext()) {
            flag |= collection.add(iterator.next());
        }
        return false;
    }
}
