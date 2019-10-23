package com.hk.st.pojo;


import lombok.Data;
import org.bson.BSONObject;

import java.io.Serializable;

/**
 * @author ouhaiq
 *
 */
@Data
public class OplogPO implements Serializable {

	private String ts;
    private Long t;
    private Long h;
    private Long v;
    private String op;
    private String ns;
    private BSONObject o;
    private BSONObject o2;
    //分片集群balance产生数据的标记
    private Boolean fromMigrate = false;

}