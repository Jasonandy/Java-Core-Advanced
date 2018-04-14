/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.iterator;

/*
*从定义可见，迭代器模式是为容器而生。很明显，对容器对象的访问必然涉及到遍历算法。
*你可以一股脑的将遍历方法塞到容器对象中去；或者根本不去提供什么遍历算法，让使用容器的人自己去实现去吧。这两种情况好像都能够解决问题。
*然而在前一种情况，容器承受了过多的功能，它不仅要负责自己“容器”内的元素维护（添加、删除等等），而且还要提供遍历自身的接口；
*而且由于遍历状态保存的问题，不能对同一个容器对象同时进行多个遍历。第二种方式倒是省事，却又将容器的内部细节暴露无遗。
*
*
*而迭代器模式的出现，很好的解决了上面两种情况的弊端。先来看下迭代器模式的真面目吧。
*迭代器模式由以下角色组成:
*	1) 迭代器角色（Iterator）：迭代器角色负责定义访问和遍历元素的接口。
*	2) 具体迭代器角色（Concrete Iterator）：具体迭代器角色要实现迭代器接口，并要记录遍历中的当前位置。
*	3) 容器角色（Container）：容器角色负责提供创建具体迭代器角色的接口。
*	4) 具体容器角色（Concrete Container）：具体容器角色实现创建具体迭代器角色的接口——这个具体迭代器角色于该容器的结构相关。
*从结构上可以看出，迭代器模式在客户与容器之间加入了迭代器角色。迭代器角色的加入，就可以很好的避免容器内部细节的暴露，而且也使得设计符号“单一职责原则”
*
*在迭代器模式中，具体迭代器角色和具体容器角色是耦合在一起的——遍历算法是与容器的内部细节紧密相关的。
*为了使客户程序从与具体迭代器角色耦合的困境中脱离出来，避免具体迭代器角色的更换给客户程序带来的修改，迭代器模式抽象了具体迭代器角色，使得客户程序更具一般性和重用性。
*这被称为多态迭代。
*/
public class Itr<E> implements Iterator<E>{

	int cursor = 0;    
    int lastRet = -1;    
    int expectedModCount = 0;

    @Override
	public boolean hasNext() {
		return false;
	}

    @Override
	public E next() {
		return null;
	}
    
    
	@Override
	public void remove() {
		
	}    

}
