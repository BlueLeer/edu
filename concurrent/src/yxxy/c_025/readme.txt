总结：
1：对于map/set的选择使用
HashMap: 线程不安全的,允许key值为null,取的时候不一定是存的时候的顺序
TreeMap: 线程不安全,不允许key值为null,会将key值排好序存储
LinkedHashMap: 线程不安全的,允许key值为null,取得时候的顺序和存的时候的顺序是一致的

线程安全的,但是效率比较低,用的比较少
HashTable
Collections.sychronizedXXX

// 大数据,高并发推荐使用
ConcurrentHashMap
ConcurrentSkipListMap 

2：队列
ArrayList
LinkedList
Collections.synchronizedXXX
CopyOnWriteList
Queue
	ConcurrentLinkedQueue(加锁了的队列) //concurrentArrayQueue
	BlockingQueue(阻塞式队列,接口)
		LinkedBlockingQueue 无界队列,可以一直往里面加,知道内存满了,程序崩溃为止
		ArrayBlockingQueue 有界队列,new的时候就得指定队列的长队
		TransferQueue
		SynchronousQueue
	DelayQueue执行定时任务
		
	