p176: String对象
创建对象：String s = new String("We are students.")
用已创建的String对象创建另一个String对象：
String tom = new String(s)

另外的构造方法：
1.String(char a[]) 用一个字符数组a创建一个String对象
///
char a[] = {'J', 'a', 'v', 'a'};
String s = new String(a)        // 等价于String s = new String("Java");
/// 

2.String(char a[], int startIndex, int count) 提取字符数组a中的一部分字符创建一个String对象，startIndex和count分别表示提取字符的起始位置和从该位置开始截取的字符个数。例如：
///
char a[] = {'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight'};
String s = new String(a,2,4)        
// 等于String s = new String("twothreefourfive");
///


p177: 引用String常量
右边代码案例输出由两个规则决定：
1.String 使用 == 比较的是：两个引用是否指向同一个对象。
2.编译时能确定的字符串常量，与运行时拼接出的字符串，创建方式不同。
注意：== 比较对象身份，equals() 比较字符串内容。

"你" + "好" 在编译时就变成 "你好"，例如：
String hello = "你好";
String testOne = "你" + "好";
这里"你" 和 "好" 都是字符串字面量，编译器直接知道拼接结果，因此会进行常量折叠（constant folding）。第二句相当于：
String testOne = "你好";
Java 会共享字符串常量池（string pool）中内容相同的字面量。因此，hello、testOne 和代码中的 "你好" 都引用同一个 String 对象。因此右边前三个结果都是true。这里的 true 来自对象相同，不只是内容相同。

you + hi 是运行时拼接；
String you = "你";
String hi = "好";
String testTwo = you + hi;
虽然这里能看出 you 和 hi 的内容，但它们是普通变量，不属于编译时常量。因此，you + hi 是运行时拼接（runtime concatenation），结果是一个新的 String 对象，不会自动复用常量池中的 "你好"。例如：
System.out.println(hello == testTwo);      // false：不同对象
System.out.println(hello.equals(testTwo)); // true：内容相同

而后，再次运行 you + hi，又得到一个新对象：
String testThree = you + hi;
System.out.println(testTwo == testThree); // false
两次运行时拼接分别产生不同对象，所以：
System.out.println(testTwo.equals(testThree)); // true


p178: String类常用方法
1.public int length()
获取一个String对象的字符序列长度

2.public boolean equals(String s)
比较当前String对象的字符序列是否与s指定的String对象的字符序列相同
s1 = new String("We are");
s2 = new String("We are");
System.out.println(s1.equals(s2));  // true
System.out.println(s1 == s2);       // false
因为"=="是s1和s2中存放的值，而s1 s2存放的是内存引用

3.public boolean startsWith(String s), public boolean endsWith(String s)
当前s对象前缀或后缀是否一致

4.public int compareTo(String s)
按字典顺序(Unicode)比较当前对象和指定对象s的字符排序大小(例如a的排序是97，b的排序是98)
如果str > s, return 正数
如果str < s, return 负数
如果str = s, return 0

5.public boolean contains(String s)
判断当前对象是否包含参数s的字符序列，例如：
tom = "student"
tom.contains("stu")     // true

6.public int indexOf(String s), public int lastIndexOf(String s)
indexOf：从当前对象的字符序列的0索引位置开始检索首次出现s的字符序列的位置，并返回该位置。如果没有检索到，该方法返回-1.
lastIndexOf：从0索引位置开始检索最后一次出现s的字符序列的位置，并返回该位置。没检索到就返回-1.
indexOf(String str, int startPoint)是一个重载方法，用于指定检索开始位置。

7.public String substring(int start, int end)
从start位置到end-1位置上裁剪出一个新的字符串，例如：
String tom = "我喜欢篮球"
String str = tom.substring(1,3)     // "喜欢"， 不是"喜欢篮"

8.public String trim()
得到一个新的对象，这个对象是当前对象去掉前后空格后的内容


p183: 对象的字符串表示以及toString()方法
所有 Java 类都继承了 Object 的 toString()。 如果不重写，通常显示类似Student@1a2b3c 的内容，默认形式是“类名 + @ + 哈希码的十六进制表示”，不是内存地址。
重写的方法签名是 public String toString()：没有参数，返回字符串。
方法内部用 return 返回描述文字，打印由外部的 println() 完成。