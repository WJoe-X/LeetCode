package lib.sixzeroseven;

/**
 * @auther: WJoe
 * @Description: 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“
 * @Date : 18:29 2018/6/28
 */
public class Test1 {

    public  static  char[] replace(char[] a){
        if (a==null||a.length==0){
            return  null;
        }
       String s =  String.valueOf(a);
        String r = s.replace(" ","%20");
        return  r.toCharArray();
    }



}
