package com.hk.st.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteUtils {


    //判断一个byte数值在另外一个byte数组中对应的游标值
    public static int getByteIndexOf(byte[] sources, byte[] split, int startIndex) {
        return getByteIndexOf(sources, split, startIndex, sources.length);
    }


    //判断一个byte数值在另外一个byte数组中对应的游标值，指定开始的游标和结束的游标位置
    public static int getByteIndexOf(byte[] sources, byte[] split, int startIndex, int endIndex) {

        if (sources == null || split == null || sources.length == 0 || split.length == 0) {
            return -1;
        }

        if (endIndex > sources.length) {
            endIndex = sources.length;
        }

        int i, j;
        for (i = startIndex; i < endIndex; i++) {
            if (sources[i] == split[0] && i + split.length - 1 < endIndex) {
                for (j = 1; j < split.length - 1; j++) {
                    if (sources[i + j] != split[j]) {
                        break;
                    }
                }

                if (j == split.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


    //判断一个byte数组split，在另一个byte数组source中存在的个数
    public static int getByteCountOf(byte[] sources, byte[] split) {
        if (sources == null || split == null || sources.length == 0 || split.length == 0) {
            return 0;
        }
        int count = 0;
        int start = 0;
        int index = 0;
        while ((index = getByteIndexOf(sources, split, start)) != -1) {
            start = index + 1;
            count++;
        }
        return count;
    }


    public static List<byte[]> getByteList(byte[] sources, byte[] split) {
        List<byte[]> list = new ArrayList<>();
        int start = 0;
        int index = 0;
        int from = 0;
        int to = 0;
        while ((index = getByteIndexOf(sources, split, start)) != -1) {
            to = index + split.length;
            byte[] bytes = Arrays.copyOfRange(sources, from, to);
            list.add(bytes);
            from = index + split.length;
            start = index + 1;
        }
        return list;
    }

}
