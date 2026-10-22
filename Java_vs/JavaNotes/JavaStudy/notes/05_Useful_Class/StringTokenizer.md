p191:StringTokenizer类
当分析一个String对象的字符序列并需要将其分解成可被独立使用的单词时，使用java.util包中的StringTokenizer类，该类有两个常用构造方法：
StringTokenizer(String s): 为s创造一个分析器，使用默认的分隔标记，即空格符，换行符，回车符，Tab符，进纸符做分隔标记
StringTokenizer(String s, String delim): 参数delim的字符序列中字符的任意排列作为分隔标记
例如：
StringTokenizer fenxi = new StringTokenizer("you are welcome");
StringTokenizer fenxi = new StringTokenizer("you#*#are**#welcome", "#*");

| 方法 | 返回类型 | 作用 | 是否向后推进读取位置 |
|---|---|---|---|
| `nextToken()` | `String` | 取出下一个 token | **是** |
| `hasMoreTokens()` | `boolean` | 判断是否还有 token 可取 | 否 |
| `countTokens()` | `int` | 统计**尚未取出的** token 数量 | 否 |


PriceToken和PriceToken_Ex解释
| 方法 | 接收什么 | 返回什么 |
|---|---|---|
| `getPriceSum()` | 小票字符串 | 总价，类型为 `double` |
| `getGoodsAmount()` | 小票字符串 | 数量，类型为 `int` |
| `getAverPrice()` | 小票字符串 | 平均价格，类型为 `double` |

getPriceSum() 先把非价格内容替换为分隔符。
String regex = "[^0123456789.]+" 
| 部分 | 含义 |
|---|---|
| `[ ... ]` | 表示匹配某一类字符 |
| 开头的 `^` | 在方括号内表示“不是这些字符” |
| `0123456789.` | 数字 `0–9` 和小数点 |
| `+` | 前面这一类字符连续出现一次或多次 |
因此，这里它匹配的是：连续出现的、既不是数字也不是小数点的字符。
结果是：
原来：牛奶:8.5元, 香蕉:3.6元, 酱油:2.8元
替换：#8.5#3.6#2.8#

然后StringTokenizer fenxi = new StringTokenizer(shoppingReceipt, "#");把里面的价格按照分隔符"#"提取出来，方便后续处理。