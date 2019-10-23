package com.hk.st.constant;

public interface IConstant {

    //在mongshake组装消息的时候我在每条消息末尾 加上了  "END_FOR_BSON_SPLIT_MARKER"， 用来消费记录分割
    //END_FOR_BSON_SPLIT_MARKER
    byte[] BYTE_SPLIT = new byte[]{69, 78, 68, 95, 70, 79, 82, 95, 66, 83, 79, 78, 95, 83, 80, 76, 73, 84, 95, 77, 65, 82, 75, 69, 82};


}
