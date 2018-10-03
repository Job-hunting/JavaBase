package exam.顺丰科技;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 单词数组左右对齐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(",");
        int maxWidth = Integer.parseInt(scanner.nextLine());
        List<String> list = fullJustify(strings,maxWidth);
        for (int i= 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }

    public static  List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        int end = 1;
        while(start < words.length){
            int needSpace = 0;
            int curLen = words[start].length();
            while(end<words.length && needSpace + curLen + words[end].length()  <= maxWidth){
                needSpace++;
                curLen += words[end].length();
                end++;
            }
            if(end == words.length){
                StringBuilder sb = new StringBuilder(words[start]);
                for(int k = start + 1; k < end; k++){
                    sb.append(" "+words[k]);
                }
                for(int k = curLen + needSpace; k<maxWidth; k++) {
                    sb.append(" ");
                }
                result.add(sb.toString());
                break;
            }
            if(end - start == 1){
                StringBuilder sb = new StringBuilder(words[start]);
                for(int k = curLen; k<maxWidth; k++)
                    sb.append(" ");
                result.add(sb.toString());
            } else{
                int space = (maxWidth-curLen)/(end-start-1);
                int remains = maxWidth-curLen-(end-start-1)*space;
                StringBuilder sb = new StringBuilder(words[start]);
                for(int k=start+1; k<end;k++){
                    for(int l=0; l<space; l++){
                        sb.append(" ");
                    }
                    if(remains > 0) sb.append(" ");
                    sb.append(words[k]);

                }
                result.add(sb.toString());
            }
            start = end;
            end = end+1;
        }
        return result;
    }
}

