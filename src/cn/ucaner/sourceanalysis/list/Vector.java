/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年6月29日 上午9:00:48</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.sourceanalysis.list;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**     
* @Package：cn.ucaner.sourceanalysis   
* @ClassName：Vector   
* @Description：   <p> Vector Vector 可实现自动增长的对象数组</p>
* @Author： - Jason   
* @CreatTime：2018年6月29日 上午9:00:48   
* @Modify By：   
* @ModifyTime：  2018年6月29日
* @Modify marker：   
* @version    V1.0
*/

/****************Notice******************
[参考]{@link https://www.cnblogs.com/zheting/p/7708366.html} {@link https://www.cnblogs.com/skywang12345/p/3308833.html}

Vector 是矢量队列，它是JDK1.0版本添加的类。继承于AbstractList，实现了List, RandomAccess, Cloneable这些接口

Vector 继承了AbstractList,实现了List;所以，它是一个队列,支持相关的添加、删除、修改、遍历等功能.
Vector 实现了RandmoAccess接口,即提供了随机访问功能.
RandmoAccess是Java中用来被List实现,为List提供快速访问功能的.
在Vector中，我们即可以通过元素的序号快速获取元素对象;这就是快速随机访问。

Vector 实现了Cloneable接口,即实现clone()函数,它能被克隆,与ArrayList不同，Vector中的操作是线程安全的.

Vector共有4个构造函数
	
	
	Vector()// 默认构造函数
	
	Vector(int capacity)// capacity是Vector的默认容量大小。当由于增加数据导致容量增加时，每次容量会增加一倍。
	
	Vector(int capacity, int capacityIncrement)// capacity是Vector的默认容量大小，capacityIncrement是每次Vector容量增加时的增量值。
	
	Vector(Collection<? extends E> collection)// 创建一个包含collection的Vector



 *******************End**************************/
public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

	private static final long serialVersionUID = 2411957469099220630L;
	
	/**
	 * 元素数据  - elementData是个动态数组，如果初始化Vector时，没指定动态数组的>大小，则使用默认大小10
	 */
	protected Object[] elementData;
	
	/**
	 * 元素个数 - elementCount 是动态数组的实际大小
	 */
	protected int elementCount;

	/**
	 * 容量增长 - 每次Vector容量增加时的增量值 - 如果在创建Vector时，指定了capacityIncrement的大小；则，每次当Vector中动态数组容量增加时>，增加的大小都是capacityIncrement
	 */
	protected int capacityIncrement;
	
	/**
	* Vector.  构造函数
	* @param initialCapacity   容量大小
	* @param capacityIncrement  扩容因子
	 */
	public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("[Java-Core-Advanced]Illegal Capacity: "+initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }
	
	/**
	* Vector. 
	* @param initialCapacity 容量大小
	 */
	public Vector(int initialCapacity) {
        this(initialCapacity, 0);//扩容因子为0
    }
	
	/**
	* Vector. 默认为10
	 */
	public Vector() {
        this(10);
    }
	
	/**
	* Vector. 
	* @param c Collection
	 */
	public Vector(Collection<? extends E> c) {
        elementData = c.toArray();
        elementCount = elementData.length;
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, elementCount, Object[].class);
        }
    }
	
	/**
	 * @Description: copyInto 
	 * @param anArray void
	 * @Autor: Jason
	 */
	public synchronized void copyInto(Object[] anArray) {
	        System.arraycopy(elementData, 0, anArray, 0, elementCount);
    }
	
	/**
	 * @Description: trimToSize
	 * @Autor: Jason
	 */
	public synchronized void trimToSize() {
        modCount++;
        int oldCapacity = elementData.length;
        if (elementCount < oldCapacity) {
            elementData = Arrays.copyOf(elementData, elementCount);
        }
    }
	
	/**
	 * @Description: ensureCapacity
	 * @param minCapacity  
	 * @Autor: Jason
	 */
	public synchronized void ensureCapacity(int minCapacity) {
        if (minCapacity > 0) {
            modCount++;
            ensureCapacityHelper(minCapacity);
        }
    }
	
	/**
	 * @Description: ensureCapacityHelper
	 * @param minCapacity 
	 * @Autor: Jason
	 */
	private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
	

   /**
    * 最大数组大小
    */
   private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

   /**
    * @Description: grow
    * @param minCapacity 
    * @Autor: Jason
    */
	private void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + ((capacityIncrement > 0) ?capacityIncrement : oldCapacity);
		if (newCapacity - minCapacity < 0)
		    newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
		    newCapacity = hugeCapacity(minCapacity);
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	/**
	 * @Description: hugeCapacity
	 * @param minCapacity
	 * @return int
	 * @Autor: Jason
	 */
	private static int hugeCapacity(int minCapacity) {
	    if (minCapacity < 0) // overflow
	        throw new OutOfMemoryError();
	    return (minCapacity > MAX_ARRAY_SIZE) ?
	        Integer.MAX_VALUE :
	        MAX_ARRAY_SIZE;
	}

	/**
	 * @Description: setSize 
	 * @param newSize void
	 * @Autor: Jason
	 */
	public synchronized void setSize(int newSize) {
	    modCount++;
	    if (newSize > elementCount) {
	        ensureCapacityHelper(newSize);
	    } else {
	        for (int i = newSize ; i < elementCount ; i++) {
	            elementData[i] = null;
	        }
	    }
	    elementCount = newSize;
	}

	/**
	 * @Description: 返回当前容器的大小
	 * @return int
	 * @Autor: Jason
	 */
    public synchronized int capacity() {
        return elementData.length;
    }

    /**
     * 返回当前数据统计
     */
    public synchronized int size() {
        return elementCount;
    }

    /**
     * 是否为空
     */
	public synchronized boolean isEmpty() {
	    return elementCount == 0;
	}

	/**
	 * @Description: 元素枚举
	 * @return Enumeration<E>
	 * @Autor: Jason
	 */
	public Enumeration<E> elements() {
	    return new Enumeration<E>() {
	        int count = 0;
	
	        public boolean hasMoreElements() {
	            return count < elementCount;
	        }
	
	        public E nextElement() {
	            synchronized (Vector.this) {
	                if (count < elementCount) {
	                    return elementData(count++);
	                }
	            }
	            throw new NoSuchElementException("Vector Enumeration");
	        }
	    };
	}

	/**
	 * 是否包含
	 */
	public boolean contains(Object o) {
	    return indexOf(o, 0) >= 0;
	}

	/**
	 * 元素的索引位置
	 */
    public int indexOf(Object o) {
        return indexOf(o, 0);
    }

    /**
     * @Description: indexOf 
     * @param o 
     * @param index
     * @return int
     * @Autor: Jason
     */
	public synchronized int indexOf(Object o, int index) {
	    if (o == null) {
	        for (int i = index ; i < elementCount ; i++)
	            if (elementData[i]==null)
	                return i;
	    } else {
	        for (int i = index ; i < elementCount ; i++)
	            if (o.equals(elementData[i]))
	                return i;
	    }
	    return -1;
	}

	/**
	 * lastIndexOf
	 */
    public synchronized int lastIndexOf(Object o) {
        return lastIndexOf(o, elementCount-1);
    }

    /**
     * @Description: lastIndexOf
     * @param o
     * @param index
     * @return int
     * @Autor: Jason
     */
    public synchronized int lastIndexOf(Object o, int index) {
        if (index >= elementCount)
            throw new IndexOutOfBoundsException(index + " >= "+ elementCount);

        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = index; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * @Description: elementAt 
     * @param index
     * @return E
     * @Autor: Jason
     */
    public synchronized E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return elementData(index);
    }

    /**
     * @Description: Returns the first component 
     * @return E
     * @Autor: Jason
     */
	public synchronized E firstElement() {
	    if (elementCount == 0) {
	        throw new NoSuchElementException();
	    }
	    return elementData(0);
	}

	/**
	 * @Description: 返回容器里最后一个元素
	 * @return E
	 * @Autor: Jason
	 */
    public synchronized E lastElement() {
        if (elementCount == 0) {
            throw new NoSuchElementException();
        }
        return elementData(elementCount - 1);
    }

    /**
     * @Description: 设置元素
     * @param obj
     * @param index void
     * @Autor: Jason
     */
    public synchronized void setElementAt(E obj, int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        elementData[index] = obj;
    }

    /**
     * @Description: 移除指定位置的元素
     * @param index  索引位置
     * @Autor: Jason
     */
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }

	/**
	 * @Description: 插入数据到具体的索引位置
	 * @param obj
	 * @param index 索引位置
	 * @Autor: Jason
	 */
    public synchronized void insertElementAt(E obj, int index) {
        modCount++;
        if (index > elementCount) {
            throw new ArrayIndexOutOfBoundsException(index
                                                     + " > " + elementCount);
        }
        ensureCapacityHelper(elementCount + 1);
        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
        elementData[index] = obj;
        elementCount++;
    }

    /**
     * @Description: 添加元素  - Core 基本可以看出来Vector的数结构
     * @param obj  元素
     * @Autor: Jason
     */
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }

    /**
     * @Description: 移除指定Object元素的数据
     * @param obj
     * @return boolean
     * @Autor: Jason
     */
	public synchronized boolean removeElement(Object obj) {
	    modCount++;
	    int i = indexOf(obj);
	    if (i >= 0) {
	        removeElementAt(i);
	        return true;
	    }
	    return false;
	}

	/**
	 * @Description:移除所有的元素
	 * @Autor: Jason
	 */
	public synchronized void removeAllElements() {
	    modCount++;
	    // Let gc do its work
	    for (int i = 0; i < elementCount; i++)
	        elementData[i] = null; //循环置空   gc垃圾回收机制处理
	
	    elementCount = 0;
	}

	/**
	 * 克隆接口 实现克隆
	 */
    public synchronized Object clone() {
        try {
            @SuppressWarnings("unchecked")
                Vector<E> v = (Vector<E>) super.clone();
            v.elementData = Arrays.copyOf(elementData, elementCount);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     * toArray
     */
    public synchronized Object[] toArray() {
        return Arrays.copyOf(elementData, elementCount);
    }

	 /**
	 * toArray
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> T[] toArray(T[] a) {
	    if (a.length < elementCount)
	        return (T[]) Arrays.copyOf(elementData, elementCount, a.getClass());
	
	    System.arraycopy(elementData, 0, a, 0, elementCount);
	
	    if (a.length > elementCount) {
	        a[elementCount] = null;
	    }
	    return a;
	}

    // Positional Access Operations
	/**
	 * @Description: elementData 
	 * @param index
	 * @return E
	 * @Autor: Jason
	 */
    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * get by Index
     */
    public synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        return elementData(index);
    }

    /**
     * set data into Index Vector
     */
    public synchronized E set(int index, E element) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }
    
    /**
     * 添加数据到后面
     */
    public synchronized boolean add(E e) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = e;
        return true;
    }

    /**
     * 移除元素
     */
    public boolean remove(Object o) {
        return removeElement(o);
    }

    /**
     * 添加元素
     */
    public void add(int index, E element) {
        insertElementAt(element, index);
    }

    /**
     * 移除置空 垃圾回收机制做处理
     */
    public synchronized E remove(int index) {
        modCount++;
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        E oldValue = elementData(index);

        int numMoved = elementCount - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,numMoved);
        elementData[--elementCount] = null; // Let gc do its work

        return oldValue;
    }

    /**
     * 清空
     */
    public void clear() {
        removeAllElements();
    }

    // Bulk Operations
    /**
     * Collection  循环比较所有是不是 contains(e)
     */
    public synchronized boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    /**
     * 添加整个集合
     */
    public synchronized boolean addAll(Collection<? extends E> c) {
        modCount++;
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityHelper(elementCount + numNew);
        System.arraycopy(a, 0, elementData, elementCount, numNew);
        elementCount += numNew;
        return numNew != 0;
    }

    /**
     * 移除所有
     */
    public synchronized boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    /**
     * retainAll 包含所有
     */
    public synchronized boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    /**
     * addAll Collection
     */
    public synchronized boolean addAll(int index, Collection<? extends E> c) {
        modCount++;
        if (index < 0 || index > elementCount) {//索引越界异常
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityHelper(elementCount + numNew);
        int numMoved = elementCount - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        elementCount += numNew;
        return numNew != 0;
    }

    /**
     * equals
     */
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     *  hashCode = 31*hashCode + (e==null ? 0 : e.hashCode()); 抽象类的HashCode方法 没有重写
     */
    public synchronized int hashCode() {
        return super.hashCode();
    }

    /**
     * 抽象集合的toString方法
     */
    public synchronized String toString() {
        return super.toString();
    }

	    /**
	     * Returns a view of the portion of this List between fromIndex,
	     * inclusive, and toIndex, exclusive.  (If fromIndex and toIndex are
	     * equal, the returned List is empty.)  The returned List is backed by this
	     * List, so changes in the returned List are reflected in this List, and
	     * vice-versa.  The returned List supports all of the optional List
	     * operations supported by this List.
	     *
	     * <p>This method eliminates the need for explicit range operations (of
	     * the sort that commonly exist for arrays).  Any operation that expects
	     * a List can be used as a range operation by operating on a subList view
	     * instead of a whole List.  For example, the following idiom
	     * removes a range of elements from a List:
	     * <pre>
	     *      list.subList(from, to).clear();
	     * </pre>
	     * Similar idioms may be constructed for indexOf and lastIndexOf,
	     * and all of the algorithms in the Collections class can be applied to
	     * a subList.
	     *
	     * <p>The semantics of the List returned by this method become undefined if
	     * the backing list (i.e., this List) is <i>structurally modified</i> in
	     * any way other than via the returned List.  (Structural modifications are
	     * those that change the size of the List, or otherwise perturb it in such
	     * a fashion that iterations in progress may yield incorrect results.)
	     *
	     * @param fromIndex low endpoint (inclusive) of the subList
	     * @param toIndex high endpoint (exclusive) of the subList
	     * @return a view of the specified range within this List
	     * @throws IndexOutOfBoundsException if an endpoint index value is out of range
	     *         {@code (fromIndex < 0 || toIndex > size)}
	     * @throws IllegalArgumentException if the endpoint indices are out of order
	     *         {@code (fromIndex > toIndex)}
	     */
    /*public synchronized List<E> subList(int fromIndex, int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex, toIndex),this);
    }*/

	/**
	 * 移除范围
	 */
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = elementCount - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex,numMoved);
        // Let gc do its work
        int newElementCount = elementCount - (toIndex-fromIndex);
        while (elementCount != newElementCount)
            elementData[--elementCount] = null;
    }

	    /**
	     * Save the state of the {@code Vector} instance to a stream (that
	     * is, serialize it).
	     * This method performs synchronization to ensure the consistency
	     * of the serialized data.
	     */
    /**
     * @Description: writeObject 
     * @param s
     * @throws java.io.IOException
     * @Autor: Jason
     */
    private void writeObject(java.io.ObjectOutputStream s)throws java.io.IOException {
        final java.io.ObjectOutputStream.PutField fields = s.putFields();
        final Object[] data;
        synchronized (this) {
            fields.put("capacityIncrement", capacityIncrement);
            fields.put("elementCount", elementCount);
            data = elementData.clone();
        }
        fields.put("elementData", data);
        s.writeFields();
    }

    /**
     * List 迭代器
     */
    public synchronized ListIterator<E> listIterator(int index) {
        if (index < 0 || index > elementCount)
            throw new IndexOutOfBoundsException("Index: "+index);
        return new ListItr(index);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     */
    public synchronized ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     */
    public synchronized Iterator<E> iterator() {
        return new Itr();
    }

    /**
    * @Package：cn.ucaner.sourceanalysis   
    * @ClassName：Itr   
    * @Description：   <p> An optimized version of AbstractList.Itr 实现迭代器</p>
    * @Author： - Jason   
    * @Modify By：   
    * @Modify marker：   
    * @version    V1.0
     */
    private class Itr implements Iterator<E> {
    	
        int cursor;       // index of next element to return 
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            // Racy but within spec, since modifications are checked
            // within or after synchronization in next/previous
            return cursor != elementCount;
        }

        public E next() {
            synchronized (Vector.this) {
                checkForComodification();
                int i = cursor;
                if (i >= elementCount)
                    throw new NoSuchElementException();
                cursor = i + 1;
                return elementData(lastRet = i);
            }
        }

        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.remove(lastRet);
                expectedModCount = modCount;
            }
            cursor = lastRet;
            lastRet = -1;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            synchronized (Vector.this) {
                final int size = elementCount;
                int i = cursor;
                if (i >= size) {
                    return;
                }
        @SuppressWarnings("unchecked")
                final E[] elementData = (E[]) Vector.this.elementData;
                if (i >= elementData.length) {
                    throw new ConcurrentModificationException();
                }
                while (i != size && modCount == expectedModCount) {
                    action.accept(elementData[i++]);
                }
                // update once at end of iteration to reduce heap write traffic
                cursor = i;
                lastRet = i - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    /**
    * @Package：cn.ucaner.sourceanalysis   
    * @ClassName：ListItr   
    * @Description：   <p> An optimized version of AbstractList.ListItr </p>
    * @Author： - Jason   
    * @Modify By：   
    * @Modify marker：   
    * @version    V1.0
     */
    final class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public E previous() {
            synchronized (Vector.this) {
                checkForComodification();
                int i = cursor - 1;
                if (i < 0)
                    throw new NoSuchElementException();
                cursor = i;
                return elementData(lastRet = i);
            }
        }

        public void set(E e) {
            if (lastRet == -1)
                throw new IllegalStateException();
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.set(lastRet, e);
            }
        }

        public void add(E e) {
            int i = cursor;
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.add(i, e);
                expectedModCount = modCount;
            }
            cursor = i + 1;
            lastRet = -1;
        }
    }

    /**
     * forEach 增强for循环
     */
    @Override
    public synchronized void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        @SuppressWarnings("unchecked")
        final E[] elementData = (E[]) this.elementData;
        final int elementCount = this.elementCount;
        for (int i=0; modCount == expectedModCount && i < elementCount; i++) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * removeIf 
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        // figure out which elements are to be removed
        // any exception thrown from the filter predicate at this stage
        // will leave the collection unmodified
        int removeCount = 0;
        final int size = elementCount;
        final BitSet removeSet = new BitSet(size);
        final int expectedModCount = modCount;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            final E element = (E) elementData[i];
            if (filter.test(element)) {
                removeSet.set(i);
                removeCount++;
            }
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }

        // shift surviving elements left over the spaces left by removed elements
        final boolean anyToRemove = removeCount > 0;
        if (anyToRemove) {
            final int newSize = size - removeCount;
            for (int i=0, j=0; (i < size) && (j < newSize); i++, j++) {
                i = removeSet.nextClearBit(i);
                elementData[j] = elementData[i];
            }
            for (int k=newSize; k < size; k++) {
                elementData[k] = null;  // Let gc do its work
            }
            elementCount = newSize;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            modCount++;
        }

        return anyToRemove;
    }

    /**
     * 替换
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final int expectedModCount = modCount;
        final int size = elementCount;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            elementData[i] = operator.apply((E) elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    /**
     * 排序
     */
    @SuppressWarnings("unchecked")
    @Override
    public synchronized void sort(Comparator<? super E> c) {
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elementData, 0, elementCount, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    /**
     * 分隔符
     */
    @Override
    public Spliterator<E> spliterator() {
        return new VectorSpliterator<>(this, null, 0, -1, 0);
    }

    /**
    * @Package：cn.ucaner.sourceanalysis   
    * @ClassName：VectorSpliterator   
    * @Description：   <p> Similar to ArrayList Spliterator </p>
    * @Author： - Jason   
    * @Modify By：   
    * @Modify marker：   
    * @version    V1.0
     */
    static final class VectorSpliterator<E> implements Spliterator<E> {
        private final Vector<E> list;
        private Object[] array;
        private int index; // current index, modified on advance/split
        private int fence; // -1 until used; then one past last index
        private int expectedModCount; // initialized when fence set

        /**
        * VectorSpliterator.  Create new spliterator covering the given  range 
        * @param list
        * @param array
        * @param origin
        * @param fence
        * @param expectedModCount
         */
        VectorSpliterator(Vector<E> list, Object[] array, int origin, int fence,
                          int expectedModCount) {
            this.list = list;
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() { // initialize on first use
            int hi;
            if ((hi = fence) < 0) {
                synchronized(list) {
                    array = list.elementData;
                    expectedModCount = list.modCount;
                    hi = fence = list.elementCount;
                }
            }
            return hi;
        }

        public Spliterator<E> trySplit() {
            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
            return (lo >= mid) ? null :
                new VectorSpliterator<E>(list, array, lo, index = mid,
                                         expectedModCount);
        }

        @SuppressWarnings("unchecked")
        public boolean tryAdvance(Consumer<? super E> action) {
            int i;
            if (action == null)
                throw new NullPointerException();
            if (getFence() > (i = index)) {
                index = i + 1;
                action.accept((E)array[i]);
                if (list.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return true;
            }
            return false;
        }

        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> action) {
            int i, hi; // hoist accesses and checks from loop
            Vector<E> lst; Object[] a;
            if (action == null)
                throw new NullPointerException();
            if ((lst = list) != null) {
                if ((hi = fence) < 0) {
                    synchronized(lst) {
                        expectedModCount = lst.modCount;
                        a = array = lst.elementData;
                        hi = fence = lst.elementCount;
                    }
                }
                else
                    a = array;
                if (a != null && (i = index) >= 0 && (index = hi) <= a.length) {
                    while (i < hi)
                        action.accept((E) a[i++]);
                    if (lst.modCount == expectedModCount)
                        return;
                }
            }
            throw new ConcurrentModificationException();
        }

        public long estimateSize() {
            return (long) (getFence() - index);
        }

        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }
    }
}
