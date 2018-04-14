/**
 *<html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 *</html>
 */
package cn.ucaner.core.base.object;

/*
 * Object类是所有Java类的祖先。每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。
 * 
 * 1.clone方法（浅拷贝）
 * 		保护方法，实现对象的浅复制，只有实现了Cloneable接口才可以调用该方法，否则抛出CloneNotSupportedException异常。
 * 		主要是JAVA里除了8种基本类型传参数是值传递，其他的类对象传参数都是引用传递，我们有时候不希望在方法里讲参数改变，这是就需要在类中复写clone方法。
 * 2.getClass方法
 * 		final方法，获得运行时类型
 * 3.toString方法
 * 		该方法用得比较多，一般子类都有覆盖。
 * 4.finalize方法
 * 		该方法用于释放资源。因为无法确定该方法什么时候被调用，很少使用。
 * 5.equals方法
 * 		该方法是非常重要的一个方法。一般equals和==是不一样的，但是在Object中两者是一样的。子类一般都要重写这个方法。
 * 6.hashCode方法
 * 		该方法用于哈希查找，可以减少在查找中使用equals的次数，重写了equals方法一般都要重写hashCode方法。这个方法在一些具有哈希功能的Collection中用到。
 * 		一般必须满足obj1.equals(obj2)==true。可以推出obj1.hash- Code()==obj2.hashCode()，但是hashCode相等不一定就满足equals。不过为了提高效率，应该尽量使上面两个条件接近等价。
 * 		如果不重写hashcode(),在HashSet中添加两个equals的对象，会将两个对象都加入进去。
 * 7.wait方法
 * 		wait方法就是使当前线程等待该对象的锁，当前线程必须是该对象的拥有者，也就是具有该对象的锁。
 * 		wait()方法一直等待，直到获得锁或者被中断。
 * 		wait(long timeout)设定一个超时间隔，如果在规定时间内没有获得锁就返回。
 * 		调用该方法后当前线程进入睡眠状态，直到以下事件发生。
 * 			（1）其他线程调用了该对象的notify方法。
 * 			（2）其他线程调用了该对象的notifyAll方法
 * 			（3）其他线程调用了interrupt中断该线程。
 * 			（4）时间间隔到了。
 * 		此时该线程就可以被调度了，如果是被中断的话就抛出一个InterruptedException异常。
 * 8.notify方法
 * 		该方法唤醒在该对象上等待的某个线程。
 * 9.notifyAll方法
 * 		该方法唤醒在该对象上等待的所有线程。
 * 
 * 10.registerNatives()
 * 		Java中，用native关键字修饰的函数表明该方法的实现并不是在Java中去完成，而是由C/C++去完成，并被编译成了.dll，由Java去调用
 * 		
 */
public class Obj {
	

}
