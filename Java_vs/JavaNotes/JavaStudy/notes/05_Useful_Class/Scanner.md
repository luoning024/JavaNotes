p193: Scanner类
1. 读取已知输入
| 方法 | 用法 | 作用 |
|---|---|---|
| `next()` | `String word = scanner.next();` | 读取下一个片段，返回字符串，并推进读取位置 |
| `hasNext()` | `scanner.hasNext()` | 判断是否还有片段可读，返回 `boolean`，不取走片段 |
| `useDelimiter()` | `scanner.useDelimiter(",");` | 设置分隔符，决定怎样划分片段 |

默认情况下，Scanner 使用空白字符分隔，包括空格、换行、制表符等。例如：
///
Scanner scanner = new Scanner("Java Python C++");

System.out.println(scanner.hasNext()); // true
System.out.println(scanner.next());    // Java
System.out.println(scanner.next());    // Python
System.out.println(scanner.next());    // C++
System.out.println(scanner.hasNext()); // false
///

如果没有内容了，再调用 next()，会抛出 NoSuchElementException。因此，读取多个片段时常写：
while (scanner.hasNext()) {
    String word = scanner.next();
    System.out.println(word);
}

useDelimiter() 接收的是正则表达式。例如：
///
Scanner scanner = new Scanner("Java,Python,C++");
scanner.useDelimiter(",");

while (scanner.hasNext()) {
    System.out.println(scanner.next());     // 输出Java Python C++
}
///

2. 从系统读取用户输入
从用户获取输入，一般按照“创建读取器 → 提示输入 → 读取 → 处理”的顺序。
System.in 是标准输入流，在通常的控制台程序中接收键盘输入。
| 方法 | 返回类型 | 读取内容 |
|---|---|---|
| `next()` | `String` | 下一个片段，默认遇到空白分隔 |
| `nextLine()` | `String` | 当前行剩余的全部内容，不包含行末换行符 |
| `nextInt()` | `int` | 下一个整数 |
| `nextDouble()` | `double` | 下一个浮点数 |