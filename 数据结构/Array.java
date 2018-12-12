package dataStructrue;
public class Array {
	public static void main(String[] args) {
        ArrayFunction<Integer> arr = new ArrayFunction<>(10);
		for(int i =0;i<10;i++) {
			arr.add(i, i);
			System.out.println(arr.get(i));
		}
        System.out.println(arr.getCapacity());
        System.out.println(arr.toString());
	}
}
class ArrayFunction<E> {
	private E[] data;//存放数据的集合
	private int size;//有效元素
	//构造函数 传入数组的容量capacity构造Array
	/**
	 * 
	 * @param capacity
	 */
	public ArrayFunction(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	//无参构造函数
	public ArrayFunction() {
	}
	/**
	 * 
	 *@Description:获取数组中元素个数
	 *@return int
	 */
	public int getSize() {
		return size;
	}
	/**
	 *  
	 *@Description:获取数组容量
	 *@return int
	 */
	public int getCapacity() {
		return data.length;
	}
	/**
	 * 
	 *@Description:返回数组是否为空
	 *@return boolean
	 */
	public boolean isEmpty() {
		return size==0;
	}
	//获取Index索引位置的元素
	public E get(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("参数不合法");
		}
		return data[index];
	}
	//修改index索引位置的元素
	public void set(int index,E e) {
		data[index] = e;
	}
	//查找元素是否有元素e
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(data[i]==e) {
				return true;
			}
		}
			return false;
	}
	//查找数组中元素e所在的索引,如果不存在元素e，则返回-1
	public int find(E e) {
		for(int i=0;i<size;i++) {
			if(data[i]==e) {
				return i;
			}
		}
		return -1;
	}
	
	public void addLast(E e) {
		add(size,e);
	}
	public void addFirst(E e) {
		add(0,e);
	}
	//添加元素
	public void add(int index,E e) {
		//index非法判断
		if(index<0||index>size) {
            throw new IllegalArgumentException("参数不合法");
		}
		if(size==data.length) {
			grow(data.length*2);
		}
		//index及后面的值向后移动
		for(int i=size-1;i>=index;i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}
	//删除指定位置的元素 并返回删除的元素
	public E remove(int index) {
		if(index<0||index>=size) {
            throw new IllegalArgumentException("参数不合法");
		}
		E res=data[index];
		for(int i=index+1;i<size;i++) {
			data[i-1] =data[i];
		}
		size--;
		if(size==(data.length/4) && data.length/2!=0){
			grow(data.length/2);
		}
		return res;
	}
	//删除第一个元素
	public E removeFirst() {
		return remove(0);
	}
	//删除最后一个元素
	public E removeLast() {
		return remove(size-1);
	}
	public void removeElement(E e) {
		int index = find(e);
		if(index!=-1) {
			remove(index);
		}
	}
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        sb.append('[');
        for(int i = 0 ; i < size ; i ++){
            sb.append(data[i]);
            if(i != size - 1)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
	private void grow(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newData[i]= data[i];
		}
		data = newData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}