#调试
##定义
####调试（DEBUG）：调试是一种修正程序逻辑错误有效手段，是每一个程序不可或缺的步骤，可以说，不懂调试的程序员不是合格的程序员。

####我将调试分成三种方法：
##1.Log调试
###（1）编写调试工具类：
####不建议使用System.out.print（）方法进行打印，开发往往采用Log来打印进行调试。
####编写步骤：
####1.构造构造器：首先使该类构造器私有化且实例时抛出不支持操作异常，即不能实例化，毕竟是个常用的工具类。
####2.声明私有静态常量：我们按照Logcat过滤的等级划分6个数字常量（即VERBOSE ～NOTHING），LEVEL常量的赋值决定了你过滤那些等级的信息，TAG常量即Log输出前缀的一个参数，它主要是为不带TAG形参的方法赋值原本Log.d（TAG，content）中的形参TAG，你也可以让带TAG形参的方法等于你的类名。
####3.构造方法：让每个方法都用if语句判断自己输出的等级（例如DEBUG）是否大于或等于LEVEL，若判断为真则输出，开发时我们可以将LEVEL=DEBUG，而开发完成后LEVEL=NOTHING。这样避免了我们开发完成去删除这些语句，一条判断对我们的APP效率影响微乎其微。方法主要分为两类，一类是默认TAG参数，一类是自定义TAG参数，自己抉择。

```
public class LogUtils
{
	private LogUtils ()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}
	
	private static final int VERBOSE = 1;
	private static final int DEBUG = 2;
	private static final int INFO = 3;
	private static final int WARN = 4;
	private static final int ERROR = 5;
	private static final int NOTHING = 6;
	private static final int LEVEL = DEBUG;
	
	private static final String TAG = "DEBUG";
	
	// 下面四个是默认tag的函数
	
	
	public static void v ( String msg )
	{
		if ( LEVEL <= VERBOSE )
			Log.v(TAG, msg);
	}
	
	public static void d ( String msg )
	{
		if ( LEVEL <= DEBUG )
			Log.d(TAG, msg);
	}
	
	public static void i ( String msg )
	{
		if ( LEVEL <= INFO )
			Log.i(TAG, msg);
	}
	
	public static void w ( String msg )
	{
		if ( LEVEL <= WARN )
			Log.w(TAG, msg);
	}
	
	public static void e ( String msg )
	{
		if ( LEVEL <= ERROR )
			Log.e(TAG, msg);
	}
	
	// 下面是传入自定义tag的函数
	public static void v ( String tag, String msg )
	{
		if ( LEVEL <= VERBOSE )
			Log.v(tag, msg);
	}
	
	public static void d ( String tag, String msg )
	{
		if ( LEVEL <= DEBUG )
			Log.d(tag, msg);
	}
	
	public static void i ( String tag, String msg )
	{
		if ( LEVEL <= INFO )
			Log.i(tag, msg);
	}
	
	public static void w ( String tag, String msg )
	{
		if ( LEVEL <= WARN )
			Log.w(tag, msg);
	}
	
	public static void e ( String tag, String msg )
	{
		if ( LEVEL <= ERROR )
			Log.e(tag, msg);
	}
}
```


####使用例子：

```
public class MainActivity extends AppCompatActivity
{
	
	
	@Override
	protected void onCreate ( Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LogUtils.d(getTitle()+"");   //None tag parameter input . Just print title
		LogUtils.d(getLocalClassName(), "onCreate: "+getTitle());   //print title
	}
}
```

###（2）调节Logcat字体风格：
先打开Setting，搜索logcat，可以设置颜色、背景、加粗等。
![这里写图片描述](http://img.blog.csdn.net/20170324223015473?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
我给出个人建议:

 - Assert-#AA66CC
 - Debug-#33B5E5
 - Error-#FF4444
 - Info-#99CC00
 - Verbose-#FFFFFF
 - Waring-#FFBB33
###（3）快捷方式：
####Android Studio为我们定义了一些打出简单的单词便可选择打出之前先前定义的代码。
####1.配置
![这里写图片描述](http://img.blog.csdn.net/20170324223053958?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####2.使用
![这里写图片描述](http://img.blog.csdn.net/20170325090110002?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
###（4）使用场景分析
打印APP中你想要知道的数据；方法执行的周期运作情况等。


##2.断点调试
###（1）设置断点的方法
####1.在行号旁边双击设置
####2.光标所在行按ALT+F8
###（2）调试
####1.进入断点调试：设置好断点后我们进入调试，可以点击编译旁的DEBUG按钮，或者快捷键shift+F9.
![这里写图片描述](http://img.blog.csdn.net/20170325100400574?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####2.调试界面介绍
![这里写图片描述](http://img.blog.csdn.net/20170325100854173?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####3.调试按钮介绍
下面用红色框出的为必须掌握的快捷键。

####(1).Show Execution Point：点击该按钮，快速定位当前调试的位置，并将该行高亮的显示出来。
![这里写图片描述](http://img.blog.csdn.net/20170228171540391)

####(2).Step Over（F8）：单步跳过，点击该按钮将导致程序向下执行一行，不进入方法体内部。
![这里写图片描述](http://img.blog.csdn.net/20170228171923008)
####(3).Step Into（F7）：单步跳入，执行该操作将导致程序向下执行一行。如果该行有自定义的方法，则进入该方法内部继续执行，但不进入官方类库方法体。
![这里写图片描述](http://img.blog.csdn.net/20170228172041941)
####(4).Force step into（Alt+Shift+F7）：强制单步跳入，和step into功能类似，但所有方法体都进入。
![这里写图片描述](http://img.blog.csdn.net/20170228172221176)
####(5).Step Out（Shift+F8）：如果在调试的时候你进入了一个方法（如f()），并觉得该方法没有问题，你就可以使用stepout跳出该方法，返回到该方法被调用处的下一行语句,注意跳出的方法f()已经被执行。
![这里写图片描述](http://img.blog.csdn.net/20170228172440489)
####(6).Force Run to Cursor：忽略当前断点，跳到光标处的断点。比如我们一共有三个断点，当前在第一个断点，我们想直接调试第三个断点后的代码，那么将光标放到要调试的位置，点击这个按钮即可。
![这里写图片描述](http://img.blog.csdn.net/20170228172745519)
例子
![这里写图片描述](http://img.blog.csdn.net/20170325142421763?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

####(7).Evaluate expression（ALT+F8）：点击该按钮会在当前调试的语句处嵌入一个交互式解释器，在该解释器中，你可以执行任何你想要执行的表达式进行求值操作。
![这里写图片描述](http://img.blog.csdn.net/20170228173145383)
可以输入形参让函数进行执行返回结果的操作。
![这里写图片描述](http://img.blog.csdn.net/20170325141339511?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
也可以查看当前参数的值。
![这里写图片描述](http://img.blog.csdn.net/20170325141718044?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####(8).Resume Program（F9）:继续程序，效果是程序将运行一个断点到下一个断点之间需要执行的代码。如果后面代码没有断点，再次点击该按钮将会执行完程序。
![这里写图片描述](http://img.blog.csdn.net/20170325140416100?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


###（3）使用场景
一句话，一个断点什么问题都出来了.断点一般被我们用于寻找较为隐蔽的细节问题，比如数据较多的情况出现数据异常等。

##3.单元调试
每当我们创建工程的时候可以看到有两个可以供我们测试的文件：Instrumented text & Unit test。
![这里写图片描述](http://img.blog.csdn.net/20170326090038818?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
Unit Test 和 Instrument Test 的区别

在 Android Developer 给出的 Instrument Test 解释如下：

Instrumented unit tests are unit tests that run on physical devices and emulators, instead of the Java Virtual Machine (JVM) on your local machine. You should create instrumented unit tests if your tests need access to instrumentation information (such as the target app’s Context) or if they require the real implementation of an Android framework component (such as a Parcelable or SharedPreferences object). Using instrumented unit tests also helps to reduce the effort required to write and maintain mock code. You are still free to use a mocking framework, if you choose, to simulate any dependency relationships. Instrumented unit tests can take advantage of the Android framework APIs and supporting APIs, such as the Android Testing Support Library。

简单的翻译： Instrumented Unit test 是允许在真机或者模拟器上的，而不是运行在本地环境下的虚拟机中。如果在测试时需要使用 instrumentation information(例如 app Context),或者你需要获取 Android 框架的组件(例如 SharedPrederences），这时候你就可以创建一个 instrumented unit test。使用 Instrumented unit test 可以帮助减少编写模拟环境的代码。当然你也可以使用一些 mock 框架。使用 Instrumented unit test 可以很好的利用 Android framework api 和 supporting API。

在 Android Developer 给出的 Local Unit Tests(Unit Test)解释如下：

If your unit test has no dependencies or only has simple dependencies on Android, you should run your test on a local development machine. This testing approach is efficient because it helps you avoid the overhead of loading the target app and unit test code onto a physical device or emulator every time your test is run. Consequently, the execution time for running your unit test is greatly reduced. With this approach, you normally use a mocking framework, like Mockito, to fulfill any dependency relationships.

简单的翻译：如果你的单元测试不依赖Android环境，那么你需要使用一个本地的单元测试，运行在本地的JVM上，这样的话，就有利于你的测试速度，因为加载物理设备是很耗费时间的。你可以使用类似于 Mockito 这种 Java 测试框架。

简单的总结一下是，这些情况适合用 Instrumented unit test ：

    1.测试时需要使用 Android api支持
    2.测试时需要使用 Android 中的组件
    3.测试时需要访问 Android 中的特定环境元素（例如 Context)

其他情况优先考虑使用 Unit Test ，因为它的速度要快很多，效率也要高很多。其次，Instrumented unit tes 是基于 Unit Test 的。

###单元测试检验数据库操作
流程
####1.继承SQLiteOpenHeler编写SQLiteOpenUtils-创建数据库

1.SQLiteOpenUtils
> SQLiteOpenUtils

```
public class SQLiteOpenUtils extends SQLiteOpenHelper
{
	private static final String NAME = "MadJieJie.db";
	private static final int VERSION = 1;
	
	public SQLiteOpenUtils ( Context context)
	{
		super(context, NAME, null, VERSION);
	}
	
	/**
	 * Create MadJieJie db.
	 * @param db
	 */
	@Override
	public void onCreate ( SQLiteDatabase db )
	{
		db.execSQL("CREATE TABLE user(" +
						   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				           "account VARCHAR(50) NOT NULL," +                //account
				           "password VARCHAR(50) NOT NULL" +                //password
				           ")");
	}
	
	@Override
	public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion )
	{
		
	}
}
```


####2.编写数据库工具类DBUtils-插入数据
> DBUtils

```
public class DBUtils
{
	
	private DBUtils ()
	{
		throw new UnsupportedOperationException("can't init");
	}
	
	/**
	 * Insert into user's data.
	 *
	 * @param context
	 * @param account
	 * @param password
	 * @return
	 */
	public static boolean insertUserData ( Context context, final String account, final String password )
	{
		SQLiteOpenUtils sqLiteOpenUtils = new SQLiteOpenUtils(context);
		SQLiteDatabase db = sqLiteOpenUtils.getWritableDatabase();
		try
		{
			db.execSQL("INSERT INTO TABLE user(account,password) VALUES(?,?)", new String[]{ account, password });
			return true;
		} catch( SQLException e )
		{
			e.printStackTrace();
			return false;
		} finally
		{
			if ( db != null )
				db.close();
			if ( sqLiteOpenUtils != null )
				sqLiteOpenUtils.close();
		}
		
	}
	
}
```

####3.单元测试-测试语句是否正确
####（1）创建测试类
双击选中该类，点击Go To,在点击Test
![这里写图片描述](http://img.blog.csdn.net/20170326144606124?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
选中创建一个新的测试类
![这里写图片描述](http://img.blog.csdn.net/20170326144733547?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![这里写图片描述](http://img.blog.csdn.net/20170326145102104?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####（2）调试
![这里写图片描述](http://img.blog.csdn.net/20170326145340633?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
通过编译的模样
![这里写图片描述](http://img.blog.csdn.net/20170326145503932?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
因为错误被捕获了-Logcat可以查看到
![这里写图片描述](http://img.blog.csdn.net/20170326150110984?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
把try-catch语句去掉
![这里写图片描述](http://img.blog.csdn.net/20170326150328007?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTWFkSmllSmll/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
####（3）使用场景
对较为复杂的函数，如数据库，网络操作等。。。
MVP框架中的P操作测试-用Mockito框架。

> [源码下载-如有帮助GitHub给个赞](https://github.com/MadJieJie/Debug)

参考文章：

 1. [单元调试](http://blog.csdn.net/u010218288/article/details/47973943)
 2.  [Intellij IDEA调试功能使用总结](http://blog.csdn.net/theusprome/article/details/53016164)

